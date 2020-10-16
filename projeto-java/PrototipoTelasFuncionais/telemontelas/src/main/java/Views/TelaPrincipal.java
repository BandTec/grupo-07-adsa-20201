package Views;


import Entities.Chamado;
import Entities.Maquina;
import Services.ButtonColumn;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Larissa
 */

public class TelaPrincipal extends javax.swing.JFrame {
    
        ArrayList<Chamado> chamados = new ArrayList();
        Maquina maquina1 = new Maquina(1, "DESK-LARISSA");
        Maquina maquina2 = new Maquina(2, "DESK-GABLAZARO");
        Maquina maquina3 = new Maquina(3, "DESK-VITOR");
        Maquina maquina4 = new Maquina(4, "DESK-CERVAL");
        Maquina maquina5 = new Maquina(5, "DESK-GUILHERME");
        Maquina maquina6 = new Maquina(6, "DESK-MARCELO");
         
        Chamado chamado1 = new Chamado(1,"Desconectado", maquina1, "Há 2 horas");
        Chamado chamado2 = new Chamado(2,"Desconectado", maquina2, "Há 1 dia");
        Chamado chamado3 = new Chamado(3,"Conectado", maquina3, "Online");
        Chamado chamado4 = new Chamado(4,"Conectado", maquina4, "Online");
        Chamado chamado5 = new Chamado(5,"Conectado", maquina5, "Online");
        Chamado chamado6 = new Chamado(6,"Conectado", maquina6, "Online");
    
    
    BufferedImage img = null;
    public TelaPrincipal() {
        initComponents();
        
        chamados.add(chamado1);
        chamados.add(chamado2);
        chamados.add(chamado3);
        chamados.add(chamado4);
        chamados.add(chamado5);  
        chamados.add(chamado6); 

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaRedeMaquina = new javax.swing.JTable();

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 90, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 52, Short.MAX_VALUE)
        );

        setMaximumSize(new java.awt.Dimension(1366, 768));
        setMinimumSize(new java.awt.Dimension(1366, 768));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1366, 768));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabelaRedeMaquina.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        tabelaRedeMaquina.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "MÁQUINA", "STATUS", "VISTO POR ÚLTIMO", "AÇÕES"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaRedeMaquina.setRowHeight(50);
        jScrollPane1.setViewportView(tabelaRedeMaquina);
        if (tabelaRedeMaquina.getColumnModel().getColumnCount() > 0) {
            tabelaRedeMaquina.getColumnModel().getColumn(0).setResizable(false);
            tabelaRedeMaquina.getColumnModel().getColumn(1).setResizable(false);
            tabelaRedeMaquina.getColumnModel().getColumn(2).setResizable(false);
            tabelaRedeMaquina.getColumnModel().getColumn(3).setResizable(false);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 760, 380));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
                DefaultTableModel tableModel = (DefaultTableModel) tabelaRedeMaquina.getModel();
        
            for(Chamado c: chamados){
                 Object[] chama = {c.getCodigo(),c.getMaquina().getNome(), c.getDescricao(), c.getPrioridade()};
                 tableModel.addRow(chama);
                 
                 ButtonColumn bc;
                 bc = new ButtonColumn(tabelaRedeMaquina, 4) {
                 };
            }
    }//GEN-LAST:event_formWindowOpened
 
        
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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaRedeMaquina;
    // End of variables declaration//GEN-END:variables

}
