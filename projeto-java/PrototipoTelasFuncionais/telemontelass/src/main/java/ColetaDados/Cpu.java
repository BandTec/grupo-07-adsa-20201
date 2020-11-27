/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ColetaDados;

import Banco.Insertbd;
import Entities.AlertHardware;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import oshi.hardware.CentralProcessor;

/**
 *
 * @author Markz
 */
public class Cpu extends Componente {

    private CentralProcessor cpu = this.getHaw().getProcessor();
    private long oldTicks[] = new long[CentralProcessor.TickType.values().length];
    private double cpuUsage;
    private List<Double> cpuList = new ArrayList();
    AlertHardware alertCpu = new AlertHardware();
    Insertbd inserir = new Insertbd();

    public Cpu(String tipo) {
        super(tipo);
        this.desc = cpu.getProcessorIdentifier().getName();

    }

    public double getCpuUsage() {
            try {
                cpuUsage = (cpu.getSystemCpuLoadBetweenTicks(oldTicks) * 100);
                oldTicks = cpu.getSystemCpuLoadTicks();
            } catch (Exception e) {
                System.out.println(e);
            }
        gerarLista();
        verificarLista();
        return cpuUsage;
    }

    //ESTÁ EM DESENVOLVIMENTO
    public List<Double> gerarLista() {

        if (cpuList.size() < 10) {
            cpuList.add(cpuUsage);
        } else {
            cpuList.remove(0);
            cpuList.add(cpuUsage);
        }
        return cpuList;
        //ESTÁ EM DESENVOLVIMENTO
    }

    //ESTÁ EM DESENVOLVIMENTO
    public void verificarLista() {
        Integer i = 0;
        for (Double cpu : cpuList) {
            if (cpuList.get(i) > 100.00) {
                i++;
                if (i > 5) {
                    alertCpu.enviarAlertaCpu(alertCpu);
                }
            }
        }
        //ESTÁ EM DESENVOLVIMENTO
    }

    public String getTipo() {
        return tipo;
    }

    public String getDesc() {
        return desc;
    }
    
    public CentralProcessor getCpu() {
        return cpu;
    }

    public long[] getOldTicks() {
        return oldTicks;
    }

    @Override
    public String toString() {
        return "Cpu{" + "cpu=" + cpu + '}';
    }
}
