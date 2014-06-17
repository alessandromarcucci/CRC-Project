/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Admin.java
 *
 * Created on 8-gen-2012, 11.55.15
 */

package ClientCRC;

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
public class Administrator extends javax.swing.JFrame implements ActionListener {
    private Font myFont = new Font("Tahoma", Font.PLAIN,11);
    /** Creates new form Admin */
    public Administrator(String username, int admin) {
        
        initComponents();
        this.setIconImage(new ImageIcon("C:\\SOAP\\images\\icon.gif").getImage());
        this.getContentPane().setBackground(Color.DARK_GRAY);
        Color color;
        color = Color.DARK_GRAY;
        int col = color.getRed();
        int col2 = color.getBlue();
        int col3 = color.getGreen();
        System.out.println(col);
        System.out.println(col2);
        System.out.println(col3);
        jUser.setText(username);
        jAdmin.setDisplayedMnemonic(admin);
        JMenu passaMenu = new JMenu("Passa a");
        JMenuItem adminMenu = new JMenuItem("user");
        JMenuItem disconnettiMenu = new JMenuItem("Disconnetti");
        JMenuItem esciMenu = new JMenuItem("Esci da ReCronix");
        JMenuItem guidaMenu = new JMenuItem("Guida");
        JMenuItem creditMenu = new JMenuItem("Credits");
        
        creditMenu.setFont(myFont);
        creditMenu.setBackground(Color.DARK_GRAY);
        creditMenu.setForeground(Color.yellow);
        
        
        guidaMenu.setFont(myFont);
        guidaMenu.setBackground(Color.DARK_GRAY);
        guidaMenu.setForeground(Color.yellow);
        
        passaMenu.setFont(myFont);
        passaMenu.setBackground(Color.DARK_GRAY);
        passaMenu.setForeground(Color.black);
        
        disconnettiMenu.setFont(myFont);
        disconnettiMenu.setBackground(Color.DARK_GRAY);
        disconnettiMenu.setForeground(Color.yellow);
        
        esciMenu.setFont(myFont);
        esciMenu.setBackground(Color.DARK_GRAY);
        esciMenu.setForeground(Color.yellow);
        
        adminMenu.setFont(myFont);
        adminMenu.setBackground(Color.darkGray);
        adminMenu.setForeground(Color.yellow);
        passaMenu.add(adminMenu);
        
        jMenu1.add(passaMenu);
        jMenu1.add(disconnettiMenu);
        jMenu1.addSeparator();
        jMenu1.add(esciMenu);
        
        jMenu2.add(guidaMenu);
        jMenu2.add(creditMenu);
        
        adminMenu.addActionListener(this);
        disconnettiMenu.addActionListener(this);
        esciMenu.addActionListener(this);
        guidaMenu.addActionListener(this);
        creditMenu.addActionListener(this);
        
        try{
                URL address = new URL("http://localhost:8080/soap/servlet/rpcrouter");
                Call chiamata=new Call();
                chiamata.setTargetObjectURI("urn:crc");// l'ID della nostra RCP creata ad HOC
                chiamata.setMethodName("getName"); // chiamata del nostro metodo
                chiamata.setEncodingStyleURI(Constants.NS_URI_SOAP_ENC);
                Vector parametri=new Vector();
                parametri.addElement(new Parameter("username",String.class,jUser.getText(),null));
                chiamata.setParams(parametri);
                System.out.println("SOAP call parameters:"+chiamata);// codifica dei dati trasmessi


                    try {
                        Response risposta = chiamata.invoke(address, "");
                        Parameter par = risposta.getReturnValue(); // leggo la risposta
                        Object value = par.getValue();
                        String msg=String.valueOf(value);
                        jNome.setText(msg);
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
    public void actionPerformed(ActionEvent ev)
  {
    System.out.println("Selected: " + ev.getActionCommand());
    Object src = ev.getActionCommand();
    //String s = String.valueOf(src);
    //System.out.println(s);
    if (src == "user" ){
              int admin = jAdmin.getDisplayedMnemonic();
              new User(jUser.getText(),admin).setVisible(true);
              this.dispose();
    
    }
    if (src == "Esci da ReCronix"){
        
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
    else if(src == "Disconnetti"){
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
     else if (src == "Guida"){
        try{
                  String command = "cmd /c start C:\\SOAP\\ProgettoCRC\\guida.txt";
                  Process p = Runtime.getRuntime().exec(command);
            }catch(Exception e){
                e.printStackTrace();
            }
    }
  }
  }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jUser = new javax.swing.JLabel();
        jLogout = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jNome = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jEliminaUtente = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        jAddRicovero = new javax.swing.JRadioButton();
        jModRicovero = new javax.swing.JRadioButton();
        jDeleteRicovero = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        jUse = new javax.swing.JRadioButton();
        jExit = new javax.swing.JButton();
        jGo = new javax.swing.JButton();
        jAddPaziente = new javax.swing.JRadioButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        jAdmin = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jUser.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        jUser.setForeground(new java.awt.Color(255, 153, 0));
        jUser.setText("jLabel1");

        jLogout.setBackground(new java.awt.Color(102, 102, 102));
        jLogout.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLogout.setForeground(new java.awt.Color(255, 255, 0));
        jLogout.setText("log out");
        jLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLogoutActionPerformed(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setText("AMMINISTRATORE");

        jNome.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jNome.setForeground(new java.awt.Color(255, 153, 0));
        jNome.setText("jLabel2");

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 0));
        jLabel2.setText("gestisci Database");

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 0));
        jLabel3.setText("gestisci utenti:");

        jEliminaUtente.setBackground(new java.awt.Color(64, 64, 64));
        jEliminaUtente.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jEliminaUtente.setForeground(new java.awt.Color(255, 255, 0));
        jEliminaUtente.setText("elimina utente");
        jEliminaUtente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jEliminaUtenteActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 0));
        jLabel4.setText("gestisci ricoveri");

        jAddRicovero.setBackground(new java.awt.Color(64, 64, 64));
        jAddRicovero.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jAddRicovero.setForeground(new java.awt.Color(255, 255, 0));
        jAddRicovero.setText("aggiungi ricovero");
        jAddRicovero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAddRicoveroActionPerformed(evt);
            }
        });

        jModRicovero.setBackground(new java.awt.Color(64, 64, 64));
        jModRicovero.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jModRicovero.setForeground(new java.awt.Color(255, 255, 0));
        jModRicovero.setText("modifica ricovero");
        jModRicovero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jModRicoveroActionPerformed(evt);
            }
        });

        jDeleteRicovero.setBackground(new java.awt.Color(64, 64, 64));
        jDeleteRicovero.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jDeleteRicovero.setForeground(new java.awt.Color(255, 255, 0));
        jDeleteRicovero.setText("elimina ricovero");
        jDeleteRicovero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jDeleteRicoveroActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 0));
        jLabel5.setText("accedi all'applicazione come utente normale");

        jUse.setBackground(new java.awt.Color(64, 64, 64));
        jUse.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jUse.setForeground(new java.awt.Color(255, 255, 0));
        jUse.setText("usa applicazione");
        jUse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jUseActionPerformed(evt);
            }
        });

        jExit.setBackground(new java.awt.Color(102, 102, 102));
        jExit.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jExit.setForeground(new java.awt.Color(255, 255, 0));
        jExit.setText("exit");
        jExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jExitActionPerformed(evt);
            }
        });

        jGo.setBackground(new java.awt.Color(102, 102, 102));
        jGo.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jGo.setForeground(new java.awt.Color(255, 255, 0));
        jGo.setText("vai >>");
        jGo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jGoActionPerformed(evt);
            }
        });

        jAddPaziente.setBackground(new java.awt.Color(64, 64, 64));
        jAddPaziente.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jAddPaziente.setForeground(new java.awt.Color(255, 255, 0));
        jAddPaziente.setText("aggiungi paziente");
        jAddPaziente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAddPazienteActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 0));
        jLabel6.setText("AMMINISTRATORE");

        jMenuBar1.setBackground(new java.awt.Color(102, 102, 102));
        jMenuBar1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jMenu1.setBackground(new java.awt.Color(102, 102, 102));
        jMenu1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jMenu1.setForeground(new java.awt.Color(255, 153, 0));
        jMenu1.setText("File");
        jMenu1.setPreferredSize(new java.awt.Dimension(60, 20));
        jMenuBar1.add(jMenu1);

        jMenu2.setBackground(new java.awt.Color(102, 102, 102));
        jMenu2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
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
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jExit, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jGo, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jNome)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jUser, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLogout))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                                .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(jLabel5))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jAddRicovero)
                    .addComponent(jModRicovero))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jAddPaziente)
                    .addComponent(jDeleteRicovero))
                .addGap(72, 72, 72))
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jEliminaUtente)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jUse)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jAdmin)
                .addGap(116, 116, 116))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLogout)
                    .addComponent(jUser)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jNome))
                .addGap(7, 7, 7)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jLabel3)
                .addGap(13, 13, 13)
                .addComponent(jEliminaUtente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jAddRicovero)
                    .addComponent(jDeleteRicovero))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jModRicovero)
                    .addComponent(jAddPaziente))
                .addGap(18, 18, 18)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jUse)
                    .addComponent(jAdmin))
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jGo)
                    .addComponent(jExit, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void jAddRicoveroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAddRicoveroActionPerformed
        if (jAddRicovero.isSelected()){
            jModRicovero.setSelected(false);
            jDeleteRicovero.setSelected(false);
            jEliminaUtente.setSelected(false);
            jAddPaziente.setSelected(false);
            jUse.setSelected(false);
        }
    }//GEN-LAST:event_jAddRicoveroActionPerformed

    private void jEliminaUtenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jEliminaUtenteActionPerformed
        if (jEliminaUtente.isSelected()){
            jModRicovero.setSelected(false);
            jDeleteRicovero.setSelected(false);
            jAddRicovero.setSelected(false);
            jAddPaziente.setSelected(false);
            jUse.setSelected(false);
        }
    }//GEN-LAST:event_jEliminaUtenteActionPerformed

    private void jModRicoveroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jModRicoveroActionPerformed
        if (jModRicovero.isSelected()){
            jAddRicovero.setSelected(false);
            jDeleteRicovero.setSelected(false);
            jEliminaUtente.setSelected(false);
            jAddPaziente.setSelected(false);
            jUse.setSelected(false);
        }
    }//GEN-LAST:event_jModRicoveroActionPerformed

    private void jDeleteRicoveroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jDeleteRicoveroActionPerformed
        if (jDeleteRicovero.isSelected()){
            jAddRicovero.setSelected(false);
            jModRicovero.setSelected(false);
            jEliminaUtente.setSelected(false);
            jAddPaziente.setSelected(false);
            jUse.setSelected(false);
        }
    }//GEN-LAST:event_jDeleteRicoveroActionPerformed

    private void jUseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jUseActionPerformed
        if (jUse.isSelected()){
            jAddRicovero.setSelected(false);
            jDeleteRicovero.setSelected(false);
            jEliminaUtente.setSelected(false);
            jAddPaziente.setSelected(false);
            jDeleteRicovero.setSelected(false);
        }
    }//GEN-LAST:event_jUseActionPerformed

    private void jGoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jGoActionPerformed
        String user=jUser.getText();
        int admin = jAdmin.getDisplayedMnemonic();
        if (jAddRicovero.isSelected()){
            new ScegliPaziente(user,admin).setVisible(true);
            this.dispose();

        }
        else if(jModRicovero.isSelected()){
           new ModificaRic(user,admin).setVisible(true);
            this.dispose();
        }
        else if(jDeleteRicovero.isSelected()){
            new EliminaRic(user,admin).setVisible(true);
            this.dispose();
        }
        else if(jEliminaUtente.isSelected()){
            new EliminaUser2(user,admin).setVisible(true);
            this.dispose();
        }
        else if(jUse.isSelected()){
            new User(user,admin).setVisible(true);
            this.dispose();
        }
        else if(jAddPaziente.isSelected()){
            new AggiungiPaziente(user,admin).setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_jGoActionPerformed

    private void jAddPazienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAddPazienteActionPerformed
        if (jAddPaziente.isSelected()){
            jAddRicovero.setSelected(false);
            jModRicovero.setSelected(false);
            jEliminaUtente.setSelected(false);
            jDeleteRicovero.setSelected(false);
            jUse.setSelected(false);
        }
    }//GEN-LAST:event_jAddPazienteActionPerformed

    /**
    * @param args the command line arguments
    */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton jAddPaziente;
    private javax.swing.JRadioButton jAddRicovero;
    private javax.swing.JLabel jAdmin;
    private javax.swing.JRadioButton jDeleteRicovero;
    private javax.swing.JRadioButton jEliminaUtente;
    private javax.swing.JButton jExit;
    private javax.swing.JButton jGo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JButton jLogout;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JRadioButton jModRicovero;
    private javax.swing.JLabel jNome;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JRadioButton jUse;
    private javax.swing.JLabel jUser;
    // End of variables declaration//GEN-END:variables

}
