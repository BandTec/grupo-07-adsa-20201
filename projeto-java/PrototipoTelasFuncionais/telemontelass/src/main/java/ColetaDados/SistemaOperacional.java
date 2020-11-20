/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ColetaDados;

import oshi.SystemInfo;
import oshi.software.os.OperatingSystem;

/**
 *
 * @author Markz
 */
public class SistemaOperacional {
    
    private OperatingSystem os = new SystemInfo().getOperatingSystem();
    private long osUpTime;

    public long getOsUpTime() {
        try {
            osUpTime = os.getSystemUptime();
        } catch (Exception e) {
        }
        return osUpTime;
    }

    public OperatingSystem getOs() {
        return os;
    }

    @Override
    public String toString() {
        return "SistemaOperacional{" + ", os=" + os + ", osUpTime=" + osUpTime + '}';
    }
}
