/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Paziente.java
 *
 * Created on 13-feb-2012, 11.51.46
 */

package ClientCRC;

import javax.swing.JOptionPane;
import java.net.*;
import java.util.Vector;
import javax.swing.JDialog;
import org.apache.soap.rpc.*;
import org.apache.soap.Constants;
import org.apache.soap.SOAPException;
import java.awt.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.html.*;

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
public class Paziente extends javax.swing.JFrame implements ActionListener {
    private Font myFont = new Font("Tahoma", Font.PLAIN,11);
    /** Creates new form Paziente */
    public Paziente(String id,String user, String code,String cognome,String nome, String data, String età,String sesso,
                     String dataric,String datadim,String durata,String DRG,String prima,String iceprima,String seconda,
                      String iceseconda, String terza,String iceterza,String quarta,String icequarta,String NPC,String colldate,
                      String creat,String CRC,String cinqueclassi,String dueclassi,String diabete,String ipertensione,
                      String MDC,String tipo,String descrizione,String peso,String soglia, float mass)  {
        initComponents();
        
        this.getContentPane().setBackground(Color.DARK_GRAY);
        this.setIconImage(new ImageIcon("C:\\SOAP\\images\\icon.gif").getImage());
        this.setAlwaysOnTop(true);
        
        
        JMenuItem salvaMenu = new JMenuItem("Salva Tabella");
        
        
        JMenuItem indietroMenu = new JMenuItem("Indietro");
        JMenuItem guidaMenu = new JMenuItem("Guida");
        JMenuItem creditMenu = new JMenuItem("Credits");
        
        creditMenu.setFont(myFont);
        creditMenu.setBackground(Color.DARK_GRAY);
        creditMenu.setForeground(Color.yellow);
        
        
        guidaMenu.setFont(myFont);
        guidaMenu.setBackground(Color.DARK_GRAY);
        guidaMenu.setForeground(Color.yellow);
        
        
        
        salvaMenu.setFont(myFont);
        salvaMenu.setBackground(Color.DARK_GRAY);
        salvaMenu.setForeground(Color.yellow);
        
        
        
        indietroMenu.setFont(myFont);
        indietroMenu.setBackground(Color.DARK_GRAY);
        indietroMenu.setForeground(Color.yellow);
        
        
        jMenu1.add(salvaMenu);
        jMenu1.add(indietroMenu);
        
        jMenu1.addSeparator();
       
        jMenu1.setBackground(Color.DARK_GRAY);
        
        jMenu2.add(guidaMenu);
        jMenu2.addSeparator();
        jMenu2.add(creditMenu);
        //JMenuItem openAction =  new JMenuItem("Open SPSS");
        
        //JMenuItem cutAction =   new JMenuItem("Cut");
        //JMenuItem copyAction =  new  JMenuItem("Copy");
        //JMenuItem pasteAction =  new JMenuItem("Paste");
        //JMenuItem saveTabAction= new JMenuItem("Salva tabella");
        //JMenuItem disconnectAction =   new JMenuItem("Disconnect");
        //JMenuItem exitAction =  new JMenuItem("Exit");
        //salvaMenu.add(disconnectAction);
        //fileMenu.add(openAction);
        //fileMenu.addSeparator();
        //fileMenu.add(exitAction);
        //editMenu.add(cutAction);
        //editMenu.add(copyAction);
        //editMenu.add(pasteAction);
        //editMenu.addSeparator();
        //viewMenu.add(saveTabAction);
        indietroMenu.addActionListener(this);
        
        salvaMenu.addActionListener(this);
        
        guidaMenu.addActionListener(this);
        creditMenu.addActionListener(this);
        
        
        
        
        jID.setText(id);
        jCode.setText(code);
        jCognome.setText(cognome);
        jNome.setText(nome);
        jData.setText(data);
        jEtà.setText(età);
        jSesso.setText(sesso);
        jDataRic.setText(dataric);
        jDataDim.setText(datadim);
        jDurata.setText(durata);
        jDRG.setText(DRG);
        jPrima.setText(prima);
        jIcePrima.setText(iceprima);
        jSeconda.setText(seconda);
        jIceSeconda.setText(iceseconda);
        jTerza.setText(terza);
        jIceTerza.setText(iceterza);
        jQuarta.setText(quarta);
        jIceQuarta.setText(icequarta);
        jNPC.setText(NPC);
        jCollDate.setText(colldate);
        jCreat.setText(creat);
        jCRC.setText(CRC);
        j5classi.setText(cinqueclassi);
        j2classi.setText(dueclassi);
        jDiabete.setText(diabete);
        jIpertensione.setText(ipertensione);
        jMDC.setText(MDC);
        jTipo.setText(tipo);
        jDescrizione.setText(descrizione);
        jPeso.setText(peso);
        jSoglia.setText(soglia);
        float dura = Float.valueOf(durata).floatValue();
        float sog = Float.valueOf(soglia).floatValue();
        float l;
        if (dura >= sog){
            
            jLabel35.setText("*la durata del ricovero del paziente supera il valore soglia");
        }
        String s2 = peso.replaceAll (",", ".");
        float pe = Float.valueOf(s2).floatValue();
        System.out.println(pe);
        System.out.println(mass);
        float quartile = ((mass/4)*3);
        if (pe >= quartile){
            jLabel36.setText("*il peso della malattia supera il terzo quartile");
            
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
   

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jID = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jNome = new javax.swing.JLabel();
        jCognome = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jCode = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jData = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jDescrizione = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        jDataRic = new javax.swing.JLabel();
        jDataDim = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jDurata = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jSesso = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jDRG = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPrima = new javax.swing.JLabel();
        jSeconda = new javax.swing.JLabel();
        jTerza = new javax.swing.JLabel();
        jQuarta = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jIcePrima = new javax.swing.JLabel();
        jIceSeconda = new javax.swing.JLabel();
        jIceTerza = new javax.swing.JLabel();
        jIceQuarta = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jNPC = new javax.swing.JLabel();
        jCollDate = new javax.swing.JLabel();
        jCreat = new javax.swing.JLabel();
        jCRC = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        j2classi = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        j5classi = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jDiabete = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jIpertensione = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jSoglia = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jTipo = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jMDC = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jPeso = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel33 = new javax.swing.JLabel();
        jEtà = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel34 = new javax.swing.JLabel();
        jQuartile = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setText("TABELLA DEL RICOVERO n.");

        jID.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jID.setForeground(new java.awt.Color(255, 204, 0));
        jID.setText("jLabel2");

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 0));
        jLabel2.setText("paziente");

