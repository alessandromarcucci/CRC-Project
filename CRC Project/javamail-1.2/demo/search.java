/*
 * @(#)search.java	1.12 00/05/24
 *
 * Copyright 1997-2000 Sun Microsystems, Inc. All Rights Reserved.
 *
 * Sun grants you ("Licensee") a non-exclusive, royalty free, license to use,
 * modify and redistribute this software in source and binary code form,
 * provided that i) this copyright notice and license appear on all copies of
 * the software; and ii) Licensee does not utilize the software in a manner
 * which is disparaging to Sun.
 *
 * This software is provided "AS IS," without a warranty of any kind. ALL
 * EXPRESS OR IMPLIED CONDITIONS, REPRESENTATIONS AND WARRANTIES, INCLUDING ANY
 * IMPLIED WARRANTY OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE OR
 * NON-INFRINGEMENT, ARE HEREBY EXCLUDED. SUN AND ITS LICENSORS SHALL NOT BE
 * LIABLE FOR ANY DAMAGES SUFFERED BY LICENSEE AS A RESULT OF USING, MODIFYING
 * OR DISTRIBUTING THE SOFTWARE OR ITS DERIVATIVES. IN NO EVENT WILL SUN OR ITS
 * LICENSORS BE LIABLE FOR ANY LOST REVENUE, PROFIT OR DATA, OR FOR DIRECT,
 * INDIRECT, SPECIAL, CONSEQUENTIAL, INCIDENTAL OR PUNITIVE DAMAGES, HOWEVER
 * CAUSED AND REGARDLESS OF THE THEORY OF LIABILITY, ARISING OUT OF THE USE OF
 * OR INABILITY TO USE SOFTWARE, EVEN IF SUN HAS BEEN ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGES.
 *
 * This software is not designed or intended for use in on-line control of
 * aircraft, air traffic, aircraft navigation or aircraft communications; or in
 * the design, construction, operation or maintenance of any nuclear
 * facility. Licensee represents and warrants that it will not use or
 * redistribute the Software for such purposes.
 */

import java.util.*;
import java.io.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.search.*;
import javax.activation.*;

/*
 * Search the given folder for messages matching the given
 * criteria.
 *
 * @author John Mani
 */

public class search {

    static String protocol = "imap";
    static String host = null;
    static String user = null;
    static String password = null;
    static String mbox = "INBOX";
    static String url = null;
    static boolean debug = false;

    public static void main(String argv[]) {
	int optind;

	String subject = null;
	String from = null;
    	boolean or = false;
	boolean today = false;

	for (optind = 0; optind < argv.length; optind++) {
	    if (argv[optind].equals("-T")) {
		protocol = argv[++optind];
	    } else if (argv[optind].equals("-H")) {
		host = argv[++optind];
	    } else if (argv[optind].equals("-U")) {
		user = argv[++optind];
	    } else if (argv[optind].equals("-P")) {
		password = argv[++optind];
	    } else if (argv[optind].equals("-or")) {
		or = true;
	    } else if (argv[optind].equals("-D")) {
		debug = true;
	    } else if (argv[optind].equals("-f")) {
		mbox = argv[++optind];
	    } else if (argv[optind].equals("-L")) {
		url = argv[++optind];
	    } else if (argv[optind].equals("-subject")) {
		subject = argv[++optind];
	    } else if (argv[optind].equals("-from")) {
		from = argv[++optind];
	    } else if (argv[optind].equals("-today")) {
		today = true;
	    } else if (argv[optind].equals("--")) {
		optind++;
		break;
	    } else if (argv[optind].startsWith("-")) {
		System.out.println(
		 "Usage: search [-D] [-L url] [-T protocol] [-H host] " + 
		 "[-U user] [-P password] [-f mailbox] " + 
		 "[-subject subject] [-from from] [-or] [-today]");
		System.exit(1);
	    } else {
		break;
	    }
	}

        try {

	    if ((subject == null) && (from == null) && !today) {
		System.out.println("Specify either -subject, -from or -today");
		System.exit(1);
	    }

	    // Get a Properties object
	    Properties props = System.getProperties();

	    // Get a Session object
	    Session session = Session.getDefaultInstance(props, null);
	    session.setDebug(debug);

	    // Get a Store object
	    Store store = null;
	    if (url != null) {
		URLName urln = new URLName(url);
		store = session.getStore(urln);
		store.connect();
	    } else {
		if (protocol != null)		
		    store = session.getStore(protocol);
		else
		    store = session.getStore();

		// Connect
		if (host != null || user != null || password != null)
		    store.connect(host, user, password);
		else
		    store.connect();
	    }
	    

	    // Open the Folder

	    Folder folder = store.getDefaultFolder();
	    if (folder == null) {
	        System.out.println("Cant find default namespace");
	        System.exit(1);
	    }

	    folder = folder.getFolder(mbox);
	    if (folder == null) {
	        System.out.println("Invalid folder");
	        System.exit(1);
	    }

	    folder.open(Folder.READ_ONLY);
	    SearchTerm term = null;

	    if (subject != null)
		term = new SubjectTerm(subject);
	    if (from != null) {
		FromStringTerm fromTerm = new FromStringTerm(from);
		if (term != null) {
		    if (or)
			term = new OrTerm(term, fromTerm);
		    else
			term = new AndTerm(term, fromTerm);
		}
		else
		    term = fromTerm;
	    }
	    if (today) {
		ReceivedDateTerm dateTerm = 
		 new ReceivedDateTerm(ComparisonTerm.EQ, new Date());
		if (term != null) {
		    if (or)
			term = new OrTerm(term, dateTerm);
		    else
			term = new AndTerm(term, dateTerm);
		}
		else
		    term = dateTerm;
	    }

	    Message[] msgs = folder.search(term);
	    System.out.println("FOUND " + msgs.length + " MESSAGES");
	    if (msgs.length == 0) // no match
		System.exit(1);

	    // Use a suitable FetchProfile
	    FetchProfile fp = new FetchProfile();
	    fp.add(FetchProfile.Item.ENVELOPE);
	    folder.fetch(msgs, fp);

	    for (int i = 0; i < msgs.length; i++) {
		System.out.println("--------------------------");
		System.out.println("MESSAGE #" + (i + 1) + ":");
		dumpPart(msgs[i]);
	    }

	    folder.close(false);
	    store.close();
	} catch (Exception ex) {
	    System.out.println("Oops, got exception! " + ex.getMessage());
	    ex.printStackTrace();
	}

	System.exit(1);
    }

