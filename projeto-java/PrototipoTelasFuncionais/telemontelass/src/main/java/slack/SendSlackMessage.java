/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slack;

import java.util.Timer;
import java.util.TimerTask;
import Entities.AlertMensagemMotivadora;

/**
 *
 * @author Pichau
 */
public class SendSlackMessage { 
    public static void main(String[] args) {
        Timer timer = new Timer();
        Integer delay = 5000;
        Integer interval = 300000;
           
        timer.scheduleAtFixedRate(new TimerTask() {
        public void run() {
           enviarFrasesMotivadoras();
        }
    }, delay, interval);

    }
    
    public static void enviarFrasesMotivadoras(){
            AlertMensagemMotivadora mensagem = new AlertMensagemMotivadora();
            mensagem.enviarMensagem(mensagem);
            SlackMessage slackMessage = SlackMessage.builder()
              .channel("#outros-assuntos")
              .user("Telebot")
              .text(mensagem.getMensagemAlerta())
              .icon_emoji(":pray:")
              .build();
            SlackUtils.sendMessage(slackMessage);
        }
}
