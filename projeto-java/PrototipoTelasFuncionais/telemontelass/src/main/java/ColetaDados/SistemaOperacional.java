/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ColetaDados;

import oshi.software.os.OperatingSystem;

/**
 *
 * @author Markz
 */
public class SistemaOperacional {

    private Sistema sistema = new Sistema();
    private OperatingSystem os = sistema.getSi().getOperatingSystem();
    private long osUpTime;

    public long getOsUpTime() {
        try {
            osUpTime = os.getSystemUptime();
        } catch (Exception e) {
        }
        return osUpTime;
    }

    public Sistema getSistema() {
        return sistema;
    }

    public OperatingSystem getOs() {
        return os;
    }

    @Override
    public String toString() {
        return "SistemaOperacional{" + "sistema=" + sistema + ", os=" + os + ", osUpTime=" + osUpTime + '}';
    }
}
