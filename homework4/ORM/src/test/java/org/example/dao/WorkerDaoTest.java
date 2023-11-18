package org.example.dao;

import junit.framework.TestCase;
import org.example.dao.config.TestConfig;
import org.example.dao.config.TestSessionFactory;
import org.example.pojo.Worker;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WorkerDaoTest extends TestCase {

    WorkerDao workerDao;
    Connection conn;

    @Before
    public void setUp() throws Exception {
        workerDao = new WorkerDao(TestSessionFactory.getSessionFactory());
        conn = TestConfig.connection();
        conn.createStatement().executeUpdate("DELETE FROM worker");
    }

    @After
    public void tearDown() throws Exception {
        workerDao = null;
        conn.createStatement().executeUpdate("DELETE FROM worker");
        conn.close();
    }

    @Test
    public void testSave() throws SQLException {
        Worker worker = new Worker("1uuid1", "SaveWorker", "Object",  null);

        workerDao.save(worker);

        ResultSet rs = conn.createStatement().executeQuery("select count(*) from worker");
        rs.next();
        int actualCount = rs.getInt(1);
        assertEquals(1, actualCount);
    }

    @Test
    public void testGet() throws SQLException {

        String testId = "9uuid9";
        conn.createStatement().executeUpdate(
                "insert into worker (id, name, surname) values ('"+ testId +"', 'Chaplin','bro')");

        Worker worker = workerDao.get(testId);

        assertNotNull(worker);

    }
}