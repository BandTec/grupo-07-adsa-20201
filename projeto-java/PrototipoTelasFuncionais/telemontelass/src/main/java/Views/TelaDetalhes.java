package Views;

import Banco.Insertbd;
import Banco.Registro;
import ColetaDados.Maquina;
import ColetaDados.Processos;
import ColetaDados.Sessao;
import Entities.AlertHardware;
import Entities.AlertPausa;
import ColetaDados.Mem;
import ColetaDados.Cpu;
import java.awt.Color;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import oshi.software.os.OSProcess;
import javax.swing.table.DefaultTableModel;
import log.Log;
import Entities.AlertMensagemMotivadora;

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
    List<String> listProcessos = new ArrayList();
    AlertMensagemMotivadora alertaMotivador = new AlertMensagemMotivadora();
    Integer horaPlusComeco = Integer.valueOf(reg.getHoraPlus1hr());
    Integer horaPlusFinal = Integer.valueOf(reg.getHoraPlus7hr());
    
    public TelaDetalhes() {

        try {
            initComponents();
            ApresentarDados();
//            inserirDadosComponentes();
//            verificarProcessos();
            fraseMotivadora();
            alertaPausa();
            jLabel8.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/cancel.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH)));
        } catch (Exception e) {
            Log log = new Log("ERROR_tela_detalhes", e.toString(), "Erro");
            log.logCriation();
        }
    }

    public void verificarProcessos() {
        
        listProcessos = maquina.getProcessesName();
        List<String> programas = new ArrayList();
        programas = inserir.selectProgramas();

        for (int i = 0; i < listProcessos.size(); i++) {
            if (!programas.contains(listProcessos.get(i).replaceAll("\n", ""))) {
                alertProcs.enviarAlertaProcesso(alertProcs, listProcessos.get(i).replaceAll("\n", ""));
            }
        }
    }

    public void ApresentarDados() {

        int delay = 500;   // tempo de espera antes da 1ª execução da tarefa.
        int interval = 1000;  // intervalo no qual a tarefa será executada.

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                try {
                    
                    verificarProcessos();
                    Object rowData[] = new Object[10];
                    
                    
                    pgbCpu.setValue((int)maquina.getCpuUsage());
                    pgbRam.setValue((int) maquina.getMemUsage());

                    pgbCpu.setStringPainted(true);
                    pgbCpu.setForeground(Color.BLACK);

                    pgbRam.setStringPainted(true);
                    pgbRam.setForeground(Color.BLACK);

                    lblSo.setText(maquina.getOsMaquina());
                    lblHostname.setText(maquina.getHostname());
                    lblUser.setText(maquina.getUsers());

                    DefaultTableModel model = (DefaultTableModel) jTable2.getModel();

                    for (String processo : listProcessos) {

                        if (!(processo.contains("Idle"))) {
                            rowData[0] = processo;
                            model.addRow(rowData);
                            if (model.getRowCount() > 10) {
                                model.removeRow(0);
                            }
                        }
                    }
                    

                } catch (Exception e) {
                    Log log = new Log("ERROR_apresentar_dados", e.toString(), "Erro");
                    log.logCriation();
                }
            }
        }, delay, interval);

    }
    
    public void fraseMotivadora(){
        
        Timer timer = new Timer();
        Integer delay = 500;
        Integer interval = 120000;
           
        timer.scheduleAtFixedRate(new TimerTask() {
        public void run() {
           alertaMotivador.enviarMensagem(alertaMotivador);
        }
    }, delay, interval);
    }
    
    public void alertaPausa(){
        Timer timer = new Timer();
        Integer delay = 500;
        Integer interval = 1000;
        timer.scheduleAtFixedRate(new TimerTask() {
        public void run() {
           if (Integer.valueOf(new Registro().getHoraFormatada()) > horaPlusComeco && contador == 1) {
                        contador = 2;
                        alertPausa.enviarAlertaPausa(alertPausa);
                    } else if ((Integer.valueOf(new Registro().getHoraFormatada())) > horaPlusFinal && contador == 2) {
                        contador = 0;
                        alertPausa.enviarAlertaPausa(alertPausa);
                    }
            Double cpu = maquina.getCpuUsage();
            inserir.InserirDadosComponente(cpu, maquina.getCpu().getDesc(), maquina.getHostname());
            inserir.InserirDadosComponente(maquina.getMemUsage(), maquina.getMem().getDesc(), maquina.getHostname());              
        }
    }, delay, interval);  
    }
    
//    public void inserirDadosComponentes(){
//        Timer timer = new Timer();
//        Integer delay = 500;
//        Integer interval = 3000;
//        timer.scheduleAtFixedRate(new TimerTask() {
//        public void run() {
//            Double cpu = maquina.getCpuUsage();
//            System.out.println(cpu);
//                    inserir.InserirDadosComponente(cpu, maquina.getCpu().getDesc(), maquina.getHostname());
//
//                    inserir.InserirDadosComponente(maquina.getMemUsage(), maquina.getMem().getDesc(), maquina.getHostname());
//                          
//        }
//    }, delay, interval);  
//        
//        
//       
//    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        lblHostname = new javax.swing.JLabel();
        pgbCpu = new javax.swing.JProgressBar();
        pgbRam = new javax.swing.JProgressBar();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblSo = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblUser = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

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

        setTitle("TELEMON - DETALHES");
        setBackground(new java.awt.Color(153, 153, 153));
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(236, 240, 241));

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

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(180, 30, 12));
        jLabel1.setText("Máquina:");

        lblHostname.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        lblHostname.setText("...");

        pgbCpu.setBackground(new java.awt.Color(0, 153, 255));
        pgbCpu.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        pgbCpu.setOrientation(1);
        pgbCpu.setToolTipText("");
        pgbCpu.setStringPainted(true);

        pgbRam.setBackground(new java.awt.Color(0, 153, 255));
        pgbRam.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        pgbRam.setOrientation(1);
        pgbRam.setToolTipText("");
        pgbRam.setStringPainted(true);

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 18)); // NOI18N
        jLabel6.setText("RAM ");

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 18)); // NOI18N
        jLabel3.setText("CPU");

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(180, 30, 12));
        jLabel4.setText("Sistema Operacional:");

        lblSo.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        lblSo.setText("...");

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(180, 30, 12));
        jLabel5.setText("Usuário:");

        lblUser.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        lblUser.setText("...");

        jLabel8.setText(" ");
        jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblHostname))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblSo, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(136, 136, 136)
                                .addComponent(pgbCpu, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(pgbRam, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(16, 30, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(100, 100, 100)
                        .addComponent(jLabel6)
                        .addGap(48, 48, 48))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblUser, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(lblUser)))
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblHostname))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblSo))
                .addGap(2, 2, 2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pgbCpu, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pgbRam, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel8MouseClicked

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
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
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
