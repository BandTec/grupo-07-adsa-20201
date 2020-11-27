/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Banco;

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

    public void InserirDadosComponente(double valor) {

        template.update("INSERT INTO tbDadosComponente VALUES (?,?,?,?)", null, valor, reg.dataFormatada + reg.horaFormatada, 1);

        List consulta = template.queryForList("SELECT * FROM tbDadosComponente");

        System.out.println(consulta);
    }

    public void InserirProcessos(String name, double usoCpu, double usoMem) {
//
//        if (contador++ < 100) {
//            template.update("INSERT INTO tbProcessos VALUES (?,?,?,?,?,?)", null, name, usoCpu, usoMem, reg.dataFormatada + reg.horaFormatada, 1);
//
//            List consulta = template.queryForList("SELECT * FROM tbProcessos");
//        }else{
//            contador = 0;
            template.update("TRUNCATE TABLE tbProcessos;");
            template.update("INSERT INTO tbProcessos VALUES (?,?,?,?,?,?)", null, name, usoCpu, usoMem, reg.dataFormatada + reg.horaFormatada, 1);
//        }
    }

    public void InserirComponente(String tipo, String desc) {

        template.update("INSERT INTO tbComponente VALUES (?,?,?)", null, tipo, desc);

        List consulta = template.queryForList("SELECT * FROM tbComponente");
    }
}
