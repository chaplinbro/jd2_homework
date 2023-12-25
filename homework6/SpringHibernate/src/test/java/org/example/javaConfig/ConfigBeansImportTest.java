package org.example.javaConfig;

import org.example.entity.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestConfigBeans.class)
@TestPropertySource(value = "classpath:test.application.properties")
public class ConfigBeansImportTest {

    @Autowired
    ConfigBeansImport configBeansImport;
    @Autowired
    DataSource dataSource;

    Connection conn;

    @Before
    public void setUp() throws Exception {
        conn = dataSource.getConnection();
//        conn.createStatement().executeUpdate("CREATE TABLE IF NOT EXISTS user (id INT, name VARCHAR(255), age INT)");
        conn.createStatement().executeUpdate("delete from user");
    }

    @After
    public void tearDown() throws Exception {
        conn.createStatement().executeUpdate("delete from user");
        conn.close();
    }

    @Test
    public void testSaveUser() throws SQLException, ClassNotFoundException {
        User user = new User(111L, "testSave", 12);

        configBeansImport.saveUser(user);

        ResultSet rs = conn.createStatement().executeQuery(
                "select count(*) from user where name = 'testSave'");
        rs.next();
        long count = rs.getLong(1);
        assertEquals(1, count);
    }

    @Test
    public void testGetUser() throws SQLException, ClassNotFoundException {
        long testId = 101;
        conn.createStatement().executeUpdate(
                "insert into user (id, age, name) values ('" + testId + "', '34', 'testGet')");

        User user = configBeansImport.getUser(testId);

        assertNotNull(user);
        assertEquals("testGet", user.getName());
    }

    @Test
    public void testDeleteUser() throws SQLException, ClassNotFoundException {
        long testId = 300;
        conn.createStatement().executeUpdate(
                "insert into user (id, age, name) values ('" + testId + "', '23', 'testDelete')");

        configBeansImport.deleteUser(testId);

        ResultSet rs = conn.createStatement().executeQuery(
                "select count(*) from user where id = '" + testId + "';");
        rs.next();
        long actualId = rs.getLong(1);
        assertEquals(0, actualId);
    }
}