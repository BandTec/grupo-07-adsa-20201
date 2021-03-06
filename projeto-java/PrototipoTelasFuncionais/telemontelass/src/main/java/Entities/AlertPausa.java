package Entities;

import javax.swing.JOptionPane;
import org.json.JSONObject;
import slack.Slack;
import ColetaDados.Maquina;

public class AlertPausa extends Alerts{

        /*
        SOBRE A PAUSA
                As pausas deverão ser concedidas:
                - Após os primeiros e antes dos últimos 60 (sessenta) minutos de trabalho em atividade de teleatendimento/telemarketing.
                - Em 02 (dois) períodos de 10 (dez) minutos contínuos;
                - O intervalo para repouso e alimentação para a atividade de teleatendimento/telemarketing deve ser de 20 (vinte) minutos.
        */
    
    
        public void enviarAlertaPausa(Alerts alertaPausa){  
            Maquina maquina = new Maquina();
            alertaPausa.setTipoAlerta("Pausa");
            alertaPausa.setMensagemAlerta("Você tem direito a uma pausa de 10 minutos");
            JOptionPane.showMessageDialog(null, alertaPausa.getMensagemAlerta(), alertaPausa.getTipoAlerta(), JOptionPane.INFORMATION_MESSAGE);  
              Slack slack = new Slack();                        
                        JSONObject json = new JSONObject();
                        json.put("text", String.format("%s estara em pausa pelos proximos 10 minutos.", maquina.getUsers()));
                        slack.sendMessage(json);
            
    }
   
    
}