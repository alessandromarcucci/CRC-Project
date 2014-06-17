/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ModificaRic3.java
 *
 * Created on 29-gen-2012, 12.04.44
 */

package ClientCRC;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JOptionPane;
import java.net.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JMenuItem;
import org.apache.soap.rpc.*;
import org.apache.soap.Constants;
import org.apache.soap.SOAPException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author alessandro
 */
public class ModificaRic3 extends javax.swing.JFrame implements ActionListener {
    private Font myFont = new Font("Tahoma", Font.PLAIN,11);
    /** Creates new form ModificaRic3 */
    public ModificaRic3(String user, String ID, String nome, String cognome, String code, int admin) {
        initComponents();
        this.getContentPane().setBackground(Color.DARK_GRAY);
        this.setIconImage(new ImageIcon("C:\\SOAP\\images\\icon.gif").getImage());
        jUser.setText(user);
        jNome.setText(nome);
        jCognome.setText(cognome);
        jCodice.setText(code);
        jID.setText(ID);
        jAdmin.setDisplayedMnemonic(admin);
        JMenuItem disconnettiMenu = new JMenuItem("Disconnetti");
        JMenuItem esciMenu = new JMenuItem("Esci da ReCronix");
        
        JMenuItem indietroMenu = new JMenuItem("Indietro");
        JMenuItem guidaMenu = new JMenuItem("Guida");
        JMenuItem creditMenu = new JMenuItem("Credits");
        
        creditMenu.setFont(myFont);
        creditMenu.setBackground(Color.DARK_GRAY);
        creditMenu.setForeground(Color.yellow);
        
        
        guidaMenu.setFont(myFont);
        guidaMenu.setBackground(Color.DARK_GRAY);
        guidaMenu.setForeground(Color.yellow);
        
        
        
        disconnettiMenu.setFont(myFont);
        disconnettiMenu.setBackground(Color.DARK_GRAY);
        disconnettiMenu.setForeground(Color.yellow);
        
        esciMenu.setFont(myFont);
        esciMenu.setBackground(Color.DARK_GRAY);
        esciMenu.setForeground(Color.yellow);
        
        indietroMenu.setFont(myFont);
        indietroMenu.setBackground(Color.DARK_GRAY);
        indietroMenu.setForeground(Color.yellow);
        
        
        jMenu1.add(indietroMenu);
        jMenu1.add(disconnettiMenu);
        jMenu1.addSeparator();
        jMenu1.add(esciMenu);
        jMenu1.setBackground(Color.DARK_GRAY);
        
        jMenu2.add(guidaMenu);
        jMenu2.addSeparator();
        jMenu2.add(creditMenu);
        
        indietroMenu.addActionListener(this);
        
        disconnettiMenu.addActionListener(this);
        esciMenu.addActionListener(this);
        guidaMenu.addActionListener(this);
        creditMenu.addActionListener(this);

        
        try{
                URL address = new URL("http://localhost:8080/soap/servlet/rpcrouter");
                Call chiamata=new Call();
                chiamata.setTargetObjectURI("urn:crc");// l'ID della nostra RCP creata ad HOC
                chiamata.setMethodName("getDurata1"); // chiamata del nostro metodo
                chiamata.setEncodingStyleURI(Constants.NS_URI_SOAP_ENC);
                Vector parametri=new Vector();
                parametri.addElement(new Parameter("id",String.class,ID,null));
                //parametri.addElement(new Parameter("Fuori",String.class,visitor,null));
                chiamata.setParams(parametri);
                System.out.println("SOAP call parameters:"+chiamata);// codifica dei dati trasmessi


                    try {
                        Response risposta = chiamata.invoke(address, "");
                        Parameter par = risposta.getReturnValue(); // leggo la risposta
                        Object value=par.getValue();
                        String msg=String.valueOf(value);
                        jDurata.setText(msg);
                        }
                    catch(SOAPException e)
                        {
                           JOptionPane.showMessageDialog(this, "attenzione si è verificato un errore", "errore", JOptionPane.ERROR_MESSAGE);
                           System.out.println("errore causato:("+e.getFaultCode()+"):"+e.getMessage());
                        }
                }
            catch(MalformedURLException ex){
               JOptionPane.showMessageDialog(this, "attenzione errore di connessione", "errore", JOptionPane.ERROR_MESSAGE);
               System.out.println(ex.getMessage());
           }



    try{
                URL address = new URL("http://localhost:8080/soap/servlet/rpcrouter");
                Call chiamata=new Call();
                chiamata.setTargetObjectURI("urn:crc");// l'ID della nostra RCP creata ad HOC
                chiamata.setMethodName("getNPC1"); // chiamata del nostro metodo
                chiamata.setEncodingStyleURI(Constants.NS_URI_SOAP_ENC);
                Vector parametri=new Vector();
                parametri.addElement(new Parameter("id",String.class,ID,null));
                //parametri.addElement(new Parameter("Fuori",String.class,visitor,null));
                chiamata.setParams(parametri);
                System.out.println("SOAP call parameters:"+chiamata);// codifica dei dati trasmessi


                    try {
                        Response risposta = chiamata.invoke(address, "");
                        Parameter par = risposta.getReturnValue(); // leggo la risposta
                        Object value=par.getValue();
                        String msg=String.valueOf(value);
                        jNPC.setText(msg);
                        }
                    catch(SOAPException e)
                        {
                           JOptionPane.showMessageDialog(this, "attenzione si è verificato un errore", "errore", JOptionPane.ERROR_MESSAGE);
                           System.out.println("errore causato:("+e.getFaultCode()+"):"+e.getMessage());
                        }
                }
            catch(MalformedURLException ex){
               JOptionPane.showMessageDialog(this, "attenzione errore di connessione", "errore", JOptionPane.ERROR_MESSAGE);
               System.out.println(ex.getMessage());
           }

        try{
                URL address = new URL("http://localhost:8080/soap/servlet/rpcrouter");
                Call chiamata=new Call();
                chiamata.setTargetObjectURI("urn:crc");// l'ID della nostra RCP creata ad HOC
                chiamata.setMethodName("getDRG1"); // chiamata del nostro metodo
                chiamata.setEncodingStyleURI(Constants.NS_URI_SOAP_ENC);
                Vector parametri=new Vector();
                parametri.addElement(new Parameter("id",String.class,ID,null));
                //parametri.addElement(new Parameter("Fuori",String.class,visitor,null));
                chiamata.setParams(parametri);
                System.out.println("SOAP call parameters:"+chiamata);// codifica dei dati trasmessi


                    try {
                        Response risposta = chiamata.invoke(address, "");
                        Parameter par = risposta.getReturnValue(); // leggo la risposta
                        Object value=par.getValue();
                        String msg=String.valueOf(value);
                        jDRG.setText(msg);
                        }
                    catch(SOAPException e)
                        {
                           JOptionPane.showMessageDialog(this, "attenzione si è verificato un errore", "errore", JOptionPane.ERROR_MESSAGE);
                           System.out.println("errore causato:("+e.getFaultCode()+"):"+e.getMessage());
                        }
                }
            catch(MalformedURLException ex){
               JOptionPane.showMessageDialog(this, "attenzione errore di connessione", "errore", JOptionPane.ERROR_MESSAGE);
               System.out.println(ex.getMessage());
           }

        try{
                URL address = new URL("http://localhost:8080/soap/servlet/rpcrouter");
                Call chiamata=new Call();
                chiamata.setTargetObjectURI("urn:crc");// l'ID della nostra RCP creata ad HOC
                chiamata.setMethodName("getCreat1"); // chiamata del nostro metodo
                chiamata.setEncodingStyleURI(Constants.NS_URI_SOAP_ENC);
                Vector parametri=new Vector();
                parametri.addElement(new Parameter("id",String.class,ID,null));
                //parametri.addElement(new Parameter("Fuori",String.class,visitor,null));
                chiamata.setParams(parametri);
                System.out.println("SOAP call parameters:"+chiamata);// codifica dei dati trasmessi


                    try {
                        Response risposta = chiamata.invoke(address, "");
                        Parameter par = risposta.getReturnValue(); // leggo la risposta
                        Object value=par.getValue();
                        String msg=String.valueOf(value);
                        jCreat.setText(msg);
                        }
                    catch(SOAPException e)
                        {
                           JOptionPane.showMessageDialog(this, "attenzione si è verificato un errore", "errore", JOptionPane.ERROR_MESSAGE);
                           System.out.println("errore causato:("+e.getFaultCode()+"):"+e.getMessage());
                        }
                }
            catch(MalformedURLException ex){
               JOptionPane.showMessageDialog(this, "attenzione errore di connessione", "errore", JOptionPane.ERROR_MESSAGE);
               System.out.println(ex.getMessage());
           }

        try{
                URL address = new URL("http://localhost:8080/soap/servlet/rpcrouter");
                Call chiamata=new Call();
                chiamata.setTargetObjectURI("urn:crc");// l'ID della nostra RCP creata ad HOC
                chiamata.setMethodName("getCRC1"); // chiamata del nostro metodo
                chiamata.setEncodingStyleURI(Constants.NS_URI_SOAP_ENC);
                Vector parametri=new Vector();
                parametri.addElement(new Parameter("id",String.class,ID,null));
                //parametri.addElement(new Parameter("Fuori",String.class,visitor,null));
                chiamata.setParams(parametri);
                System.out.println("SOAP call parameters:"+chiamata);// codifica dei dati trasmessi


                    try {
                        Response risposta = chiamata.invoke(address, "");
                        Parameter par = risposta.getReturnValue(); // leggo la risposta
                        Object value=par.getValue();
                        String msg=String.valueOf(value);
                        jCRC.setText(msg);
                        }
                    catch(SOAPException e)
                        {
                           JOptionPane.showMessageDialog(this, "attenzione si è verificato un errore", "errore", JOptionPane.ERROR_MESSAGE);
                           System.out.println("errore causato:("+e.getFaultCode()+"):"+e.getMessage());
                        }
                }
            catch(MalformedURLException ex){
               JOptionPane.showMessageDialog(this, "attenzione errore di connessione", "errore", JOptionPane.ERROR_MESSAGE);
               System.out.println(ex.getMessage());
           }

        try{
                URL address = new URL("http://localhost:8080/soap/servlet/rpcrouter");
                Call chiamata=new Call();
                chiamata.setTargetObjectURI("urn:crc");// l'ID della nostra RCP creata ad HOC
                chiamata.setMethodName("getPrima1"); // chiamata del nostro metodo
                chiamata.setEncodingStyleURI(Constants.NS_URI_SOAP_ENC);
                Vector parametri=new Vector();
                parametri.addElement(new Parameter("id",String.class,ID,null));
                //parametri.addElement(new Parameter("Fuori",String.class,visitor,null));
                chiamata.setParams(parametri);
                System.out.println("SOAP call parameters:"+chiamata);// codifica dei dati trasmessi


                    try {
                        Response risposta = chiamata.invoke(address, "");
                        Parameter par = risposta.getReturnValue(); // leggo la risposta
                        Object value=par.getValue();
                        String msg=String.valueOf(value);
                        jPrima.setText(msg);
                        }
                    catch(SOAPException e)
                        {
                           JOptionPane.showMessageDialog(this, "attenzione si è verificato un errore", "errore", JOptionPane.ERROR_MESSAGE);
                           System.out.println("errore causato:("+e.getFaultCode()+"):"+e.getMessage());
                        }
                }
            catch(MalformedURLException ex){
               JOptionPane.showMessageDialog(this, "attenzione errore di connessione", "errore", JOptionPane.ERROR_MESSAGE);
               System.out.println(ex.getMessage());
           }
        try{
                URL address = new URL("http://localhost:8080/soap/servlet/rpcrouter");
                Call chiamata=new Call();
                chiamata.setTargetObjectURI("urn:crc");// l'ID della nostra RCP creata ad HOC
                chiamata.setMethodName("getIcePrima1"); // chiamata del nostro metodo
                chiamata.setEncodingStyleURI(Constants.NS_URI_SOAP_ENC);
                Vector parametri=new Vector();
                parametri.addElement(new Parameter("id",String.class,ID,null));
                //parametri.addElement(new Parameter("Fuori",String.class,visitor,null));
                chiamata.setParams(parametri);
                System.out.println("SOAP call parameters:"+chiamata);// codifica dei dati trasmessi


                    try {
                        Response risposta = chiamata.invoke(address, "");
                        Parameter par = risposta.getReturnValue(); // leggo la risposta
                        Object value=par.getValue();
                        String msg=String.valueOf(value);
                        jIcePrima.setText(msg);
                        }
                    catch(SOAPException e)
                        {
                           JOptionPane.showMessageDialog(this, "attenzione si è verificato un errore", "errore", JOptionPane.ERROR_MESSAGE);
                           System.out.println("errore causato:("+e.getFaultCode()+"):"+e.getMessage());
                        }
                }
            catch(MalformedURLException ex){
               JOptionPane.showMessageDialog(this, "attenzione errore di connessione", "errore", JOptionPane.ERROR_MESSAGE);
               System.out.println(ex.getMessage());
           }

        try{
                URL address = new URL("http://localhost:8080/soap/servlet/rpcrouter");
                Call chiamata=new Call();
                chiamata.setTargetObjectURI("urn:crc");// l'ID della nostra RCP creata ad HOC
                chiamata.setMethodName("getSeconda1"); // chiamata del nostro metodo
                chiamata.setEncodingStyleURI(Constants.NS_URI_SOAP_ENC);
                Vector parametri=new Vector();
                parametri.addElement(new Parameter("id",String.class,ID,null));
                //parametri.addElement(new Parameter("Fuori",String.class,visitor,null));
                chiamata.setParams(parametri);
                System.out.println("SOAP call parameters:"+chiamata);// codifica dei dati trasmessi


                    try {
                        Response risposta = chiamata.invoke(address, "");
                        Parameter par = risposta.getReturnValue(); // leggo la risposta
                        Object value=par.getValue();
                        String msg=String.valueOf(value);
                        jSeconda.setText(msg);
                        }
                    catch(SOAPException e)
                        {
                           JOptionPane.showMessageDialog(this, "attenzione si è verificato un errore", "errore", JOptionPane.ERROR_MESSAGE);
                           System.out.println("errore causato:("+e.getFaultCode()+"):"+e.getMessage());
                        }
                }
            catch(MalformedURLException ex){
               JOptionPane.showMessageDialog(this, "attenzione errore di connessione", "errore", JOptionPane.ERROR_MESSAGE);
               System.out.println(ex.getMessage());
           }

        try{
                URL address = new URL("http://localhost:8080/soap/servlet/rpcrouter");
                Call chiamata=new Call();
                chiamata.setTargetObjectURI("urn:crc");// l'ID della nostra RCP creata ad HOC
                chiamata.setMethodName("getIceSeconda1"); // chiamata del nostro metodo
                chiamata.setEncodingStyleURI(Constants.NS_URI_SOAP_ENC);
                Vector parametri=new Vector();
                parametri.addElement(new Parameter("id",String.class,ID,null));
                //parametri.addElement(new Parameter("Fuori",String.class,visitor,null));
                chiamata.setParams(parametri);
                System.out.println("SOAP call parameters:"+chiamata);// codifica dei dati trasmessi


                    try {
                        Response risposta = chiamata.invoke(address, "");
                        Parameter par = risposta.getReturnValue(); // leggo la risposta
                        Object value=par.getValue();
                        String msg=String.valueOf(value);
                        jIceSeconda.setText(msg);
                        }
                    catch(SOAPException e)
                        {
                           JOptionPane.showMessageDialog(this, "attenzione si è verificato un errore", "errore", JOptionPane.ERROR_MESSAGE);
                           System.out.println("errore causato:("+e.getFaultCode()+"):"+e.getMessage());
                        }
                }
            catch(MalformedURLException ex){
               JOptionPane.showMessageDialog(this, "attenzione errore di connessione", "errore", JOptionPane.ERROR_MESSAGE);
               System.out.println(ex.getMessage());
           }

        try{
                URL address = new URL("http://localhost:8080/soap/servlet/rpcrouter");
                Call chiamata=new Call();
                chiamata.setTargetObjectURI("urn:crc");// l'ID della nostra RCP creata ad HOC
                chiamata.setMethodName("getTerza1"); // chiamata del nostro metodo
                chiamata.setEncodingStyleURI(Constants.NS_URI_SOAP_ENC);
                Vector parametri=new Vector();
                parametri.addElement(new Parameter("id",String.class,ID,null));
                //parametri.addElement(new Parameter("Fuori",String.class,visitor,null));
                chiamata.setParams(parametri);
                System.out.println("SOAP call parameters:"+chiamata);// codifica dei dati trasmessi


                    try {
                        Response risposta = chiamata.invoke(address, "");
                        Parameter par = risposta.getReturnValue(); // leggo la risposta
                        Object value=par.getValue();
                        String msg=String.valueOf(value);
                        jTerza.setText(msg);
                        }
                    catch(SOAPException e)
                        {
                           JOptionPane.showMessageDialog(this, "attenzione si è verificato un errore", "errore", JOptionPane.ERROR_MESSAGE);
                           System.out.println("errore causato:("+e.getFaultCode()+"):"+e.getMessage());
                        }
                }
            catch(MalformedURLException ex){
               JOptionPane.showMessageDialog(this, "attenzione errore di connessione", "errore", JOptionPane.ERROR_MESSAGE);
               System.out.println(ex.getMessage());
           }

        try{
                URL address = new URL("http://localhost:8080/soap/servlet/rpcrouter");
                Call chiamata=new Call();
                chiamata.setTargetObjectURI("urn:crc");// l'ID della nostra RCP creata ad HOC
                chiamata.setMethodName("getIceTerza1"); // chiamata del nostro metodo
                chiamata.setEncodingStyleURI(Constants.NS_URI_SOAP_ENC);
                Vector parametri=new Vector();
                parametri.addElement(new Parameter("id",String.class,ID,null));
                //parametri.addElement(new Parameter("Fuori",String.class,visitor,null));
                chiamata.setParams(parametri);
                System.out.println("SOAP call parameters:"+chiamata);// codifica dei dati trasmessi


                    try {
                        Response risposta = chiamata.invoke(address, "");
                        Parameter par = risposta.getReturnValue(); // leggo la risposta
                        Object value=par.getValue();
                        String msg=String.valueOf(value);
                        jIceTerza.setText(msg);
                        }
                    catch(SOAPException e)
                        {
                           JOptionPane.showMessageDialog(this, "attenzione si è verificato un errore", "errore", JOptionPane.ERROR_MESSAGE);
                           System.out.println("errore causato:("+e.getFaultCode()+"):"+e.getMessage());
                        }
                }
            catch(MalformedURLException ex){
               JOptionPane.showMessageDialog(this, "attenzione errore di connessione", "errore", JOptionPane.ERROR_MESSAGE);
               System.out.println(ex.getMessage());
           }

        try{
                URL address = new URL("http://localhost:8080/soap/servlet/rpcrouter");
                Call chiamata=new Call();
                chiamata.setTargetObjectURI("urn:crc");// l'ID della nostra RCP creata ad HOC
                chiamata.setMethodName("getQuarta1"); // chiamata del nostro metodo
                chiamata.setEncodingStyleURI(Constants.NS_URI_SOAP_ENC);
                Vector parametri=new Vector();
                parametri.addElement(new Parameter("id",String.class,ID,null));
                //parametri.addElement(new Parameter("Fuori",String.class,visitor,null));
                chiamata.setParams(parametri);
                System.out.println("SOAP call parameters:"+chiamata);// codifica dei dati trasmessi


                    try {
                        Response risposta = chiamata.invoke(address, "");
                        Parameter par = risposta.getReturnValue(); // leggo la risposta
                        Object value=par.getValue();
                        String msg=String.valueOf(value);
                        jQuarta.setText(msg);
                        }
                    catch(SOAPException e)
                        {
                           JOptionPane.showMessageDialog(this, "attenzione si è verificato un errore", "errore", JOptionPane.ERROR_MESSAGE);
                           System.out.println("errore causato:("+e.getFaultCode()+"):"+e.getMessage());
                        }
                }
            catch(MalformedURLException ex){
               JOptionPane.showMessageDialog(this, "attenzione errore di connessione", "errore", JOptionPane.ERROR_MESSAGE);
               System.out.println(ex.getMessage());
           }

        try{
                URL address = new URL("http://localhost:8080/soap/servlet/rpcrouter");
                Call chiamata=new Call();
                chiamata.setTargetObjectURI("urn:crc");// l'ID della nostra RCP creata ad HOC
                chiamata.setMethodName("getIceQuarta1"); // chiamata del nostro metodo
                chiamata.setEncodingStyleURI(Constants.NS_URI_SOAP_ENC);
                Vector parametri=new Vector();
                parametri.addElement(new Parameter("id",String.class,ID,null));
                //parametri.addElement(new Parameter("Fuori",String.class,visitor,null));
                chiamata.setParams(parametri);
                System.out.println("SOAP call parameters:"+chiamata);// codifica dei dati trasmessi


                    try {
                        Response risposta = chiamata.invoke(address, "");
                        Parameter par = risposta.getReturnValue(); // leggo la risposta
                        Object value=par.getValue();
                        String msg=String.valueOf(value);
                        jIceQuarta.setText(msg);
                        }
                    catch(SOAPException e)
                        {
                           JOptionPane.showMessageDialog(this, "attenzione si è verificato un errore", "errore", JOptionPane.ERROR_MESSAGE);
                           System.out.println("errore causato:("+e.getFaultCode()+"):"+e.getMessage());
                        }
                }
            catch(MalformedURLException ex){
               JOptionPane.showMessageDialog(this, "attenzione errore di connessione", "errore", JOptionPane.ERROR_MESSAGE);
               System.out.println(ex.getMessage());
           }

        try{
                URL address = new URL("http://localhost:8080/soap/servlet/rpcrouter");
                Call chiamata=new Call();
                chiamata.setTargetObjectURI("urn:crc");// l'ID della nostra RCP creata ad HOC
                chiamata.setMethodName("getDataR1"); // chiamata del nostro metodo
                chiamata.setEncodingStyleURI(Constants.NS_URI_SOAP_ENC);
                Vector parametri=new Vector();
                parametri.addElement(new Parameter("id",String.class,ID,null));
                //parametri.addElement(new Parameter("Fuori",String.class,visitor,null));
                chiamata.setParams(parametri);
                System.out.println("SOAP call parameters:"+chiamata);// codifica dei dati trasmessi


                    try {
                        Response risposta = chiamata.invoke(address, "");
                        Parameter par = risposta.getReturnValue(); // leggo la risposta
                        Object value=par.getValue();
                        String msg=String.valueOf(value);
                        jOldDataR.setText(msg);
                        }
                    catch(SOAPException e)
                        {
                           JOptionPane.showMessageDialog(this, "attenzione si è verificato un errore", "errore", JOptionPane.ERROR_MESSAGE);
                           System.out.println("errore causato:("+e.getFaultCode()+"):"+e.getMessage());
                        }
                }
            catch(MalformedURLException ex){
               JOptionPane.showMessageDialog(this, "attenzione errore di connessione", "errore", JOptionPane.ERROR_MESSAGE);
               System.out.println(ex.getMessage());
           }

        try{
                URL address = new URL("http://localhost:8080/soap/servlet/rpcrouter");
                Call chiamata=new Call();
                chiamata.setTargetObjectURI("urn:crc");// l'ID della nostra RCP creata ad HOC
                chiamata.setMethodName("getDataD1"); // chiamata del nostro metodo
                chiamata.setEncodingStyleURI(Constants.NS_URI_SOAP_ENC);
                Vector parametri=new Vector();
                parametri.addElement(new Parameter("id",String.class,ID,null));
                //parametri.addElement(new Parameter("Fuori",String.class,visitor,null));
                chiamata.setParams(parametri);
                System.out.println("SOAP call parameters:"+chiamata);// codifica dei dati trasmessi


                    try {
                        Response risposta = chiamata.invoke(address, "");
                        Parameter par = risposta.getReturnValue(); // leggo la risposta
                        Object value=par.getValue();
                        String msg=String.valueOf(value);
                        jOldDataD.setText(msg);
                        }
                    catch(SOAPException e)
                        {
                           JOptionPane.showMessageDialog(this, "attenzione si è verificato un errore", "errore", JOptionPane.ERROR_MESSAGE);
                           System.out.println("errore causato:("+e.getFaultCode()+"):"+e.getMessage());
                        }
                }
            catch(MalformedURLException ex){
               JOptionPane.showMessageDialog(this, "attenzione errore di connessione", "errore", JOptionPane.ERROR_MESSAGE);
               System.out.println(ex.getMessage());
           }

        try{
                URL address = new URL("http://localhost:8080/soap/servlet/rpcrouter");
                Call chiamata=new Call();
                chiamata.setTargetObjectURI("urn:crc");// l'ID della nostra RCP creata ad HOC
                chiamata.setMethodName("getColldate1"); // chiamata del nostro metodo
                chiamata.setEncodingStyleURI(Constants.NS_URI_SOAP_ENC);
                Vector parametri=new Vector();
                parametri.addElement(new Parameter("id",String.class,ID,null));
                //parametri.addElement(new Parameter("Fuori",String.class,visitor,null));
                chiamata.setParams(parametri);
                System.out.println("SOAP call parameters:"+chiamata);// codifica dei dati trasmessi


                    try {
                        Response risposta = chiamata.invoke(address, "");
                        Parameter par = risposta.getReturnValue(); // leggo la risposta
                        Object value=par.getValue();
                        String msg=String.valueOf(value);
                        jOldColldate.setText(msg);
                        }
                    catch(SOAPException e)
                        {
                           JOptionPane.showMessageDialog(this, "attenzione si è verificato un errore", "errore", JOptionPane.ERROR_MESSAGE);
                           System.out.println("errore causato:("+e.getFaultCode()+"):"+e.getMessage());
                        }
                }
            catch(MalformedURLException ex){
               JOptionPane.showMessageDialog(this, "attenzione errore di connessione", "errore", JOptionPane.ERROR_MESSAGE);
               System.out.println(ex.getMessage());
           }

        try{
                URL address = new URL("http://localhost:8080/soap/servlet/rpcrouter");
                Call chiamata=new Call();
                chiamata.setTargetObjectURI("urn:crc");// l'ID della nostra RCP creata ad HOC
                chiamata.setMethodName("get2classi1"); // chiamata del nostro metodo
                chiamata.setEncodingStyleURI(Constants.NS_URI_SOAP_ENC);
                Vector parametri=new Vector();
                parametri.addElement(new Parameter("id",String.class,ID,null));
                //parametri.addElement(new Parameter("Fuori",String.class,visitor,null));
                chiamata.setParams(parametri);
                System.out.println("SOAP call parameters:"+chiamata);// codifica dei dati trasmessi


                    try {
                        Response risposta = chiamata.invoke(address, "");
                        Parameter par = risposta.getReturnValue(); // leggo la risposta
                        Object value=par.getValue();
                        //String msg=String.valueOf(value);
                        jDueClassi.setSelectedItem(value);
                        }
                    catch(SOAPException e)
                        {
                           JOptionPane.showMessageDialog(this, "attenzione si è verificato un errore", "errore", JOptionPane.ERROR_MESSAGE);
                           System.out.println("errore causato:("+e.getFaultCode()+"):"+e.getMessage());
                        }
                }
            catch(MalformedURLException ex){
               JOptionPane.showMessageDialog(this, "attenzione errore di connessione", "errore", JOptionPane.ERROR_MESSAGE);
               System.out.println(ex.getMessage());
           }

        try{
                URL address = new URL("http://localhost:8080/soap/servlet/rpcrouter");
                Call chiamata=new Call();
                chiamata.setTargetObjectURI("urn:crc");// l'ID della nostra RCP creata ad HOC
                chiamata.setMethodName("get5classi1"); // chiamata del nostro metodo
                chiamata.setEncodingStyleURI(Constants.NS_URI_SOAP_ENC);
                Vector parametri=new Vector();
                parametri.addElement(new Parameter("id",String.class,ID,null));
                //parametri.addElement(new Parameter("Fuori",String.class,visitor,null));
                chiamata.setParams(parametri);
                System.out.println("SOAP call parameters:"+chiamata);// codifica dei dati trasmessi


                    try {
                        Response risposta = chiamata.invoke(address, "");
                        Parameter par = risposta.getReturnValue(); // leggo la risposta
                        Object value=par.getValue();
                        //String msg=String.valueOf(value);
                        jCinqueClassi.setSelectedItem(value);
                        }
                    catch(SOAPException e)
                        {
                           JOptionPane.showMessageDialog(this, "attenzione si è verificato un errore", "errore", JOptionPane.ERROR_MESSAGE);
                           System.out.println("errore causato:("+e.getFaultCode()+"):"+e.getMessage());
                        }
                }
            catch(MalformedURLException ex){
               JOptionPane.showMessageDialog(this, "attenzione errore di connessione", "errore", JOptionPane.ERROR_MESSAGE);
               System.out.println(ex.getMessage());
           }

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
    public void actionPerformed(ActionEvent e) {
        System.out.println("Selected: " + e.getActionCommand());
    Object src = e.getActionCommand();
    //String s = String.valueOf(src);
    //System.out.println(s);
    if (src == "Disconnetti" ){
        
      JOptionPane option = new JOptionPane("Vuoi davvero disconnetterti?", JOptionPane.QUESTION_MESSAGE, JOptionPane.YES_NO_OPTION);
    option.setBackground(Color.DARK_GRAY);
    JDialog dialog = option.createDialog("disconnessione");
    dialog.pack();
    dialog.setVisible(true);
    int n = ((Integer)option.getValue()).intValue();
    if (n == 0){
              new Login().setVisible(true);
              this.dispose();
    }
    }
    
    else if (src == "Guida"){
        
                  String command = "cmd /c start C:\\SOAP\\ProgettoCRC\\guida.txt";
            try {
                Process p = Runtime.getRuntime().exec(command);
            } catch (IOException ex) {
                Logger.getLogger(ModificaRic2.class.getName()).log(Level.SEVERE, null, ex);
            }
            
           
    }
    else if(src == "Indietro"){
                String code = jCodice.getText();
                String nome = jNome.getText();
                String cognome = jCognome.getText();
                String user = jLabel1.getText();
                int admin = jAdmin.getDisplayedMnemonic();
                new ModificaRic2(user, code, nome, cognome, admin).setVisible(true);
                this.dispose();
    }
    else if(src == "Esci da ReCronix"){
        System.out.println("mao maooo");
        JOptionPane option = new JOptionPane("Sei convinto di voler uscire?", JOptionPane.QUESTION_MESSAGE, JOptionPane.YES_NO_OPTION);
        option.setBackground(Color.DARK_GRAY);
        JDialog dialog = option.createDialog("uscita da ReCronix");
        dialog.pack();
        dialog.setVisible(true);
        int n = ((Integer)option.getValue()).intValue();
        if (n == 0) {
            System.exit(0);
        }
    }
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMeseC = new javax.swing.JComboBox();
        jLabel28 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jCodice = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jNome = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jCognome = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jAnnoR = new javax.swing.JComboBox();
        jConfirm = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jGiornoC = new javax.swing.JComboBox();
        jLabel29 = new javax.swing.JLabel();
        jCRC = new javax.swing.JTextField();
        jLab = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jGiornoR = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jIceQuarta = new javax.swing.JTextField();
        jMeseR = new javax.swing.JComboBox();
        jAnnoD = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        jMeseD = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel24 = new javax.swing.JLabel();
        jNPC = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jCreat = new javax.swing.JTextField();
        jAnnoC = new javax.swing.JComboBox();
        jLabel26 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jDurata = new javax.swing.JTextField();
        jGiornoD = new javax.swing.JComboBox();
        jLabel15 = new javax.swing.JLabel();
        jPrima = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jDRG = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jIcePrima = new javax.swing.JTextField();
        jSeconda = new javax.swing.JTextField();
        jDueClassi = new javax.swing.JComboBox();
        jLabel18 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jIceSeconda = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jTerza = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jIceTerza = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jQuarta = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jUser = new javax.swing.JLabel();
        jCinqueClassi = new javax.swing.JComboBox();
        jLabel31 = new javax.swing.JLabel();
        jOldDataR = new javax.swing.JLabel();
        jOldDataD = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jOldColldate = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLogout = new javax.swing.JButton();
        jExit = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jID = new javax.swing.JLabel();
        jAdmin = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMeseC.setBackground(new java.awt.Color(102, 102, 102));
        jMeseC.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jMeseC.setForeground(new java.awt.Color(255, 255, 0));
        jMeseC.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));

