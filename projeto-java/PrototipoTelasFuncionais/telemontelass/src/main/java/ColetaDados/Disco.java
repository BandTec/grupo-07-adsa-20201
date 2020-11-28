/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ColetaDados;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import oshi.SystemInfo;
import oshi.hardware.HWDiskStore;
import oshi.hardware.HWPartition;

/**
 *
 * @author Markz
 */
public class Disco extends Componente{

    private List<HWDiskStore> listDisco = new SystemInfo().getHardware().getDiskStores();
    
    public Disco(String tipo) {
        super(tipo);
        this.desc = listDisco.toString();
        this.listDisco = listDisco.stream().filter(disk -> disk.getSize() > 0).collect(Collectors.toList());
    }
    
    public String diskName(Integer pos){
        String name = listDisco.get(pos).getModel();
        return name.substring(0 ,name.indexOf(" ("));
    }
    
    public List<String> pontoMontagem(Integer pos){
        HWDiskStore disco = listDisco.get(pos);
        List<String> pontoMontagem = new ArrayList();
        
        for(HWPartition particao : disco.getPartitions()){
            if(!particao.getMountPoint().equals("")){
                pontoMontagem.add(particao.getMountPoint());
            }
        }
        return pontoMontagem;
    }
    
    public double tamanhoDisco(Integer pos){
        return listDisco.get(pos).getSize() / 1000000000;
    }
    
    public double espacoLivre(Integer pos){
        Long livre = 0l;
        
        for (String ponto : pontoMontagem(pos)){
            File file = new File(ponto);
            livre += file.getFreeSpace();
        }
        return livre;
    }
    
    public double DiskUsage(Integer pos){
        double tamanho = tamanhoDisco(pos);
        double livre = espacoLivre(pos);
        
        double usage = (((tamanho - livre) * 100) / tamanho);
        
        return usage;
    }
    
    public int quantidadeDisco(){
        return listDisco.size();
    }

    public List<HWDiskStore> getListDisco() {
        return listDisco;
    }

    public String getTipo() {
        return tipo;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return "Disco{" + "listDisco=" + listDisco + '}';
    }

}
