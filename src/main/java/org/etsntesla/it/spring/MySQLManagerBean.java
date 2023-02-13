package org.etsntesla.it.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
public class MySQLManagerBean {

    @Autowired
    @Qualifier("factoryDBConfig")
    private DatabaseConfiguration config;

    public Connection getConnection(){
        try {
            return DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPass()
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
