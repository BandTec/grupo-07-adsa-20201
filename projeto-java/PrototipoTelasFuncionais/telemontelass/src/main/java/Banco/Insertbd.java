/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Banco;

import ColetaDados.Maquina;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import log.Log;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import log.Log;

/**
 *
 * @author markz
 */
public class Insertbd {

    Registro reg = new Registro();
    Connection con = new Connection();
    JdbcTemplate template = new JdbcTemplate(con.getDatasource());
    Integer contador = 0;
    List programas = new ArrayList();
    Object y;

    public void InserirDadosComponente(double valor, String componente, String hostname) {
        try {

        Object consultaFkMaquina = template.queryForMap("SELECT codMaquina FROM tbMaquina WHERE userMaquina = ?", hostname).get("codMaquina");
        System.out.println(consultaFkMaquina);
        Object consultaFkComponente = template.queryForMap("SELECT codComponente FROM tbComponente WHERE descComponente = ?", componente).get("codComponente");
        System.out.println(consultaFkComponente);
        Object fkComponenteMaquina = template.queryForMap("SELECT codComponenteMaquina FROM tbComponenteMaquina WHERE fkComponente = ? AND fkMaquina = ?",
                consultaFkComponente, consultaFkMaquina).get("codComponenteMaquina");
        System.out.println(fkComponenteMaquina);

        template.update("INSERT INTO tbDadosComponente VALUES (?,?,?,?)", null, valor, reg.dataFormatada + reg.horaFormatada, fkComponenteMaquina);

        List consulta = template.queryForList("SELECT * FROM tbDadosComponente");
        } catch (Exception e) {
            Log log = new Log("Erro_insert_bd", e.toString(), "Erro");
            log.logCriation();
        }
    }

    public void InserirProcessos(String name, double usoCpu, double usoMem, String hostname) {
        try {

            Object consultaFkMaquina = template.queryForMap("SELECT codMaquina FROM tbMaquina WHERE userMaquina = ?", hostname).get("codMaquina");
            Object count = template.queryForMap("SELECT COUNT(codProcesso) AS registros FROM tbProcessos; ").get("registros");
            
            if ((int) count < 100) {
                
                if (!selectProgramas().contains(name)) {
                    
                    template.update("INSERT INTO tbProcessos VALUES (?,?,?,?,?,?,?)", 
                            null, 
                            name, 
                            usoCpu, 
                            usoMem, 
                            reg.dataFormatada + reg.horaFormatada, 
                            consultaFkMaquina,
                            0);
                }else{
                    
                template.update("INSERT INTO tbProcessos VALUES (?,?,?,?,?,?,?)", 
                        null, 
                        name, 
                        usoCpu, 
                        usoMem, 
                        reg.dataFormatada + reg.horaFormatada, 
                        consultaFkMaquina,
                        1);}
                
                List consulta = template.queryForList("SELECT * FROM tbProcessos");
                
            } else {

                template.update("TRUNCATE TABLE tbProcessos;");
                
                if (!selectProgramas().contains(name)) {
                    
                    template.update("INSERT INTO tbProcessos VALUES (?,?,?,?,?,?,?)", 
                            null, 
                            name, 
                            usoCpu, 
                            usoMem, 
                            reg.dataFormatada + reg.horaFormatada, 
                            consultaFkMaquina,
                            0);
                }else{
                    
                template.update("INSERT INTO tbProcessos VALUES (?,?,?,?,?,?,?)", 
                        null, 
                        name, 
                        usoCpu, 
                        usoMem, 
                        reg.dataFormatada + reg.horaFormatada, 
                        consultaFkMaquina,
                        1);}
            }
        } catch (Exception e) {;
            Log log = new Log("Erro_insert_bd", e.toString(), "Erro");
            log.logCriation();
        }
    }

    public void InserirComponente(String tipo, String desc) {
        try {
        template.update("INSERT INTO tbComponente VALUES (?,?,?)", null, tipo, desc);
        List consulta = template.queryForList("SELECT * FROM tbComponente");
        } catch (Exception e) {
            Log log = new Log("Erro_insert_bd", e.toString(), "Erro");
            log.logCriation();
        }
    }
    
        public List selectProgramas() {
        try {
            programas.clear();
            List x = template.queryForList("SELECT nomePrograma FROM tbPrograma;");
            for (int i = 0; i < x.size(); i++) {
                y = template.queryForList("SELECT nomePrograma FROM tbPrograma").get(i).get("nomePrograma");
                programas.add(y);
            }
        } catch (Exception e) {
            Log log = new Log("Erro_select_bd", e.toString(), "Erro");
            log.logCriation();
        }
        return programas;
    }
}