        jLabel28.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 204, 0));
        jLabel28.setText("D:");

        jCodice.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jCodice.setForeground(new java.awt.Color(255, 204, 0));
        jCodice.setText("jLabel6");

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 0));
        jLabel3.setText("data ricovero");

        jNome.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jNome.setForeground(new java.awt.Color(255, 204, 0));
        jNome.setText("jLabel3");

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 0));
        jLabel5.setText("con codice fiscale");

        jCognome.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jCognome.setForeground(new java.awt.Color(255, 204, 0));
        jCognome.setText("jLabel4");

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 204, 0));
        jLabel4.setText("A:");

        jAnnoR.setBackground(new java.awt.Color(102, 102, 102));
        jAnnoR.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jAnnoR.setForeground(new java.awt.Color(255, 204, 0));
        jAnnoR.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2020", "2019", "2018", "2017", "2016", "2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988", "1987", "1986", "1985", "1984", "1983", "1982", "1981", "1980", "1979", "1978", "1977", "1976", "1975", "1974", "1973", "1972", "1971", "1970", "1969", "1968", "1967", "1966", "1965", "1964", "1963", "1962", "1961", "1960", "1959", "1958", "1957", "1956", "1955", "1954", "1953", "1952", "1951", "1950", "1949", "1948", "1947", "1946", "1945", "1944", "1943", "1942", "1941", "1940", "1939", "1938", "1937", "1936", "1935", "1934", "1933", "1932", "1931", "1930", "1929", "1928", "1927", "1926", "1925", "1924", "1923", "1922", "1921", "1920", "1919", "1918", "1917", "1916", "1915", "1914", "1913", "1912", "1911", "1910", "1909", "1908", "1907", "1906", "1905", "1904", "1903", "1902", "1901", "1900" }));
        jAnnoR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAnnoRActionPerformed(evt);
            }
        });

        jConfirm.setBackground(new java.awt.Color(102, 102, 102));
        jConfirm.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jConfirm.setForeground(new java.awt.Color(255, 204, 0));
        jConfirm.setText("conferma");
        jConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jConfirmActionPerformed(evt);
            }
        });

        jGiornoC.setBackground(new java.awt.Color(102, 102, 102));
        jGiornoC.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jGiornoC.setForeground(new java.awt.Color(255, 255, 0));
        jGiornoC.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        jLabel29.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 0));
        jLabel29.setText("divisione in:");

        jCRC.setBackground(new java.awt.Color(255, 255, 153));
        jCRC.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCRC.setForeground(new java.awt.Color(0, 0, 153));

        jLab.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLab.setForeground(new java.awt.Color(255, 255, 0));
        jLab.setText("CRC");

        jButton3.setBackground(new java.awt.Color(102, 102, 102));
        jButton3.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 0));
        jButton3.setText("<< indietro");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 204, 0));
        jLabel7.setText("G:");

        jGiornoR.setBackground(new java.awt.Color(102, 102, 102));
        jGiornoR.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jGiornoR.setForeground(new java.awt.Color(255, 204, 0));
        jGiornoR.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        jLabel8.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 0));
        jLabel8.setText("data dimissione");

        jLabel9.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 204, 0));
        jLabel9.setText("A:");

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 204, 0));
        jLabel6.setText("M:");

        jIceQuarta.setBackground(new java.awt.Color(255, 255, 153));
        jIceQuarta.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jIceQuarta.setForeground(new java.awt.Color(0, 0, 153));

        jMeseR.setBackground(new java.awt.Color(102, 102, 102));
        jMeseR.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jMeseR.setForeground(new java.awt.Color(255, 204, 0));
        jMeseR.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));

        jAnnoD.setBackground(new java.awt.Color(102, 102, 102));
        jAnnoD.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jAnnoD.setForeground(new java.awt.Color(255, 204, 0));
        jAnnoD.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2020", "2019", "2018", "2017", "2016", "2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988", "1987", "1986", "1985", "1984", "1983", "1982", "1981", "1980", "1979", "1978", "1977", "1976", "1975", "1974", "1973", "1972", "1971", "1970", "1969", "1968", "1967", "1966", "1965", "1964", "1963", "1962", "1961", "1960", "1959", "1958", "1957", "1956", "1955", "1954", "1953", "1952", "1951", "1950", "1949", "1948", "1947", "1946", "1945", "1944", "1943", "1942", "1941", "1940", "1939", "1938", "1937", "1936", "1935", "1934", "1933", "1932", "1931", "1930", "1929", "1928", "1927", "1926", "1925", "1924", "1923", "1922", "1921", "1920", "1919", "1918", "1917", "1916", "1915", "1914", "1913", "1912", "1911", "1910", "1909", "1908", "1907", "1906", "1905", "1904", "1903", "1902", "1901", "1900" }));

        jLabel10.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 204, 0));
        jLabel10.setText("M:");

        jMeseD.setBackground(new java.awt.Color(102, 102, 102));
        jMeseD.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jMeseD.setForeground(new java.awt.Color(255, 204, 0));
        jMeseD.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));

        jLabel11.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 204, 0));
        jLabel11.setText("G:");

        jLabel27.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 204, 0));
        jLabel27.setText("M:");

        jLabel23.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 0));
        jLabel23.setText("NPC");

        jLabel24.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 0));
        jLabel24.setText("creat");

        jNPC.setBackground(new java.awt.Color(255, 255, 153));
        jNPC.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jNPC.setForeground(new java.awt.Color(0, 0, 153));

        jLabel25.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 0));
        jLabel25.setText("colldate");

        jCreat.setBackground(new java.awt.Color(255, 255, 153));
        jCreat.setFont(new java.awt.Font("DejaVu Serif", 1, 12)); // NOI18N
        jCreat.setForeground(new java.awt.Color(0, 0, 153));

        jAnnoC.setBackground(new java.awt.Color(102, 102, 102));
        jAnnoC.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jAnnoC.setForeground(new java.awt.Color(255, 204, 0));
        jAnnoC.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2020", "2019", "2018", "2017", "2016", "2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988", "1987", "1986", "1985", "1984", "1983", "1982", "1981", "1980", "1979", "1978", "1977", "1976", "1975", "1974", "1973", "1972", "1971", "1970", "1969", "1968", "1967", "1966", "1965", "1964", "1963", "1962", "1961", "1960", "1959", "1958", "1957", "1956", "1955", "1954", "1953", "1952", "1951", "1950", "1949", "1948", "1947", "1946", "1945", "1944", "1943", "1942", "1941", "1940", "1939", "1938", "1937", "1936", "1935", "1934", "1933", "1932", "1931", "1930", "1929", "1928", "1927", "1926", "1925", "1924", "1923", "1922", "1921", "1920", "1919", "1918", "1917", "1916", "1915", "1914", "1913", "1912", "1911", "1910", "1909", "1908", "1907", "1906", "1905", "1904", "1903", "1902", "1901", "1900" }));

        jLabel26.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 204, 0));
        jLabel26.setText("A:");

        jLabel12.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 0));
        jLabel12.setText("giorni di ricovero");

        jDurata.setBackground(new java.awt.Color(255, 255, 153));
        jDurata.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jDurata.setForeground(new java.awt.Color(0, 0, 153));
        jDurata.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jDurataActionPerformed(evt);
            }
        });

        jGiornoD.setBackground(new java.awt.Color(102, 102, 102));
        jGiornoD.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jGiornoD.setForeground(new java.awt.Color(255, 204, 0));
        jGiornoD.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        jLabel15.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 0));
        jLabel15.setText("1° diagnosi");

        jPrima.setBackground(new java.awt.Color(255, 255, 153));
        jPrima.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jPrima.setForeground(new java.awt.Color(0, 0, 153));

        jLabel13.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 0));
        jLabel13.setText("DRG");

        jDRG.setBackground(new java.awt.Color(255, 255, 153));
        jDRG.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jDRG.setForeground(new java.awt.Color(0, 0, 153));

        jLabel17.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 0));
        jLabel17.setText("2° diagnosi");

        jLabel16.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 0));
        jLabel16.setText("ice 1° diagnosi");

        jIcePrima.setBackground(new java.awt.Color(255, 255, 153));
        jIcePrima.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jIcePrima.setForeground(new java.awt.Color(0, 0, 153));

        jSeconda.setBackground(new java.awt.Color(255, 255, 153));
        jSeconda.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jSeconda.setForeground(new java.awt.Color(0, 0, 153));

        jDueClassi.setBackground(new java.awt.Color(102, 102, 102));
        jDueClassi.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jDueClassi.setForeground(new java.awt.Color(255, 255, 0));
        jDueClassi.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1" }));

        jLabel18.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 0));
        jLabel18.setText("ice 2° diagnosi");

        jIceSeconda.setBackground(new java.awt.Color(255, 255, 153));
        jIceSeconda.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jIceSeconda.setForeground(new java.awt.Color(0, 0, 153));
        jIceSeconda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jIceSecondaActionPerformed(evt);
            }
        });

        jLabel30.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 204, 0));
        jLabel30.setText("2 classi");

        jLabel19.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 0));
        jLabel19.setText("3° diagnosi");

        jTerza.setBackground(new java.awt.Color(255, 255, 153));
        jTerza.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTerza.setForeground(new java.awt.Color(0, 0, 153));
        jTerza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTerzaActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 0));
        jLabel20.setText("ice 3° diagnosi");

        jIceTerza.setBackground(new java.awt.Color(255, 255, 153));
        jIceTerza.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jIceTerza.setForeground(new java.awt.Color(0, 0, 153));

        jLabel21.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 0));
        jLabel21.setText("4° diagnosi");

        jQuarta.setBackground(new java.awt.Color(255, 255, 153));
        jQuarta.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jQuarta.setForeground(new java.awt.Color(0, 0, 153));

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setText("AMMINISTRATORE");

        jLabel22.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 0));
        jLabel22.setText("ice 4° diagnosi");

        jUser.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        jUser.setForeground(new java.awt.Color(255, 204, 0));
        jUser.setText("jLabel2");

        jCinqueClassi.setBackground(new java.awt.Color(102, 102, 102));
        jCinqueClassi.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCinqueClassi.setForeground(new java.awt.Color(255, 255, 0));
        jCinqueClassi.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4" }));

        jLabel31.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 204, 0));
        jLabel31.setText("5 classi ");

        jOldDataR.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jOldDataR.setForeground(new java.awt.Color(255, 204, 0));
        jOldDataR.setText("jLabel14");

        jOldDataD.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jOldDataD.setForeground(new java.awt.Color(255, 204, 0));
        jOldDataD.setText("jLabel32");

        jLabel33.setText("--------->");

        jLabel34.setText("--------->");

        jOldColldate.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jOldColldate.setForeground(new java.awt.Color(255, 204, 0));
        jOldColldate.setText("jLabel35");

        jLabel36.setText("--------->");

        jLogout.setBackground(new java.awt.Color(102, 102, 102));
        jLogout.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLogout.setForeground(new java.awt.Color(255, 255, 0));
        jLogout.setText("log out");
        jLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLogoutActionPerformed(evt);
            }
        });

        jExit.setBackground(new java.awt.Color(102, 102, 102));
        jExit.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jExit.setForeground(new java.awt.Color(255, 255, 0));
        jExit.setText("esci");
        jExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jExitActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 0));
        jLabel2.setText("Modifica ricovero n.");

        jID.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jID.setForeground(new java.awt.Color(255, 204, 0));
        jID.setText("jLabel14");

        jAdmin.setText("jLabel14");

        jMenuBar1.setBackground(new java.awt.Color(102, 102, 102));
        jMenuBar1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jMenuBar1.setForeground(new java.awt.Color(102, 102, 102));

        jMenu1.setBackground(new java.awt.Color(102, 102, 102));
        jMenu1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jMenu1.setForeground(new java.awt.Color(255, 102, 0));
        jMenu1.setText("File");
        jMenu1.setPreferredSize(new java.awt.Dimension(60, 20));
        jMenuBar1.add(jMenu1);

        jMenu2.setBackground(new java.awt.Color(102, 102, 102));
        jMenu2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jMenu2.setForeground(new java.awt.Color(255, 153, 0));
        jMenu2.setText("Edit");
        jMenu2.setPreferredSize(new java.awt.Dimension(60, 20));
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSeparator3, javax.swing.GroupLayout.DEFAULT_SIZE, 617, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSeparator2, javax.swing.GroupLayout.DEFAULT_SIZE, 617, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSeparator4, javax.swing.GroupLayout.DEFAULT_SIZE, 617, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel8)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jOldDataD))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(45, 45, 45)
                                    .addComponent(jOldDataR)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel13)
                                    .addComponent(jLab)
                                    .addComponent(jLabel25))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jOldColldate))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jDurata)
                                        .addComponent(jDRG)
                                        .addComponent(jCRC, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel36)
                            .addComponent(jLabel33)
                            .addComponent(jLabel34))
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel24)
                                    .addComponent(jLabel23))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jNPC)
                                    .addComponent(jCreat, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel26)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jAnnoC, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel27)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jMeseC, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel28)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jGiornoC, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(jLabel4)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jAnnoR, 0, 61, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel9)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jAnnoD, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel10)
                                        .addComponent(jLabel6))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jMeseD, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel11))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jMeseR, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel7)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jGiornoR, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jGiornoD, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(82, 82, 82))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 617, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel29)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel30)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDueClassi, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(jLabel31)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCinqueClassi, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel19)
                                    .addComponent(jLabel21)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel17))
                                .addGap(98, 98, 98)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jQuarta, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSeconda, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPrima, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTerza, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel20)
                                    .addComponent(jLabel22)
                                    .addComponent(jLabel18)
                                    .addComponent(jLabel16))
                                .addGap(73, 73, 73)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jIceQuarta, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                                    .addComponent(jIceTerza)
                                    .addComponent(jIceSeconda)
                                    .addComponent(jIcePrima)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jID))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCodice)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jExit, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jNome)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCognome)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jAdmin))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jUser, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLogout)
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGap(267, 267, 267)
                .addComponent(jConfirm)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLogout)
                    .addComponent(jLabel1)
                    .addComponent(jUser))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jID)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jNome)
                    .addComponent(jCognome)
                    .addComponent(jAdmin))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jCodice))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jAnnoR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jMeseR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jGiornoR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jOldDataR)
                    .addComponent(jLabel33))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(jOldDataD)
                        .addComponent(jLabel34))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(jAnnoD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10)
                        .addComponent(jMeseD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11)
                        .addComponent(jGiornoD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jDurata, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(jDRG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLab)
                            .addComponent(jCRC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23)
                            .addComponent(jNPC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(jCreat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel25)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel26)
                        .addComponent(jAnnoC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel27)
                        .addComponent(jMeseC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel28)
                        .addComponent(jGiornoC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel36)
                        .addComponent(jOldColldate)))
                .addGap(18, 18, 18)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(jLabel30)
                    .addComponent(jDueClassi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31)
                    .addComponent(jCinqueClassi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jPrima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16)
                            .addComponent(jIcePrima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jSeconda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18)
                            .addComponent(jIceSeconda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTerza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20)
                            .addComponent(jIceTerza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel17)
                        .addGap(13, 13, 13)
                        .addComponent(jLabel19)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jQuarta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22)
                    .addComponent(jIceQuarta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jConfirm)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jExit)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jAnnoRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAnnoRActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_jAnnoRActionPerformed

    private void jConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jConfirmActionPerformed
        String ID = jID.getText();
        String code = jCodice.getText();
        String nome = jNome.getText();
        String cognome = jCognome.getText();
        String annoR = (String)jAnnoR.getSelectedItem();
        String meseR = (String)jMeseR.getSelectedItem();
        String giornoR = (String)jGiornoR.getSelectedItem();
        String dataR = (""+annoR+"-"+meseR+"-"+giornoR+"");
        String annoD = (String)jAnnoD.getSelectedItem();
        String meseD = (String)jMeseD.getSelectedItem();
        String giornoD = (String)jGiornoD.getSelectedItem();
        String dataD = (""+annoD+"-"+meseD+"-"+giornoD+"");
        String durata = jDurata.getText();
        String DRG = jDRG.getText();
        String creat = jCreat.getText();
        String CRC = jCRC.getText();
        String prima = jPrima.getText();
        String iceprima = jIcePrima.getText();
        String seconda = jSeconda.getText();
        String iceseconda = jIceSeconda.getText();
        String terza = jTerza.getText();
        String iceterza = jIceTerza.getText();
        String quarta = jQuarta.getText();
        String icequarta = jIceQuarta.getText();
        String contab = jNPC.getText();
        String annoC = (String)jAnnoC.getSelectedItem();
        String meseC = (String)jMeseC.getSelectedItem();
        String giornoC = (String)jGiornoC.getSelectedItem();
        String dataC = (""+annoC+"-"+meseC+"-"+giornoC+"");
        String dueclassi = (String)jDueClassi.getSelectedItem();
        String cinqueclassi = (String)jCinqueClassi.getSelectedItem();
        String diabete = "0";
        String ipertensione = "0";
        if((prima.equals("250"))||(seconda.equals("250"))||(terza.equals("250"))||(quarta.equals("250"))){
            diabete = "1";
        }
        if((prima.equals("401"))||(seconda.equals("401"))||(terza.equals("401"))||(quarta.equals("401"))||(prima.equals("402"))||(seconda.equals("402"))||(terza.equals("402"))||(quarta.equals("402"))){
            ipertensione = "1";
        }

        if (!(seconda.equals(""))){
            if (iceseconda.equals("")){
                JOptionPane.showMessageDialog(this, "inserire indice della seconda diagnosi", "ERROR", JOptionPane.ERROR_MESSAGE);
                jIceSeconda.setText("");
             }
            if (!(terza.equals(""))){
                if (iceterza.equals("")){
                JOptionPane.showMessageDialog(this, "inserire indice della terza diagnosi", "ERROR", JOptionPane.ERROR_MESSAGE);
                jIceTerza.setText("");
             }
                if(!(quarta.equals(""))){
                    if(icequarta.equals("")){
                        JOptionPane.showMessageDialog(this, "inserire indice della quarta diagnosi", "ERROR", JOptionPane.ERROR_MESSAGE);
                        jIceQuarta.setText("");
                      }
                }

                else{
                    quarta = "NULL";
                    icequarta = "NULL";
                }
            }
            else{
                    terza = "NULL";
                    iceterza = "NULL";
                    quarta = "NULL";
                    icequarta = "NULL";
                }
           }
           else{
                    seconda = "NULL";
                    iceseconda = "NULL";
                    terza = "NULL";
                    iceterza ="NULL";
                    quarta = "NULL";
                    icequarta = "NULL";
              }

        if(!durata.isEmpty()&&!contab.isEmpty()&& !DRG.isEmpty()&& !prima.isEmpty()&& !iceprima.isEmpty()&& !creat.isEmpty()&&!CRC.isEmpty()){
            JOptionPane option = new JOptionPane("si procede con il salvataggio?", JOptionPane.QUESTION_MESSAGE, JOptionPane.YES_NO_OPTION);
                JDialog dialog = option.createDialog("WARNING!!!");
                dialog.pack();
                dialog.setVisible(true);
                int n = ((Integer)option.getValue()).intValue();
                System.out.println(n);
                if (n == 0){
                    /*try{
                        URL address = new URL("http://localhost:8080/soap/servlet/rpcrouter");
                        Call chiamata=new Call();
                        chiamata.setTargetObjectURI("urn:crc");// l'ID della nostra RCP creata ad HOC
                        chiamata.setMethodName("RitornaID"); // chiamata del nostro metodo
                        chiamata.setEncodingStyleURI(Constants.NS_URI_SOAP_ENC); // codifica dei dati trasmessi
                        /* Imposto i parametri che devo inviare alla mia funzione tramite la chiamata RPC */
                        //System.out.println("SOAP call parameters:"+chiamata);
                        /* Tentiamo l'invocazione della RPC */
                        /*try {
                                    Response risposta = chiamata.invoke(address, "");
                                    Parameter par = risposta.getReturnValue(); // leggo la risposta
                                    Object value = par.getValue();
                                    //System.out.println("il valore di ritorno è :");
                                    System.out.println(value);
                                    int id1 = ((Integer) value).intValue ();
                                    String id = String.valueOf(id1);
                                    System.out.println(id);*/

                                    try{
                                              URL address = new URL("http://localhost:8080/soap/servlet/rpcrouter");
                                              Call chiama=new Call();
                                              chiama.setTargetObjectURI("urn:crc");// l'ID della nostra RCP creata ad HOC
                                              chiama.setMethodName("UpdateRic"); // chiamata del nostro metodo
                                              chiama.setEncodingStyleURI(Constants.NS_URI_SOAP_ENC); // codifica dei dati trasmessi
                                              /* Imposto i parametri che devo inviare alla mia funzione tramite la chiamata RPC */
                                              Vector parame = new Vector();
                                              parame.addElement(new Parameter("idricovero", String.class, ID, null));
                                              parame.addElement(new Parameter("codice", String.class, code, null));
                                              parame.addElement(new Parameter("dataRic", String.class, dataR, null));
                                              parame.addElement(new Parameter("durata", String.class, durata, null));
                                              parame.addElement(new Parameter("dataDim", String.class, dataD, null));
                                              parame.addElement(new Parameter("DRG", String.class, DRG, null));
                                              parame.addElement(new Parameter("prima", String.class, prima, null));
                                              parame.addElement(new Parameter("iceprima", String.class, iceprima, null));
                                              parame.addElement(new Parameter("seconda", String.class, seconda, null));
                                              parame.addElement(new Parameter("iceseconda", String.class, iceseconda, null));
                                              parame.addElement(new Parameter("terza", String.class, terza, null));
                                              parame.addElement(new Parameter("iceterza", String.class, iceterza, null));
                                              parame.addElement(new Parameter("quarta", String.class, quarta, null));
                                              parame.addElement(new Parameter("icequarta", String.class, icequarta, null));
                                              parame.addElement(new Parameter("NPC", String.class, contab, null));
                                              parame.addElement(new Parameter("colldate", String.class, dataC, null));
                                              parame.addElement(new Parameter("creat", String.class, creat, null));
                                              parame.addElement(new Parameter("CRC", String.class, CRC, null));
                                              parame.addElement(new Parameter("cinqueclassi", String.class,cinqueclassi , null));
                                              parame.addElement(new Parameter("dueclassi", String.class, dueclassi, null));
                                              parame.addElement(new Parameter("diabete", String.class, diabete, null));
                                              parame.addElement(new Parameter("ipertensione", String.class, ipertensione, null));


                                              chiama.setParams(parame); // impostiamo i parametri creati nella chiamata
                                              System.out.println("SOAP call parameters:"+chiama);
                                              /* Tentiamo l'invocazione della RPC */
                                              try {
                                                  Response rispo = chiama.invoke(address, "");
                                                  Parameter para = rispo.getReturnValue(); // leggo la risposta
                                                  Object value2 = para.getValue();
                                                  String msg = String.valueOf(value2);
                                                  System.out.println(msg);

                                                  if (msg.equals("si")){
                                                        JOptionPane.showMessageDialog(this, "Inserimento Completato con successo", "Succeded", JOptionPane.INFORMATION_MESSAGE);
                                                    }
                                                    else{
                                                         JOptionPane.showMessageDialog(this, "Attenzione nuovo ricovero non inserito", "errore", JOptionPane.ERROR_MESSAGE);


                                                    }

                                              /*}
                                              catch(SOAPException e){
                                                    JOptionPane.showMessageDialog(this, "attenzione si è verificato un errore1", "errore", JOptionPane.ERROR_MESSAGE);
                                                    System.out.println("errore causato:("+e.getFaultCode()+"):"+e.getMessage());
                                              }
                                    }
                                        catch(Exception ex){
                                             JOptionPane.showMessageDialog(this, "attenzione errore", "errore", JOptionPane.ERROR_MESSAGE);
                                             System.out.println(ex.getMessage());
                                        }*/



                                    /*try{
                                              Call chiama=new Call();
                                              chiama.setTargetObjectURI("urn:crc");// l'ID della nostra RCP creata ad HOC
                                              chiama.setMethodName("newRicovero"); // chiamata del nostro metodo
                                              chiama.setEncodingStyleURI(Constants.NS_URI_SOAP_ENC); // codifica dei dati trasmessi

                                              Vector parame = new Vector();
                                              parame.addElement(new Parameter("id", int.class, id, null));
                                              parame.addElement(new Parameter("codice", String.class, code, null));
                                              parame.addElement(new Parameter("dataR", String.class, dataR, null));
                                              parame.addElement(new Parameter("durata", String.class, durata, null));
                                              parame.addElement(new Parameter("dataD", String.class, dataD, null));
                                              parame.addElement(new Parameter("DRG", String.class, DRG, null));
                                              parame.addElement(new Parameter("prima", String.class, prima, null));
                                              parame.addElement(new Parameter("iceprima", String.class, iceprima, null));
                                              parame.addElement(new Parameter("seconda", String.class, seconda, null));
                                              parame.addElement(new Parameter("iceseconda", String.class, iceseconda, null));
                                              parame.addElement(new Parameter("terza", String.class, terza, null));
                                              parame.addElement(new Parameter("iceterza", String.class, iceterza, null));
                                              parame.addElement(new Parameter("quarta", String.class, quarta, null));
                                              parame.addElement(new Parameter("icequarta", String.class, icequarta, null));
                                              parame.addElement(new Parameter("NPC", String.class, NPC, null));
                                              parame.addElement(new Parameter("dataC", String.class, dataC, null));
                                              parame.addElement(new Parameter("creat", String.class, creat, null));
                                              parame.addElement(new Parameter("CRC", String.class, CRC, null));
                                              parame.addElement(new Parameter("5classi", String.class,cinqueclassi , null));
                                              parame.addElement(new Parameter("2classi", String.class, dueclassi, null));
                                              parame.addElement(new Parameter("diabete", String.class, diabete, null));
                                              parame.addElement(new Parameter("ipertensione", String.class, ipertensione, null));
                                              chiama.setParams(parame); // impostiamo i parametri creati nella chiamata
                                              System.out.println("SOAP call parameters:"+chiama);

                                              try {
                                                    Response rispo = chiama.invoke(address, "");
                                                    Parameter para = rispo.getReturnValue(); // leggo la risposta
                                                    String msg1=(String) para.getValue();
                                                    if (msg1.equals("si")){
                                                        JOptionPane.showMessageDialog(this, "Inserimento Completato con successo", "Succeded", JOptionPane.INFORMATION_MESSAGE);
                                                    }
                                                    else{
                                                         JOptionPane.showMessageDialog(this, "Attenzione nuovo ricovero non inserito", "errore", JOptionPane.ERROR_MESSAGE);
                                                    }

                                              }
                                              catch(SOAPException e){
                                                    JOptionPane.showMessageDialog(this, "attenzione si è verificato un errore", "errore", JOptionPane.ERROR_MESSAGE);
                                                    System.out.println("errore causato:("+e.getFaultCode()+"):"+e.getMessage());
                                              }
                                        }
                                        catch(Exception ex){
                                             JOptionPane.showMessageDialog(this, "attenzione errore", "errore", JOptionPane.ERROR_MESSAGE);
                                             System.out.println("L'errore del cazzo è :");
                                             System.out.println(ex.getMessage());
                                        }*/





                        }
                             catch(SOAPException e){
                                   JOptionPane.showMessageDialog(this, "attenzione si è verificato un errore", "errore", JOptionPane.ERROR_MESSAGE);
                                   System.out.println("errore causato:("+e.getFaultCode()+"):"+e.getMessage());
                             }
                    }
                        catch(MalformedURLException ex){
                              JOptionPane.showMessageDialog(this, "attenzione ID Libro già in uso", "errore", JOptionPane.ERROR_MESSAGE);
                              System.out.println(ex.getMessage());
                        }
                        }
                }

    }//GEN-LAST:event_jConfirmActionPerformed

    private void jDurataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jDurataActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_jDurataActionPerformed

    private void jIceSecondaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jIceSecondaActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_jIceSecondaActionPerformed

    private void jTerzaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTerzaActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_jTerzaActionPerformed

    private void jExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jExitActionPerformed
        JOptionPane option = new JOptionPane("Are you sure you want to exit?", JOptionPane.QUESTION_MESSAGE, JOptionPane.YES_NO_OPTION);
        JDialog dialog = option.createDialog("WARNING!!!");
        dialog.pack();
        dialog.setVisible(true);
        int n = ((Integer)option.getValue()).intValue();
        if (n == 0) {
            System.exit(0);
        }
    }//GEN-LAST:event_jExitActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String user=jUser.getText();
        String code = jCodice.getText();
        String nome = jNome.getText();
        String cognome = jCognome.getText();
        int admin = jAdmin.getDisplayedMnemonic();
        new ModificaRic2(user,code,nome, cognome, admin).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLogoutActionPerformed
        JOptionPane option = new JOptionPane("Vuoi Davvero Disconneterti?", JOptionPane.QUESTION_MESSAGE, JOptionPane.YES_NO_OPTION);
        JDialog dialog = option.createDialog("WARNING!!!");
        dialog.pack();
        dialog.setVisible(true);

        int n = ((Integer)option.getValue()).intValue();
        if (n == 0){
            new Login().setVisible(true);
            this.dispose();
        }
}//GEN-LAST:event_jLogoutActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jAdmin;
    private javax.swing.JComboBox jAnnoC;
    private javax.swing.JComboBox jAnnoD;
    private javax.swing.JComboBox jAnnoR;
    private javax.swing.JButton jButton3;
    private javax.swing.JTextField jCRC;
    private javax.swing.JComboBox jCinqueClassi;
    private javax.swing.JLabel jCodice;
    private javax.swing.JLabel jCognome;
    private javax.swing.JButton jConfirm;
    private javax.swing.JTextField jCreat;
    private javax.swing.JTextField jDRG;
    private javax.swing.JComboBox jDueClassi;
    private javax.swing.JTextField jDurata;
    private javax.swing.JButton jExit;
    private javax.swing.JComboBox jGiornoC;
    private javax.swing.JComboBox jGiornoD;
    private javax.swing.JComboBox jGiornoR;
    private javax.swing.JLabel jID;
    private javax.swing.JTextField jIcePrima;
    private javax.swing.JTextField jIceQuarta;
    private javax.swing.JTextField jIceSeconda;
    private javax.swing.JTextField jIceTerza;
    private javax.swing.JLabel jLab;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JButton jLogout;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JComboBox jMeseC;
    private javax.swing.JComboBox jMeseD;
    private javax.swing.JComboBox jMeseR;
    private javax.swing.JTextField jNPC;
    private javax.swing.JLabel jNome;
    private javax.swing.JLabel jOldColldate;
    private javax.swing.JLabel jOldDataD;
    private javax.swing.JLabel jOldDataR;
    private javax.swing.JTextField jPrima;
    private javax.swing.JTextField jQuarta;
    private javax.swing.JTextField jSeconda;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTextField jTerza;
    private javax.swing.JLabel jUser;
    // End of variables declaration//GEN-END:variables

}
