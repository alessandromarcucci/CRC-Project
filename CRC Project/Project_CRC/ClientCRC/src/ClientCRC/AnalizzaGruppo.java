/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ClientCRC;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.*;

/**
 *
 * @author alessandro
 */
public class AnalizzaGruppo extends javax.swing.JFrame implements ActionListener{
    private Font myFont = new Font("Tahoma", Font.PLAIN,11);
    /**
     * Creates new form AnalizzaGruppo
     */
    public AnalizzaGruppo(int male, int female, int prima, int seconda, int terza, int quarta, int quinta, int sesta,
                          int settima, int ottava, int nona, int decima, int zero, int uno, int zeroz, int unoz, int duez,
                          int trez, int quattroz,int nessuno18,int prima18,int seconda18,int terza18,int quarta18,int nessuno40,int prima40,int seconda40,
                          int terza40,int quarta40,int nessuno60,int prima60,int seconda60,int terza60,int quarta60,int nessuno80,int prima80,int seconda80,
                          int terza80,int quarta80,int nessunomagg,int primamagg,int secondamagg,int terzamagg,int quartamagg,
                          int dentro ,int fuori,
                          int unor,
                          int duer,int trer,int quattror,int cinquer,int seir,int setter,int ottor,int nover,int diecir,int undicir,int dodicir,int tredicir,int quattordicir,
                          int quindicir,int sedicir,int diciassetter,int diciottor,int diciannover,int ventir,int ventunor,int ventiduer,int ventitrer,int ventiquattror,int venticinquer,int prer) {
        initComponents();
        this.getContentPane().setBackground(Color.DARK_GRAY);
        this.setIconImage(new ImageIcon("C:\\SOAP\\images\\icon.gif").getImage());
        String ma = String.valueOf(male);
        jMaschi.setText(ma);
        String fe = String.valueOf(female);
        jFemmine.setText(fe);
        String p = String.valueOf(prima);
        jPrima.setText(p);
        String s = String.valueOf(seconda);
        jSeconda.setText(s);
        String t = String.valueOf(terza);
        jTerza.setText(t);
        String q = String.valueOf(quarta);
        jQuarta.setText(q);
        String qi = String.valueOf(quinta);
        jQuinta.setText(qi);
        String se = String.valueOf(sesta);
        jSesta.setText(se);
        String st = String.valueOf(settima);
        jSettima.setText(st);
        String o = String.valueOf(ottava);
        jOttava.setText(o);
        String n = String.valueOf(nona);
        jNona.setText(n);
        String d = String.valueOf(decima);
        jDecima.setText(d);
        jUno.setDisplayedMnemonic(uno);
        jZero.setDisplayedMnemonic(zero);
        jZeroz.setDisplayedMnemonic(zeroz);
        jUnoz.setDisplayedMnemonic(unoz);
        jDuez.setDisplayedMnemonic(duez);
        jTrez.setDisplayedMnemonic(trez);
        jQuattroz.setDisplayedMnemonic(quattroz);
        jLabel22.setDisplayedMnemonic(nessuno18);
        jLabel23.setDisplayedMnemonic(prima18);
        jLabel24.setDisplayedMnemonic(seconda18);
        jLabel25.setDisplayedMnemonic(terza18);
        jLabel26.setDisplayedMnemonic(quarta18);
        jLabel27.setDisplayedMnemonic(nessuno40);
        jLabel28.setDisplayedMnemonic(prima40);
        jLabel29.setDisplayedMnemonic(seconda40);
        jLabel30.setDisplayedMnemonic(terza40);
        jLabel31.setDisplayedMnemonic(quarta40);
        jLabel32.setDisplayedMnemonic(nessuno60);
        jLabel33.setDisplayedMnemonic(prima60);
        jLabel34.setDisplayedMnemonic(seconda60);
        jLabel35.setDisplayedMnemonic(terza60);
        jLabel36.setDisplayedMnemonic(quarta60);
        jLabel37.setDisplayedMnemonic(nessuno80);
        jLabel38.setDisplayedMnemonic(prima80);
        jLabel39.setDisplayedMnemonic(seconda80);
        jLabel40.setDisplayedMnemonic(terza80);
        jLabel41.setDisplayedMnemonic(quarta80);
        jLabel42.setDisplayedMnemonic(nessunomagg);
        jLabel43.setDisplayedMnemonic(primamagg);
        jLabel44.setDisplayedMnemonic(secondamagg);
        jLabel45.setDisplayedMnemonic(terzamagg);
        jLabel46.setDisplayedMnemonic(quartamagg);
        jLabel47.setDisplayedMnemonic(dentro);
        jLabel48.setDisplayedMnemonic(fuori);
        
        
        JMenuItem indietroMenu = new JMenuItem("Indietro");
        JMenuItem guidaMenu = new JMenuItem("Guida");
        JMenuItem creditMenu = new JMenuItem("Credits");
        
        creditMenu.setFont(myFont);
        creditMenu.setBackground(Color.DARK_GRAY);
        creditMenu.setForeground(Color.yellow);
        
        
        guidaMenu.setFont(myFont);
        guidaMenu.setBackground(Color.DARK_GRAY);
        guidaMenu.setForeground(Color.yellow);
        
        
        
        indietroMenu.setFont(myFont);
        indietroMenu.setBackground(Color.DARK_GRAY);
        indietroMenu.setForeground(Color.yellow);
        
        
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
        
        guidaMenu.addActionListener(this);
        creditMenu.addActionListener(this);
        
        
        
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
     if (src == "Guida"){
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
    
  }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jMaschi = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jFemmine = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jNona = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jDecima = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jSettima = new javax.swing.JLabel();
        jOttava = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPrima = new javax.swing.JLabel();
        jSeconda = new javax.swing.JLabel();
        jTerza = new javax.swing.JLabel();
        jQuarta = new javax.swing.JLabel();
        jSesta = new javax.swing.JLabel();
        jQuinta = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel20 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel21 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jZero = new javax.swing.JLabel();
        jUno = new javax.swing.JLabel();
        jZeroz = new javax.swing.JLabel();
        jUnoz = new javax.swing.JLabel();
        jDuez = new javax.swing.JLabel();
        jTrez = new javax.swing.JLabel();
        jQuattroz = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setText("USER");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 204, 0));
        jLabel2.setText("jLabel2");

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 0));
        jLabel3.setText("analizza gruppo di ricovero");

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 0));
        jLabel5.setText("popolazione del gruppo divisa per sesso");

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 204, 0));
        jLabel6.setText("; F:");

        jMaschi.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jMaschi.setForeground(new java.awt.Color(255, 204, 0));
        jMaschi.setText("jLabel4");

        jLabel7.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 204, 0));
        jLabel7.setText("(M:");

        jLabel8.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 204, 0));
        jLabel8.setText(")");

        jFemmine.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jFemmine.setForeground(new java.awt.Color(255, 204, 0));
        jFemmine.setText("jLabel6");

        jButton2.setBackground(new java.awt.Color(102, 102, 102));
        jButton2.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 0));
        jButton2.setText("grafico 1");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 0));
        jLabel9.setText("popolazione del gruppo divisa per età :");

        jLabel12.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 204, 0));
        jLabel12.setText("- [20 - 30 anni] :");

        jNona.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jNona.setForeground(new java.awt.Color(255, 204, 0));
        jNona.setText("jLabel20");

        jLabel10.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 204, 0));
        jLabel10.setText("- [0 - 10 anni]   :");

        jDecima.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jDecima.setForeground(new java.awt.Color(255, 204, 0));
        jDecima.setText("jLabel20");

        jLabel11.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 204, 0));
        jLabel11.setText("- [10 - 20 anni] :");

        jSettima.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jSettima.setForeground(new java.awt.Color(255, 204, 0));
        jSettima.setText("jLabel20");

        jOttava.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jOttava.setForeground(new java.awt.Color(255, 204, 0));
        jOttava.setText("jLabel20");

        jLabel14.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 204, 0));
        jLabel14.setText("- [40 - 50 anni] :");

        jLabel13.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 204, 0));
        jLabel13.setText("- [30 - 40 anni] :");

        jLabel15.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 204, 0));
        jLabel15.setText("- [50 - 60 anni] :");

        jLabel16.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 204, 0));
        jLabel16.setText("- [60 - 70 anni] :");

        jLabel17.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 204, 0));
        jLabel17.setText("- [70 - 80 anni] :");

        jLabel18.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 204, 0));
        jLabel18.setText("- [80 - 90 anni] :");

        jLabel19.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 204, 0));
        jLabel19.setText("- [>90 annii]     :");

        jPrima.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jPrima.setForeground(new java.awt.Color(255, 204, 0));
        jPrima.setText("jLabel20");

        jSeconda.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jSeconda.setForeground(new java.awt.Color(255, 204, 0));
        jSeconda.setText("jLabel20");

        jTerza.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jTerza.setForeground(new java.awt.Color(255, 204, 0));
        jTerza.setText("jLabel20");

        jQuarta.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jQuarta.setForeground(new java.awt.Color(255, 204, 0));
        jQuarta.setText("jLabel20");

        jSesta.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jSesta.setForeground(new java.awt.Color(255, 204, 0));
        jSesta.setText("jLabel20");

        jQuinta.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jQuinta.setForeground(new java.awt.Color(255, 204, 0));
        jQuinta.setText("jLabel20");

        jButton3.setBackground(new java.awt.Color(102, 102, 102));
        jButton3.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 0));
        jButton3.setText("grafico 2");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel20.setBackground(new java.awt.Color(102, 102, 102));
        jLabel20.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 0));
        jLabel20.setText("divisione in classi di DRG");

        jButton4.setBackground(new java.awt.Color(102, 102, 102));
        jButton4.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 0));
        jButton4.setText("grafico 3");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 0));
        jLabel21.setText("analisi del valore soglia");

        jButton5.setBackground(new java.awt.Color(102, 102, 102));
        jButton5.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 0));
        jButton5.setText("grafico 5");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(102, 102, 102));
        jButton6.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 0));
        jButton6.setText("grafico 4");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(102, 102, 102));
        jButton7.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 0));
        jButton7.setText("grafico 6");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

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
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(86, 86, 86)
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel21)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton5)
                                .addGap(89, 89, 89)
                                .addComponent(jButton7)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSeparator2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jMaschi)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jFemmine)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8))
                            .addComponent(jButton2)
                            .addComponent(jSeparator3)
                            .addComponent(jSeparator4)
                            .addComponent(jLabel9)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButton3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel41)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel31))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel19)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jDecima)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel40)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel30))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel18)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jNona)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel39)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel29))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel17)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jOttava)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel38)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel28))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel16)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jSettima)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel37)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel27))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel15)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jSesta)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel46)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel36)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel26))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel10)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jPrima))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel11)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jSeconda)))
                                        .addGap(68, 68, 68)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jZero)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jUno)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel43)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLabel42)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(jLabel32)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(jLabel22))))))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTerza)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel33)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel23))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel13)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jQuarta))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel14)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jQuinta)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel48)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel45)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel35)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel25))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel47)
                                                .addGap(52, 52, 52)
                                                .addComponent(jLabel44)
                                                .addGap(30, 30, 30)
                                                .addComponent(jLabel34)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel24)))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jQuattroz)
                                    .addComponent(jTrez)
                                    .addComponent(jDuez)
                                    .addComponent(jUnoz)
                                    .addComponent(jZeroz))))
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator5)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7)
                    .addComponent(jMaschi)
                    .addComponent(jLabel6)
                    .addComponent(jFemmine)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jPrima)
                    .addComponent(jZero)
                    .addComponent(jZeroz))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jSeconda)
                    .addComponent(jUno)
                    .addComponent(jUnoz)
                    .addComponent(jLabel22)
                    .addComponent(jLabel32)
                    .addComponent(jLabel42))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jTerza)
                    .addComponent(jDuez)
                    .addComponent(jLabel23)
                    .addComponent(jLabel33)
                    .addComponent(jLabel43))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jQuarta)
                    .addComponent(jTrez)
                    .addComponent(jLabel24)
                    .addComponent(jLabel34)
                    .addComponent(jLabel44)
                    .addComponent(jLabel47))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jQuinta)
                    .addComponent(jQuattroz)
                    .addComponent(jLabel25)
                    .addComponent(jLabel35)
                    .addComponent(jLabel45)
                    .addComponent(jLabel48))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jSesta)
                    .addComponent(jLabel26)
                    .addComponent(jLabel36)
                    .addComponent(jLabel46))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jSettima)
                    .addComponent(jLabel27)
                    .addComponent(jLabel37))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jOttava)
                    .addComponent(jLabel28)
                    .addComponent(jLabel38))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jNona)
                    .addComponent(jLabel29)
                    .addComponent(jLabel39))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jDecima)
                    .addComponent(jLabel30)
                    .addComponent(jLabel40))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel31)
                        .addComponent(jLabel41)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jButton7))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int male = Integer.valueOf(jMaschi.getText());
        int female = Integer.valueOf(jFemmine.getText());
        new SessoPie(male, female).setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int prima = Integer.valueOf(jPrima.getText());
        int seconda = Integer.valueOf(jSeconda.getText());
        int terza = Integer.valueOf(jTerza.getText());
        int quarta = Integer.valueOf(jQuarta.getText());
        int quinta = Integer.valueOf(jQuinta.getText());
        int sesta = Integer.valueOf(jSesta.getText());
        int settima = Integer.valueOf(jSettima.getText());
        int ottava = Integer.valueOf(jOttava.getText());
        int nona = Integer.valueOf(jNona.getText());
        int decima = Integer.valueOf(jDecima.getText());
        new EtàPie(prima, seconda, terza, quarta, quinta, sesta, settima, ottava, nona, decima).setVisible(true);
                                            
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        int uno = jUno.getDisplayedMnemonic();
        int zero = jZero.getDisplayedMnemonic();
        new DueClassi(zero,uno).setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        int zero = jZeroz.getDisplayedMnemonic();
        int uno = jUnoz.getDisplayedMnemonic();
        int due = jDuez.getDisplayedMnemonic();
        int tre = jTrez.getDisplayedMnemonic();
        int quattro = jQuattroz.getDisplayedMnemonic();
        new CinqueClassi(zero,uno,due,tre,quattro).setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        int dentro = jLabel47.getDisplayedMnemonic();
        int fuori = jLabel48.getDisplayedMnemonic();
        new DentroFuori(fuori, dentro).setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        int nessuno18 = jLabel22.getDisplayedMnemonic();
        int prima18 = jLabel23.getDisplayedMnemonic();
        int seconda18 = jLabel24.getDisplayedMnemonic();
        int terza18 = jLabel25.getDisplayedMnemonic();
        int quarta18 = jLabel26.getDisplayedMnemonic();
        int nessuno40 = jLabel27.getDisplayedMnemonic();
        int prima40 = jLabel28.getDisplayedMnemonic();
        int seconda40 = jLabel29.getDisplayedMnemonic();
        int terza40 = jLabel30.getDisplayedMnemonic();
        int quarta40 = jLabel31.getDisplayedMnemonic();
        int nessuno60 = jLabel32.getDisplayedMnemonic();
        int prima60 = jLabel33.getDisplayedMnemonic();
        int seconda60 = jLabel34.getDisplayedMnemonic();
        int terza60 = jLabel35.getDisplayedMnemonic();
        int quarta60 = jLabel36.getDisplayedMnemonic();
        int nessuno80 = jLabel37.getDisplayedMnemonic();
        int prima80 = jLabel38.getDisplayedMnemonic();
        int seconda80 = jLabel39.getDisplayedMnemonic();
        int terza80 = jLabel40.getDisplayedMnemonic();
        int quarta80 = jLabel41.getDisplayedMnemonic();
        int nessunomagg = jLabel42.getDisplayedMnemonic();
        int primamagg = jLabel43.getDisplayedMnemonic();
        int secondamagg = jLabel44.getDisplayedMnemonic();
        int terzamagg = jLabel45.getDisplayedMnemonic();
        int quartamagg = jLabel46.getDisplayedMnemonic();
        new BarChartDemo(nessuno18, prima18, seconda18, terza18, quarta18, nessuno40, prima40, seconda40, terza40, quarta40,
                          nessuno60, prima60, seconda60, terza60, quarta60,nessuno80, prima80, seconda80, terza80, quarta80,
                          nessunomagg, primamagg, secondamagg, terzamagg, quartamagg).setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jDecima;
    private javax.swing.JLabel jDuez;
    private javax.swing.JLabel jFemmine;
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
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jMaschi;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel jNona;
    private javax.swing.JLabel jOttava;
    private javax.swing.JLabel jPrima;
    private javax.swing.JLabel jQuarta;
    private javax.swing.JLabel jQuattroz;
    private javax.swing.JLabel jQuinta;
    private javax.swing.JLabel jSeconda;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JLabel jSesta;
    private javax.swing.JLabel jSettima;
    private javax.swing.JLabel jTerza;
    private javax.swing.JLabel jTrez;
    private javax.swing.JLabel jUno;
    private javax.swing.JLabel jUnoz;
    private javax.swing.JLabel jZero;
    private javax.swing.JLabel jZeroz;
    // End of variables declaration//GEN-END:variables
}
