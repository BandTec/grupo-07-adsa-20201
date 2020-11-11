
package Entities;

import java.util.ArrayList;
import java.util.List;
import oshi.SystemInfo;
import oshi.software.os.OSProcess;
import oshi.software.os.OperatingSystem;

public class DadosProcessos {
    
    private SystemInfo si = new SystemInfo();
    
    static List<String> procList = new ArrayList<>();
    
    private OperatingSystem os = si.getOperatingSystem();
    
    public List<String> getOsProcesses(){
        try {
            List<OSProcess> osProcesses = os.getProcesses(10, OperatingSystem.ProcessSort.CPU);
            
            procList.clear();
            
            for(int i = 0; i < osProcesses.size() && i < 10; i++){
                
                OSProcess p = osProcesses.get(i);
                
                procList.add(p.getName());
                    
            }
            System.out.println("Acquiring processes...");
            Thread.sleep(0);
        } catch (InterruptedException ex){
            System.out.printf("The Processes Capture is over. ERROR: %s", ex);
        }
        return procList;
    }
    
    public OperatingSystem getOs() {
        return os;
    }
}
