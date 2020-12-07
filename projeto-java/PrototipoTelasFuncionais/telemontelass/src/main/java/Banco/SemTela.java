/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Banco;

import ColetaDados.Maquina;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Markz
 */
public class SemTela {

    public static void main(String[] args) {
        Maquina maquina = new Maquina();
        Insertbd banco = new Insertbd();

        int delay = 500;   // tempo de espera antes da 1ª execução da tarefa.
        int interval = 1000;  // intervalo no qual a tarefa será executada.

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                
                maquina.getProcessesName();
                banco.InserirDadosComponente(maquina.getCpuUsage(), maquina.getCpu().getDesc(), maquina.getHostname());
                banco.InserirDadosComponente(maquina.getMemUsage(), maquina.getMem().getDesc(), maquina.getHostname());
                
            }
        }, delay, interval);
    }
}
