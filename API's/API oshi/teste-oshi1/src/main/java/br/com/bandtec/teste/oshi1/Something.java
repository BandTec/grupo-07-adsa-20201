
package br.com.bandtec.teste.oshi1;


import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.hardware.GlobalMemory;

public class Something {
    
    public static void main(String[] args) {
            SystemInfo si = new SystemInfo();
            HardwareAbstractionLayer hal = si.getHardware();
            CentralProcessor cpu = hal.getProcessor();
            GlobalMemory gm = h.getMemory();
            
            System.out.println(si);
            System.out.println(hal);
            System.out.println(cpu);
            System.out.println(gm);
            
    }    
}
