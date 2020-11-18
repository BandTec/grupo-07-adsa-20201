/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ColetaDados;

import java.util.ArrayList;
import java.util.List;
import oshi.software.os.OSProcess;
import oshi.software.os.OSSession;
import oshi.software.os.OperatingSystem;

/**
 *
 * @author Markz
 */
public class Maquina {

    private Sistema sistema = new Sistema();
    private SistemaOperacional os = new SistemaOperacional();
    private Cpu cpu = new Cpu();
    private Mem mem = new Mem();
    private Disco disco = new Disco();
    private Sessao sessao = new Sessao();
    private Processos processos = new Processos();

    private List<OSSession> sessionList;
    private double cpuUsage;
    private double memTotal = mem.getMemTotal();
    private double memUsage;
    private List<String> procs;
    private long timeUp;

    private String osMaquina;
    private String hostname;
    private String registo;
    private List<String> componentes = new ArrayList();

    public Maquina() {
        this.sessionList = sessao.getUsersList();
        this.cpuUsage = cpu.getCpuUsage();
        this.memUsage = mem.getMemUsage();
        this.procs = processos.getOsProcesses();
        this.timeUp = os.getOsUpTime();
        this.osMaquina = os.getOs().toString();
        this.registo = "";
        componentes.add(cpu.getComp().toString());
        componentes.add(mem.getComp().toString());
        componentes.add(disco.getComp().toString());
//        componentes.add(String.format("CPU: %s \n"
//                + "RAM: %.1f Gb\n"
//                + "Discos: %s \n",
//                cpu.getCpu().toString(),
//                memTotal,
//                disco.getDisco().toString()));
        cpu.gerarLista();
        cpu.verificarLista();
        mem.gerarLista();
        mem.verificarLista();
    }

    public Sistema getSistema() {
        return sistema;
    }

    public OperatingSystem getOs() {
        return os.getOs();
    }

    public Cpu getCpu() {
        return cpu;
    }

    public Mem getMem() {
        return mem;
    }

    public Disco getDisco() {
        return disco;
    }

    public List<OSSession> getSessionList() {
        return sessionList;
    }

    public Processos getProcessos() {
        return processos;
    }

    public double getCpuUsage() {
        return cpuUsage;
    }

    public double getMemTotal() {
        return memTotal;
    }

    public double getMemUsage() {
        return memUsage;
    }

    public List<String> getProcs() {
        return procs;
    }

    public long getTimeUp() {
        return timeUp;
    }

    public List<String> getComponentes() {
        return componentes;
    }

//    @Override
//    public String toString() {
//        return "Maquina{" + "Sistema:" + sistema + ",\n "
//                + "Sistema Operacional:" + os + ",\n "
//                + "Modelo CPU:" + cpu + ",\n "
//                + "Total MEM" + memTotal + ",\n "
//                + "Discos:" + disco + ",\n "
//                + "Usuários:" + usersList + ",\n "
//                + "Uso da CPU:" + cpuUsage + ",\n "
//                + "Uso da MEM:" + memUsage + ",\n "
//                + "Processos:" + processos + ",\n "
//                + "Tempo ligada:" + timeUp + '}';
//    }

        @Override
    public String toString() {
        return "Maquina{"
//                + "Hostname:" + hostname + ",\n "
                + "Sistema Operacional:" + osMaquina + ",\n "
                + "Sessão:" + sessionList + ",\n "
                + "Processos:" + procs + ",\n "
                + "Tempo ligada:" + timeUp + ",\n "
                + "Componentes:" + componentes + '}';
    } 
}
