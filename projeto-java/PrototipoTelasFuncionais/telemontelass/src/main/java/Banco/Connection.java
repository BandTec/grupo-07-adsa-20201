/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Banco;

import org.apache.commons.dbcp2.BasicDataSource;

/**
 *
 * @author markz
 */
public class Connection {
    
    private BasicDataSource datasource;

    public Connection() {
        this.datasource = new BasicDataSource();
        this.datasource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        this.datasource.setUrl("jdbc:mysql://localhost:3306/bdTelemon");
        this.datasource.setUsername("root");
        this.datasource.setPassword("urubu100");
    }

    public BasicDataSource getDatasource() {
        return datasource;
    }
    
}
