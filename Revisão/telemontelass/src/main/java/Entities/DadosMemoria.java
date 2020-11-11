package Entities;

import oshi.SystemInfo;
import oshi.hardware.GlobalMemory;
import oshi.hardware.HardwareAbstractionLayer;

public class DadosMemoria {
    
    private SystemInfo si = new SystemInfo();
    private HardwareAbstractionLayer haw = si.getHardware();
    private GlobalMemory mem = haw.getMemory();
    
    
    public double getMemAvailable(){
        double memUsage = Double.valueOf(100 - (mem.getAvailable() * 100) / (mem.getTotal()));
        return memUsage;
    }
    
    public GlobalMemory getMem(){
        return mem;
    }
    
}
