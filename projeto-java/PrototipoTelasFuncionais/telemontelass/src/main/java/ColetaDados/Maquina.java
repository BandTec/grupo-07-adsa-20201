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
    private Users users = new Users();
    private Processos processos = new Processos();

    private List<OSSession> usersList;
    private double cpuUsage;
    private double memTotal = mem.getMemTotal();
    private double memUsage;
    private List<String> procs;
    private long timeUp;

    private String osMaquina;
    private String userMaquina;
    private String hostname;
    private String registo;
    private List<String> componentes = new ArrayList();

    public void Init() {
        componentes.add(String.format("CPU: %s \n"
                + "RAM: %.1f Gb\n"
                + "Discos: %s \n",
                cpu.getCpu().toString(),
                memTotal,
                disco.getDisco().toString()));
        usersList = users.getUsersList();
        cpuUsage = cpu.getCpuUsage();
        cpu.gerarLista();
        cpu.verificarLista();
        memUsage = mem.getMemUsage();
        mem.gerarLista();
        mem.verificarLista();
        procs = processos.getOsProcesses();                                                                                                                                                                             
        timeUp = os.getOsUpTime();
    }
    
    public void verificarMaq(double uso) {
        List<Double> alertList = new ArrayList();
        if(uso > 90.00) {
            alertList.add(uso);
        if(alertList.size() > 10) {
            String.format("Alerta! Máquina %s está com o uso de %s elevado", hostname, cpu);
        }    
        }
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

    public Users getUsers() {
        return users;
    }

    public Processos getProcessos() {
        return processos;
    }

    public List<OSSession> getUsersList() {
        return usersList;
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

    @Override
    public String toString() {
        return "Maquina{" + "Sistema:" + sistema + ",\n "
                + "Sistema Operacional:" + os + ",\n "
                + "Modelo CPU:" + cpu + ",\n "
                + "Total MEM" + memTotal + ",\n "
                + "Discos:" + disco + ",\n "
                + "Usuários:" + usersList + ",\n "
                + "Uso da CPU:" + cpuUsage + ",\n "
                + "Uso da MEM:" + memUsage + ",\n "
                + "Processos:" + processos + ",\n "
                + "Tempo ligada:" + timeUp + '}';
    }
}