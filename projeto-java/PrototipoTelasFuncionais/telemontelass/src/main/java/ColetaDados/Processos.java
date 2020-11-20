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
    private Mem memoria = new Mem("ram");
    List<OSProcess> osProcesses = new ArrayList();
    private List<String> procList = new ArrayList();
    
    private String nomeProcesso;
    private double cpuProcesso;
    private double memProcesso;
    private String registro;

    public List<OSProcess> getOsProcesses() {
        try {
            osProcesses = os.getOs().getProcesses(11, OperatingSystem.ProcessSort.CPU);
        } catch (Exception e) {
        }
        return osProcesses;
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
