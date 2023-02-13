package org.etsntesla.it;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MySqlManager {

   private  static Connection connection;

   private static Properties properties;

   private static final String MYSQL_STRING = "jdbc:mysql://localhost:3306/db_emocije_ah";
   private static final String MYSQL_USER= "root";
   private static final String MYSQL_PASS= "";


    static {
        try {
            getProperties();
            connection = DriverManager.getConnection(
                    properties.getProperty("database.url"),
                    properties.getProperty("database.user"),
                    properties.getProperty("database.pass")
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static Connection getConnection() {
        return connection;
    }

    public static void getProperties(){
        try {
            properties = new Properties();
            InputStream inputStream = MySqlManager.class.getClassLoader().getResourceAsStream("application.properties");
            properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
