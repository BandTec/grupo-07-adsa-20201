/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ColetaDados;

import java.util.ArrayList;
import java.util.List;
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
    private List<String> procList = new ArrayList();

    public List<String> getOsProcesses() {
        try {
            List<OSProcess> osProcesses = os.getOs().getProcesses(10, OperatingSystem.ProcessSort.CPU);

            for (int i = 0; i < osProcesses.size() && i < 10; i++) {

                OSProcess p = osProcesses.get(i);

                procList.add(String.format("%5d %s %5.1f %% %4.1f %% \n",
                        p.getProcessID(),
                        p.getName(),
                        p.getProcessCpuLoadBetweenTicks(p),
                        100d * p.getResidentSetSize() / memoria.getMem().getTotal()));
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
