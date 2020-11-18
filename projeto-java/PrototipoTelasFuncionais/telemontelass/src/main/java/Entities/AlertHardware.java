package Entities;

import ColetaDados.Processos;
import java.util.List;

import javax.swing.JOptionPane;
import oshi.software.os.OSProcess;


public class AlertHardware extends Alerts{

    public void enviarAlertaCpu(AlertHardware alertaHardware){
        alertaHardware.setTipoAlerta("Problema com CPU");
        alertaHardware.setMensagemAlerta("Sua CPU está apresentando problemas, envie uma notificação ao seu gestor");
        JOptionPane.showMessageDialog(null, alertaHardware.getMensagemAlerta(), alertaHardware.getTipoAlerta(), JOptionPane.ERROR_MESSAGE);  
    }
    
     public void enviarAlertaProcesso(AlertHardware alertaHardware){
          ColetaDados.Maquina maquina = new ColetaDados.Maquina();
          for (String process : maquina.getProcs()) {
                if (process.contains("Discord")) {
                    System.out.println(process);
                    alertaHardware.setTipoAlerta("Programa não autorizado detectado");
                    alertaHardware.setMensagemAlerta("Você está usando programas não autorizados, uma notificação foi enviada ao seu gestor");
                    JOptionPane.showMessageDialog(null, alertaHardware.getMensagemAlerta(), alertaHardware.getTipoAlerta(), JOptionPane.WARNING_MESSAGE);  
                }
         }
    }
     
    public void enviarAlertaMemoria(AlertHardware alertaHardware){
        alertaHardware.setTipoAlerta("Problema com Memória");
        alertaHardware.setMensagemAlerta("Sua memória está apresentando problemas, envie uma notificação ao seu gestor");
        JOptionPane.showMessageDialog(null, alertaHardware.getMensagemAlerta(), alertaHardware.getTipoAlerta(), JOptionPane.ERROR_MESSAGE);  
    } 
     
    public void enviarAlertaDisco(AlertHardware alertaHardware){
        alertaHardware.setTipoAlerta("Problema com Disco");
        alertaHardware.setMensagemAlerta("Seu disco está apresentando problemas, envie uma notificação ao seu gestor");
        JOptionPane.showMessageDialog(null, alertaHardware.getMensagemAlerta(), alertaHardware.getTipoAlerta(), JOptionPane.ERROR_MESSAGE);  
    } 
}
