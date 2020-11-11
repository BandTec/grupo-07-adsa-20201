package Entities;

import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.HardwareAbstractionLayer;

public class DadosCpu {

    private SystemInfo si = new SystemInfo();
    
    private HardwareAbstractionLayer haw = si.getHardware();
    
    private CentralProcessor cpu = haw.getProcessor();
    
    private long[] oldTicks = cpu.getSystemCpuLoadTicks();

    public double getCpuUsage(){
        double cpuUsage = (cpu.getSystemCpuLoadBetweenTicks(oldTicks) * 100);
        oldTicks = cpu.getSystemCpuLoadTicks();
        return cpuUsage;
    }

    
    
}
