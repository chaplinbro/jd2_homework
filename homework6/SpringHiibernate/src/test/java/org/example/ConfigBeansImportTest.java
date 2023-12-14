package org.example;

import org.example.data.TestConfig;
import org.example.data.TestSessionFactory;
import org.example.entity.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@ContextConfiguration(classes = {ConfigBeans.class, ConfigBeansImport.class})
public class ConfigBeansImportTest {

    @Autowired
    ConfigBeansImport configBeansImport;

    Connection conn;

    @Before
    public void setUp() throws Exception {
        configBeansImport = new ConfigBeansImport(TestSessionFactory.getSessionFactory());
        conn = TestConfig.connection();
        conn.createStatement().executeUpdate("delete from user");
    }

    @After
    public void tearDown() throws Exception {
        configBeansImport = null;
        conn = TestConfig.connection();
//        conn.createStatement().executeUpdate("delete from user");
        conn.close();
    }

    @Test
    public void testSaveUser() throws SQLException, ClassNotFoundException {
        User user = new User(111L, "testSave", 12);

        configBeansImport.saveUser(user);

        conn = TestConfig.connection();
        ResultSet rs = conn.createStatement().executeQuery(
                "select count(*) from user where name = 'testSave'");
        rs.next();
        long count = rs.getLong(1);
        assertEquals(1, count);
        conn.close();
    }

    @Test
    public void testGetUser() throws SQLException, ClassNotFoundException {
        conn = TestConfig.connection();
        long testId = 101;
        conn.createStatement().executeUpdate(
                "insert into user values ('" + testId + "', '34', 'testGet')");

        User user = configBeansImport.getUser(testId);

        assertNotNull(user);
        assertEquals("testGet", user.getName());
        conn.close();
    }

    @Test
    public void testDeleteUser() throws SQLException, ClassNotFoundException {

        conn = TestConfig.connection();
        long testId = 300;
        conn.createStatement().executeUpdate(
                "insert into user values ('" + testId + "', '23', 'testDelete')");

        configBeansImport.deleteUser(testId);

        ResultSet rs = conn.createStatement().executeQuery(
                "select count(*) from user where id = '" + testId + "';");
        rs.next();
        long actualId = rs.getLong(1);
        assertEquals(0, actualId);
        conn.close();
    }
}