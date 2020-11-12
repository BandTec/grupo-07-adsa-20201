/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ColetaDados;

import java.util.ArrayList;
import java.util.List;
import oshi.software.os.OSSession;

/**
 *
 * @author Markz
 */
public class Maquina {

    private Sistema sistema = new Sistema();
    private SistemaOperacional os = new SistemaOperacional();
    private Componente comp = new Componente();
    private Cpu cpu = new Cpu();
    private Mem mem = new Mem();
    private Disco disco = new Disco();
    private Users users = new Users();
    private Processos processos = new Processos();

    private List<OSSession> usersList;
    private double cpuUsage;
    private double memTotal = mem.getMemTotal();
    private double memUsage;
    private List<String> procs;
    private long timeUp;

    public void Init() {
        usersList = users.getUsersList();
        cpuUsage = cpu.getCpuUsage();
        memUsage = mem.getMemUsage();
        procs = processos.getOsProcesses();
        timeUp = os.getOsUpTime();
    }

    @Override
    public String toString() {
        return "Maquina{" + "Sistema:" + sistema + ",\n "
                + "Sistema Operacional:" + os + ",\n "
                + "Componentes:" + comp + ",\n "
                + "Modelo CPU:" + cpu + ",\n "
                + "Total MEM" + memTotal + ",\n "
                + "Discos:" + disco + ",\n "
                + "Usuários:" + usersList + ",\n "
                + "Uso da CPU:" + cpuUsage + ",\n "
                + "Uso da MEM:" + memUsage + ",\n "
                + "Processos:" + procs + ",\n "
                + "Tempo ligada:" + timeUp + '}';
    }
}
