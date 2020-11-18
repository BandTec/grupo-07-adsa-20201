
package Entities;
import java.awt.List;
import java.util.ArrayList;


public class MaquinaDeprecado {
    
    private Integer codigo = 0;
    private String nome = "";
    private ArrayList<Processos> processos = new ArrayList();
    private ArrayList<String> programas = new ArrayList<>();
    
    public ArrayList<String> getProgramas() {
        return programas;
    }

    public void setProgramas(ArrayList<String> programas) {
        this.programas = programas;
    }

    
    
    public MaquinaDeprecado(){
        
    }
    public ArrayList<Processos> getProcessos() {
        return processos;
    }

    public void setProcessos(ArrayList<Processos> processos) {
        this.processos = processos;
    }
    

    public MaquinaDeprecado(Integer codigo, String nome, ArrayList<String> programas) {
        this.nome = nome;
        this.codigo = codigo;
        this.programas = programas;

        
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
