
package Entities;
import java.awt.List;
import java.util.ArrayList;


public class Maquina {
    
    private Integer codigo = 0;
    private String nome = "";
    
    private ArrayList<Processos> processos = new ArrayList();
    
    public Maquina(){
        
    }
    public ArrayList<Processos> getProcessos() {
        return processos;
    }

    public void setProcessos(ArrayList<Processos> processos) {
        this.processos = processos;
    }
    

    public Maquina(Integer codigo, String nome) {
        this.nome = nome;
        this.codigo = codigo;

        
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    
    
    
    
}
