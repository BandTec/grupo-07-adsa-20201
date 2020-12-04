package Entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JOptionPane;

public class AlertMensagemMotivadora extends Alerts{ 
     ArrayList<String> frasesAleatorias = new ArrayList();
     Random random = new Random();

     
     public void gerarFrases(){
       frasesAleatorias.add("Comece onde voce esta, use o que voce tem e faca o que voce pode.");
       frasesAleatorias.add("Tudo o que um sonho precisa para ser realizado e alguem que acredite que ele possa ser realizado.");
       frasesAleatorias.add("Deviamos ser ensinados a nao esperar por inspiracao para comecar algo. Acao sempre gera inspiracao. Inspiracao raramente gera acao.");
       frasesAleatorias.add("Nao importa que voce va devagar, contanto que voce nao pare.");
       frasesAleatorias.add("A inspiracao existe, porem temos que encontra-la trabalhando.");
       frasesAleatorias.add("Descubra quem e voce, e seja essa pessoa. A sua alma foi colocada nesse mundo para ser isso, entao viva essa verdade e todo resto vira.");
     }

    public void enviarMensagem(Alerts alertaMensagem){
        gerarFrases();
        Integer totalItensArray = frasesAleatorias.size();
        Integer numeroAleatorio = random.nextInt(totalItensArray);
       // alertaMensagem.setTipoAlerta("Vai uma motivação ai?");
        alertaMensagem.setMensagemAlerta(frasesAleatorias.get(numeroAleatorio));
        //JOptionPane.showMessageDialog(null, alertaMensagem.getMensagemAlerta(), alertaMensagem.getTipoAlerta(), JOptionPane.INFORMATION_MESSAGE);  
        
    }
    

}
