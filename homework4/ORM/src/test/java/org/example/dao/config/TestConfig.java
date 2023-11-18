package org.example.dao.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConfig {

    private static TestConfig config;

    protected TestConfig() throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
    }

    protected Connection getConnection() throws SQLException {

        return DriverManager.getConnection("jdbc:mysql://localhost:3306/orm_db_test", "user", "user");
    }

    public static Connection connection() throws ClassNotFoundException, SQLException {
        if (config == null) {
            config = new TestConfig();
        }
        return config.getConnection();
    }
}
