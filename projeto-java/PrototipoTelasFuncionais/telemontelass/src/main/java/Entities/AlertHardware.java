package Entities;

import Banco.Insertbd;
import ColetaDados.Maquina;
import ColetaDados.Processos;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import log.Log;
import org.json.JSONObject;
import oshi.software.os.OSProcess;
import slack.Slack;


public class AlertHardware extends Alerts{
    
    Insertbd select = new Insertbd();
    
    public void enviarAlertaCpu(AlertHardware alertaHardware){
        alertaHardware.setTipoAlerta("Problema com CPU");
        alertaHardware.setMensagemAlerta("Sua CPU está apresentando problemas, envie uma notificação ao seu gestor");
        JOptionPane.showMessageDialog(null, alertaHardware.getMensagemAlerta(), alertaHardware.getTipoAlerta(), JOptionPane.ERROR_MESSAGE);  
    }
    
     public void enviarAlertaProcesso(AlertHardware alertaHardware, String processo){
          ColetaDados.Maquina maquina = new ColetaDados.Maquina();
                    alertaHardware.setTipoAlerta("Programa não autorizado detectado");
                    alertaHardware.setMensagemAlerta(String.format("Você está usando programas não autorizados (Programa: %s), uma notificação foi enviada ao seu gestor", processo));
                    JOptionPane.showMessageDialog(null, alertaHardware.getMensagemAlerta(), alertaHardware.getTipoAlerta(), JOptionPane.WARNING_MESSAGE);
                    try {
                        Log log = new Log(alertaHardware.getTipoAlerta(), alertaHardware.getMensagemAlerta(), "Alerta");
                        log.logCriation();
                        Slack slack = new Slack();                        
                        JSONObject json = new JSONObject();
                        json.put("text", String.format("%s na maquina do usuario %s", alertaHardware.getTipoAlerta(), maquina.getUsers()));
                        slack.sendMessage(json);
                    } catch (Exception e) {
                        System.out.println("Erro: " + e);
                    }
    }
     
    public void enviarAlertaMemoria(AlertHardware alertaHardware){
        alertaHardware.setTipoAlerta("Problema com Memória RAM");
        alertaHardware.setMensagemAlerta("Sua memória está apresentando problemas, envie uma notificação ao seu gestor");
        JOptionPane.showMessageDialog(null, alertaHardware.getMensagemAlerta(), alertaHardware.getTipoAlerta(), JOptionPane.ERROR_MESSAGE);
        try {
            Log log = new Log(alertaHardware.getTipoAlerta(), alertaHardware.getMensagemAlerta(), "Alerta");
            log.logCriation();
            Maquina maquina = new Maquina();
            Slack slack = new Slack();                        
            JSONObject json = new JSONObject();
            json.put("text", String.format("%s na maquina do usuario %s", alertaHardware.getTipoAlerta(), maquina.getUsers()));
            slack.sendMessage(json);
        } catch (Exception e) {
            System.out.println("Erro: " + e);
        }
    } 
     
    public void enviarAlertaDisco(AlertHardware alertaHardware){
        alertaHardware.setTipoAlerta("Problema com Disco");
        alertaHardware.setMensagemAlerta("Seu disco está apresentando problemas, envie uma notificação ao seu gestor");
        JOptionPane.showMessageDialog(null, alertaHardware.getMensagemAlerta(), alertaHardware.getTipoAlerta(), JOptionPane.ERROR_MESSAGE);
         try {
            Log log = new Log(alertaHardware.getTipoAlerta(), alertaHardware.getMensagemAlerta(), "Alerta");
            log.logCriation();
            Maquina maquina = new Maquina();
            Slack slack = new Slack();                        
            JSONObject json = new JSONObject();
            json.put("text", String.format("%s na maquina do usuario %s", alertaHardware.getTipoAlerta(), maquina.getUsers()));
            slack.sendMessage(json);
        } catch (Exception e) {
            System.out.println("Erro: " + e);
        }
    } 
}
