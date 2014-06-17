/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ClientCRC;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.soap.Constants;
import org.apache.soap.SOAPException;
import org.apache.soap.rpc.Call;
import org.apache.soap.rpc.Parameter;
import org.apache.soap.rpc.Response;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import java.net.*;
import java.util.Vector;
import org.apache.soap.rpc.*;
import org.apache.soap.Constants;
import org.apache.soap.SOAPException;
import java.lang.*;
import javax.swing.JDialog;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import java.net.*;
import java.util.Vector;
import javax.swing.JDialog;
import org.apache.soap.rpc.*;
import org.apache.soap.Constants;
import org.apache.soap.SOAPException;
import javax.swing.table.DefaultTableModel;

import java.io.File;
import java.io.IOException;
import java.util.Locale;
import jxl.CellView;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import javax.swing.*;
import java.io.*;
import java.text.MessageFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.filechooser.FileFilter;
import sun.net.www.content.text.plain;

/**
 *
 * @author alessandro
 */
public class NewRicerca2C extends javax.swing.JFrame implements ActionListener {
private Font myFont = new Font("Tahoma", Font.PLAIN,11);
    /**
     * Creates new form NewRicerca2C
     */
    public NewRicerca2C(String cerca, String user) {
        initComponents();
        this.getContentPane().setBackground(Color.DARK_GRAY);
        this.setIconImage(new ImageIcon("C:\\SOAP\\images\\icon.gif").getImage());
        jUser.setText(user);
        jLabel4.setText(cerca);
        
        //JMenu passaMenu = new JMenu("Passa a");
        //JMenuItem apriMenu = new JMenuItem("Apri SPSS");
        JMenuItem salvaMenu = new JMenuItem("Salva Tabella");
        //JMenuItem disconnettiMenu = new JMenuItem("Disconnetti");
        //JMenuItem esciMenu = new JMenuItem("Esci da ReCronix");
        //JMenuItem adminMenu = new JMenuItem("admin");
        JMenuItem apritabMenu = new JMenuItem("Apri tabella con SPSS");
        JMenuItem indietroMenu = new JMenuItem("Indietro");
        JMenuItem guidaMenu = new JMenuItem("Guida");
        JMenuItem creditMenu = new JMenuItem("Credits");
        JMenuItem apriMenu = new JMenuItem("Apri SPSS");
        
        creditMenu.setFont(myFont);
        creditMenu.setBackground(Color.DARK_GRAY);
        creditMenu.setForeground(Color.yellow);
        
        apriMenu.setFont(myFont);
        apriMenu.setBackground(Color.DARK_GRAY);
        apriMenu.setForeground(Color.yellow);
        
        
        guidaMenu.setFont(myFont);
        guidaMenu.setBackground(Color.DARK_GRAY);
        guidaMenu.setForeground(Color.yellow);
             
        apritabMenu.setFont(myFont);
        apritabMenu.setBackground(Color.DARK_GRAY);
        apritabMenu.setForeground(Color.yellow);
        
        salvaMenu.setFont(myFont);
        salvaMenu.setBackground(Color.DARK_GRAY);
        salvaMenu.setForeground(Color.yellow);
        
        indietroMenu.setFont(myFont);
        indietroMenu.setBackground(Color.DARK_GRAY);
        indietroMenu.setForeground(Color.yellow);
        
        
        jMenu1.add(apritabMenu);
        jMenu1.add(salvaMenu);
        jMenu1.add(indietroMenu);
        jMenu1.addSeparator();
        jMenu1.setBackground(Color.DARK_GRAY);
        jMenu1.add(apriMenu);
        jMenu2.add(guidaMenu);
        jMenu2.addSeparator();
        jMenu2.add(creditMenu);
        
        indietroMenu.addActionListener(this);
        apritabMenu.addActionListener(this);
        salvaMenu.addActionListener(this);
        guidaMenu.addActionListener(this);
        creditMenu.addActionListener(this);
        apriMenu.addActionListener(this);
        
        jUser.setText(user);
        
        String username = jUser.getText();
        try {
                  URL address = new URL("http://localhost:8080/soap/servlet/rpcrouter");
                  Call chiamata = new Call();
                  chiamata.setTargetObjectURI("urn:crc");
                  chiamata.setMethodName("getTabCode2C");
                  chiamata.setEncodingStyleURI(Constants.NS_URI_SOAP_ENC);
                  Vector parametri = new Vector();
                  parametri.addElement(new Parameter("MDC", String.class, cerca , null));
                  chiamata.setParams(parametri); // impostiamo i parametri creati nella chiamata
                  try {
                        Response risposta = chiamata.invoke(address, "");
                        if (!risposta.generatedFault()) {
                              Parameter par = risposta.getReturnValue();
                              Vector code = (Vector) par.getValue();
         try {
                  Call chiamata1 = new Call();
                  chiamata1.setTargetObjectURI("urn:crc");
                  chiamata1.setMethodName("getTabCognome2C");
                  chiamata1.setEncodingStyleURI(Constants.NS_URI_SOAP_ENC);
                  Vector parametri1 = new Vector();
                  parametri1.addElement(new Parameter("MDC", String.class, cerca , null));
                  chiamata1.setParams(parametri1);
                  try {
                        Response risposta1 = chiamata1.invoke(address, "");
                        if (!risposta1.generatedFault()) {
                              Parameter par1 = risposta1.getReturnValue();
                              Vector secondname = (Vector) par1.getValue();
         try {
                  Call chiamata2 = new Call();
                  chiamata2.setTargetObjectURI("urn:crc");
                  chiamata2.setMethodName("getTabNome2C");
                  chiamata2.setEncodingStyleURI(Constants.NS_URI_SOAP_ENC);
                  Vector parametri2 = new Vector();
                  parametri2.addElement(new Parameter("MDC", String.class, cerca , null));
                  chiamata2.setParams(parametri2);
                  try {
                        Response risposta2 = chiamata2.invoke(address, "");
                        if (!risposta2.generatedFault()) {
                              Parameter par2 = risposta2.getReturnValue();
                              Vector name = (Vector) par2.getValue();
         try {
                  Call chiamata3 = new Call();
                  chiamata3.setTargetObjectURI("urn:crc");
                  chiamata3.setMethodName("getTabData2C");
                  chiamata3.setEncodingStyleURI(Constants.NS_URI_SOAP_ENC);
                  Vector parametri3 = new Vector();
                  parametri3.addElement(new Parameter("MDC", String.class, cerca , null));
                  chiamata3.setParams(parametri3);
                  try {
                        Response risposta3 = chiamata3.invoke(address, "");
                        if (!risposta3.generatedFault()) {
                              Parameter par3 = risposta3.getReturnValue();
                              Vector date = (Vector) par3.getValue();
          try {
                  Call chiamata4 = new Call();
                  chiamata4.setTargetObjectURI("urn:crc");
                  chiamata4.setMethodName("getTabEta2C");
                  chiamata4.setEncodingStyleURI(Constants.NS_URI_SOAP_ENC);
                  Vector parametri4 = new Vector();
                  parametri4.addElement(new Parameter("MDC", String.class, cerca , null));
                  chiamata4.setParams(parametri4);
                  try {
                        Response risposta4 = chiamata4.invoke(address, "");
                        if (!risposta4.generatedFault()) {
                              Parameter par4 = risposta4.getReturnValue();
                              Vector age = (Vector) par4.getValue();
          try {
                  Call chiamata5 = new Call();
                  chiamata5.setTargetObjectURI("urn:crc");
                  chiamata5.setMethodName("getTabSesso2C");
                  chiamata5.setEncodingStyleURI(Constants.NS_URI_SOAP_ENC);
                  Vector parametri5 = new Vector();
                  parametri5.addElement(new Parameter("MDC", String.class, cerca , null));
                  chiamata5.setParams(parametri5);
                  try {
                        Response risposta5 = chiamata5.invoke(address, "");
                        if (!risposta5.generatedFault()) {
                              Parameter par5 = risposta5.getReturnValue();
                              Vector sex = (Vector) par5.getValue();
         try {
                  Call chiamata6 = new Call();
                  chiamata6.setTargetObjectURI("urn:crc");
                  chiamata6.setMethodName("getTabDatar2C");
                  chiamata6.setEncodingStyleURI(Constants.NS_URI_SOAP_ENC);
                  Vector parametri6 = new Vector();
                  parametri6.addElement(new Parameter("MDC", String.class, cerca , null));
                  chiamata6.setParams(parametri6);
                  try {
                        Response risposta6 = chiamata6.invoke(address, "");
                        if (!risposta6.generatedFault()) {
                              Parameter par6 = risposta6.getReturnValue();
                              Vector datar = (Vector) par6.getValue();
         try {
                  
                  Call chiamata7 = new Call();
                  chiamata7.setTargetObjectURI("urn:crc");
                  chiamata7.setMethodName("getTabDatad2C");
                  chiamata7.setEncodingStyleURI(Constants.NS_URI_SOAP_ENC);
                  Vector parametri7 = new Vector();
                  parametri7.addElement(new Parameter("MDC", String.class, cerca , null));
                  chiamata7.setParams(parametri7);
                  try {
                        Response risposta7 = chiamata7.invoke(address, "");
                        if (!risposta7.generatedFault()) {
                              Parameter par7 = risposta7.getReturnValue();
                              Vector datad = (Vector) par7.getValue();
         try {
                  Call chiamata8 = new Call();
                  chiamata8.setTargetObjectURI("urn:crc");
                  chiamata8.setMethodName("getTabDurata2C");
                  chiamata8.setEncodingStyleURI(Constants.NS_URI_SOAP_ENC);
                  Vector parametri8 = new Vector();
                  parametri8.addElement(new Parameter("MDC", String.class, cerca , null));
                  chiamata8.setParams(parametri8);
                  try {
                        Response risposta8 = chiamata8.invoke(address, "");
                        if (!risposta8.generatedFault()) {
                              Parameter par8 = risposta8.getReturnValue();
                              Vector durata = (Vector) par8.getValue();
          try {
                  Call chiamata9 = new Call();
                  chiamata9.setTargetObjectURI("urn:crc");
                  chiamata9.setMethodName("getTabDRG2C");
                  chiamata9.setEncodingStyleURI(Constants.NS_URI_SOAP_ENC);
                  Vector parametri9 = new Vector();
                  parametri9.addElement(new Parameter("MDC", String.class, cerca , null));
                  chiamata9.setParams(parametri9);
                  try {
                        Response risposta9 = chiamata9.invoke(address, "");
                        if (!risposta9.generatedFault()) {
                              Parameter par9 = risposta9.getReturnValue();
                              Vector DRG = (Vector) par9.getValue();
         try {                 
                  Call chiamata10 = new Call();
                  chiamata10.setTargetObjectURI("urn:crc");
                  chiamata10.setMethodName("getTabPrima2C");
                  chiamata10.setEncodingStyleURI(Constants.NS_URI_SOAP_ENC);
                  Vector parametri10 = new Vector();
                  parametri10.addElement(new Parameter("MDC", String.class, cerca , null));
                  chiamata10.setParams(parametri10);
                  try {
                        Response risposta10 = chiamata10.invoke(address, "");
                        if (!risposta10.generatedFault()) {
                              Parameter par10 = risposta10.getReturnValue();
                              Vector prima = (Vector) par10.getValue();
          try {
                  Call chiamata11 = new Call();
                  chiamata11.setTargetObjectURI("urn:crc");
                  chiamata11.setMethodName("getTabIcePrima2C");
                  chiamata11.setEncodingStyleURI(Constants.NS_URI_SOAP_ENC);
                  Vector parametri11 = new Vector();
                  parametri11.addElement(new Parameter("MDC", String.class, cerca , null));
                  chiamata11.setParams(parametri11);
                  try {
                        Response risposta11 = chiamata11.invoke(address, "");
                        if (!risposta11.generatedFault()) {
                              Parameter par11 = risposta11.getReturnValue();
                              Vector iceprima = (Vector) par11.getValue();
         try {
                  Call chiamata12 = new Call();
                  chiamata12.setTargetObjectURI("urn:crc");
                  chiamata12.setMethodName("getTabSeconda2C");
                  chiamata12.setEncodingStyleURI(Constants.NS_URI_SOAP_ENC);
                  Vector parametri12 = new Vector();
                  parametri12.addElement(new Parameter("MDC", String.class, cerca , null));
                  chiamata12.setParams(parametri12);
                  try {
                        Response risposta12 = chiamata12.invoke(address, "");
                        if (!risposta12.generatedFault()) {
                              Parameter par12 = risposta12.getReturnValue();
                              Vector seconda = (Vector) par12.getValue();
         try {
                  Call chiamata13 = new Call();
                  chiamata13.setTargetObjectURI("urn:crc");
                  chiamata13.setMethodName("getTabIceSeconda2C");
                  chiamata13.setEncodingStyleURI(Constants.NS_URI_SOAP_ENC);
                  Vector parametri13 = new Vector();
                  parametri13.addElement(new Parameter("MDC", String.class, cerca , null));
                  chiamata13.setParams(parametri13);
                  try {
                        Response risposta13 = chiamata13.invoke(address, "");
                        if (!risposta13.generatedFault()) {
                              Parameter par13 = risposta13.getReturnValue();
                              Vector iceseconda = (Vector) par13.getValue();
         try {
                  Call chiamata14 = new Call();
                  chiamata14.setTargetObjectURI("urn:crc");
                  chiamata14.setMethodName("getTabTerza2C");
                  chiamata14.setEncodingStyleURI(Constants.NS_URI_SOAP_ENC);
                  Vector parametri14 = new Vector();
                  parametri14.addElement(new Parameter("MDC", String.class, cerca , null));
                  chiamata14.setParams(parametri14);
                  try {
                        Response risposta14 = chiamata14.invoke(address, "");
                        if (!risposta14.generatedFault()) {
                              Parameter par14 = risposta14.getReturnValue();
                              Vector terza = (Vector) par14.getValue();
         try {
                  Call chiamata15 = new Call();
                  chiamata15.setTargetObjectURI("urn:crc");
                  chiamata15.setMethodName("getTabIceTerza2C");
                  chiamata15.setEncodingStyleURI(Constants.NS_URI_SOAP_ENC);
                  Vector parametri15 = new Vector();
                  parametri15.addElement(new Parameter("MDC", String.class, cerca , null));
                  chiamata15.setParams(parametri15);
                  try {
                        Response risposta15 = chiamata15.invoke(address, "");
                        if (!risposta15.generatedFault()) {
                              Parameter par15 = risposta15.getReturnValue();
                              Vector iceterza = (Vector) par15.getValue();
        try {
                  Call chiamata30 = new Call();
                  chiamata30.setTargetObjectURI("urn:crc");
                  chiamata30.setMethodName("getTabQuarta2C");
                  chiamata30.setEncodingStyleURI(Constants.NS_URI_SOAP_ENC);
                  Vector parametri30 = new Vector();
                  parametri30.addElement(new Parameter("MDC", String.class, cerca , null));
                  chiamata30.setParams(parametri30);
                  try {
                        Response risposta30 = chiamata30.invoke(address, "");
                        if (!risposta30.generatedFault()) {
                              Parameter par30 = risposta30.getReturnValue();
                              Vector quarta = (Vector) par30.getValue();

        try {
                  Call chiamata16 = new Call();
                  chiamata16.setTargetObjectURI("urn:crc");
                  chiamata16.setMethodName("getTabIceQuarta2C");
                  chiamata16.setEncodingStyleURI(Constants.NS_URI_SOAP_ENC);
                  Vector parametri16 = new Vector();
                  parametri16.addElement(new Parameter("MDC", String.class, cerca , null));
                  chiamata16.setParams(parametri16);
                  try {
                        Response risposta16 = chiamata16.invoke(address, "");
                        if (!risposta16.generatedFault()) {
                              Parameter par16 = risposta16.getReturnValue();
                              Vector icequarta = (Vector) par16.getValue();
        try {
                  Call chiamata17 = new Call();
                  chiamata17.setTargetObjectURI("urn:crc");
                  chiamata17.setMethodName("getTabNPC2C");
                  chiamata17.setEncodingStyleURI(Constants.NS_URI_SOAP_ENC);
                  Vector parametri17 = new Vector();
                  parametri17.addElement(new Parameter("MDC", String.class, cerca , null));
                  chiamata17.setParams(parametri17);
                  try {
                        Response risposta17 = chiamata17.invoke(address, "");
                        if (!risposta17.generatedFault()) {
                              Parameter par17 = risposta17.getReturnValue();
                              Vector NPC = (Vector) par17.getValue();
         try {
                Call chiama18 = new Call();
                chiama18.setTargetObjectURI("urn:crc");
                chiama18.setMethodName("getTabCollDate2C");
                chiama18.setEncodingStyleURI(Constants.NS_URI_SOAP_ENC);
                Vector parametri18 = new Vector();
                  parametri18.addElement(new Parameter("MDC", String.class, cerca , null));
                  chiama18.setParams(parametri18);
                try {
                      Response rispo18 = chiama18.invoke(address, "");
                      if (!rispo18.generatedFault()) {
                               Parameter para18 = rispo18.getReturnValue();
                               Vector colldate = (Vector) para18.getValue();
        try {
                  Call chiamata19 = new Call();
                  chiamata19.setTargetObjectURI("urn:crc");
                  chiamata19.setMethodName("getTabCreat2C");
                  chiamata19.setEncodingStyleURI(Constants.NS_URI_SOAP_ENC);
                  Vector parametri19 = new Vector();
                  parametri19.addElement(new Parameter("MDC", String.class, cerca , null));
                  chiamata19.setParams(parametri19);
                  try {
                        Response risposta19 = chiamata19.invoke(address, "");
                        if (!risposta19.generatedFault()) {
                              Parameter par19 = risposta19.getReturnValue();
                              Vector creat = (Vector) par19.getValue();
        try {
                Call chiama20 = new Call();
                chiama20.setTargetObjectURI("urn:crc");
                chiama20.setMethodName("getTabCRC2C");
                chiama20.setEncodingStyleURI(Constants.NS_URI_SOAP_ENC);
                Vector parametri20 = new Vector();
                  parametri20.addElement(new Parameter("MDC", String.class, cerca , null));
                  chiama20.setParams(parametri20);
                try {
                     Response rispo20 = chiama20.invoke(address, "");
                     if (!rispo20.generatedFault()) {
                                Parameter para20 = rispo20.getReturnValue();
                                Vector crc = (Vector) para20.getValue();

        try {
                Call chiama21 = new Call();
                chiama21.setTargetObjectURI("urn:crc");
                chiama21.setMethodName("getTab5classi2C");
                chiama21.setEncodingStyleURI(Constants.NS_URI_SOAP_ENC);
                Vector parametri21 = new Vector();
                  parametri21.addElement(new Parameter("MDC", String.class, cerca , null));
                  chiama21.setParams(parametri21);
                try {
                     Response rispo21 = chiama21.invoke(address, "");
                     if (!rispo21.generatedFault()) {
                                Parameter para21 = rispo21.getReturnValue();
                                Vector cinque = (Vector) para21.getValue();

        try {
                Call chiama22 = new Call();
                chiama22.setTargetObjectURI("urn:crc");
                chiama22.setMethodName("getTab2classi2C");
                chiama22.setEncodingStyleURI(Constants.NS_URI_SOAP_ENC);
                Vector parametri22 = new Vector();
                  parametri22.addElement(new Parameter("MDC", String.class, cerca , null));
                  chiama22.setParams(parametri22);
                try {
                     Response rispo22 = chiama22.invoke(address, "");
                     if (!rispo22.generatedFault()) {
                                Parameter para22 = rispo22.getReturnValue();
                                Vector due = (Vector) para22.getValue();

        try {
                Call chiama23 = new Call();
                chiama23.setTargetObjectURI("urn:crc");
                chiama23.setMethodName("getTabDiabete2C");
                chiama23.setEncodingStyleURI(Constants.NS_URI_SOAP_ENC);
                Vector parametri23 = new Vector();
                  parametri23.addElement(new Parameter("MDC", String.class, cerca , null));
                  chiama23.setParams(parametri23);
                try {
                     Response rispo23 = chiama23.invoke(address, "");
                     if (!rispo23.generatedFault()) {
                                Parameter para23 = rispo23.getReturnValue();
                                Vector diabete = (Vector) para23.getValue();

         try {
                Call chiama24 = new Call();
                chiama24.setTargetObjectURI("urn:crc");
                chiama24.setMethodName("getTabIpertensione2C");
                chiama24.setEncodingStyleURI(Constants.NS_URI_SOAP_ENC);
                Vector parametri24 = new Vector();
                  parametri24.addElement(new Parameter("MDC", String.class, cerca , null));
                  chiama24.setParams(parametri24);
                try {
                     Response rispo24 = chiama24.invoke(address, "");
                     if (!rispo24.generatedFault()) {
                                Parameter para24 = rispo24.getReturnValue();
                                Vector ipertensione = (Vector) para24.getValue();

          try {
                Call chiama25 = new Call();
                chiama25.setTargetObjectURI("urn:crc");
                chiama25.setMethodName("getTabMDC2C");
                chiama25.setEncodingStyleURI(Constants.NS_URI_SOAP_ENC);
                Vector parametri25 = new Vector();
                  parametri25.addElement(new Parameter("MDC", String.class, cerca , null));
                  chiama25.setParams(parametri25);
                try {
                     Response rispo25 = chiama25.invoke(address, "");
                     if (!rispo25.generatedFault()) {
                                Parameter para25 = rispo25.getReturnValue();
                                Vector MDC = (Vector) para25.getValue();

          try {
                Call chiama26 = new Call();
                chiama26.setTargetObjectURI("urn:crc");
                chiama26.setMethodName("getTabTipo2C");
                chiama26.setEncodingStyleURI(Constants.NS_URI_SOAP_ENC);
                Vector parametri26 = new Vector();
                  parametri26.addElement(new Parameter("MDC", String.class, cerca , null));
                  chiama26.setParams(parametri26);
                try {
                     Response rispo26 = chiama26.invoke(address, "");
                     if (!rispo26.generatedFault()) {
                                Parameter para26 = rispo26.getReturnValue();
                                Vector tipo = (Vector) para26.getValue();

          try {
                Call chiama27 = new Call();
                chiama27.setTargetObjectURI("urn:crc");
                chiama27.setMethodName("getTabDescrizione2C");
                chiama27.setEncodingStyleURI(Constants.NS_URI_SOAP_ENC);
                Vector parametri27 = new Vector();
                  parametri27.addElement(new Parameter("MDC", String.class, cerca , null));
                  chiama27.setParams(parametri27);
                try {
                     Response rispo27 = chiama27.invoke(address, "");
                     if (!rispo25.generatedFault()) {
                                Parameter para27 = rispo27.getReturnValue();
                                Vector descrizione = (Vector) para27.getValue();

          try {
                Call chiama28 = new Call();
                chiama28.setTargetObjectURI("urn:crc");
                chiama28.setMethodName("getTabPeso2C");
                chiama28.setEncodingStyleURI(Constants.NS_URI_SOAP_ENC);
                Vector parametri28 = new Vector();
                  parametri28.addElement(new Parameter("MDC", String.class, cerca , null));
                  chiama28.setParams(parametri28);
                try {
                     Response rispo28 = chiama28.invoke(address, "");
                     if (!rispo28.generatedFault()) {
                                Parameter para28 = rispo28.getReturnValue();
                                Vector peso = (Vector) para28.getValue();

         try {
                Call chiama29 = new Call();
                chiama29.setTargetObjectURI("urn:crc");
                chiama29.setMethodName("getTabSoglia2C");
                chiama29.setEncodingStyleURI(Constants.NS_URI_SOAP_ENC);
                Vector parametri29 = new Vector();
                  parametri29.addElement(new Parameter("MDC", String.class, cerca , null));
                  chiama29.setParams(parametri29);
                try {
                     Response rispo29 = chiama29.invoke(address, "");
                     if (!rispo29.generatedFault()) {
                                Parameter para29 = rispo29.getReturnValue();
                                Vector soglia = (Vector) para29.getValue();






                                //visualizzo il risultato nella tabella
                                DefaultTableModel modello = new DefaultTableModel() {
                                                                                                                                                                                                                                                                                                                                                                                                @Override
                                    public boolean isCellEditable(int row, int col) {
				return false;
                                }
                                };
                                
                                jTable1.setModel(modello);
                                modello.addColumn("codice",code );
                                modello.addColumn("cognome", secondname);
                                modello.addColumn("nome", name);
                                modello.addColumn("data di nascita", date);
                                modello.addColumn("eta'", age);
                                modello.addColumn("sesso", sex);
                                modello.addColumn("data ricovero", datar);
                                modello.addColumn("data dimissione", datad);
                                modello.addColumn("durata ricovero", durata);
                                modello.addColumn("DRG", DRG);
                                modello.addColumn("prima diagnosi", prima);
                                modello.addColumn("indice prima diagnosi", iceprima);
                                modello.addColumn("seconda diagnosi", seconda);
                                modello.addColumn("indice seconda diagnosi", iceseconda);
                                modello.addColumn("terza diagnosi", terza);
                                modello.addColumn("indice terza diagnosi", iceterza);
                                modello.addColumn("quarta diagnosi", quarta);
                                modello.addColumn("indice quarta diagnosi", icequarta);
                                modello.addColumn("nuova posizione contabile", NPC);
                                modello.addColumn("colldate", colldate);
                                modello.addColumn("creat", creat);
                                modello.addColumn("CRC", crc);
                                modello.addColumn("5classi", cinque);
                                modello.addColumn("2classi", due);
                                modello.addColumn("diabete", diabete);
                                modello.addColumn("ipertensione", ipertensione);
                                modello.addColumn("MDC", MDC);
                                modello.addColumn("tipo", tipo);
                                modello.addColumn("descrizione", descrizione);
                                modello.addColumn("peso", peso);
                                modello.addColumn("soglia", soglia);
                     }
                  } catch (SOAPException e) {
                                 System.out.println("Errore causato: (" + e.getFaultCode() + "):" + e.getMessage());
                  }
                  } catch (Exception e) {
                                          JOptionPane.showMessageDialog(this, "Attenzione si e verificato un errore", "Errore", JOptionPane.ERROR_MESSAGE);
                                          System.out.println(e.getMessage());
                   }
                   }
                  } catch (SOAPException e) {
                                 System.out.println("Errore causato: (" + e.getFaultCode() + "):" + e.getMessage());
                  }
                  } catch (Exception e) {
                                          JOptionPane.showMessageDialog(this, "Attenzione si e verificato un errore", "Errore", JOptionPane.ERROR_MESSAGE);
                                          System.out.println(e.getMessage());
                   }
                   }
                  } catch (SOAPException e) {
                                 System.out.println("Errore causato: (" + e.getFaultCode() + "):" + e.getMessage());
                  }
                  } catch (Exception e) {
                                          JOptionPane.showMessageDialog(this, "Attenzione si e verificato un errore", "Errore", JOptionPane.ERROR_MESSAGE);
                                          System.out.println(e.getMessage());
                   }
                   }
                  } catch (SOAPException e) {
                                 System.out.println("Errore causato: (" + e.getFaultCode() + "):" + e.getMessage());
                  }
                  } catch (Exception e) {
                                          JOptionPane.showMessageDialog(this, "Attenzione si e verificato un errore", "Errore", JOptionPane.ERROR_MESSAGE);
                                          System.out.println(e.getMessage());
                   }
                   }
                  } catch (SOAPException e) {
                                 System.out.println("Errore causato: (" + e.getFaultCode() + "):" + e.getMessage());
                  }
                  } catch (Exception e) {
                                          JOptionPane.showMessageDialog(this, "Attenzione si e verificato un errore", "Errore", JOptionPane.ERROR_MESSAGE);
                                          System.out.println(e.getMessage());
                   }




                   }
                   } catch (SOAPException e) {
                                         System.out.println("Errore causato: (" + e.getFaultCode() + "):" + e.getMessage());
                   }
                   }catch (Exception e) {
                                          JOptionPane.showMessageDialog(this, "Attenzione si e verificato un errore", "Errore", JOptionPane.ERROR_MESSAGE);
                                          System.out.println(e.getMessage());
                   }

                   }
                   } catch (SOAPException e) {
                                         System.out.println("Errore causato: (" + e.getFaultCode() + "):" + e.getMessage());
                   }
                   }catch (Exception e) {
                                          JOptionPane.showMessageDialog(this, "Attenzione si e verificato un errore", "Errore", JOptionPane.ERROR_MESSAGE);
                                          System.out.println(e.getMessage());
                   }

                   }
                   } catch (SOAPException e) {
                                         System.out.println("Errore causato: (" + e.getFaultCode() + "):" + e.getMessage());
                   }
                   }catch (Exception e) {
                                          JOptionPane.showMessageDialog(this, "Attenzione si e verificato un errore", "Errore", JOptionPane.ERROR_MESSAGE);
                                          System.out.println(e.getMessage());
                   }


                   }
                   } catch (SOAPException e) {
                                         System.out.println("Errore causato: (" + e.getFaultCode() + "):" + e.getMessage());
                   }
                   }catch (Exception e) {
                                          JOptionPane.showMessageDialog(this, "Attenzione si e verificato un errore", "Errore", JOptionPane.ERROR_MESSAGE);
                                          System.out.println(e.getMessage());
                   }
                                
                   }
                   } catch (SOAPException e) {
                                         System.out.println("Errore causato: (" + e.getFaultCode() + "):" + e.getMessage());
                   }
                   }catch (Exception e) {
                                          JOptionPane.showMessageDialog(this, "Attenzione si e verificato un errore", "Errore", JOptionPane.ERROR_MESSAGE);
                                          System.out.println(e.getMessage());
                   }

                   }
                   } catch (SOAPException e) {
                                         System.out.println("Errore causato: (" + e.getFaultCode() + "):" + e.getMessage());
                   }
                   }catch (Exception e) {
                                          JOptionPane.showMessageDialog(this, "Attenzione si e verificato un errore", "Errore", JOptionPane.ERROR_MESSAGE);
                                          System.out.println(e.getMessage());
                   }

                   }
                   } catch (SOAPException e) {
                                         System.out.println("Errore causato: (" + e.getFaultCode() + "):" + e.getMessage());
                   }
                   }catch (Exception e) {
                                          JOptionPane.showMessageDialog(this, "Attenzione si e verificato un errore", "Errore", JOptionPane.ERROR_MESSAGE);
                                          System.out.println(e.getMessage());
                   }

                   }
                   } catch (SOAPException e) {
                                         System.out.println("Errore causato: (" + e.getFaultCode() + "):" + e.getMessage());
                   }
                   }catch (Exception e) {
                                          JOptionPane.showMessageDialog(this, "Attenzione si e verificato un errore", "Errore", JOptionPane.ERROR_MESSAGE);
                                          System.out.println(e.getMessage());
                   }


                   }
                   } catch (SOAPException e) {
                                         System.out.println("Errore causato: (" + e.getFaultCode() + "):" + e.getMessage());
                   }
                   }catch (Exception e) {
                                          JOptionPane.showMessageDialog(this, "Attenzione si e verificato un errore", "Errore", JOptionPane.ERROR_MESSAGE);
                                          System.out.println(e.getMessage());
                   }
                              
                   }
                   } catch (SOAPException e) {
                                         System.out.println("Errore causato: (" + e.getFaultCode() + "):" + e.getMessage());
                   }
                   }catch (Exception e) {
                                          JOptionPane.showMessageDialog(this, "Attenzione si e verificato un errore", "Errore", JOptionPane.ERROR_MESSAGE);
                                          System.out.println(e.getMessage());
                   }

                   }
                   } catch (SOAPException e) {
                                         System.out.println("Errore causato: (" + e.getFaultCode() + "):" + e.getMessage());
                   }
                   }catch (Exception e) {
                                          JOptionPane.showMessageDialog(this, "Attenzione si e verificato un errore", "Errore", JOptionPane.ERROR_MESSAGE);
                                          System.out.println(e.getMessage());
                   }

                   }
                   } catch (SOAPException e) {
                                         System.out.println("Errore causato: (" + e.getFaultCode() + "):" + e.getMessage());
                   }
                   }catch (Exception e) {
                                          JOptionPane.showMessageDialog(this, "Attenzione si e verificato un errore", "Errore", JOptionPane.ERROR_MESSAGE);
                                          System.out.println(e.getMessage());
                   }

                   }
                   } catch (SOAPException e) {
                                         System.out.println("Errore causato: (" + e.getFaultCode() + "):" + e.getMessage());
                   }
                   }catch (Exception e) {
                                          JOptionPane.showMessageDialog(this, "Attenzione si e verificato un errore", "Errore", JOptionPane.ERROR_MESSAGE);
                                          System.out.println(e.getMessage());
                   }

                   }
                   } catch (SOAPException e) {
                                         System.out.println("Errore causato: (" + e.getFaultCode() + "):" + e.getMessage());
                   }
                   }catch (Exception e) {
                                          JOptionPane.showMessageDialog(this, "Attenzione si e verificato un errore", "Errore", JOptionPane.ERROR_MESSAGE);
                                          System.out.println(e.getMessage());
                   }

                   }
                   } catch (SOAPException e) {
                                         System.out.println("Errore causato: (" + e.getFaultCode() + "):" + e.getMessage());
                   }
                   }catch (Exception e) {
                                          JOptionPane.showMessageDialog(this, "Attenzione si e verificato un errore", "Errore", JOptionPane.ERROR_MESSAGE);
                                          System.out.println(e.getMessage());
                   }

                   }
                   } catch (SOAPException e) {
                                         System.out.println("Errore causato: (" + e.getFaultCode() + "):" + e.getMessage());
                   }
                   }catch (Exception e) {
                                          JOptionPane.showMessageDialog(this, "Attenzione si e verificato un errore", "Errore", JOptionPane.ERROR_MESSAGE);
                                          System.out.println(e.getMessage());
                   }

                   }
                   } catch (SOAPException e) {
                                         System.out.println("Errore causato: (" + e.getFaultCode() + "):" + e.getMessage());
                   }
                   }catch (Exception e) {
                                          JOptionPane.showMessageDialog(this, "Attenzione si e verificato un errore", "Errore", JOptionPane.ERROR_MESSAGE);
                                          System.out.println(e.getMessage());
                   }

                   }
                   } catch (SOAPException e) {
                                         System.out.println("Errore causato: (" + e.getFaultCode() + "):" + e.getMessage());
                   }
                   }catch (Exception e) {
                                          JOptionPane.showMessageDialog(this, "Attenzione si e verificato un errore", "Errore", JOptionPane.ERROR_MESSAGE);
                                          System.out.println(e.getMessage());
                   }




                   }
                   } catch (SOAPException e) {
                                         System.out.println("Errore causato: (" + e.getFaultCode() + "):" + e.getMessage());
                   }
                   }catch (Exception e) {
                                          JOptionPane.showMessageDialog(this, "Attenzione si e verificato un errore", "Errore", JOptionPane.ERROR_MESSAGE);
                                          System.out.println(e.getMessage());
                   }


                   }
                   } catch (SOAPException e) {
                                         System.out.println("Errore causato: (" + e.getFaultCode() + "):" + e.getMessage());
                   }
                   }catch (Exception e) {
                                          JOptionPane.showMessageDialog(this, "Attenzione si e verificato un errore", "Errore", JOptionPane.ERROR_MESSAGE);
                                          System.out.println(e.getMessage());
                   }


                   }
                   } catch (SOAPException e) {
                                         System.out.println("Errore causato: (" + e.getFaultCode() + "):" + e.getMessage());
                   }
                   }catch (Exception e) {
                                          JOptionPane.showMessageDialog(this, "Attenzione si e verificato un errore", "Errore", JOptionPane.ERROR_MESSAGE);
                                          System.out.println(e.getMessage());
                   }


                   }
                   } catch (SOAPException e) {
                                         System.out.println("Errore causato: (" + e.getFaultCode() + "):" + e.getMessage());
                   }
                   }catch (Exception e) {
                                          JOptionPane.showMessageDialog(this, "Attenzione si e verificato un errore", "Errore", JOptionPane.ERROR_MESSAGE);
                                          System.out.println(e.getMessage());
                   }


                   }
                   } catch (SOAPException e) {
                                         System.out.println("Errore causato: (" + e.getFaultCode() + "):" + e.getMessage());
                   }
                   }catch (Exception e) {
                                          JOptionPane.showMessageDialog(this, "Attenzione si e verificato un errore", "Errore", JOptionPane.ERROR_MESSAGE);
                                          System.out.println(e.getMessage());
                   }


                   }
                   } catch (SOAPException e) {
                                         System.out.println("Errore causato: (" + e.getFaultCode() + "):" + e.getMessage());
                   }
                   }catch (Exception e) {
                                          JOptionPane.showMessageDialog(this, "Attenzione si e verificato un errore", "Errore", JOptionPane.ERROR_MESSAGE);
                                          System.out.println(e.getMessage());
                   }


                   }
                   } catch (SOAPException e) {
                                         System.out.println("Errore causato: (" + e.getFaultCode() + "):" + e.getMessage());
                   }
                   }catch (Exception e) {
                                          JOptionPane.showMessageDialog(this, "Attenzione si e verificato un errore", "Errore", JOptionPane.ERROR_MESSAGE);
                                          System.out.println(e.getMessage());
                   }


                  }

                   }catch (SOAPException e) {
                                            System.out.println("Errore causato: (" +e.getFaultCode()+ "):" + e.getMessage());
                   }


                   } catch (MalformedURLException es) {
                                            JOptionPane.showMessageDialog(this, "Attenzione si e verificato un errore", "Errore", JOptionPane.ERROR_MESSAGE);
                                            System.out.println(es.getMessage());
                   }

        jTable1.addMouseListener(new MouseAdapter(){
            @Override
     public void mouseClicked(MouseEvent e){
      if (e.getClickCount() == 1){
         System.out.println("single click" );
         }
      else if (e.getClickCount()== 2){
        System.out.println("double click");
        int rows[] = jTable1.getSelectedRows();
        String user= jUser.getText();
        String code = (String) jTable1.getValueAt(rows[0], 0);
        String cognome= (String)jTable1.getValueAt(rows[0],1);
        String nome = (String)jTable1.getValueAt(rows[0],2);
        String data = (String)jTable1.getValueAt(rows[0],3);
        String età = (String)jTable1.getValueAt(rows[0],4);
        String sesso = (String)jTable1.getValueAt(rows[0],5);
        String dataric = (String)jTable1.getValueAt(rows[0],6);
        String datadim = (String)jTable1.getValueAt(rows[0],7);
        String durata = (String)jTable1.getValueAt(rows[0],8);
        String DRG = (String)jTable1.getValueAt(rows[0],9);
        String prima = (String)jTable1.getValueAt(rows[0],10);
        String iceprima = (String)jTable1.getValueAt(rows[0],11);
        String seconda = (String)jTable1.getValueAt(rows[0],12);
        String iceseconda = (String)jTable1.getValueAt(rows[0],13);
        String terza = (String)jTable1.getValueAt(rows[0],14);
        String iceterza = (String)jTable1.getValueAt(rows[0],15);
        String quarta = (String)jTable1.getValueAt(rows[0],16);
        String icequarta = (String)jTable1.getValueAt(rows[0],17);
        String NPC = (String)jTable1.getValueAt(rows[0],18);
        String colldate = (String)jTable1.getValueAt(rows[0],19);
        String creat = (String)jTable1.getValueAt(rows[0],20);
        String CRC = (String)jTable1.getValueAt(rows[0],21);
        String cinqueclassi = (String)jTable1.getValueAt(rows[0],22);
        String dueclassi = (String)jTable1.getValueAt(rows[0],23);
        String diabete = (String)jTable1.getValueAt(rows[0],24);
        String ipertensione = (String)jTable1.getValueAt(rows[0],25);
        String MDC = (String)jTable1.getValueAt(rows[0],26);
        String tipo = (String)jTable1.getValueAt(rows[0], 27);
        String descrizione = (String)jTable1.getValueAt(rows[0], 28);
        String peso = (String)jTable1.getValueAt(rows[0],29);
        String soglia = (String)jTable1.getValueAt(rows[0], 30);
        int id = (rows[0]);
        float mass = 0;
        String id2 = String.valueOf(id);
        try{
                        
                        Call chiamata=new Call();
                        chiamata.setTargetObjectURI("urn:crc");// l'ID della nostra RCP creata ad HOC
                        chiamata.setMethodName("getPesoMax"); // chiamata del nostro metodo
                        chiamata.setEncodingStyleURI(Constants.NS_URI_SOAP_ENC); // codifica dei dati trasmessi
                        /* Imposto i parametri che devo inviare alla mia funzione tramite la chiamata RPC */
                        System.out.println("SOAP call parameters:"+chiamata);
                        /* Tentiamo l'invocazione della RPC */
                        try {
                                    URL address = new URL("http://localhost:8080/soap/servlet/rpcrouter");
                                    Response risposta = chiamata.invoke(address, "");
                                    Parameter par = risposta.getReturnValue(); // leggo la risposta
                                    Object value = par.getValue();
                                    //System.out.println("il valore di ritorno è :");
                                    System.out.println("?");
                                    System.out.println(value);
                                    //mass = ((Float) value).floatValue ();
                                    //System.out.println("??");
                                    String max = String.valueOf(value);
                                    //System.out.println("???");
                                    String s2 = max.replaceAll (",", ".");
                                    mass = Float.valueOf(s2).floatValue();
                                    //System.out.println("????");
                                    //System.out.println(mass);
                        }
                        catch(SOAPException ex){
                                   System.out.println("errore causato:("+ex.getFaultCode()+"):"+ex.getMessage());
                                              }
                        }
                        catch(Exception ex){
                            
                                             System.out.println(ex.getMessage());
                                        }
        new Paziente (id2, user,code,cognome,nome, data, età,sesso, dataric,datadim,durata,DRG,prima,iceprima,seconda,
                      iceseconda, terza, iceterza, quarta, icequarta, NPC, colldate,creat, CRC, cinqueclassi, dueclassi,
                      diabete, ipertensione, MDC, tipo, descrizione, peso, soglia, mass).setVisible(true);
      }
      }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    public void actionPerformed(ActionEvent ev)
  {
    System.out.println("Selected: " + ev.getActionCommand());
    Object src = ev.getActionCommand();
    //String s = String.valueOf(src);
    //System.out.println(s);
    
    if(src == "Apri tabella con SPSS"){
        
        try{    
            String canc = "cmd /c start C:\\SOAP\\ProgettoCRC\\app\\canc.bat";
            Process p1 = Runtime.getRuntime().exec(canc);
        }catch(Exception e){
            e.printStackTrace();
        }
        File file =  new File("C:\\SOAP\\ProgettoCRC\\app\\appoggio.txt");
        
        if (file.getName().indexOf('.') == -1) {}
        try {
            FileWriter os = new FileWriter(file, true);
            PrintWriter out = new PrintWriter(os);
            for (int row = 0; row < jTable1.getRowCount(); row++) {
                System.out.println(jTable1.getRowCount());
            for (int column = 0; column < jTable1.getColumnCount(); column++) {
                System.out.println(jTable1.getColumnCount());
                out.print(jTable1.getValueAt(row, column)+("; "));
            }
            out.print("\n");
        }
        out.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, e, "ERRORE", JOptionPane.ERROR_MESSAGE);
        }
        try{
           String command = "cmd /c start C:\\SOAP\\ProgettoCRC\\app\\copiatab.bat";
            Process p = Runtime.getRuntime().exec(command);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    else if (src == "Guida"){
        try{
                  String command = "cmd /c start C:\\SOAP\\ProgettoCRC\\guida.txt";
                  Process p = Runtime.getRuntime().exec(command);
            }catch(Exception e){
                e.printStackTrace();
            }
    }
    else if(src == "Indietro"){
        
                
                this.dispose();
    }
    
    else if(src == "Apri SPSS"){
        JOptionPane option = new JOptionPane("Vuoi aprire SPPS v13.0?", JOptionPane.QUESTION_MESSAGE, JOptionPane.YES_NO_OPTION);
        option.setBackground(Color.DARK_GRAY);
        JDialog dialog = option.createDialog("uscita da ReCronix");
        dialog.pack();
        dialog.setVisible(true);
        int n = ((Integer)option.getValue()).intValue();
        if (n == 0) {
            try{
                  String command = "cmd /c start C:\\Programmi\\SPSSEVAL\\spsswin.exe";
                  Process p = Runtime.getRuntime().exec(command);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        }
    else if (src == "Salva Tabella"){
        JFileChooser fileChooser = new JFileChooser(System.getProperty("user.dir")); 
        fileChooser.setFont(myFont);
        fileChooser.setBackground(Color.darkGray);
        fileChooser.setForeground(Color.yellow);
        setFileChooserFont(fileChooser.getComponents());  
      
        int returnVal = fileChooser.showSaveDialog(this); 
        if (returnVal == JFileChooser.APPROVE_OPTION) {


File file = fileChooser.getSelectedFile();
String fileName = file.getName();

//File f =  new File("C:\\SOAP\\ProgettoCRC\\ricoveri.txt");

if (file.getName().indexOf('.') == -1) {

}
try {
    FileWriter os = new FileWriter(file, true);
    PrintWriter out = new PrintWriter(os);
    for (int row = 0; row < jTable1.getRowCount(); row++) {
        System.out.println(jTable1.getRowCount());
        for (int column = 0; column < jTable1.getColumnCount(); column++) {
            System.out.println(jTable1.getColumnCount());
            out.print(jTable1.getValueAt(row, column)+("; "));
        }
        out.print("\n");
    }
    out.close();
} catch (IOException e) {
    JOptionPane.showMessageDialog(this, e, "ERRORE", JOptionPane.ERROR_MESSAGE);
}

fileChooser.setCurrentDirectory(file);
file = fileChooser.getCurrentDirectory();


        
        }
    }
  }
    
   
public void setFileChooserFont(Component[] comp)  
  {  
    for(int x = 0; x < comp.length; x++)  
    {  
      if(comp[x] instanceof Container) setFileChooserFont(((Container)comp[x]).getComponents());  
      try{comp[x].setFont(myFont);
      }  
      catch(Exception e){}//do nothing  
      try{comp[x].setBackground(Color.darkGray);
      }  
      catch(Exception e){}//do nothing
      try{comp[x].setForeground(Color.yellow);
      }  
      catch(Exception e){}//do nothing
    }  
  }  
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jUser = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTable1.setBackground(new java.awt.Color(255, 255, 153));
        jTable1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTable1.setForeground(new java.awt.Color(0, 0, 102));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jUser.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jUser.setForeground(new java.awt.Color(255, 204, 0));
        jUser.setText("jLabel1");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setText("USER");

        jButton1.setBackground(new java.awt.Color(102, 102, 102));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 0));
        jButton1.setText("log out");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(102, 102, 102));
        jButton2.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 0));
        jButton2.setText("Analizza Gruppo");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 0));
        jLabel2.setText("nuova ricerca");

        jTextField1.setBackground(new java.awt.Color(255, 255, 153));
        jTextField1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(0, 0, 102));

        jButton3.setBackground(new java.awt.Color(102, 102, 102));
        jButton3.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 0));
        jButton3.setText("cerca");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 0));
        jLabel3.setText("Gruppo [divisione 2 classi] :[ classe");

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 204, 0));
        jLabel4.setText("r");

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 0));
        jLabel5.setText("]");

        jMenuBar1.setBackground(new java.awt.Color(102, 102, 102));
        jMenuBar1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jMenu1.setBackground(new java.awt.Color(102, 102, 102));
        jMenu1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jMenu1.setForeground(new java.awt.Color(255, 153, 0));
        jMenu1.setText("File");
        jMenu1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jMenu1.setPreferredSize(new java.awt.Dimension(60, 20));
        jMenuBar1.add(jMenu1);

        jMenu2.setBackground(new java.awt.Color(102, 102, 102));
        jMenu2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jMenu2.setForeground(new java.awt.Color(255, 153, 0));
        jMenu2.setText("Edit");
        jMenu2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jUser))
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 1224, Short.MAX_VALUE))
                        .addGap(16, 16, 16))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jUser)
                    .addComponent(jLabel1)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap(75, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int male = 0;
       int female = 0;
        for (int row = 0; row < jTable1.getRowCount(); row++) {
           Object val = jTable1.getModel().getValueAt(row, 5);
           String dura = val.toString();
           if (dura.compareTo("Male")== 0){
                male++;
           }
           if (dura.compareTo("Female")== 0){
               female++;
           }
        }
        int prima = 0;
        int seconda = 0;
        int terza = 0;
        int quarta = 0;
        int quinta = 0;
        int sesta = 0;
        int settima = 0;
        int ottava = 0;
        int nona = 0;
        int decima = 0;
        for (int row = 0; row < jTable1.getRowCount(); row++) {
            Object val = jTable1.getModel().getValueAt(row, 4);
            String et = val.toString();
            String eti = et.replaceAll(",",".");
            float età = Float.valueOf(eti).floatValue();
            if (età <10) prima++;
            if ((età >= 10)&&(età <20)) seconda++;
            if ((età >= 20)&&(età <30)) terza++;
            if ((età >= 30)&&(età <40)) quarta++;
            if ((età >= 40)&&(età <50)) quinta++;
            if ((età >= 50)&&(età <60)) sesta++;
            if ((età >= 60)&&(età <70)) settima++;
            if ((età >= 70)&&(età <80)) ottava++;
            if ((età >= 80)&&(età <90)) nona++;
            if (età >= 90) decima++;
        }
            int uno = 0;
            int zero = 0;
            for (int rowz = 0; rowz < jTable1.getRowCount(); rowz++) {
            Object valz = jTable1.getModel().getValueAt(rowz, 23);
            String classe = valz.toString();
            if (classe.compareTo("0")== 0){
                zero++;
            }
            if (classe.compareTo("1")== 0){
                uno++;
            }
        }
            int unoz = 0;
        int zeroz = 0;
        int duez = 0;
        int trez = 0;
        int quattroz = 0;
        for (int rowzz = 0; rowzz < jTable1.getRowCount(); rowzz++) {
            Object valzz = jTable1.getModel().getValueAt(rowzz, 22);
            String classe = valzz.toString();
            if (classe.compareTo("0")== 0){
                zeroz++;
            }
            if (classe.compareTo("1")== 0){
                unoz++;
            }
            if (classe.compareTo("2")== 0){
                duez++;
            }
            if (classe.compareTo("3")== 0){
                trez++;
            }
            if (classe.compareTo("4")== 0){
                quattroz++;
            }
        }
        
        int fuori =0;
        int dentro = 0;
        int nessuno18 = 0;
        int prima18 = 0;
        int seconda18 = 0;
        int terza18 = 0;
        int quarta18 = 0;
        int nessuno40 = 0;
        int prima40 = 0;
        int seconda40 = 0;
        int terza40 = 0;
        int quarta40 = 0;
        int nessuno60 = 0;
        int prima60 = 0;
        int seconda60 = 0;
        int terza60 = 0;
        int quarta60 = 0;
        int nessuno80 = 0;
        int prima80 = 0;
        int seconda80= 0;
        int terza80 = 0;
        int quarta80 = 0;
        int nessunomagg = 0;
        int primamagg = 0;
        int secondamagg= 0;
        int terzamagg = 0;
        int quartamagg = 0;
        int unor = 0;
        int duer = 0;
        int trer = 0;
        int quattror = 0;
        int cinquer = 0;
        int seir = 0;
        int setter = 0;
        int ottor = 0;
        int nover = 0;
        int diecir = 0;
        int undicir = 0;
        int dodicir = 0;
        int tredicir = 0;
        int quattordicir = 0;
        int quindicir = 0;
        int sedicir = 0;
        int diciassetter = 0;
        int diciottor = 0;
        int diciannover = 0;
        int ventir = 0;
        int ventunor = 0;
        int ventiduer = 0;
        int ventitrer = 0;
        int ventiquattror = 0;
        int venticinquer = 0;
        int prer = 0;
        

        for (int rowo = 0; rowo < jTable1.getRowCount(); rowo++) {
            Object valo = jTable1.getModel().getValueAt(rowo, 8);
            String dura = valo.toString();
            float durata = Float.valueOf(dura).floatValue();
            System.out.println(durata);

            Object val2 = jTable1.getModel().getValueAt(rowo, 30);
            String sog = val2.toString();
            int soglia = Integer.valueOf(sog).intValue();
            System.out.println(soglia);

            Object val3 = jTable1.getModel().getValueAt(rowo, 4);
            String etz = val3.toString();
            String etiz = etz.replaceAll(",",".");
            float etàz = Float.valueOf(etiz).floatValue();
            float diff = soglia - durata;
            if (etàz< 20){
            if (diff >= 0){
                nessuno18++;
            }
            if ((diff < 0)&&(diff > -10)){
                prima18++;
            } 
            if ((diff < -10)&&(diff > -20)){
                seconda18++;
            }
            if ((diff < -20)&&(diff > -30)){
                terza18++;
            }
            if (diff < -30){
                quarta18++;
            }
            }
            if ((etàz >= 20)&&(etàz < 40)){
            if (diff >= 0){
                nessuno40++;
            }
            if ((diff < 0)&&(diff > -10)){
                prima40++;
            }
            if ((diff < -10)&&(diff > -20)){
                seconda40++;
            }
            if ((diff < -20)&&(diff > -30)){
                terza40++;
            }
            if (diff < -30){
                quarta40++;
            }
            }
            if ((etàz >= 40)&&(etàz< 60)){
            if (diff >= 0){
                nessuno60++;
            }
            if ((diff < 0)&&(diff > -10)){
                prima60++;
            }
            if ((diff < -10)&&(diff > -20)){
                seconda60++;
            }
            if ((diff < -20)&&(diff > -30)){
                terza60++;
            }
            if (diff < -30){
                quarta60++;
            }
            }
            if ((etàz >= 60)&&(etàz < 80)){
            if (diff >= 0){
                nessuno80++;
            }
            if ((diff < 0)&&(diff > -10)){
                prima80++;
            }
            if ((diff < -10)&&(diff > -20)){
                seconda80++;
            }
            if ((diff < -20)&&(diff > -30)){
                terza80++;
            }
            if (diff < -30){
                quarta80++;
            }
            }
            if (etàz >= 80){
            if (diff >= 0){
                nessunomagg++;
            }
            if ((diff < 0)&&(diff > -10)){
                primamagg++;
            }
            if ((diff < -10)&&(diff > -20)){
                secondamagg++;
            }
            if ((diff < -20)&&(diff > -30)){
                terzamagg++;
            }
            if (diff < -30){
                quartamagg++;
            }
            }

        }
        for (int rowzzz = 0; rowzzz < jTable1.getRowCount(); rowzzz++) {
            
            
            
            Object valzz = jTable1.getModel().getValueAt(rowzzz, 30);
            String sog = valzz.toString();
            float soglia = Integer.valueOf(sog).intValue();
            System.out.println(soglia);
            
            Object val2 = jTable1.getModel().getValueAt(rowzzz, 8);
            String dura = val2.toString();
            float durata = Float.valueOf(dura).floatValue();
            System.out.println(durata);
            
            Object val3 = jTable1.getModel().getValueAt(rowzzz,26);
            String emme = val3.toString();
            
            
            if(durata > soglia){
                fuori++;
                if (emme.equals("1")) unor++;
                if (emme.equals("2")) duer++;
                if (emme.equals("3")) trer++;
                if (emme.equals("4")) quattror++;
                if (emme.equals("5")) cinquer++;
                if (emme.equals("6")) seir++;
                if (emme.equals("7")) setter++;
                if (emme.equals("8")) ottor++;
                if (emme.equals("9")) nover++;
                if (emme.equals("10")) diecir++;
                if (emme.equals("11")) undicir++;
                if (emme.equals("12")) dodicir++;
                if (emme.equals("13")) tredicir++;
                if (emme.equals("14")) quattordicir++;
                if (emme.equals("15")) quindicir++;
                if (emme.equals("16")) sedicir++;
                if (emme.equals("17")) diciassetter++;
                if (emme.equals("18")) diciottor++;
                if (emme.equals("19")) diciannover++;
                if (emme.equals("20")) ventir++;
                if (emme.equals("21")) ventunor++;
                if (emme.equals("22")) ventiduer++;
                if (emme.equals("23")) ventitrer++;
                if (emme.equals("24")) ventiquattror++;
                if (emme.equals("25")) venticinquer++;
                if (emme.equals("pre")) prer++;
                
                
            }
            else dentro++;
        }
        String tipo = jLabel4.getText();
        
        new Analizza2Classi(tipo, male, female, prima, seconda, terza, quarta, quinta, sesta, settima, ottava, nona, decima,zero, uno,zeroz, unoz,duez,trez, quattroz,
                           nessuno18, prima18, seconda18, terza18, quarta18, nessuno40, prima40, seconda40, terza40, quarta40,
                          nessuno60, prima60, seconda60, terza60, quarta60,nessuno80, prima80, seconda80, terza80, quarta80,
                          nessunomagg, primamagg, secondamagg, terzamagg, quartamagg, dentro , fuori, unor, duer, trer, quattror, cinquer, seir,
                           setter, ottor, nover, diecir, undicir, dodicir, tredicir, quattordicir, quindicir, sedicir, diciassetter, diciottor, diciannover,
                          ventir, ventunor, ventiduer, ventitrer, ventiquattror, venticinquer, prer).setVisible(true);
    
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String user = jUser.getText();
        String cerca = jTextField1.getText();
        new NewRicerca2C(cerca, user).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel jUser;
    // End of variables declaration//GEN-END:variables

   
}
