package org.example.dao;

import junit.framework.TestCase;
import org.example.dao.config.TestConfig;
import org.example.dao.config.TestSessionFactory;
import org.example.pojo.Manager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.*;


public class ManagerDaoTest extends TestCase {

    ManagerDao managerDao;
    Connection conn;

    @Before
    public void setUp() throws Exception {
        managerDao = new ManagerDao(TestSessionFactory.getSessionFactory());
        conn = TestConfig.connection();
        conn.createStatement().executeUpdate("DELETE FROM manager");
    }

    @After
    public void tearDown() throws Exception {
        managerDao = null;
        conn.createStatement().executeUpdate("DELETE FROM manager");
        conn.close();
    }

    @Test
    public void testSave() throws SQLException {
        //given
        Manager manager = new Manager(null, "Zahar", "Nikolaech", null);
        //when
        managerDao.save(manager);
        //then
        ResultSet rs = conn.createStatement().executeQuery("select count(*) from manager");
        rs.next();
        long actualCount = rs.getLong(1);
        assertEquals(1, actualCount);
    }

    @Test
    public void testGet() throws SQLException {
        long testId = 13;

        String sql = "insert into manager (id, name, surname) values (?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setLong(1, testId);
        ps.setString(2, "chaplin");
        ps.setString(3, "bro");

        ps.executeUpdate();

        Manager manager = managerDao.get(testId);

        assertNotNull(manager);
    }
}