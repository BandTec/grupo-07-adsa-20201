package Views;

import Banco.Insertbd;
import Banco.Registro;
import ColetaDados.Cpu;
import ColetaDados.Maquina;
import ColetaDados.Mem;
import ColetaDados.Processos;
import ColetaDados.Sessao;
import Entities.AlertHardware;
import Entities.AlertPausa;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.table.DefaultTableModel;
import log.Log;
import oshi.software.os.OSProcess;

public class TelaDetalhes extends javax.swing.JFrame {

    Timer timer = new Timer();
    Maquina maquina = new Maquina();
    Sessao session = new Sessao();
    AlertHardware alertProcs = new AlertHardware();
    AlertPausa alertPausa = new AlertPausa();
    Insertbd inserir = new Insertbd();
    private Processos processos = new Processos();
    Registro reg = new Registro();
    int contador = 1;

    public TelaDetalhes() {
        try {
            initComponents();
            ApresentarDados();
            alertProcs.enviarAlertaProcesso(alertProcs);
        } catch (Exception e) {
            Log log = new Log("ERROR_tela_detalhes", e.toString(), "Erro");
            log.logCriation();
        }
    }

    public void ApresentarDados() {

        System.out.println(session.getSessionList());
        System.out.println(maquina.getHostname());
        System.out.println(maquina.getUsers());
        System.out.println(maquina.getCpu().getDesc());
        System.out.println(maquina.getMem().getDesc());

        int delay = 500;   // tempo de espera antes da 1ª execução da tarefa.
        int interval = 1000;  // intervalo no qual a tarefa será executada.

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                try {

                    Object rowData[] = new Object[10];

                    pgbCpu.setValue((int) maquina.getCpuUsage());
                    pgbRam.setValue((int) maquina.getMemUsage());

                    pgbCpu.setStringPainted(true);
                    pgbCpu.setForeground(Color.BLACK);

                    pgbRam.setStringPainted(true);
                    pgbRam.setForeground(Color.BLACK);

                    lblSo.setText(maquina.getOsMaquina());
                    lblHostname.setText(maquina.getHostname());
                    lblUser.setText(maquina.getUsers());

                    DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
                    List<String> listProcessos = maquina.getProcessesName();

                    for (String processo : listProcessos) {

                        if (!(processo.contains("Idle"))) {
                            rowData[0] = processo;
                            model.addRow(rowData);
                            if (model.getRowCount() > 10) {
                                model.removeRow(0);
                            }
                        }
                    }

                    inserir.InserirDadosComponente(maquina.getCpuUsage(), maquina.getCpu().getDesc(), maquina.getHostname());
                    inserir.InserirDadosComponente(maquina.getDisco().DiskUsage(0), maquina.getDisco().diskName(0), maquina.getHostname());
                    inserir.InserirDadosComponente(maquina.getMemUsage(), maquina.getMem().getDesc(), maquina.getHostname());

                    if (Integer.valueOf(new Registro().getHoraFormatada()) > Integer.valueOf(reg.getHoraPlus1hr()) && contador == 1) {
                        contador = 2;
                        alertPausa.enviarAlertaPausa(alertPausa);
                    } else if ((Integer.valueOf(new Registro().getHoraFormatada())) > Integer.valueOf(reg.getHoraPlus1hr()) && contador == 2) {
                        contador = 0;
                        alertPausa.enviarAlertaPausa(alertPausa);
                    }

                } catch (Exception e) {
                    Log log = new Log("ERROR_apresentar_dados", e.toString(), "Erro");
                    log.logCriation();
                }
            }
        }, delay, interval);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        lblHostname = new javax.swing.JLabel();
        pgbRam = new javax.swing.JProgressBar();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblSo = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        pgbCpu = new javax.swing.JProgressBar();
        jLabel5 = new javax.swing.JLabel();
        lblUser = new javax.swing.JLabel();

        jLabel7.setText("jLabel7");

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
        jScrollPane2.setViewportView(jTable1);

        setBackground(new java.awt.Color(236, 240, 241));

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(180, 30, 12));
        jLabel1.setText("Máquina:");

        lblHostname.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        lblHostname.setText("CH2354");

        pgbRam.setBackground(new java.awt.Color(0, 153, 255));
        pgbRam.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        pgbRam.setOrientation(1);
        pgbRam.setToolTipText("");
        pgbRam.setStringPainted(true);

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 18)); // NOI18N
        jLabel3.setText("CPU");

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 18)); // NOI18N
        jLabel6.setText("RAM ");

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(180, 30, 12));
        jLabel4.setText("Sistema Operacional:");

        lblSo.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        lblSo.setText("...");

        jTable2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jTable2.setForeground(new java.awt.Color(0, 0, 0));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Processos em aberto"
            }
        ));
        jTable2.setGridColor(new java.awt.Color(0, 153, 153));
        jScrollPane3.setViewportView(jTable2);

        pgbCpu.setBackground(new java.awt.Color(0, 153, 255));
        pgbCpu.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        pgbCpu.setOrientation(1);
        pgbCpu.setToolTipText("");
        pgbCpu.setStringPainted(true);

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(180, 30, 12));
        jLabel5.setText("Usuário:");

        lblUser.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        lblUser.setText("...");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(12, 12, 12)
                                .addComponent(lblHostname))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblSo, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(lblUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(pgbCpu, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(47, 47, 47)
                                .addComponent(pgbRam, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(74, 74, 74))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(81, 81, 81)
                                .addComponent(jLabel6)
                                .addGap(91, 91, 91))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(lblHostname))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel3)))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(lblSo))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(lblUser))))
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(pgbCpu, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(pgbRam, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(TelaDetalhes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaDetalhes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaDetalhes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaDetalhes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaDetalhes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel lblHostname;
    private javax.swing.JLabel lblSo;
    private javax.swing.JLabel lblUser;
    public static javax.swing.JProgressBar pgbCpu;
    private javax.swing.JProgressBar pgbRam;
    // End of variables declaration//GEN-END:variables
}
