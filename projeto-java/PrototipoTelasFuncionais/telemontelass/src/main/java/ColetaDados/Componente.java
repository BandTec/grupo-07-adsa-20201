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
    private String tipo;
    private String desc;

    public Componente(String tipo) {
        this.tipo = tipo;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
    
    public Sistema getSistema() {
        return sistema;
    }

    public HardwareAbstractionLayer getHaw() {
        return haw;
    }

    public String getTipo() {
        return tipo;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return "Componente{" + "tipo=" + tipo + ",\n desc=" + desc + '}';
    }
    
    


    
}
