/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ColetaDados;

import java.util.ArrayList;
import java.util.List;
import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.GlobalMemory;
import oshi.hardware.HWDiskStore;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.software.os.OSProcess;
import oshi.software.os.OSSession;
import oshi.software.os.OperatingSystem;
import oshi.util.FormatUtil;

/**
 *
 * @author Markz
 */
public class ColetaDados {
    private SystemInfo si = new SystemInfo();
    private OperatingSystem os = si.getOperatingSystem();
    private HardwareAbstractionLayer haw = si.getHardware();
    private CentralProcessor cpu = haw.getProcessor();
    private long[] oldTicks = cpu.getSystemCpuLoadTicks();
    private double cpuUsage;
    private GlobalMemory mem = haw.getMemory();
    private double memUsage;
    private List<HWDiskStore> disco = haw.getDiskStores();
    private long osUpTime;
    private List<OSSession> usersList = os.getSessions();
    private List<String> procList = new ArrayList();
    private List<OSProcess> osProcesses = new ArrayList();

    public long getOsUpTime(){
        try {
            osUpTime = os.getSystemUptime();
        } catch (Exception e) {
        }
        return osUpTime;
    }
    
    public double getCpuUsage(){
        
        try {
            cpuUsage = (cpu.getSystemCpuLoadBetweenTicks(oldTicks) * 100);
            
        } catch (Exception e) {
            System.out.println(e);
        }
        return cpuUsage;
    }
    
    public double getMemUsage(){
        
        try {
            memUsage = (100 - (mem.getAvailable() * 100) / (mem.getTotal()));
        } catch (Exception e) {
        }
        return memUsage;
    }
    
    public String getOsProcesses() {
        try {
            osProcesses = os.getProcesses(10, OperatingSystem.ProcessSort.CPU);

            for (int i = 0; i < osProcesses.size() && i < 10; i++) {

                OSProcess p = osProcesses.get(i);

                procList.add(String.format("PID %5d CPU %5.1f %% MEM %4.1f %% VSZ %9s RSS %9s NAME %s \n", 
                        p.getProcessID(),
                        100d * (p.getKernelTime() + p.getUserTime()) / p.getUpTime(),
                        100d * p.getResidentSetSize() / mem.getTotal(), 
                        FormatUtil.formatBytes(p.getVirtualSize()),
                        FormatUtil.formatBytes(p.getResidentSetSize()),
                        p.getName()));
            }
        } catch (Exception e) {
        }
        return osProcesses.toString();
    }

    @Override
    public String toString() {
        return "ColetaDados{" + "Sistema Operacional:" + os + ",\n "
                + "CPU :" + cpu + ",\n "
                + "CPU %:" + cpuUsage + ",\n "
                + "MEM :" + mem + ",\n "
                + "MEM %:" + memUsage + ",\n "
                + "DISK :" + disco + ",\n "
                + "USERS :" + usersList + ",\n "
                + "PROCESSES :" + procList + ",\n "
                + "PROCESSES :" + osProcesses + '}';
    }
    
    
}
