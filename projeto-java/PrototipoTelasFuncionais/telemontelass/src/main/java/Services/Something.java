package Services;

import java.util.ArrayList;
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
import oshi.util.FormatUtil;

public class Something {

    private SystemInfo si = new SystemInfo();
    static List<String> procList = new ArrayList<>();

    //=>Sistema Operacional<=//
    private OperatingSystem os = si.getOperatingSystem();
    private List<OSSession> Users = os.getSessions();

    //=>hardware<=//
    private HardwareAbstractionLayer haw = si.getHardware();
    private CentralProcessor cpu = haw.getProcessor();
    private GlobalMemory mem = haw.getMemory();
    private long[] oldTicks = cpu.getSystemCpuLoadTicks();
        

    //=>Initialize<=//
    public void Telemon() {
        System.out.println("-------------------------------");
        System.out.println("----------> Telemon <----------");
        System.out.println("-------------------------------");
    }

    //=>Gets<=//
    public Double getCpuUsage() {
        Double cpuUsage = 0.0;
        //try {
            //while (true) {

                cpuUsage = (cpu.getSystemCpuLoadBetweenTicks(oldTicks) * 100);
                oldTicks = cpu.getSystemCpuLoadTicks();
                System.out.printf("CPU Usage: %.1f%% \n", cpuUsage);
                //Thread.sleep(1000);
            //}
        //} catch (InterruptedException ex) {
            //System.out.printf("The CPU Capture is over. ERROR: %s", ex);
        //}
        return cpuUsage;
    }

    public Double getMemAvailable() {
        //try {
            //while (true) {
                Double memUsage = Double.valueOf(100 - (mem.getAvailable() * 100) / (mem.getTotal()));
                //System.out.printf("%s \n Memory Usage: %.1f%% \n", getMem(), Double.valueOf(memUsage));
               // Thread.sleep(1000);
            //}
        //} catch (InterruptedException ex) {
            //System.out.printf("The Memory Capture is over. ERROR: %s", ex);
        //
        return Double.valueOf(memUsage);
    }

    public void getOsUpTime() {
        try {
            while (true) {
                long osUptime = os.getSystemUptime();
                System.out.println(osUptime);
                Thread.sleep(1000);
            }
        } catch (InterruptedException ex) {
            System.out.printf("The On-Time Capture is over. ERROR: %s", ex);
        }
    }

    public void getOsProcesses() {
        try {
            List<OSProcess> osProcesses = os.getProcesses(10, OperatingSystem.ProcessSort.CPU);
            int j = 0;
                
                procList.clear();
                
                for (int i = 0; i < osProcesses.size() && i < 10; i++) {

                    OSProcess p = osProcesses.get(i);

                    procList.add(String.format("PID %5d CPU %5.1f MEM %4.1f VSZ %9s RSS %9s NAME %s \n", p.getProcessID(),
                            100d * (p.getKernelTime() + p.getUserTime()) / p.getUpTime(),
                            100d * p.getResidentSetSize() / mem.getTotal(), FormatUtil.formatBytes(p.getVirtualSize()),
                            FormatUtil.formatBytes(p.getResidentSetSize()), p.getName()));

                }
                System.out.println("Acquiring processes...");
                Thread.sleep(5000);
                System.out.println(procList);
            

        } catch (InterruptedException ex) {
            System.out.printf("The Processes Capture is over. ERROR: %s", ex);
        }
    }
    
//    public void getOsServices() {
//        try {
//            while (true) {
//                OSService[] osServices = os.getServices();
//                System.out.println(osServices);
//                Thread.sleep(1000);
//            }
//        } catch (InterruptedException ex) {
//            System.out.printf("The Services Capture is over. ERROR: %s", ex);
//        }
//    }

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
