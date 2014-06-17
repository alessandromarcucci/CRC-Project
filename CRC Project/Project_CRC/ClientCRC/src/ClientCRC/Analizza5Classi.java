/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ClientCRC;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
/**
 *
 * @author alessandro
 */
public class Analizza5Classi extends javax.swing.JFrame implements ActionListener{
    private Font myFont = new Font("Tahoma", Font.PLAIN,11);
    /**
     * Creates new form Analizza5Classi
     */
    public Analizza5Classi(String tipo,int male, int female, int prima, int seconda, int terza, int quarta, int quinta, int sesta,
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
        jLabel50.setText(tipo);
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
        
        jLabel51.setDisplayedMnemonic(unor);
        jLabel52.setDisplayedMnemonic(duer);
        jLabel53.setDisplayedMnemonic(trer);
        jLabel54.setDisplayedMnemonic(quattror);
        jLabel55.setDisplayedMnemonic(cinquer);
        jLabel56.setDisplayedMnemonic(seir);
        jLabel57.setDisplayedMnemonic(setter);
        jLabel58.setDisplayedMnemonic(ottor);
        jLabel59.setDisplayedMnemonic(nover);
        jLabel60.setDisplayedMnemonic(diecir);
        jLabel61.setDisplayedMnemonic(undicir);
        jLabel62.setDisplayedMnemonic(dodicir);
        jLabel63.setDisplayedMnemonic(tredicir);
        jLabel64.setDisplayedMnemonic(quattordicir);
        jLabel65.setDisplayedMnemonic(quindicir);
        jLabel66.setDisplayedMnemonic(sedicir);
        jLabel67.setDisplayedMnemonic(diciassetter);
        jLabel68.setDisplayedMnemonic(diciottor);
        jLabel69.setDisplayedMnemonic(diciannover);
        jLabel70.setDisplayedMnemonic(ventir);
        jLabel71.setDisplayedMnemonic(ventiduer);
        jLabel72.setDisplayedMnemonic(ventitrer);
        jLabel73.setDisplayedMnemonic(ventiquattror);
        jLabel74.setDisplayedMnemonic(venticinquer);
        jLabel75.setDisplayedMnemonic(prer);
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

        jSeparator1 = new javax.swing.JSeparator();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jMaschi = new javax.swing.JLabel();
        jFemmine = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jNona = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPrima = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jDecima = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jSettima = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jOttava = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jQuarta = new javax.swing.JLabel();
        jSesta = new javax.swing.JLabel();
        jQuinta = new javax.swing.JLabel();
        jTerza = new javax.swing.JLabel();
        jSeconda = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jButton3 = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
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
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel49.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(255, 255, 0));
        jLabel49.setText("]");

