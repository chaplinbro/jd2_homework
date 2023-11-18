package org.example.dao;

import junit.framework.TestCase;
import org.example.dao.config.TestConfig;
import org.example.dao.config.TestSessionFactory;
import org.example.pojo.Employer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployerDaoTest extends TestCase {

    EmployerDao employerDao;
    Connection conn;

    @Before
    public void setUp() throws Exception {
        employerDao = new EmployerDao(TestSessionFactory.getSessionFactory());
        conn = TestConfig.connection();
        conn.createStatement().executeUpdate("DELETE FROM employer");
    }

    @After
    public void tearDown() throws Exception {
        employerDao = null;
        conn.createStatement().executeUpdate("DELETE FROM employer");
        conn.close();
    }

    @Test
    public void testSave() throws SQLException {
        Employer employer = new Employer(1, 21, "SaveEmployer", "Object");

        employerDao.save(employer);

        ResultSet rs = conn.createStatement().executeQuery("select count(*) from employer");
        rs.next();
        int actualCount = rs.getInt(1);
        assertEquals(1, actualCount);
    }

    @Test
    public void testGet() throws SQLException {
        Integer testId = 99;
        conn.createStatement().executeUpdate(
                "insert into employer values ('" + testId + "', 43234 , 'chaplin', 'bro')");

        Employer employer = employerDao.get(testId);

        assertNotNull(employer);

    }
}