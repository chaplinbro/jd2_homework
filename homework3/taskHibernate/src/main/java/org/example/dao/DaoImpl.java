package org.example.dao;

import org.example.pojo.Expense;
import org.example.pojo.Receiver;
import org.hibernate.*;

import javax.transaction.Transactional;
import java.util.ArrayList;

public class DaoImpl implements Dao {

    SessionFactory sessionFactory;

    public DaoImpl(SessionFactory sessionFactory) {
        if (sessionFactory == null) {
            throw new IllegalArgumentException("ошибочка");
        }
        this.sessionFactory = sessionFactory;
    }

    @Override
    public int saveReceiver(Receiver receiver) {
        Session session = null;
        Transaction transaction = null;
        int savedId;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            savedId = (Integer) session.save(receiver);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw new RuntimeException(e);
        } finally {
            if (session != null) session.close();
        }
        return savedId;
    }

    @Override
    public int saveExpense(Expense expense) {
        Session session = null;
        Transaction transaction = null;
        int savedId;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            savedId = (Integer) session.save(expense);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw new RuntimeException(e);
        } finally {
            if (session != null) session.close();
        }
        return savedId;
    }

    @Override
    public ArrayList<Receiver> getReceiver() {
        try (Session session = sessionFactory.openSession()) {
            Query<Receiver> query = session.createQuery("select * from expense", Receiver.class);
            return new ArrayList<>(query.list());
        }
    }

    @Override
    public ArrayList<Expense> getExpenses() {
        try (Session session = sessionFactory.openSession()) {
            Query<Expense> query = session.createQuery("select * from expense", Expense.class);
            return new ArrayList<>(query.list());
        }
    }

    @Override
    public boolean deleteReceiver(int num) {
        Session session = null;
        Transaction transaction = null;
        Receiver receiver;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            receiver = session.get(Receiver.class, num);
            if (receiver == null) {
                return false;
            }
            session.delete(receiver);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw new RuntimeException(e);
        } finally {
            if (session != null) session.close();
        }
        return true;
    }

    @Override
    public boolean deleteExpense(int num) {
        Session session = null;
        Transaction transaction = null;
        Expense expense;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            expense = session.get(Expense.class, num);
            if (expense == null) {
                return false;
            }
            session.delete(expense);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw new RuntimeException(e);
        } finally {
            if (session != null) session.close();
        }
        return true;
    }

    @Override
    @Transactional
    public Receiver getReceiver(int num) {
        try {
            Session session = sessionFactory.getCurrentSession();
            Receiver receiver = session.get(Receiver.class, num);
            if (receiver == null) {
                throw new Exception("Receiver с id " + num + " не найден");
            }
            return receiver;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    @Transactional
    public Expense getExpense(int num) {
        try {
            Session session = sessionFactory.getCurrentSession();
            Expense expense = session.get(Expense.class, num);
            if (expense == null) {
                throw new Exception("expense с id " + num + " не найден");
            }
            return expense;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    @Transactional
    public Receiver loadReceiver(int num) {
        try {
            Session session = sessionFactory.getCurrentSession();
            return session.load(Receiver.class, num);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    @Transactional
    public void flush(Receiver receiver) {
        try {
            Session session = sessionFactory.openSession();
            session.flush();
            session.refresh(receiver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}