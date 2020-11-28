/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Banco;

import ColetaDados.Maquina;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author markz
 */
public class Insertbd {

    Registro reg = new Registro();
    Connection con = new Connection();
    JdbcTemplate template = new JdbcTemplate(con.getDatasource());
    Integer contador = 0;

    public void InserirDadosComponente(double valor, String componente, String hostname) {
        
        List consultaFkMaquina = template.queryForList("SELECT codMaquina FROM tbMaquina WHERE userMaquina = ?", hostname);
        List consultaFkComponente = template.queryForList("SELECT codComponente FROM tbComponente WHERE descComponente = ?", componente);
        List consultaFk = template.queryForList("SELECT codComponenteMaquina FROM tbComponenteMaquina WHERE fkComponente = ? AND fkMaquina = ?;", 
                consultaFkComponente, consultaFkMaquina);
        
        System.out.println("FkMáquina: " + consultaFkMaquina);
        System.out.println("FkComponente: " + consultaFkComponente);
        System.out.println("FkComponenteMáquina: " + consultaFk);

        template.update("INSERT INTO tbDadosComponente VALUES (?,?,?,?)", null, valor, reg.dataFormatada + reg.horaFormatada, 1);

        List consulta = template.queryForList("SELECT * FROM tbDadosComponente");
    }

    public void InserirProcessos(String name, double usoCpu, double usoMem, String hostname) {
        
        List consultaFk = template.queryForList("SELECT codMaquina FROM tbMaquina WHERE userMaquina = ?", hostname);
        System.out.println("FkMáquina: " + consultaFk);

        if (contador++ < 100) {
            template.update("INSERT INTO tbProcessos VALUES (?,?,?,?,?,?)", null, name, usoCpu, usoMem, reg.dataFormatada + reg.horaFormatada, 1);

            List consulta = template.queryForList("SELECT * FROM tbProcessos");
        }else{
            contador = 0;
            template.update("TRUNCATE TABLE tbProcessos;");
            template.update("INSERT INTO tbProcessos VALUES (?,?,?,?,?,?)", null, name, usoCpu, usoMem, reg.dataFormatada + reg.horaFormatada, 1);
        }
    }

    public void InserirComponente(String tipo, String desc) {

        template.update("INSERT INTO tbComponente VALUES (?,?,?)", null, tipo, desc);

        List consulta = template.queryForList("SELECT * FROM tbComponente");
    }
}
