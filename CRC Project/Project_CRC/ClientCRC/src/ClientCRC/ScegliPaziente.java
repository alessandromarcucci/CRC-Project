/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ScegliPaziente.java
 *
 * Created on 28-gen-2012, 10.21.04
 */

package ClientCRC;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import java.net.*;
import java.util.Vector;
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
public class ScegliPaziente extends javax.swing.JFrame implements ActionListener{
    private Font myFont = new Font("Tahoma", Font.PLAIN,11);
    /** Creates new form ScegliPaziente */
    public ScegliPaziente(String username, int admin) {
        initComponents();
        this.getContentPane().setBackground(Color.DARK_GRAY);
        this.setIconImage(new ImageIcon("C:\\SOAP\\images\\icon.gif").getImage());
        jUser.setText(username);
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
        try {
                  URL address = new URL("http://localhost:8080/soap/servlet/rpcrouter");
                  Call chiamata = new Call();
                  chiamata.setTargetObjectURI("urn:crc");
                  chiamata.setMethodName("getPazCode");
                  chiamata.setEncodingStyleURI(Constants.NS_URI_SOAP_ENC);
                  try {
                        Response risposta = chiamata.invoke(address, "");
                        if (!risposta.generatedFault()) {
                              Parameter par = risposta.getReturnValue();
                              Vector Code = (Vector) par.getValue();


       try {
                 Call chiama = new Call();
                 chiama.setTargetObjectURI("urn:crc");
                 chiama.setMethodName("getPazName");
                 chiama.setEncodingStyleURI(Constants.NS_URI_SOAP_ENC);
                 try {
                        Response rispo = chiama.invoke(address, "");
                        if (!rispo.generatedFault()) {
                        Parameter para = rispo.getReturnValue();
                        Vector First = (Vector) para.getValue();

        try {
                Call chiama2 = new Call();
                chiama2.setTargetObjectURI("urn:crc");
                chiama2.setMethodName("getPazSecondName");
                chiama2.setEncodingStyleURI(Constants.NS_URI_SOAP_ENC);
                try {
                        Response rispo2 = chiama2.invoke(address, "");
                        if (!rispo2.generatedFault()) {
                        Parameter para2 = rispo2.getReturnValue();
                        Vector Second = (Vector) para2.getValue();

         try {
                Call chiama3 = new Call();
                chiama3.setTargetObjectURI("urn:crc");
                chiama3.setMethodName("getPazDate");
                chiama3.setEncodingStyleURI(Constants.NS_URI_SOAP_ENC);
                try {
                         Response rispo3 = chiama3.invoke(address, "");
                         if (!rispo3.generatedFault()) {
                         Parameter para3 = rispo3.getReturnValue();
                         Vector Date = (Vector) para3.getValue();

        /*try {
              Call chiama4 = new Call();
              chiama4.setTargetObjectURI("urn:crc");
              chiama4.setMethodName("getUserDate");
              chiama4.setEncodingStyleURI(Constants.NS_URI_SOAP_ENC);
              try {
                         Response rispo4 = chiama4.invoke(address, "");
                         if (!rispo4.generatedFault()) {
                         Parameter para4 = rispo4.getReturnValue();
                         Vector Date = (Vector) para4.getValue();*/

                            //visualizzo il risultato nella tabella
                            DefaultTableModel modello = new DefaultTableModel(){
                                public boolean isCellEditable(int row, int col) {
				return false;
                                }
                                
                            };
                            jTable1.setModel(modello);
                            modello.addColumn("cod. fiscale", Code);
                            modello.addColumn("nome", First);
                            modello.addColumn("cognome", Second);
                            modello.addColumn("data nascita", Date);
                           // modello.addColumn("data di nascita",Date);

              /*}
              } catch (SOAPException e) {
                        System.out.println("Errore causato: (" + e.getFaultCode() + "):" + e.getMessage());
              }
              } catch (Exception e) {
                        JOptionPane.showMessageDialog(this, "Attenzione si e verificato un errore", "Errore", JOptionPane.ERROR_MESSAGE);
                        System.out.println(e.getMessage());
              }*/

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
        jTable1.addMouseListener(new MouseAdapter(){
            @Override
     public void mouseClicked(MouseEvent e){
      if (e.getClickCount() == 1){
         System.out.println("single click" );
         }
      else{
          int rows[] = jTable1.getSelectedRows();
          String user= jUser.getText();
          String codice =(String) jTable1.getValueAt(rows[0],0);
          String nome = (String) jTable1.getValueAt(rows[0],1);
          String cognome = (String) jTable1.getValueAt(rows[0],2);
          int admin = jAdmin.getDisplayedMnemonic();
          new AggiungiRicovero(user,codice,nome,cognome,admin).setVisible(true);
          dispose();
            }
        }
       });
        

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
        jUser = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLogout = new javax.swing.JButton();
        jBack = new javax.swing.JButton();
        jExit = new javax.swing.JButton();
        jConfirm = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jAdmin = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setText("AMMINISTRATORE");

        jUser.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        jUser.setForeground(new java.awt.Color(255, 204, 0));
        jUser.setText("jLabel2");

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

        jLogout.setBackground(new java.awt.Color(102, 102, 102));
        jLogout.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLogout.setForeground(new java.awt.Color(255, 255, 0));
        jLogout.setText("log out");
        jLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLogoutActionPerformed(evt);
            }
        });

        jBack.setBackground(new java.awt.Color(102, 102, 102));
        jBack.setFont(new java.awt.Font("Segoe UI Semibold", 0, 10)); // NOI18N
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
        jExit.setText("exit");
        jExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jExitActionPerformed(evt);
            }
        });

        jConfirm.setBackground(new java.awt.Color(102, 102, 102));
        jConfirm.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jConfirm.setForeground(new java.awt.Color(255, 255, 0));
        jConfirm.setText("Seleziona");
        jConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jConfirmActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 0));
        jLabel2.setText("Seleziona Paziente");

        jAdmin.setText("jLabel3");

        jMenuBar1.setBackground(new java.awt.Color(102, 102, 102));
        jMenuBar1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jMenu1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jMenu1.setForeground(new java.awt.Color(255, 153, 0));
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
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 608, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jBack)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 480, Short.MAX_VALUE)
                                .addComponent(jExit)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(244, 244, 244))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jAdmin)
                                .addGap(74, 74, 74)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jUser)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLogout)
                                .addContainerGap())))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLogout)
                    .addComponent(jUser)
                    .addComponent(jAdmin))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jConfirm)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBack)
                    .addComponent(jExit))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jConfirmActionPerformed
        int rows[] = jTable1.getSelectedRows();
        String user= jUser.getText();
        String codice =(String) jTable1.getValueAt(rows[0],0);
        String nome = (String) jTable1.getValueAt(rows[0],1);
        String cognome = (String) jTable1.getValueAt(rows[0],2);
        int admin = jAdmin.getDisplayedMnemonic();
        new AggiungiRicovero(user,codice,nome,cognome, admin).setVisible(true);
        this.dispose();

    }//GEN-LAST:event_jConfirmActionPerformed

    private void jBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBackActionPerformed
       String user=jUser.getText();
       int admin = jAdmin.getDisplayedMnemonic();
        new Administrator(user, admin).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jBackActionPerformed

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
    private javax.swing.JButton jConfirm;
    private javax.swing.JButton jExit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton jLogout;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel jUser;
    // End of variables declaration//GEN-END:variables

}
