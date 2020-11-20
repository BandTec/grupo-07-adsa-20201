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
public class Disco extends Componente{

    private List<HWDiskStore> disco = this.getHaw().getDiskStores();
    
    public Disco(String tipo) {
        super(tipo);
        this.desc = disco.toString();
    }

    public List<HWDiskStore> getDisco() {
        return disco;
    }

    @Override
    public String toString() {
        return "Disco{" + "disco=" + disco + '}';
    }

}
