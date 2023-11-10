package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Config {

    private static Config config;

    protected Config() throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
    }

    protected Connection getConnection() throws SQLException {

        return DriverManager.getConnection("jdbc:mysql://localhost:3306/hibernate_db", "user", "user");
    }

    public static Connection Connection() throws ClassNotFoundException, SQLException {
        if (config == null) {
            config = new Config();
        }
        return config.getConnection();
    }
}