        jLabel50.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(255, 204, 0));
        jLabel50.setText("r");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 0));
        jLabel3.setText("Gruppo [divisione 2 classi] :[ classe");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 0));
        jLabel5.setText("popolazione del gruppo divisa per sesso");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 204, 0));
        jLabel7.setText("(M:");

        jMaschi.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jMaschi.setForeground(new java.awt.Color(255, 204, 0));
        jMaschi.setText("jLabel4");

        jFemmine.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jFemmine.setForeground(new java.awt.Color(255, 204, 0));
        jFemmine.setText("jLabel6");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 204, 0));
        jLabel8.setText(")");

        jButton2.setBackground(new java.awt.Color(102, 102, 102));
        jButton2.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 0));
        jButton2.setText("grafico 1");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 204, 0));
        jLabel6.setText("; F:");

        jNona.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jNona.setForeground(new java.awt.Color(255, 204, 0));
        jNona.setText("jLabel20");

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 204, 0));
        jLabel19.setText("- [>90 annii]     :");

        jPrima.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jPrima.setForeground(new java.awt.Color(255, 204, 0));
        jPrima.setText("jLabel20");

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 204, 0));
        jLabel18.setText("- [80 - 90 anni] :");

        jDecima.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jDecima.setForeground(new java.awt.Color(255, 204, 0));
        jDecima.setText("jLabel20");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 204, 0));
        jLabel10.setText("- [0 - 10 anni]   :");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 0));
        jLabel9.setText("popolazione del gruppo divisa per età :");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 204, 0));
        jLabel12.setText("- [20 - 30 anni] :");

        jSettima.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jSettima.setForeground(new java.awt.Color(255, 204, 0));
        jSettima.setText("jLabel20");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 204, 0));
        jLabel11.setText("- [10 - 20 anni] :");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 204, 0));
        jLabel14.setText("- [40 - 50 anni] :");

        jOttava.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jOttava.setForeground(new java.awt.Color(255, 204, 0));
        jOttava.setText("jLabel20");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 204, 0));
        jLabel13.setText("- [30 - 40 anni] :");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 204, 0));
        jLabel15.setText("- [50 - 60 anni] :");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 204, 0));
        jLabel16.setText("- [60 - 70 anni] :");

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 204, 0));
        jLabel17.setText("- [70 - 80 anni] :");

        jQuarta.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jQuarta.setForeground(new java.awt.Color(255, 204, 0));
        jQuarta.setText("jLabel20");

        jSesta.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jSesta.setForeground(new java.awt.Color(255, 204, 0));
        jSesta.setText("jLabel20");

        jQuinta.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jQuinta.setForeground(new java.awt.Color(255, 204, 0));
        jQuinta.setText("jLabel20");

        jTerza.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jTerza.setForeground(new java.awt.Color(255, 204, 0));
        jTerza.setText("jLabel20");

        jSeconda.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jSeconda.setForeground(new java.awt.Color(255, 204, 0));
        jSeconda.setText("jLabel20");

        jButton3.setBackground(new java.awt.Color(102, 102, 102));
        jButton3.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 0));
        jButton3.setText("grafico 2");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
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

        jButton7.setBackground(new java.awt.Color(102, 102, 102));
        jButton7.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 0));
        jButton7.setText("grafico 4");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(102, 102, 102));
        jButton4.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 0));
        jButton4.setText("grafico 3");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(102, 102, 102));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 0));
        jButton1.setText("logout");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setText("USER");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 204, 0));
        jLabel2.setText("jLabel2");

        jMenuBar1.setBackground(new java.awt.Color(102, 102, 102));
        jMenuBar1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jMenu1.setBackground(new java.awt.Color(102, 102, 102));
        jMenu1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jMenu1.setForeground(new java.awt.Color(255, 102, 0));
        jMenu1.setText("File");
        jMenu1.setPreferredSize(new java.awt.Dimension(60, 20));
        jMenuBar1.add(jMenu1);

        jMenu2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jMenu2.setForeground(new java.awt.Color(255, 102, 0));
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
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                            .addGroup(layout.createSequentialGroup()
                                .addGap(266, 266, 266)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel9)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel10)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jPrima))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel11)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jSeconda))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel12)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jTerza))
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jLabel16)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(jSettima))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jLabel15)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(jSesta))
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLabel13)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(jQuarta))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLabel14)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(jQuinta))))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel19)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jDecima))
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jLabel18)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(jNona))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jLabel17)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(jOttava))))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGap(66, 66, 66)
                                                        .addComponent(jLabel28))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel22)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jLabel48))
                                                            .addComponent(jLabel47))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(jLabel30)
                                                            .addComponent(jLabel29)))
                                                    .addComponent(jLabel45)))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(28, 28, 28)
                                                .addComponent(jLabel41))
                                            .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGap(10, 10, 10)
                                                        .addComponent(jLabel44))
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel43)
                                                        .addComponent(jLabel42))
                                                    .addComponent(jLabel59)
                                                    .addComponent(jButton7)))))
                                    .addComponent(jLabel60))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel70)
                                        .addGap(6, 6, 6)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel24)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel46))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel52)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGap(10, 10, 10)
                                                        .addComponent(jLabel66)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLabel57)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jLabel51))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addGap(17, 17, 17)
                                                                .addComponent(jLabel61)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jLabel58)
                                                                .addGap(14, 14, 14))
                                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(layout.createSequentialGroup()
                                                                    .addGap(77, 77, 77)
                                                                    .addComponent(jLabel26))
                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                    .addComponent(jLabel37)
                                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                    .addComponent(jLabel27)
                                                                    .addGap(7, 7, 7))
                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                    .addComponent(jLabel31)
                                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                    .addComponent(jLabel38)
                                                                    .addGap(31, 31, 31))))
                                                        .addComponent(jLabel73)))
                                                .addGap(173, 173, 173)
                                                .addComponent(jLabel23)
                                                .addGap(33, 33, 33)
                                                .addComponent(jLabel75)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel74))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel20)
                                                    .addComponent(jLabel4))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel56))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel67)
                                                    .addComponent(jLabel68)
                                                    .addComponent(jLabel69, javax.swing.GroupLayout.Alignment.TRAILING))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                            .addComponent(jLabel39)
                                                            .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel62)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jLabel63)))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel32)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jLabel33))
                                                            .addComponent(jLabel40)))
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                        .addComponent(jLabel64)
                                                        .addGap(6, 6, 6)
                                                        .addComponent(jLabel65)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addComponent(jLabel34)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(jLabel36))
                                                            .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel35)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jLabel25))
                                                            .addComponent(jLabel76)))))))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton5)
                                        .addGap(149, 149, 149))))
                            .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 421, Short.MAX_VALUE)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(268, 268, 268)
                                .addComponent(jLabel53)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel55)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel71)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel72)
                        .addGap(431, 431, 431))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton4)
                                .addGap(156, 156, 156)
                                .addComponent(jLabel54))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel49))
                            .addComponent(jLabel21)
                            .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel49))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7)
                    .addComponent(jMaschi)
                    .addComponent(jLabel6)
                    .addComponent(jFemmine)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(jLabel74)
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel25)
                                        .addComponent(jLabel42))
                                    .addComponent(jLabel35))
                                .addGap(25, 25, 25)
                                .addComponent(jLabel33))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel68))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel26)
                                            .addGap(25, 25, 25)
                                            .addComponent(jLabel27))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(12, 12, 12)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGap(23, 23, 23)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel31)
                                                        .addComponent(jLabel38)))
                                                .addComponent(jLabel37))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel58)
                                                .addComponent(jLabel61))))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel65, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel34)
                                            .addComponent(jLabel36)
                                            .addComponent(jLabel41)
                                            .addComponent(jLabel64))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(jLabel32)
                                                    .addComponent(jLabel62))
                                                .addGap(55, 55, 55))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGap(20, 20, 20)
                                                        .addComponent(jLabel40))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLabel63)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(jLabel39)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addComponent(jLabel59)
                                        .addGap(45, 45, 45))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel67)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel69)
                                            .addComponent(jLabel70))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGap(5, 5, 5)
                                                        .addComponent(jLabel60))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGap(18, 18, 18)
                                                        .addComponent(jLabel71)))
                                                .addGap(24, 24, 24)
                                                .addComponent(jButton3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel72)
                                                .addGap(26, 26, 26))))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10)
                                    .addComponent(jPrima)
                                    .addComponent(jLabel43)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel20)
                                        .addComponent(jLabel56)))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel51)
                                        .addComponent(jLabel52))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(jLabel29)
                                                    .addComponent(jLabel48))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(jLabel30)
                                                    .addComponent(jLabel47))
                                                .addGap(14, 14, 14))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(3, 3, 3)
                                                .addComponent(jLabel22)
                                                .addGap(19, 19, 19)
                                                .addComponent(jLabel28)))
                                        .addComponent(jLabel57)))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel76)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel23)
                                                .addComponent(jLabel66))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel24)
                                                .addComponent(jLabel46))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(jLabel45)
                                            .addGap(20, 20, 20)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel75)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel73)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel11)
                                    .addComponent(jSeconda)
                                    .addComponent(jLabel44))
                                .addGap(5, 5, 5)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel12)
                                    .addComponent(jTerza))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jQuarta)
                                    .addComponent(jLabel13))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel14)
                                    .addComponent(jQuinta))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel15)
                                    .addComponent(jSesta))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel16)
                                    .addComponent(jSettima))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(jOttava))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(jNona))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(jDecima))
                        .addGap(51, 51, 51)
                        .addComponent(jLabel21)
                        .addGap(11, 11, 11)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel55)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel53)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton4)
                                .addComponent(jButton7)
                                .addComponent(jButton5)))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(45, 45, 45)
                            .addComponent(jLabel54))))
                .addContainerGap())
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
        int dentro = jLabel47.getDisplayedMnemonic();
        int fuori = jLabel48.getDisplayedMnemonic();
        new DentroFuori(fuori, dentro).setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

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
                nessuno60, prima60, seconda60, terza60, quarta60, nessuno80, prima80, seconda80, terza80, quarta80,
                nessunomagg, primamagg, secondamagg, terzamagg, quartamagg).setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        int uno = jLabel51.getDisplayedMnemonic();
        int due = jLabel52.getDisplayedMnemonic();
        int tre = jLabel53.getDisplayedMnemonic();
        int quattro = jLabel54.getDisplayedMnemonic();
        int cinque = jLabel55.getDisplayedMnemonic();
        int sei = jLabel56.getDisplayedMnemonic();
        int sette = jLabel57.getDisplayedMnemonic();
        int otto = jLabel58.getDisplayedMnemonic();
        int nove = jLabel59.getDisplayedMnemonic();
        int dieci = jLabel60.getDisplayedMnemonic();
        int undici = jLabel61.getDisplayedMnemonic();
        int dodici = jLabel62.getDisplayedMnemonic();
        int tredici = jLabel63.getDisplayedMnemonic();
        int quattordici = jLabel64.getDisplayedMnemonic();
        int quindici = jLabel65.getDisplayedMnemonic();
        int sedici = jLabel66.getDisplayedMnemonic();
        int diciassette = jLabel67.getDisplayedMnemonic();
        int diciotto = jLabel68.getDisplayedMnemonic();
        int diciannove = jLabel69. getDisplayedMnemonic();
        int venti = jLabel70.getDisplayedMnemonic();
        int ventuno = jLabel71.getDisplayedMnemonic();
        int ventidue = jLabel72.getDisplayedMnemonic();
        int ventitre = jLabel73.getDisplayedMnemonic();
        int ventiquattro = jLabel74.getDisplayedMnemonic();
        int venticinque = jLabel75.getDisplayedMnemonic();
        int pre = jLabel76.getDisplayedMnemonic();
        
        new BarChart2(uno, due, tre, quattro, cinque, sei, sette, otto, nove , dieci, undici , dodici, tredici, quattordici,
                     quindici, sedici, diciassette, diciotto, diciannove, venti, ventuno, ventidue, ventitre, ventiquattro,
                     venticinque, pre).setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jDecima;
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
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
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
    private javax.swing.JLabel jQuinta;
    private javax.swing.JLabel jSeconda;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel jSesta;
    private javax.swing.JLabel jSettima;
    private javax.swing.JLabel jTerza;
    // End of variables declaration//GEN-END:variables
}
