/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * NewJFrame.java
 *
 * Created on 7-gen-2012, 11.46.09
 */

package clientETOM;
import javax.swing.JOptionPane;
import java.net.*;
import java.util.Vector;
import javax.swing.JDialog;
import org.apache.soap.rpc.*;
import org.apache.soap.Constants;
import org.apache.soap.SOAPException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author alessandro
 */
public class CambiaData extends javax.swing.JFrame {

    /** Creates new form NewJFrame */
    public CambiaData() {
        initComponents();

        /*String dbUrl ="jdbc:odbc:diagnosi";
        String user ="";
        String password = "";
        Class.forName(sun.jdbc.odbc.JdbcOdbcDriver);*/


        try {          
                URL address = new URL("http://localhost:8080/soap/servlet/rpcrouter");
                  Call chiamata = new Call();
                  chiamata.setTargetObjectURI("urn:diagnosi");
                  chiamata.setMethodName("getCatchBirthdate");
                  chiamata.setEncodingStyleURI(Constants.NS_URI_SOAP_ENC);
                  try {
                        Response risposta = chiamata.invoke(address, "");
                        if (!risposta.generatedFault()) {
                              Parameter par = risposta.getReturnValue();
                              Vector birthdate = (Vector) par.getValue();

                              DefaultTableModel modello = new DefaultTableModel();
                              jTable1.setModel(modello);
                              modello.addColumn("birthdate", birthdate );

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
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jChange = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        jLabel1.setForeground(new java.awt.Color(0, 51, 51));
        jLabel1.setText("campi data nel file diagnosi.csv");

        jChange.setForeground(new java.awt.Color(51, 255, 0));
        jChange.setText("change");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(162, 162, 162)
                        .addComponent(jChange)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jChange)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CambiaData().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jChange;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

}