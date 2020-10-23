
package Entities;
import java.util.Date;


public class Processos {
    
    private Integer codigo = 0;
    private Double cpu = 0.0;
    private Integer memoria = 0;
    private Integer disco = 0;
    private Date instante;
    
    public Processos(Double cpu, Integer memoria, Integer disco, Date instante){
        this.cpu = cpu;
        this.memoria = memoria;
        this.disco = disco;
        this.instante = instante;
    }

    public Double getCpu() {
        return cpu;
    }

    public void setCpu(Double cpu) {
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
