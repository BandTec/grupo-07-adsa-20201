/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ColetaDados;

import oshi.hardware.GlobalMemory;

/**
 *
 * @author Markz
 */
public class Mem {
   
    private Componente comp = new Componente();
    private GlobalMemory mem = comp.getHaw().getMemory();
    private double memUsage;
    
    public double getMemUsage(){
        
        try {
            memUsage = (100 - (mem.getAvailable() * 100) / (mem.getTotal()));
        } catch (Exception e) {
        }
        return memUsage;
    }

    public Componente getComp() {
        return comp;
    }

    public GlobalMemory getMem() {
        return mem;
    }
    
    
}
