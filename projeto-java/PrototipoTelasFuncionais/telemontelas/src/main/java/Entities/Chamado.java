package Entities;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Larissa
 */
public class Chamado {
    
    private String descricao = "";
    private Integer codigo = 0;
    private Maquina maquina;
    private String vistoPorUltimo = "";
    
    
    public Chamado(){
        
    }
    
    public Chamado(Integer codigo, String descricao, Maquina maquina, String vistoPorUltimo) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.maquina = maquina;
        this.vistoPorUltimo = vistoPorUltimo;
    }

    public String getVistoPorUltimo() {
        return vistoPorUltimo;
    }

    public void setVistoPorUltimo(String vistoPorUltimo) {
        this.vistoPorUltimo = vistoPorUltimo;
    }
    


    public Maquina getMaquina() {
        return maquina;
    }

    public void setMaquina(Maquina maquina) {
        this.maquina = maquina;
    }
    

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }
    
   
    
}
