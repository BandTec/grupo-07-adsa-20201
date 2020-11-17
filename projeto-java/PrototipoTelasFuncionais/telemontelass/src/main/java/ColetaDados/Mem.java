/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ColetaDados;

import Entities.AlertHardware;
import java.util.List;
import oshi.hardware.GlobalMemory;

/**
 *
 * @author Markz
 */
public class Mem {

    private Componente comp = new Componente();
    private GlobalMemory mem = comp.getHaw().getMemory();
    private double memUsage;
    private double memTotal = (mem.getTotal() / 1000000000);
    private List<double> memList = new ArraryList();
    AlertHardware alertMem = new AlertHardware();

    public double getMemUsage() {

        try {
            memUsage = (100 - (mem.getAvailable() * 100) / (mem.getTotal()));
        } catch (Exception e) {
        }
        return memUsage;
    }

    public List<double> gerarLista() {

        if (memList.size() < 10) {
            memList.add(memUsage);
        } else {
            memList.remove(0);
            memList.add(memUsage);
        }
        return memList;
    }

    public void verificarLista() {
        Integer i = 0;
        for (Mem mem : memList) {
            if (memList.get(i) > 90.00) {
                i++;
                if (i > 5) {
                    alertMem.enviarAlertaMemoria(alertMem);
                }
            }
        }
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
