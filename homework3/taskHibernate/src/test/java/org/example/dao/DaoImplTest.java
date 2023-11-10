package org.example.dao;

import org.example.dao.data.TestSessionFactory;
import org.example.pojo.Expense;
import org.example.pojo.Receiver;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class DaoImplTest {

    private static Dao dao;

    @Before
    public void setUp() throws Exception {
        dao = new DaoImpl(TestSessionFactory.getSessionFactory());
        Session session = TestSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
//        session.createSQLQuery("TRUNCATE TABLE expense;").executeUpdate();
//        session.createSQLQuery("TRUNCATE TABLE receiver;").executeUpdate();
        session.getTransaction().commit();
    }

    @After
    public void tearDown() throws Exception {
        Session session = TestSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
//        session.createSQLQuery("TRUNCATE TABLE expense;").executeUpdate();
//        session.createSQLQuery("TRUNCATE TABLE receiver;").executeUpdate();
        session.getTransaction().commit();
        dao = null;
    }

    @Test
    public void testSaveReceiver() {
        //Given
        Receiver receiver = new Receiver(1, "jaha");

        // When
        int savedId = dao.saveReceiver(receiver);

        // Then
        assertNotNull(savedId);
        assertEquals(receiver.getNum(), savedId);
        assertEquals("jaha", receiver.getName());
    }

    @Test
    public void testSaveExpense() {
        //Given
        Expense expense = new Expense(1, "10-10-1010", 1, 32);

        // When
        int savedId = dao.saveExpense(expense);

        // Then
        assertNotNull(savedId);
        assertEquals(expense.getNum(), savedId);
        assertEquals(expense.getReceiver(), 1);
    }
}