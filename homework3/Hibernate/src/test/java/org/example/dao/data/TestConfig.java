package org.example.dao.data;

import org.example.Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConfig extends Config {

    private static  TestConfig testConfig;

    public TestConfig() throws ClassNotFoundException {
        super();
    }

    protected Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/hibernate_db_test", "user", "user");
    }
    public static Connection connection() throws ClassNotFoundException, SQLException {
        if (testConfig == null){
            testConfig = new TestConfig();
        }
        return testConfig.getConnection();
    }
}