    public static void dumpPart(Part p) throws Exception {
	if (p instanceof Message) {
	    Message m = (Message)p;
	    Address[] a;
	    // FROM 
	    if ((a = m.getFrom()) != null) {
		for (int j = 0; j < a.length; j++)
		    System.out.println("FROM: " + a[j].toString());
	    }

	    // TO
	    if ((a = m.getRecipients(Message.RecipientType.TO)) != null) {
		for (int j = 0; j < a.length; j++)
		    System.out.println("TO: " + a[j].toString());
	    }

	    // SUBJECT
	    System.out.println("SUBJECT: " + m.getSubject());

	    // DATE
	    Date d = m.getSentDate();
	    System.out.println("SendDate: " +
		(d != null ? d.toLocaleString() : "UNKNOWN"));

	    // FLAGS:
	    Flags flags = m.getFlags();
	    StringBuffer sb = new StringBuffer();
	    Flags.Flag[] sf = flags.getSystemFlags(); // get the system flags

	    boolean first = true;
	    for (int i = 0; i < sf.length; i++) {
		String s;
		Flags.Flag f = sf[i];
		if (f == Flags.Flag.ANSWERED)
		    s = "\\Answered";
		else if (f == Flags.Flag.DELETED)
		    s = "\\Deleted";
		else if (f == Flags.Flag.DRAFT)
		    s = "\\Draft";
		else if (f == Flags.Flag.FLAGGED)
		    s = "\\Flagged";
		else if (f == Flags.Flag.RECENT)
		    s = "\\Recent";
		else if (f == Flags.Flag.SEEN)
		    s = "\\Seen";
		else
		    continue;	// skip it
		if (first)
		    first = false;
		else
		    sb.append(' ');
		sb.append(s);
	    }

	    String[] uf = flags.getUserFlags(); // get the user flag strings
	    for (int i = 0; i < uf.length; i++) {
		if (first)
		    first = false;
		else
		    sb.append(' ');
		sb.append(uf[i]);
	    }
	    System.out.println("FLAGS = " + sb.toString());
	}

	System.out.println("CONTENT-TYPE: " + p.getContentType());

	/* Dump input stream
	InputStream is = ((MimeMessage)m).getInputStream();
	int c;
	while ((c = is.read()) != -1)
	    System.out.write(c);
	*/

	Object o = p.getContent();
	if (o instanceof String) {
	    System.out.println("This is a String");
	    System.out.println((String)o);
	} else if (o instanceof Multipart) {
	    System.out.println("This is a Multipart");
	    Multipart mp = (Multipart)o;
	    int count = mp.getCount();
	    for (int i = 0; i < count; i++)
		dumpPart(mp.getBodyPart(i));
	} else if (o instanceof InputStream) {
	    System.out.println("This is just an input stream");
	    InputStream is = (InputStream)o;
	    int c;
	    while ((c = is.read()) != -1)
		System.out.write(c);
	}
    }
}
