package jsp.num;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Vector;
import org.apache.jasper.runtime.*;
import java.beans.*;
import org.apache.jasper.JasperException;
import num.NumberGuessBean;


public class _0002fjsp_0002fnum_0002fnumguess_0002ejspnumguess_jsp_0 extends HttpJspBase {

    // begin [file="C:\\SOAP\\jakarta-tomcat-3.2.4\\webapps\\examples\\jsp\\num\\numguess.jsp";from=(11,0);to=(11,72)]
    // end

    static {
    }
    public _0002fjsp_0002fnum_0002fnumguess_0002ejspnumguess_jsp_0( ) {
    }

    private static boolean _jspx_inited = false;

    public final void _jspx_init() throws JasperException {
    }

    public void _jspService(HttpServletRequest request, HttpServletResponse  response)
        throws IOException, ServletException {

        JspFactory _jspxFactory = null;
        PageContext pageContext = null;
        HttpSession session = null;
        ServletContext application = null;
        ServletConfig config = null;
        JspWriter out = null;
        Object page = this;
        String  _value = null;
        try {

            if (_jspx_inited == false) {
                _jspx_init();
                _jspx_inited = true;
            }
            _jspxFactory = JspFactory.getDefaultFactory();
            response.setContentType("text/html;charset=ISO-8859-1");
            pageContext = _jspxFactory.getPageContext(this, request, response,
			"", true, 8192, true);

            application = pageContext.getServletContext();
            config = pageContext.getServletConfig();
            session = pageContext.getSession();
            out = pageContext.getOut();

            // HTML // begin [file="C:\\SOAP\\jakarta-tomcat-3.2.4\\webapps\\examples\\jsp\\num\\numguess.jsp";from=(0,0);to=(9,0)]
                out.write("<!--\r\n  Copyright (c) 1999 The Apache Software Foundation.  All rights \r\n  reserved.\r\n\r\n  Number Guess Game\r\n  Written by Jason Hunter, CTO, K&A Software\r\n  http://www.servlets.com\r\n-->\r\n\r\n");
            // end
            // HTML // begin [file="C:\\SOAP\\jakarta-tomcat-3.2.4\\webapps\\examples\\jsp\\num\\numguess.jsp";from=(9,42);to=(11,0)]
                out.write("\r\n\r\n");
            // end
            // begin [file="C:\\SOAP\\jakarta-tomcat-3.2.4\\webapps\\examples\\jsp\\num\\numguess.jsp";from=(11,0);to=(11,72)]
                num.NumberGuessBean numguess = null;
                boolean _jspx_specialnumguess  = false;
                 synchronized (session) {
                    numguess= (num.NumberGuessBean)
                    pageContext.getAttribute("numguess",PageContext.SESSION_SCOPE);
                    if ( numguess == null ) {
                        _jspx_specialnumguess = true;
                        try {
                            numguess = (num.NumberGuessBean) Beans.instantiate(this.getClass().getClassLoader(), "num.NumberGuessBean");
                        } catch (Exception exc) {
                             throw new ServletException (" Cannot create bean of class "+"num.NumberGuessBean");
                        }
                        pageContext.setAttribute("numguess", numguess, PageContext.SESSION_SCOPE);
                    }
                 } 
                if(_jspx_specialnumguess == true) {
            // end
            // begin [file="C:\\SOAP\\jakarta-tomcat-3.2.4\\webapps\\examples\\jsp\\num\\numguess.jsp";from=(11,0);to=(11,72)]
                }
            // end
            // HTML // begin [file="C:\\SOAP\\jakarta-tomcat-3.2.4\\webapps\\examples\\jsp\\num\\numguess.jsp";from=(11,72);to=(12,0)]
                out.write("\r\n");
            // end
            // begin [file="C:\\SOAP\\jakarta-tomcat-3.2.4\\webapps\\examples\\jsp\\num\\numguess.jsp";from=(12,0);to=(12,47)]
                JspRuntimeLibrary.introspect(pageContext.findAttribute("numguess"), request);
            // end
            // HTML // begin [file="C:\\SOAP\\jakarta-tomcat-3.2.4\\webapps\\examples\\jsp\\num\\numguess.jsp";from=(12,47);to=(19,0)]
                out.write("\r\n\r\n<html>\r\n<head><title>Number Guess</title></head>\r\n<body bgcolor=\"white\">\r\n<font size=4>\r\n\r\n");
            // end
            // begin [file="C:\\SOAP\\jakarta-tomcat-3.2.4\\webapps\\examples\\jsp\\num\\numguess.jsp";from=(19,2);to=(19,32)]
                 if (numguess.getSuccess()) { 
            // end
            // HTML // begin [file="C:\\SOAP\\jakarta-tomcat-3.2.4\\webapps\\examples\\jsp\\num\\numguess.jsp";from=(19,34);to=(22,17)]
                out.write("\r\n\r\n  Congratulations!  You got it.\r\n  And after just ");
            // end
            // begin [file="C:\\SOAP\\jakarta-tomcat-3.2.4\\webapps\\examples\\jsp\\num\\numguess.jsp";from=(22,20);to=(22,46)]
                out.print( numguess.getNumGuesses() );
            // end
            // HTML // begin [file="C:\\SOAP\\jakarta-tomcat-3.2.4\\webapps\\examples\\jsp\\num\\numguess.jsp";from=(22,48);to=(24,2)]
                out.write(" tries.<p>\r\n\r\n  ");
            // end
            // begin [file="C:\\SOAP\\jakarta-tomcat-3.2.4\\webapps\\examples\\jsp\\num\\numguess.jsp";from=(24,4);to=(24,23)]
                 numguess.reset(); 
            // end
            // HTML // begin [file="C:\\SOAP\\jakarta-tomcat-3.2.4\\webapps\\examples\\jsp\\num\\numguess.jsp";from=(24,25);to=(28,0)]
                out.write("\r\n\r\n  Care to <a href=\"numguess.jsp\">try again</a>?\r\n\r\n");
            // end
            // begin [file="C:\\SOAP\\jakarta-tomcat-3.2.4\\webapps\\examples\\jsp\\num\\numguess.jsp";from=(28,2);to=(28,47)]
                 } else if (numguess.getNumGuesses() == 0) { 
            // end
            // HTML // begin [file="C:\\SOAP\\jakarta-tomcat-3.2.4\\webapps\\examples\\jsp\\num\\numguess.jsp";from=(28,49);to=(39,0)]
                out.write("\r\n\r\n  Welcome to the Number Guess game.<p>\r\n\r\n  I'm thinking of a number between 1 and 100.<p>\r\n\r\n  <form method=get>\r\n  What's your guess? <input type=text name=guess>\r\n  <input type=submit value=\"Submit\">\r\n  </form>\r\n\r\n");
            // end
            // begin [file="C:\\SOAP\\jakarta-tomcat-3.2.4\\webapps\\examples\\jsp\\num\\numguess.jsp";from=(39,2);to=(39,12)]
                 } else { 
            // end
            // HTML // begin [file="C:\\SOAP\\jakarta-tomcat-3.2.4\\webapps\\examples\\jsp\\num\\numguess.jsp";from=(39,14);to=(41,32)]
                out.write("\r\n\r\n  Good guess, but nope.  Try <b>");
            // end
            // begin [file="C:\\SOAP\\jakarta-tomcat-3.2.4\\webapps\\examples\\jsp\\num\\numguess.jsp";from=(41,35);to=(41,55)]
                out.print( numguess.getHint() );
            // end
            // HTML // begin [file="C:\\SOAP\\jakarta-tomcat-3.2.4\\webapps\\examples\\jsp\\num\\numguess.jsp";from=(41,57);to=(43,16)]
                out.write("</b>.\r\n\r\n  You have made ");
            // end
            // begin [file="C:\\SOAP\\jakarta-tomcat-3.2.4\\webapps\\examples\\jsp\\num\\numguess.jsp";from=(43,19);to=(43,45)]
                out.print( numguess.getNumGuesses() );
            // end
            // HTML // begin [file="C:\\SOAP\\jakarta-tomcat-3.2.4\\webapps\\examples\\jsp\\num\\numguess.jsp";from=(43,47);to=(52,0)]
                out.write(" guesses.<p>\r\n\r\n  I'm thinking of a number between 1 and 100.<p>\r\n\r\n  <form method=get>\r\n  What's your guess? <input type=text name=guess>\r\n  <input type=submit value=\"Submit\">\r\n  </form>\r\n\r\n");
            // end
            // begin [file="C:\\SOAP\\jakarta-tomcat-3.2.4\\webapps\\examples\\jsp\\num\\numguess.jsp";from=(52,2);to=(52,5)]
                 } 
            // end
            // HTML // begin [file="C:\\SOAP\\jakarta-tomcat-3.2.4\\webapps\\examples\\jsp\\num\\numguess.jsp";from=(52,7);to=(57,0)]
                out.write("\r\n\r\n</font>\r\n</body>\r\n</html>\r\n");
            // end

        } catch (Exception ex) {
            if (out != null && out.getBufferSize() != 0)
                out.clearBuffer();
            if (pageContext != null) pageContext.handlePageException(ex);
        } finally {
            if (out != null) out.flush();
            if (_jspxFactory != null) _jspxFactory.releasePageContext(pageContext);
        }
    }
}
