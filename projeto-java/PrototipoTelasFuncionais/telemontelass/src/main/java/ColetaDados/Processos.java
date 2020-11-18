/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ColetaDados;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import oshi.software.os.OSProcess;
import oshi.software.os.OperatingSystem;
import oshi.util.FormatUtil;

/**
 *
 * @author Markz
 */
public class Processos {

    private SistemaOperacional os = new SistemaOperacional();
    private Mem memoria = new Mem();
    List<OSProcess> osProcesses = new ArrayList();
    private List<String> procList = new ArrayList();
    
    private String nomeProcesso;
    private double cpuProcesso;
    private double memProcesso;
    private String registro;

    public List<String> getOsProcesses() {
        try {
            osProcesses = os.getOs().getProcesses(11, OperatingSystem.ProcessSort.CPU);

            for (int i = 0; i < osProcesses.size() && i < 11; i++) {

                OSProcess p = osProcesses.get(i);

                procList.add(String.format("%5d %s %5.1f %% %4.1f %% \n",
                        p.getProcessID(),
                        p.getName(),
                        p.getProcessCpuLoadBetweenTicks(p),
                        100d * p.getResidentSetSize() / memoria.getMem().getTotal()));
                
//                Map<Integer, String> procMap = new HashMap();
//                procMap.put(1, (String.format("%5d", p.getProcessID())));
//                procMap.put(2, (String.format("%s", p.getName())));
//                procMap.put(3, (String.format("%5.1f", p.getProcessCpuLoadBetweenTicks(p))));
//                procMap.put(4, (String.format("%4.1f", 100d * p.getResidentSetSize() / memoria.getMem().getTotal())));
                
//                System.out.println(procMap);
                
            }
        } catch (Exception e) {
        }
        return procList;
    }

    public SistemaOperacional getOs() {
        return os;
    }

    public Mem getMemoria() {
        return memoria;
    }

    public List<String> getProcList() {
        return procList;
    }

    @Override
    public String toString() {
        return "Processos{" + "os=" + os + ", procList=" + procList + '}';
    }
}
