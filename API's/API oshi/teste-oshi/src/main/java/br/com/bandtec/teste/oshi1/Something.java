package br.com.bandtec.teste.oshi1;

import java.util.List;
import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.ComputerSystem;
import oshi.hardware.GlobalMemory;
import oshi.hardware.HWDiskStore;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.hardware.PhysicalMemory;
import oshi.software.os.OSProcess;
import oshi.software.os.OSService;
import oshi.software.os.OSSession;
import oshi.software.os.OperatingSystem;

public class Something {

    private SystemInfo si = new SystemInfo();
    
    //=>Sistema Operacional<=//
    private OperatingSystem os = si.getOperatingSystem();
    private List<OSSession> Users = os.getSessions();
    
    
    //=>hardware<=//
    private HardwareAbstractionLayer haw = si.getHardware();
    private CentralProcessor cpu = haw.getProcessor();
    private GlobalMemory mem = haw.getMemory();
    private long[] cpuUsage = cpu.getSystemCpuLoadTicks();
    
    //=>Initialize<=//
    public void Telemon(){
        System.out.println("-------------------------------");
        System.out.println("----------> Telemon <----------");
        System.out.println("-------------------------------");
    }
    
    //=>Gets<=//
    public void getCpuUsage() { 
        try {
            while (true) {
                Double cpuUsage = (cpu.getSystemCpuLoadBetweenTicks(this.cpuUsage)) * 100;
                System.out.printf("CPU usage: %.2f %s \n", cpuUsage, "%");
                Thread.sleep(1000);
            }
        } catch (InterruptedException ex) {
            System.out.println("A Captura de CPU acabou.");
        }
    }

    public void getMemAvailable() {
        try {
            while (true) {
                long memAvailable = ((mem.getAvailable()) / 1024) / 1024;
                System.out.printf("Memory Available: %.2f Gb \n", Double.valueOf(memAvailable));
                Thread.sleep(1000);
            }
        } catch (InterruptedException ex) {
            System.out.printf("A Captura de RAM acabou. %s", ex);
        }
    }
    
    public void getOsServices() {
        try {
            while (true) {
                OSService[] osServices = os.getServices();
                System.out.println(osServices);
                Thread.sleep(1000);
            }
        } catch (InterruptedException ex) {
            System.out.println("A Captura de serviços acabou.");
        }
    }
    
    public void getOsUpTime() {
        try {
            while (true) {
                long osUptime = os.getSystemUptime();
                System.out.println(osUptime);
                Thread.sleep(1000);
            }
        } catch (InterruptedException ex) {
            System.out.println("A Captura de tempo ligado acabou.");
        }
    }
    
    public void getOsProcesses() {
        try {
            while (true) {
                List<OSProcess> osProcesses = os.getProcesses();
                System.out.println(osProcesses);
                Thread.sleep(1000);
            }
        } catch (InterruptedException ex) {
            System.out.println("A Captura de tempo ligado acabou.");
        }
    }
    
    //=>Getters<=//
    public CentralProcessor getCpu() {
        return cpu;
    }

    public GlobalMemory getMem() {
        return mem;
    }

    public OperatingSystem getOs() {
        return os;
    }

    public List<OSSession> getUsers() {
        return Users;
    }

}
