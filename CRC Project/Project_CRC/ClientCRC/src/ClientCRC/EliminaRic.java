/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * NewJFrame.java
 *
 * Created on 27-gen-2012, 11.26.19
 */

package ClientCRC;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
public class EliminaRic extends javax.swing.JFrame implements ActionListener {
    private Font myFont = new Font("Tahoma", Font.PLAIN,11);
    /** Creates new form NewJFrame */
    public EliminaRic(String user, int admin) {
        initComponents();
        this.getContentPane().setBackground(Color.DARK_GRAY);
        this.setIconImage(new ImageIcon("C:\\SOAP\\images\\icon.gif").getImage());
        jLabel2.setText(user);
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
                  chiamata.setMethodName("getIDRic");
                  chiamata.setEncodingStyleURI(Constants.NS_URI_SOAP_ENC);
                  try {
                        Response risposta = chiamata.invoke(address, "");
                        if (!risposta.generatedFault()) {
                              Parameter par = risposta.getReturnValue();
                              Vector id = (Vector) par.getValue();
                              try {
                                        Call chiama = new Call();
                                        chiama.setTargetObjectURI("urn:crc");
                                        chiama.setMethodName("getCodeRic");
                                        chiama.setEncodingStyleURI(Constants.NS_URI_SOAP_ENC);
                                        try {
                                                Response rispo = chiama.invoke(address, "");
                                                if (!rispo.generatedFault()) {
                                                      Parameter para = rispo.getReturnValue();
                                                      Vector code = (Vector) para.getValue();
                                                      try {
                                                        Call chiama2 = new Call();
                                                        chiama2.setTargetObjectURI("urn:crc");
                                                        chiama2.setMethodName("getDatarRic");
                                                        chiama2.setEncodingStyleURI(Constants.NS_URI_SOAP_ENC);
                                                        try {
                                                             Response rispo2 = chiama2.invoke(address, "");
                                                             if (!rispo2.generatedFault()) {
                                                             Parameter para2 = rispo2.getReturnValue();
                                                             Vector datar = (Vector) para2.getValue();

                                                             try {
                                                        Call chiama3 = new Call();
                                                        chiama3.setTargetObjectURI("urn:crc");
                                                        chiama3.setMethodName("getDatadRic");
                                                        chiama3.setEncodingStyleURI(Constants.NS_URI_SOAP_ENC);
                                                        try {
                                                             Response rispo3 = chiama3.invoke(address, "");
                                                             if (!rispo3.generatedFault()) {
                                                             Parameter para3 = rispo3.getReturnValue();
                                                             Vector datad = (Vector) para3.getValue();

                                                             try {
                                                        Call chiama4 = new Call();
                                                        chiama4.setTargetObjectURI("urn:crc");
                                                        chiama4.setMethodName("getDRGRic");
                                                        chiama4.setEncodingStyleURI(Constants.NS_URI_SOAP_ENC);
                                                        try {
                                                             Response rispo4 = chiama4.invoke(address, "");
                                                             if (!rispo4.generatedFault()) {
                                                             Parameter para4 = rispo4.getReturnValue();
                                                             Vector drg = (Vector) para4.getValue();


                                                      //visualizzo il risultato nella tabella
                                                      DefaultTableModel modello = new DefaultTableModel(){
                                                          public boolean isCellEditable(int row, int col) {
                                                            return false;
                                                          }
                                                      };
                                                      jTable.setModel(modello);
                                                      modello.addColumn("id", id );
                                                      modello.addColumn("paziente", code);
                                                      modello.addColumn("data ricovero", datar);
                                                      modello.addColumn("data dimissione", datad);
                                                      modello.addColumn("DRG",drg);
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
                                          System.out.println(e.getMessage());}
                      }
            }catch (SOAPException e) {
                    System.out.println("Errore causato: (" +e.getFaultCode()+ "):" + e.getMessage());
            }

            } catch (MalformedURLException es) {
                  JOptionPane.showMessageDialog(this, "Attenzione si e verificato un errore", "Errore", JOptionPane.ERROR_MESSAGE);
                  System.out.println(es.getMessage());
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
                int admin = jAdmin.getDisplayedMnemonic();
                String user = jLabel1.getText();
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

        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jlogout = new javax.swing.JButton();
        jElimina = new javax.swing.JButton();
        jBack = new javax.swing.JButton();
        jEsci = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jAdmin = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 204, 0));
        jLabel2.setText("jLabel1");

        jTable.setBackground(new java.awt.Color(255, 255, 153));
        jTable.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTable.setForeground(new java.awt.Color(0, 0, 153));
        jTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable.setSelectionBackground(new java.awt.Color(51, 255, 0));
        jTable.setSelectionForeground(new java.awt.Color(255, 0, 0));
        jScrollPane1.setViewportView(jTable);

        jlogout.setBackground(new java.awt.Color(102, 102, 102));
        jlogout.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jlogout.setForeground(new java.awt.Color(255, 255, 0));
        jlogout.setText("logout");
        jlogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jlogoutActionPerformed(evt);
            }
        });

        jElimina.setBackground(new java.awt.Color(102, 102, 102));
        jElimina.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jElimina.setForeground(new java.awt.Color(255, 204, 0));
        jElimina.setText("elimina");
        jElimina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jEliminaActionPerformed(evt);
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

        jEsci.setBackground(new java.awt.Color(102, 102, 102));
        jEsci.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jEsci.setForeground(new java.awt.Color(255, 255, 0));
        jEsci.setText("esci");
        jEsci.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jEsciActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setText("AMMINISTRATORE");

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 204, 0));
        jLabel3.setText("Scegli Ricovero");

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 536, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jBack)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jAdmin)
                                .addGap(61, 61, 61)
                                .addComponent(jEsci, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(227, 227, 227)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jElimina)
                            .addComponent(jLabel3))
                        .addGap(0, 233, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlogout)))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(12, 12, 12)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 526, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(20, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlogout)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(28, 28, 28)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(335, 335, 335)
                        .addComponent(jElimina)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jBack)
                            .addComponent(jEsci)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jAdmin)))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(118, 118, 118)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(74, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jEliminaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jEliminaActionPerformed
        int rows[] = jTable.getSelectedRows();
        String user= jLabel2.getText();
        String id =(String) jTable.getValueAt(rows[0],0);
        int admin = jAdmin.getDisplayedMnemonic();
        //String nome = (String) jTable.getValueAt(rows[0],0);
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
                                chiama.setMethodName("deleteRic"); // chiamata del nostro metodo
                                chiama.setEncodingStyleURI(Constants.NS_URI_SOAP_ENC);
                                Vector param=new Vector();
                                param.addElement(new Parameter("cf",String.class,id,null));
                                chiama.setParams(param);
                                System.out.println("SOAP call parameters:"+chiama);// codifica dei dati trasmessi
                                 try {
                                        System.out.println(id);
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
        new EliminaRic(user,admin).setVisible(true);
        this.dispose();
       }

    }//GEN-LAST:event_jEliminaActionPerformed

    private void jBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBackActionPerformed
        String user = jLabel2.getText();
        int admin = jAdmin.getDisplayedMnemonic();
        new Administrator(user, admin).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jBackActionPerformed

    private void jEsciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jEsciActionPerformed
        JOptionPane option = new JOptionPane("Vuoi Davvero Uscire Dal Programma?", JOptionPane.QUESTION_MESSAGE, JOptionPane.YES_NO_OPTION);
        JDialog dialog = option.createDialog("WARNING!!!");
        dialog.pack();
        dialog.setVisible(true);
        int n = ((Integer)option.getValue()).intValue();
        if (n == 0) {
            System.exit(0);
        }
    }//GEN-LAST:event_jEsciActionPerformed

    private void jlogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jlogoutActionPerformed
        JOptionPane option = new JOptionPane("Vuoi Davvero Disconneterti?", JOptionPane.QUESTION_MESSAGE, JOptionPane.YES_NO_OPTION);
        JDialog dialog = option.createDialog("WARNING!!!");
        dialog.pack();
        dialog.setVisible(true);

        int n = ((Integer)option.getValue()).intValue();
        if (n == 0){
                    new Login().setVisible(true);
                    this.dispose();
                    }
    }//GEN-LAST:event_jlogoutActionPerformed

   
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jAdmin;
    private javax.swing.JButton jBack;
    private javax.swing.JButton jElimina;
    private javax.swing.JButton jEsci;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable;
    private javax.swing.JButton jlogout;
    // End of variables declaration//GEN-END:variables

}
