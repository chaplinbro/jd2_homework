package org.example.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConfig {

    private static TestConfig testConfig;

    protected TestConfig() throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
    }

    protected Connection getConnection() throws SQLException {

        return DriverManager.getConnection("jdbc:mysql://localhost:3306/spring_hibernate_test", "user", "user");
    }

    public static Connection connection() throws ClassNotFoundException, SQLException {
        if (testConfig == null) {
            testConfig = new TestConfig();
        }
        return testConfig.getConnection();
    }
}