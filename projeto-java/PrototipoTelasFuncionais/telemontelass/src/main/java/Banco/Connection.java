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
        this.datasource.setUrl("jdbc:mysql://3.83.153.177:3306/bdTelemon");
        this.datasource.setUsername("root");
        this.datasource.setPassword("urubu100");

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
