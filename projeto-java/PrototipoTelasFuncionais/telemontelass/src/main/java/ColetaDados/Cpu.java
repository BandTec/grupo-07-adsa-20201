/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ColetaDados;

import oshi.hardware.CentralProcessor;

/**
 *
 * @author Markz
 */
public class Cpu {

    private Componente comp = new Componente();
    private CentralProcessor cpu = comp.getHaw().getProcessor();
    private long[] oldTicks = cpu.getSystemCpuLoadTicks();
    private double cpuUsage;
    
    public double getCpuUsage(){
        
        try {
            cpuUsage = (cpu.getSystemCpuLoadBetweenTicks(oldTicks) * 100);
            
        } catch (Exception e) {
            System.out.println(e);
        }
        return cpuUsage;
    }

    public Componente getComp() {
        return comp;
    }

    public CentralProcessor getCpu() {
        return cpu;
    }

    public long[] getOldTicks() {
        return oldTicks;
    }

    @Override
    public String toString() {
        return "Cpu{" + "comp=" + comp + ", cpu=" + cpu + ", cpuUsage=" + cpuUsage + '}';
    } 
}
