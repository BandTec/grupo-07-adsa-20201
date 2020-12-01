/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Banco;

import log.Log;
import org.apache.commons.dbcp2.BasicDataSource;

/**
 *
 * @author markz
 */
public class Connection {

    private BasicDataSource datasource;

    public Connection() {
        try {
            this.datasource = new BasicDataSource();
            this.datasource.setDriverClassName("com.mysql.cj.jdbc.Driver");
            this.datasource.setUrl("jdbc:mysql://54.157.41.111:3306/bdTelemon");
            this.datasource.setUsername("root");
            this.datasource.setPassword("urubu100");
        } catch (Exception e) {
            Log log = new Log("Fail_to_connect", e.toString(), "Erro");
            log.logCriation();
        }

//        this.datasource = new BasicDataSource();
//        this.datasource.setDriverClassName("org.h2.Driver");
//        this.datasource.setUrl("jdbc:h2:file:./bdTelemon");
//        this.datasource.setUsername("sa");
//        this.datasource.setPassword("");
    }

    public BasicDataSource getDatasource() {
        return datasource;
    }

}
