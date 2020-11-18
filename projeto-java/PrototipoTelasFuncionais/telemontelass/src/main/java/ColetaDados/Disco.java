/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ColetaDados;

import java.util.List;
import oshi.hardware.HWDiskStore;

/**
 *
 * @author Markz
 */
public class Disco {
    
    private Componente comp = new Componente("disco");
    private List<HWDiskStore> disco = comp.getHaw().getDiskStores();

    public Disco() {
        comp.setDesc(disco.toString());
    } 
    
    public Componente getComp() {
        return comp;
    }

    public List<HWDiskStore> getDisco() {
        return disco;
    }

    @Override
    public String toString() {
        return "Disco{" + "comp=" + comp + ", disco=" + disco + '}';
    }
}
