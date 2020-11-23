/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Banco;

import ColetaDados.Cpu;
import ColetaDados.Maquina;
import ColetaDados.Mem;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import oshi.SystemInfo;

/**
 *
 * @author markz
 */
public class Insertbd {

    public static void main(String[] args) {

        SystemInfo si = new SystemInfo();

        Registro reg = new Registro();

        Maquina maquina = new Maquina();

        Connection con = new Connection();
        JdbcTemplate template = new JdbcTemplate(con.getDatasource());

        template.execute("DROP TABLE IF EXISTS tbDadosComponente");

        String criacao = "CREATE TABLE tbDadosComponente("
                + "codDadosComponente INT PRIMARY KEY AUTO_INCREMENT,"
                + "valorDadosComponente DOUBLE,"
                + "registroDadosComponente VARCHAR(50));";

        template.execute(criacao);

        template.update("INSERT INTO tbDadosComponente VALUES (?,?,?)", null, maquina.getCpuUsage(), reg.dataFormatada + reg.horaFormatada);

        List consulta = template.queryForList("SELECT * FROM tbDadosComponente");

//        template.execute("DROP TABLE tbDadosComponente");
        System.out.println(consulta);

    
}
}