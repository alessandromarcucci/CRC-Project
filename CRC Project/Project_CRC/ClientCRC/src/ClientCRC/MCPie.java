/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MCPie.java
 *
 * Created on 8-feb-2012, 17.36.56
 */

package ClientCRC;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
/**
 *
 * @author alessandro
 */
public class MCPie extends javax.swing.JFrame {

    /** Creates new form MCPie */
    public MCPie(int m, int c) {
        initComponents();
        this.getContentPane().setBackground(Color.DARK_GRAY );
        this.setIconImage(new ImageIcon("C:\\SOAP\\images\\icon.gif").getImage());
        jprima.setDisplayedMnemonic(m);
        jseconda.setDisplayedMnemonic(c);
        setContentPane(createDemoPanel());
        this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jprima = new javax.swing.JLabel();
        jseconda = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jprima.setText("jLabel1");

        jseconda.setText("jLabel2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jprima)
                    .addComponent(jseconda))
                .addContainerGap(356, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jprima)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jseconda)
                .addContainerGap(255, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   private PieDataset createDataset() {

        int prima = jprima.getDisplayedMnemonic();

        int seconda = jseconda.getDisplayedMnemonic();



        int tot = prima + seconda;
        float primaperc = ((100 * prima)/tot);
        float secondaperc =((100 * seconda)/ tot);



        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("medici", new Double(primaperc));
        dataset.setValue("chirurgici", new Double(secondaperc));

        return dataset;
    }


    private static JFreeChart createChart(PieDataset dataset) {

        JFreeChart chart = ChartFactory.createPieChart(
            "tipo di interventi",  // chart title
            dataset,             // data
            true,               // include legend
            true,
            false
        );
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setLabelFont(new Font("Verdana", Font.PLAIN, 12));
        plot.setNoDataMessage("No data available");
        plot.setCircular(false);
        plot.setLabelGap(0.02);
        return chart;

    }

     public  JPanel createDemoPanel() {
        JFreeChart chart = createChart(createDataset());
        return new ChartPanel(chart);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jprima;
    private javax.swing.JLabel jseconda;
    // End of variables declaration//GEN-END:variables

}
