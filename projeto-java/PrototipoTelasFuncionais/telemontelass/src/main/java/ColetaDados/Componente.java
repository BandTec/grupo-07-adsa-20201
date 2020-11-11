/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ColetaDados;

import oshi.SystemInfo;
import oshi.hardware.HardwareAbstractionLayer;

/**
 *
 * @author Markz
 */
public class Componente {
   
    private Sistema sistema = new Sistema();
    private HardwareAbstractionLayer haw = sistema.getSi().getHardware();  

    public HardwareAbstractionLayer getHaw() {
        return haw;
    }

    public Sistema getSistema() {
        return sistema;
    }
    
}
