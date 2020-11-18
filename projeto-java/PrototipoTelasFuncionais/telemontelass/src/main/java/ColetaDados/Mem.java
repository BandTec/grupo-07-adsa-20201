/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ColetaDados;

import Entities.AlertHardware;
import java.util.ArrayList;
import java.util.List;
import oshi.hardware.GlobalMemory;

/**
 *
 * @author Markz
 */
public class Mem {

    private Componente comp = new Componente("ram");
    private GlobalMemory mem = comp.getHaw().getMemory();
    private Double memUsage;
    private Long memTotal = (mem.getTotal() / 1000000000);
    private List<Double> memList = new ArrayList();
    AlertHardware alertMem = new AlertHardware();
    
     public Mem() {
         comp.setDesc(memTotal.toString());
    } 

    public double getMemUsage() {

        try {
            memUsage = Double.valueOf(100 - (mem.getAvailable() * 100) / (mem.getTotal()));
        } catch (Exception e) {
        }
        return memUsage;
    }
    //ESTÁ EM DESENVOLVIMENTO
    public List<Double> gerarLista() {

        if (memList.size() < 10) {
            memList.add(memUsage);
        } else {
            memList.remove(0);
            memList.add(memUsage);
        }
        return memList;
    //ESTÁ EM DESENVOLVIMENTO
    }
    //ESTÁ EM DESENVOLVIMENTO
    public void verificarLista() {
        Integer i = 0;
        for (Double mem : memList) {
            if (memList.get(i) > 90.00) {
                i++;
                if (i > 5) {
                    alertMem.enviarAlertaMemoria(alertMem);
                }
            }
        }
    //ESTÁ EM DESENVOLVIMENTO
    }

    public Componente getComp() {
        return comp;
    }

    public GlobalMemory getMem() {
        return mem;
    }

    public double getMemTotal() {
        return memTotal;
    }

    @Override
    public String toString() {
        return "Mem{" + "comp=" + comp + ", mem=" + mem + ", memUsage=" + memUsage + ", memTotal=" + memTotal + '}';
    }
}
