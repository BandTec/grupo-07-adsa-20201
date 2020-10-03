package br.com.bandtec.teste.oshi1;

import java.util.List;
import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.ComputerSystem;
import oshi.hardware.GlobalMemory;
import oshi.hardware.HWDiskStore;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.hardware.PhysicalMemory;
import oshi.software.os.OperatingSystem;

public class Something {

    private SystemInfo si = new SystemInfo();
    private HardwareAbstractionLayer haw = si.getHardware();
    private CentralProcessor cpu = haw.getProcessor();
    private GlobalMemory mem = haw.getMemory();
    private long[] x = cpu.getSystemCpuLoadTicks();

    public void getCpuUsage() { 
        try {
            while (true) {
                Double cpuUsage = cpu.getSystemCpuLoadBetweenTicks(x);
                System.out.println(cpuUsage);
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
            System.out.println("A Captura de RAM acabou.");
        }
    }

    public CentralProcessor getCpu() {
        return cpu;
    }

    public GlobalMemory getMem() {
        return mem;
    }

}