        jNome.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jNome.setForeground(new java.awt.Color(255, 204, 0));
        jNome.setText("jLabel3");

        jCognome.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jCognome.setForeground(new java.awt.Color(255, 204, 0));
        jCognome.setText("jLabel3");

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 0));
        jLabel3.setText("CF");

        jCode.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jCode.setForeground(new java.awt.Color(255, 204, 0));
        jCode.setText("jLabel4");

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 0));
        jLabel4.setText("nato/a il");

        jData.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jData.setForeground(new java.awt.Color(255, 204, 0));
        jData.setText("jLabel5");

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 153, 0));
        jLabel5.setText("PAZIENTE");

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 153, 0));
        jLabel6.setText("RICOVERO");

        jLabel7.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 0));
        jLabel7.setText("ricovero ");

        jDescrizione.setBackground(new java.awt.Color(255, 255, 153));
        jDescrizione.setColumns(20);
        jDescrizione.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jDescrizione.setForeground(new java.awt.Color(0, 0, 153));
        jDescrizione.setRows(5);
        jDescrizione.setFocusable(false);
        jScrollPane2.setViewportView(jDescrizione);

        jLabel8.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 0));
        jLabel8.setText("dal");

        jDataRic.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jDataRic.setForeground(new java.awt.Color(255, 204, 0));
        jDataRic.setText("jLabel9");

        jDataDim.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jDataDim.setForeground(new java.awt.Color(255, 204, 0));
        jDataDim.setText("jLabel9");

        jLabel9.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 0));
        jLabel9.setText("al");

        jLabel10.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 0));
        jLabel10.setText("durata");

        jDurata.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jDurata.setForeground(new java.awt.Color(255, 204, 0));
        jDurata.setText("jLabel11");

        jLabel11.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 0));
        jLabel11.setText("sesso");

        jSesso.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jSesso.setForeground(new java.awt.Color(255, 204, 0));
        jSesso.setText("jLabel12");

        jLabel12.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 0));
        jLabel12.setText("DRG");

        jDRG.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jDRG.setForeground(new java.awt.Color(255, 204, 0));
        jDRG.setText("jLabel13");

        jLabel13.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 0));
        jLabel13.setText("prima diagnosi");

        jLabel14.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 0));
        jLabel14.setText("seconda diagnosi");

        jLabel15.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 0));
        jLabel15.setText("terza diagnosi");

        jLabel16.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 0));
        jLabel16.setText("quarta diagnosi");

        jPrima.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jPrima.setForeground(new java.awt.Color(255, 204, 0));
        jPrima.setText("jLabel17");

        jSeconda.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jSeconda.setForeground(new java.awt.Color(255, 204, 0));
        jSeconda.setText("jLabel18");

        jTerza.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jTerza.setForeground(new java.awt.Color(255, 204, 0));
        jTerza.setText("jLabel19");

        jQuarta.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jQuarta.setForeground(new java.awt.Color(255, 204, 0));
        jQuarta.setText("jLabel20");

        jLabel21.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 0));
        jLabel21.setText("ice prima diagnosi");

        jLabel22.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 0));
        jLabel22.setText("ice seconda diagnosi");

        jLabel23.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 0));
        jLabel23.setText("ice terza diagnosi");

        jLabel24.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 0));
        jLabel24.setText("ice quarta diagnosi");

        jIcePrima.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jIcePrima.setForeground(new java.awt.Color(255, 204, 0));
        jIcePrima.setText("jLabel25");

        jIceSeconda.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jIceSeconda.setForeground(new java.awt.Color(255, 204, 0));
        jIceSeconda.setText("jLabel26");

        jIceTerza.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jIceTerza.setForeground(new java.awt.Color(255, 204, 0));
        jIceTerza.setText("jLabel27");

        jIceQuarta.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jIceQuarta.setForeground(new java.awt.Color(255, 204, 0));
        jIceQuarta.setText("jLabel28");

        jLabel17.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 0));
        jLabel17.setText("NPC");

        jLabel18.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 0));
        jLabel18.setText("colldate");

        jLabel19.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 0));
        jLabel19.setText("creat");

        jLabel20.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 0));
        jLabel20.setText("CRC");

        jNPC.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jNPC.setForeground(new java.awt.Color(255, 204, 0));
        jNPC.setText("jLabel25");

        jCollDate.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jCollDate.setForeground(new java.awt.Color(255, 204, 0));
        jCollDate.setText("jLabel25");

        jCreat.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jCreat.setForeground(new java.awt.Color(255, 204, 0));
        jCreat.setText("jLabel25");

        jCRC.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jCRC.setForeground(new java.awt.Color(255, 204, 0));
        jCRC.setText("jLabel25");

        jLabel25.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 0));
        jLabel25.setText("n.ro divisione in 2 classi");

        j2classi.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        j2classi.setForeground(new java.awt.Color(255, 204, 0));
        j2classi.setText("jLabel26");

        jLabel27.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 0));
        jLabel27.setText("n.ro divisione in 5 classi ");

        j5classi.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        j5classi.setForeground(new java.awt.Color(255, 204, 0));
        j5classi.setText("jLabel28");

        jLabel26.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 0));
        jLabel26.setText("ricovero per diabete");

        jDiabete.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jDiabete.setForeground(new java.awt.Color(255, 204, 0));
        jDiabete.setText("jLabel28");

        jLabel29.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 0));
        jLabel29.setText("ricovero per ipertensione");

        jIpertensione.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jIpertensione.setForeground(new java.awt.Color(255, 204, 0));
        jIpertensione.setText("jLabel30");

        jLabel28.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 0));
        jLabel28.setText("soglia");

        jSoglia.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jSoglia.setForeground(new java.awt.Color(255, 204, 0));
        jSoglia.setText("jLabel30");

        jLabel30.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 0));
        jLabel30.setText("tipo");

        jTipo.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jTipo.setForeground(new java.awt.Color(255, 204, 0));
        jTipo.setText("jLabel31");

        jLabel31.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 0));
        jLabel31.setText("MDC");

        jMDC.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jMDC.setForeground(new java.awt.Color(255, 204, 0));
        jMDC.setText("jLabel32");

        jLabel32.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 0));
        jLabel32.setText("peso");

        jPeso.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jPeso.setForeground(new java.awt.Color(255, 204, 0));
        jPeso.setText("jLabel33");

        jButton1.setBackground(new java.awt.Color(102, 102, 102));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 0));
        jButton1.setText("Torna");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel33.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 0));
        jLabel33.setText("età al momento del ricovero");

        jEtà.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jEtà.setForeground(new java.awt.Color(255, 204, 0));
        jEtà.setText("jLabel34");

        jLabel34.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 0));

        jQuartile.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jQuartile.setForeground(new java.awt.Color(255, 255, 0));

        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 204, 0));

        jLabel36.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 204, 0));

        jMenuBar1.setBackground(new java.awt.Color(102, 102, 102));
        jMenuBar1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jMenu1.setBackground(new java.awt.Color(102, 102, 102));
        jMenu1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jMenu1.setForeground(new java.awt.Color(255, 153, 0));
        jMenu1.setText("File");
        jMenu1.setPreferredSize(new java.awt.Dimension(60, 20));
        jMenuBar1.add(jMenu1);

        jMenu2.setBackground(new java.awt.Color(102, 102, 102));
        jMenu2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jMenu2.setForeground(new java.awt.Color(255, 153, 0));
        jMenu2.setText("Aiuto");
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
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jNome)
                                .addGap(18, 18, 18)
                                .addComponent(jCognome)
                                .addGap(269, 269, 269))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel30)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTipo)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSesso)
                                .addContainerGap())))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator3)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(10, 10, 10)
                                        .addComponent(jCode))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jData))
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addGap(18, 18, 18)
                                        .addComponent(jDRG))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel33)
                                        .addGap(18, 18, 18)
                                        .addComponent(jEtà))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jID))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel35)
                                            .addGap(273, 273, 273)
                                            .addComponent(jLabel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel36)
                                            .addGap(264, 264, 264)
                                            .addComponent(jQuartile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel18)
                                                    .addComponent(jLabel19)
                                                    .addComponent(jLabel20)
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                        .addComponent(jLabel17)
                                                        .addGap(30, 30, 30)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(jNPC)
                                                            .addComponent(jCollDate)
                                                            .addComponent(jCreat)
                                                            .addComponent(jCRC))))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel25)
                                                        .addComponent(jLabel26))
                                                    .addGap(36, 36, 36)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(j2classi)
                                                        .addComponent(jDiabete))
                                                    .addGap(34, 34, 34)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel29)
                                                        .addComponent(jLabel27))))
                                            .addGap(66, 66, 66)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(j5classi)
                                                .addComponent(jIpertensione))))
                                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel28)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jSoglia)
                                                .addGap(40, 40, 40)
                                                .addComponent(jLabel10)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jDurata))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel8)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jDataRic)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel9)
                                                .addGap(11, 11, 11)
                                                .addComponent(jDataDim)))
                                        .addGap(208, 208, 208)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addGap(2, 2, 2)
                                                .addComponent(jLabel31)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jMDC))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel32)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jPeso))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel13)
                                            .addComponent(jLabel14)
                                            .addComponent(jLabel15)
                                            .addComponent(jLabel16))
                                        .addGap(30, 30, 30)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jQuarta)
                                            .addComponent(jTerza)
                                            .addComponent(jSeconda)
                                            .addComponent(jPrima))
                                        .addGap(133, 133, 133)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel21)
                                            .addComponent(jLabel22)
                                            .addComponent(jLabel23)
                                            .addComponent(jLabel24))
                                        .addGap(38, 38, 38)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jIceQuarta)
                                            .addComponent(jIceTerza)
                                            .addComponent(jIceSeconda)
                                            .addComponent(jIcePrima))))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane2))
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGap(237, 237, 237)
                .addComponent(jButton1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jID))
                .addGap(26, 26, 26)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jNome)
                    .addComponent(jCognome)
                    .addComponent(jLabel11)
                    .addComponent(jSesso))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCode)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jData))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel30)
                    .addComponent(jTipo))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(jEtà))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jDataRic)
                    .addComponent(jDataDim)
                    .addComponent(jLabel9)
                    .addComponent(jLabel31)
                    .addComponent(jMDC))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jDurata)
                    .addComponent(jLabel28)
                    .addComponent(jSoglia)
                    .addComponent(jLabel32)
                    .addComponent(jPeso))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jDRG))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(jPrima))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(jSeconda))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(jTerza))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(jQuarta)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jIcePrima)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jIceSeconda)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jIceTerza)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jIceQuarta))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel24)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel20))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jNPC)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCollDate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCreat)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCRC)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel25)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(j2classi)
                                .addComponent(jLabel27)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jDiabete)
                                .addComponent(jLabel29))
                            .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(j5classi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jIpertensione)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel34)
                        .addGap(39, 39, 39))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                        .addComponent(jLabel35)
                        .addGap(18, 18, 18)))
                .addComponent(jLabel36)
                .addGap(21, 21, 21)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jQuartile)
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
     public void actionPerformed(ActionEvent ev)
  {
    System.out.println("Selected: " + ev.getActionCommand());
    Object src = ev.getActionCommand();
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
String id = jID.getText();
String nome = jNome.getText();
String cognome = jCognome.getText();
String code = jCode.getText();
String sesso = jSesso.getText();
String data = jData.getText();
String tipo = jTipo.getText();
String descrizione = jDescrizione.getText();
String età = jEtà.getText();
String dataric = jDataRic.getText();
String datadim = jDataDim.getText();
String MDC = jMDC.getText();
String soglia = jSoglia.getText();
String durata = jDurata.getText();
String peso = jPeso.getText();
String DRG = jDRG.getText();
String prima = jPrima.getText();
String iceprima = jIcePrima.getText();
String seconda = jSeconda.getText();
String iceseconda = jIceSeconda.getText();
String terza = jTerza.getText();
String iceterza = jIceTerza.getText();
String quarta = jQuarta.getText();
String icequarta = jIceQuarta.getText();
String NPC = jNPC.getText();
String colldate = jCollDate.getText();
String creat = jCreat.getText();
String CRC = jCRC.getText();
String duec = j2classi.getText();
String cinquec = j5classi.getText();
String diabete = jDiabete.getText();
String ipertensione = jIpertensione.getText();


try {
    FileWriter os = new FileWriter(file, true);
    PrintWriter out = new PrintWriter(os);
    out.print("ID DEL RICOVERO : "+(jID.getText())+("\n\n\n"));
    out.print("DATI DEL PAZIENTE\n\n");
    out.print("Nome Paziente :"+(jNome.getText())+("\n"));
    out.print("Cognome Paziente :"+(jCognome.getText())+("\n"));
    out.print("Data di Nascita :"+(jData.getText())+("\n"));
    out.print("Codice :"+(jCode.getText())+("\n"));
    out.print("Sesso :"+(jSesso.getText())+("\n\n"));
    out.print("DATI DEL RICOVERO :\n\n");
    out.print("Tipo :"+(jTipo.getText())+("\n"));
    out.print("Descrizione :"+(jDescrizione.getText())+("\n"));
    out.print("Età del paziente al momento del ricovero :"+(jEtà.getText())+("\n"));
    out.print("Data Ricovero :"+(jDataRic.getText())+("\n"));
    out.print("Data Dimissione :"+(jDataDim.getText())+("\n"));
    out.print("Durata :"+(jDurata.getText())+("\n"));
    out.print("MDC :"+(jMDC.getText())+("\n"));
    out.print("Soglia :"+(jSoglia.getText())+("\n"));
    out.print("Peso :"+(jPeso.getText())+("\n"));
    out.print("DRG :"+(jDRG.getText())+("\n"));
    out.print("Prima :"+(jPrima.getText())+("\n"));
    out.print("Ice Prima :"+(jIcePrima.getText())+("\n"));
    out.print("Seconda :"+(jSeconda.getText())+("\n"));
    out.print("Terza :"+(jTerza.getText())+("\n"));
    out.print("Ice Terza :"+(jIceTerza.getText())+("\n"));
    out.print("Quarta :"+(jQuarta.getText())+("\n"));
    out.print("Ice Quarta :"+(jIceQuarta.getText())+("\n"));
    
    
    
    /*for (int row = 0; row < jTable1.getRowCount(); row++) {
        System.out.println(jTable1.getRowCount());
        for (int column = 0; column < jTable1.getColumnCount(); column++) {
            System.out.println(jTable1.getColumnCount());
            out.print(jTable1.getValueAt(row, column)+("; "));
        }
        out.print("\n");
    }*/
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

  /**
   * This dialog is displayed when the user selects the File/Open menu item.
   */
  private class SampleDialog extends JDialog implements ActionListener
  {
    private JButton okButton = new JButton("Disconnettersi da ReCronix?");

    private SampleDialog()
    {
      
      //JPanel panel = new JPanel(new FlowLayout());
      //panel.add(okButton);
      //getContentPane().add(panel);
      //okButton.addActionListener(this);
      setPreferredSize(new Dimension(300, 200));
      JOptionPane option = new JOptionPane("Vuoi Davvero Disconnetterti?", JOptionPane.QUESTION_MESSAGE, JOptionPane.YES_NO_OPTION);
      //option.setIcon("C:\\SOAP\\images\\icon.gif");
      option.setBackground(Color.DARK_GRAY);
      
      JDialog dialog = option.createDialog("disconnessione");
      dialog.pack();
      //pack();
      //setLocationRelativeTo(this);
      // new Disconnect().setVisible(true);
      dialog.setVisible(true);

        int n = ((Integer)option.getValue()).intValue();

        if (n == 0){
                    new Login().setVisible(true);
                    this.dispose();
                    
                    }
    }

    public void actionPerformed(ActionEvent ev)
    {
      setVisible(false);
    }
  }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel j2classi;
    private javax.swing.JLabel j5classi;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jCRC;
    private javax.swing.JLabel jCode;
    private javax.swing.JLabel jCognome;
    private javax.swing.JLabel jCollDate;
    private javax.swing.JLabel jCreat;
    private javax.swing.JLabel jDRG;
    private javax.swing.JLabel jData;
    private javax.swing.JLabel jDataDim;
    private javax.swing.JLabel jDataRic;
    private javax.swing.JTextArea jDescrizione;
    private javax.swing.JLabel jDiabete;
    private javax.swing.JLabel jDurata;
    private javax.swing.JLabel jEtà;
    private javax.swing.JLabel jID;
    private javax.swing.JLabel jIcePrima;
    private javax.swing.JLabel jIceQuarta;
    private javax.swing.JLabel jIceSeconda;
    private javax.swing.JLabel jIceTerza;
    private javax.swing.JLabel jIpertensione;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
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
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jMDC;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel jNPC;
    private javax.swing.JLabel jNome;
    private javax.swing.JLabel jPeso;
    private javax.swing.JLabel jPrima;
    private javax.swing.JLabel jQuarta;
    private javax.swing.JLabel jQuartile;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel jSeconda;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel jSesso;
    private javax.swing.JLabel jSoglia;
    private javax.swing.JLabel jTerza;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel jTipo;
    // End of variables declaration//GEN-END:variables

}
