
package Views;

import Entities.DadoConexaoMaquina;
import Entities.Processos;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import Entities.Processos;
import javax.swing.SwingConstants;



/**
 *
 * @author Larissa
 */
public class TelaProcessos extends javax.swing.JFrame {

    ArrayList<Processos> processos = new ArrayList();
    public TelaProcessos() {
        
    }
    public TelaProcessos(DadoConexaoMaquina dado) {
        initComponents();
        atualizarDadosProcessos(dado);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        progresso2 = new javax.swing.JProgressBar();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        progressoCPU = new javax.swing.JProgressBar();
        progressoMemoria = new javax.swing.JProgressBar();
        progressoDisco = new javax.swing.JProgressBar();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        valorCpu = new javax.swing.JLabel();
        valorMemoria = new javax.swing.JLabel();
        ValorDisco = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jLabel9 = new javax.swing.JLabel();

        progresso2.setOrientation(SwingConstants.VERTICAL);
        progresso2.setBackground(new java.awt.Color(153, 153, 255));
        progresso2.setForeground(new java.awt.Color(153, 153, 255));

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 0, 0));
        jLabel4.setText("jLabel4");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, -1, -1));

        progressoCPU.setOrientation(SwingConstants.VERTICAL);
        progressoCPU.setBackground(new java.awt.Color(153, 153, 255));
        progressoCPU.setForeground(new java.awt.Color(153, 153, 255));
        jPanel1.add(progressoCPU, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, 90, 340));

        progressoMemoria.setBackground(new java.awt.Color(153, 153, 255));
        progressoMemoria.setForeground(new java.awt.Color(153, 153, 255));
        progressoMemoria.setToolTipText("");
        progressoMemoria.setMaximumSize(new java.awt.Dimension(32767, 30));
        progressoMemoria.setOrientation(SwingConstants.VERTICAL);
        jPanel1.add(progressoMemoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 160, 90, 340));

        progressoDisco.setBackground(new java.awt.Color(153, 153, 255));
        progressoDisco.setForeground(new java.awt.Color(153, 153, 255));
        progressoDisco.setToolTipText("");
        progressoDisco.setMaximumSize(new java.awt.Dimension(32767, 30));
        progressoDisco.setOrientation(SwingConstants.VERTICAL);
        jPanel1.add(progressoDisco, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 160, 80, 340));

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 18)); // NOI18N
        jLabel1.setText("CPU:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, -1, -1));

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 18)); // NOI18N
        jLabel2.setText("Memória:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 130, -1, -1));

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 18)); // NOI18N
        jLabel3.setText("Últimos processos:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 130, -1, -1));

        valorCpu.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 18)); // NOI18N
        valorCpu.setText("-");
        jPanel1.add(valorCpu, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, -1, -1));

        valorMemoria.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 18)); // NOI18N
        valorMemoria.setText("-");
        jPanel1.add(valorMemoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 100, -1, -1));

        ValorDisco.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 18)); // NOI18N
        ValorDisco.setText("-");
        jPanel1.add(ValorDisco, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 100, -1, -1));

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        jLabel5.setText("%");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, -1, -1));

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        jLabel6.setText("%");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 100, -1, -1));

        jLabel8.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        jLabel8.setText("%");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 100, -1, -1));

        jLabel7.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/cancel.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH)));
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 30, 31, 31));

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 160, 210, 340));

        jLabel9.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 18)); // NOI18N
        jLabel9.setText("Disco:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 130, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 580));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        this.setVisible(false);
    }//GEN-LAST:event_jLabel7MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaProcessos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaProcessos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaProcessos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaProcessos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaProcessos().setVisible(true);
            }
        });
    }
    
    private void atualizarDadosProcessos(DadoConexaoMaquina dado){
    int qtd = dado.getMaquina().getProcessos().size();
        jLabel4.setText("Dados da máquina "+dado.getMaquina().getNome());
    for(Processos processo : dado.getMaquina().getProcessos()){
        System.out.println(String.format("CPU: %.2f\nMEMÓRIA: %.2f\nDISCO: %.2f", processo.getCpu(), processo.getMemoria(), processo.getDisco()));
        progressoCPU.setValue(processo.getCpu().intValue());
        progressoMemoria.setValue(processo.getMemoria().intValue());
        progressoDisco.setValue(processo.getDisco().intValue());
        valorCpu.setText(processo.getCpu().toString());
        valorMemoria.setText(processo.getMemoria().toString());
        ValorDisco.setText(processo.getDisco().toString());   
    }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ValorDisco;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JProgressBar progresso2;
    private javax.swing.JProgressBar progressoCPU;
    private javax.swing.JProgressBar progressoDisco;
    private javax.swing.JProgressBar progressoMemoria;
    private javax.swing.JLabel valorCpu;
    private javax.swing.JLabel valorMemoria;
    // End of variables declaration//GEN-END:variables
}
