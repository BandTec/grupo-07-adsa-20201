package ColetaDados;

import Banco.Insertbd;
import Entities.AlertHardware;
import java.util.ArrayList;
import java.util.List;
import log.Log;
import oshi.hardware.GlobalMemory;
import oshi.hardware.HardwareAbstractionLayer;


public class Mem extends Componente{
    
    private GlobalMemory mem = this.getHaw().getMemory();
    private Double memUsage;
    private Long memTotal = (mem.getTotal() / 1000000000);
    private List<Double> memList = new ArrayList();
    AlertHardware alertMem = new AlertHardware();
    Insertbd inserir = new Insertbd();
    
    public Mem(String tipo) {
        super(tipo);
        this.desc = memTotal.toString();
    }

    public double getMemUsage() {

        try {
            memUsage = Double.valueOf(100 - (mem.getAvailable() * 100) / (mem.getTotal()));
        } catch (Exception e) {
            Log log = new Log("ERROR_get_mem_usage", e.toString(), "erro");
            log.logCriation();
        }
        gerarLista();
        verificarLista();
        return memUsage;
    }

    public List<Double> gerarLista() {

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
        for (Double mem : memList) {
            if (memList.get(i) > 100.00) {
                i++;
                if (i > 5) {
                    alertMem.enviarAlertaMemoria(alertMem);
                }
            }
        }

    }

    public GlobalMemory getMem() {
        return mem;
    }

    public double getMemTotal() {
        return memTotal;
    }

    @Override
    public String toString() {
        return "Mem{" + "mem=" + mem + ", memTotal=" + memTotal + '}';
    }
}