/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ModificaRic2.java
 *
 * Created on 29-gen-2012, 11.18.37
 */

package ClientCRC;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
public class ModificaRic2 extends javax.swing.JFrame implements ActionListener {
    private Font myFont = new Font("Tahoma", Font.PLAIN,11);
    /** Creates new form ModificaRic2 */
    public ModificaRic2(String username, String code, String nome, String cognome, int admin) {
        initComponents();
        this.getContentPane().setBackground(Color.DARK_GRAY);
        this.setIconImage(new ImageIcon("C:\\SOAP\\images\\icon.gif").getImage());
        jUser.setText(username);
        jNome.setText(nome);
        jCognome.setText(cognome);
        jCode.setText(code);
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
                  chiamata.setMethodName("getOneID");
                  Vector param = new Vector();
                  param.addElement(new Parameter("cf",String.class,code,null));
                  chiamata.setParams(param);
                  System.out.println("SOAP call parameters:"+chiamata);// codifica dei dati trasmessi
                  chiamata.setEncodingStyleURI(Constants.NS_URI_SOAP_ENC);
                  try {
                        Response risposta = chiamata.invoke(address, "");
                        if (!risposta.generatedFault()) {
                              Parameter par = risposta.getReturnValue();
                              Vector ID = (Vector) par.getValue();


       try {
                 Call chiama = new Call();
                 chiama.setTargetObjectURI("urn:crc");
                 chiama.setMethodName("getOneDataRic");
                 Vector parame = new Vector();
                  parame.addElement(new Parameter("cf",String.class,code,null));
                  chiama.setParams(parame);
                  System.out.println("SOAP call parameters:"+chiama);// codifica dei dati trasmessi
                 chiama.setEncodingStyleURI(Constants.NS_URI_SOAP_ENC);
                 try {
                        Response rispo = chiama.invoke(address, "");
                        if (!rispo.generatedFault()) {
                        Parameter para = rispo.getReturnValue();
                        Vector DataRic = (Vector) para.getValue();

        try {
                Call chiama2 = new Call();
                chiama2.setTargetObjectURI("urn:crc");
                chiama2.setMethodName("getOneDataDim");
                Vector parame2 = new Vector();
                  parame2.addElement(new Parameter("cf",String.class,code,null));
                  chiama2.setParams(parame2);
                  System.out.println("SOAP call parameters:"+chiama2);// codifica dei dati trasmessi
                chiama2.setEncodingStyleURI(Constants.NS_URI_SOAP_ENC);
                try {
                        Response rispo2 = chiama2.invoke(address, "");
                        if (!rispo2.generatedFault()) {
                        Parameter para2 = rispo2.getReturnValue();
                        Vector DataDim = (Vector) para2.getValue();

         try {
                Call chiama3 = new Call();
                chiama3.setTargetObjectURI("urn:crc");
                chiama3.setMethodName("getOneDRG");
                Vector parame3 = new Vector();
                  parame3.addElement(new Parameter("cf",String.class,code,null));
                  chiama3.setParams(parame3);
                  System.out.println("SOAP call parameters:"+chiama3);// codifica dei dati trasmessi
                chiama3.setEncodingStyleURI(Constants.NS_URI_SOAP_ENC);
                try {
                         Response rispo3 = chiama3.invoke(address, "");
                         if (!rispo3.generatedFault()) {
                         Parameter para3 = rispo3.getReturnValue();
                         Vector DRG = (Vector) para3.getValue();

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
                            modello.addColumn("ID", ID);
                            modello.addColumn("Data Ricovero", DataRic);
                            modello.addColumn("Data Dimissione", DataDim);
                            modello.addColumn("DRG", DRG);
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
        String id =(String) jTable1.getValueAt(rows[0],0);
        String nome = jNome.getText();
        String cognome = jCognome.getText();
        String code = jCode.getText();
        int admin = jAdmin.getDisplayedMnemonic();
        new ModificaRic3(user,id,nome,cognome,code, admin).setVisible(true);
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
        
                String user = jLabel1.getText();
                int admin = jAdmin.getDisplayedMnemonic();
                new ModificaRic(user, admin).setVisible(true);
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
        jLabel2 = new javax.swing.JLabel();
        jNome = new javax.swing.JLabel();
        jCognome = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jCode = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jConfirm = new javax.swing.JButton();
        jLogout = new javax.swing.JButton();
        jBack = new javax.swing.JButton();
        jExit = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jAdmin = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 102, 102));

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setText("AMMINISTRATORE");

        jUser.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        jUser.setForeground(new java.awt.Color(255, 204, 0));
        jUser.setText("jLabel2");

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 0));
        jLabel2.setText("Ricoveri del paziente");

        jNome.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jNome.setForeground(new java.awt.Color(255, 204, 0));
        jNome.setText("jLabel3");

        jCognome.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jCognome.setForeground(new java.awt.Color(255, 204, 0));
        jCognome.setText("jLabel3");

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 0));
        jLabel3.setText("codice fiscale");

        jCode.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jCode.setForeground(new java.awt.Color(255, 204, 0));
        jCode.setText("jLabel4");

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

        jConfirm.setBackground(new java.awt.Color(102, 102, 102));
        jConfirm.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jConfirm.setForeground(new java.awt.Color(255, 204, 0));
        jConfirm.setText("seleziona");
        jConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jConfirmActionPerformed(evt);
            }
        });

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

        jAdmin.setText("jLabel4");

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
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jBack)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jAdmin)
                                .addGap(81, 81, 81)
                                .addComponent(jExit, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jUser, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLogout))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jCode))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jNome)))
                                .addGap(32, 32, 32)
                                .addComponent(jCognome)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jConfirm)
                        .addGap(189, 189, 189))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLogout)
                    .addComponent(jLabel1)
                    .addComponent(jUser))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jNome)
                    .addComponent(jCognome))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jCode))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jConfirm)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jBack)
                            .addComponent(jExit))
                        .addGap(0, 9, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jAdmin)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jConfirmActionPerformed
        int rows[] = jTable1.getSelectedRows();
        String user= jUser.getText();
        String id =(String) jTable1.getValueAt(rows[0],0);
        String nome = jNome.getText();
        String cognome = jCognome.getText();
        String code = jCode.getText();
        int admin = jAdmin.getDisplayedMnemonic();
        new ModificaRic3(user,id,nome,cognome,code, admin).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jConfirmActionPerformed

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

    private void jBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBackActionPerformed
        String user=jUser.getText();
        int admin = jAdmin.getDisplayedMnemonic();
        new ModificaRic(user, admin).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jBackActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jAdmin;
    private javax.swing.JButton jBack;
    private javax.swing.JLabel jCode;
    private javax.swing.JLabel jCognome;
    private javax.swing.JButton jConfirm;
    private javax.swing.JButton jExit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton jLogout;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel jNome;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel jUser;
    // End of variables declaration//GEN-END:variables

}
