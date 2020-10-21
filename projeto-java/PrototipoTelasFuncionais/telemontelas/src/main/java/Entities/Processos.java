
package Entities;
import java.util.Date;


public class Processos {
    
    private Integer codigo = 0;
    private Integer cpu = 0;
    private Integer memoria = 0;
    private Integer disco = 0;
    private Date instante;
    
    public Processos(Integer cpu, Integer memoria, Integer disco, Date instante){
        this.cpu = cpu;
        this.memoria = memoria;
        this.disco = disco;
        this.instante = instante;
    }

    public Integer getCpu() {
        return cpu;
    }

    public void setCpu(Integer cpu) {
        this.cpu = cpu;
    }

    public Integer getMemoria() {
        return memoria;
    }

    public void setMemoria(Integer memoria) {
        this.memoria = memoria;
    }

    public Integer getDisco() {
        return disco;
    }

    public void setDisco(Integer disco) {
        this.disco = disco;
    }
    
    
    
    
    
}
