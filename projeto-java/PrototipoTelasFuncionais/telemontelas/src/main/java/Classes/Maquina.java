/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.awt.List;
import java.util.ArrayList;

/**
 *
 * @author Larissa
 */
public class Maquina {

    public Maquina(Integer codigo, String nome) {
        this.nome = nome;
        this.codigo = codigo;
        this.processos = processos;
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

    public ArrayList getProcessos() {
        return processos;
    }

    public void setProcessos(ArrayList processos) {
        this.processos = processos;
    }
    
    private Integer codigo = 0;
    private String nome = "";
    private ArrayList processos;
    
    
}
