
package Entities;
import java.util.Date;


public class Processos {
    
    private Integer codigo = 0;
    private Double cpu = 0.0;
    private Double memoria = 0.0;
    private Double disco = 0.0;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Date getInstante() {
        return instante;
    }

    public void setInstante(Date instante) {
        this.instante = instante;
    }
    private Date instante;
    
    public Processos(Double cpu, Double memoria, Double disco, Date instante){
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

    public Double getMemoria() {
        return memoria;
    }

    public void setMemoria(Double memoria) {
        this.memoria = memoria;
    }

    public Double getDisco() {
        return disco;
    }

    public void setDisco(Double disco) {
        this.disco = disco;
    }
    
    
    
    
    
}
