/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * EliminaUser2.java
 *
 * Created on 27-gen-2012, 15.34.05
 */

package ClientCRC;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;
import java.net.*;
import java.util.Vector;
import javax.swing.*;
import org.apache.soap.rpc.*;
import org.apache.soap.Constants;
import org.apache.soap.SOAPException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author alessandro
 */

public class EliminaUser2 extends javax.swing.JFrame implements ActionListener {
    private Font myFont = new Font("Tahoma", Font.PLAIN,11);
    /** Creates new form EliminaUser2 */
    public EliminaUser2(String username, int admin) {
        initComponents();
        this.getContentPane().setBackground(Color.DARK_GRAY);
        this.setIconImage(new ImageIcon("C:\\SOAP\\images\\icon.gif").getImage());
        
        
        jAdmin.setDisplayedMnemonic(admin);
        jLabel1.setText(username);
        
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
        try {
                  URL address = new URL("http://localhost:8080/soap/servlet/rpcrouter");
                  Call chiamata = new Call();
                  chiamata.setTargetObjectURI("urn:crc");
                  chiamata.setMethodName("getUser");
                  chiamata.setEncodingStyleURI(Constants.NS_URI_SOAP_ENC);
                  try {
                        Response risposta = chiamata.invoke(address, "");
                        if (!risposta.generatedFault()) {
                              Parameter par = risposta.getReturnValue();
                              Vector Nome = (Vector) par.getValue();


       try {
                 Call chiama = new Call();
                 chiama.setTargetObjectURI("urn:crc");
                 chiama.setMethodName("getCode");
                 chiama.setEncodingStyleURI(Constants.NS_URI_SOAP_ENC);
                 try {
                        Response rispo = chiama.invoke(address, "");
                        if (!rispo.generatedFault()) {
                        Parameter para = rispo.getReturnValue();
                        Vector Codice = (Vector) para.getValue();

        try {
                Call chiama2 = new Call();
                chiama2.setTargetObjectURI("urn:crc");
                chiama2.setMethodName("getUserName");
                chiama2.setEncodingStyleURI(Constants.NS_URI_SOAP_ENC);
                try {
                        Response rispo2 = chiama2.invoke(address, "");
                        if (!rispo2.generatedFault()) {
                        Parameter para2 = rispo2.getReturnValue();
                        Vector FirstName = (Vector) para2.getValue();

         try {
                Call chiama3 = new Call();
                chiama3.setTargetObjectURI("urn:crc");
                chiama3.setMethodName("getUserSecondName");
                chiama3.setEncodingStyleURI(Constants.NS_URI_SOAP_ENC);
                try {
                         Response rispo3 = chiama3.invoke(address, "");
                         if (!rispo3.generatedFault()) {
                         Parameter para3 = rispo3.getReturnValue();
                         Vector SecondName = (Vector) para3.getValue();

        try {
              Call chiama4 = new Call();
              chiama4.setTargetObjectURI("urn:crc");
              chiama4.setMethodName("getUserDate");
              chiama4.setEncodingStyleURI(Constants.NS_URI_SOAP_ENC);
              try {
                         Response rispo4 = chiama4.invoke(address, "");
                         if (!rispo4.generatedFault()) {
                         Parameter para4 = rispo4.getReturnValue();
                         Vector Date = (Vector) para4.getValue();

                            //visualizzo il risultato nella tabella
                            DefaultTableModel modello = new DefaultTableModel(){
                                public boolean isCellEditable(int row, int col) {
				return false;
                                }
                               
                            };
                            jTable1.setModel(modello);
                            modello.addColumn("username", Nome);
                            modello.addColumn("codice fiscale", Codice);
                            modello.addColumn("nome", FirstName);
                            modello.addColumn("cognome", SecondName);
                            modello.addColumn("data di nascita",Date);
                                 
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
              } catch (MalformedURLException e) {
                        JOptionPane.showMessageDialog(this, "Attenzione si e verificato un errore", "Errore", JOptionPane.ERROR_MESSAGE);
                        System.out.println(e.getMessage());
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
        
                String user = jLabel1.getText();
                int admin = jAdmin.getDisplayedMnemonic();
                new Administrator(user, admin).setVisible(true);
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

        jLabel1 = new javax.swing.JLabel();
        jLogout = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jRemove = new javax.swing.JButton();
        jBack = new javax.swing.JButton();
        jExit = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jAdmin = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 204, 0));
        jLabel1.setText("jLabel1");

        jLogout.setBackground(new java.awt.Color(102, 102, 102));
        jLogout.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLogout.setForeground(new java.awt.Color(255, 255, 0));
        jLogout.setText("logout");
        jLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLogoutActionPerformed(evt);
            }
        });

        jTable1.setBackground(new java.awt.Color(255, 255, 153));
        jTable1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTable1.setForeground(new java.awt.Color(0, 0, 153));
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
        jTable1.setSelectionBackground(new java.awt.Color(51, 255, 0));
        jTable1.setSelectionForeground(new java.awt.Color(255, 0, 0));
        jScrollPane1.setViewportView(jTable1);

        jRemove.setBackground(new java.awt.Color(102, 102, 102));
        jRemove.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jRemove.setForeground(new java.awt.Color(255, 204, 0));
        jRemove.setText("Remove");
        jRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRemoveActionPerformed(evt);
            }
        });

        jBack.setBackground(new java.awt.Color(102, 102, 102));
        jBack.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jBack.setForeground(new java.awt.Color(255, 255, 0));
        jBack.setText("<< indietro");
        jBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBackActionPerformed(evt);
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

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 0));
        jLabel2.setText("AMMINISTRATORE");

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 0));
        jLabel3.setText("Seleziona Utente");

        jAdmin.setText("jLabel4");

        jMenuBar1.setBackground(new java.awt.Color(102, 102, 102));
        jMenuBar1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jMenu1.setBackground(new java.awt.Color(102, 102, 102));
        jMenu1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jMenu1.setForeground(new java.awt.Color(255, 153, 0));
        jMenu1.setText("File");
        jMenu1.setPreferredSize(new java.awt.Dimension(60, 20));
        jMenuBar1.add(jMenu1);

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 860, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 860, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jBack)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jExit, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLogout))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel3))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(395, 395, 395)
                                .addComponent(jRemove)
                                .addGap(100, 100, 100)
                                .addComponent(jAdmin)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLogout)
                    .addComponent(jLabel1))
                .addGap(28, 28, 28)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jRemove)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jBack)
                            .addComponent(jExit)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jAdmin)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBackActionPerformed
        String user = jLabel1.getText();
        int admin = jAdmin.getDisplayedMnemonic();
        new Administrator(user, admin).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jBackActionPerformed

    private void jRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRemoveActionPerformed
        int rows[] = jTable1.getSelectedRows();
        String user= jLabel1.getText();
        String codice =(String) jTable1.getValueAt(rows[0],1);
        String nome = (String) jTable1.getValueAt(rows[0],0);
        int admin = jAdmin.getDisplayedMnemonic();
        JOptionPane option = new JOptionPane("Vuoi davvero cancellare l'utente selezionato?", JOptionPane.QUESTION_MESSAGE, JOptionPane.YES_NO_OPTION);
        JDialog dialog = option.createDialog("WARNING!!!");
        dialog.pack();
        dialog.setVisible(true);
        
        int n = ((Integer)option.getValue()).intValue();
        if (n == 0){

                            try{
                                URL indirizzo = new URL("http://localhost:8080/soap/servlet/rpcrouter");
                                Call chiama=new Call();
                                chiama.setTargetObjectURI("urn:crc");// l'ID della nostra RCP creata ad HOC
                                chiama.setMethodName("deleteUser"); // chiamata del nostro metodo
                                chiama.setEncodingStyleURI(Constants.NS_URI_SOAP_ENC);
                                Vector param=new Vector();
                                param.addElement(new Parameter("cf",String.class,codice,null));
                                chiama.setParams(param);
                                System.out.println("SOAP call parameters:"+chiama);// codifica dei dati trasmessi
                                 try {
                                        System.out.println(codice);
                                        Response risp = chiama.invoke(indirizzo, "");
                                        Parameter para = risp.getReturnValue(); // leggo la risposta
                                     }
                                 catch(SOAPException e)
                                                {
                                                   JOptionPane.showMessageDialog(this, "attenzione si è verificato un errore", "errore", JOptionPane.ERROR_MESSAGE);
                                                   System.out.println("errore causato:("+e.getFaultCode()+"):"+e.getMessage());
                                                }
                             }
                           catch(Exception ex){
                                       JOptionPane.showMessageDialog(this, "attenzione errore di connessione", "errore", JOptionPane.ERROR_MESSAGE);
                                       System.out.println(ex.getMessage());
                                              }

        JOptionPane.showMessageDialog(this, "Partita Eliminata", "Info", JOptionPane.INFORMATION_MESSAGE);
        new EliminaUser2(user, admin).setVisible(true);
        this.dispose();
       }
    }//GEN-LAST:event_jRemoveActionPerformed

    private void jExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jExitActionPerformed
        JOptionPane option = new JOptionPane("Vuoi Davvero Uscire Dal Programma?", JOptionPane.QUESTION_MESSAGE, JOptionPane.YES_NO_OPTION);
        JDialog dialog = option.createDialog("WARNING!!!");
        dialog.pack();
        dialog.setVisible(true);
        int n = ((Integer)option.getValue()).intValue();
        if (n == 0) {
            System.exit(0);
        }
    }//GEN-LAST:event_jExitActionPerformed

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
    private javax.swing.JButton jBack;
    private javax.swing.JButton jExit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton jLogout;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JButton jRemove;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

}
