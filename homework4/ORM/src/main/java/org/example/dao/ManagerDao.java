package org.example.dao;

import org.example.pojo.Address;
import org.example.pojo.Manager;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class ManagerDao {

    SessionFactory sessionFactory;

    public ManagerDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Long save(Manager manager) {
        Session session = null;
        Transaction transaction = null;
        Long saveId = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            saveId = (Long) session.save(manager);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw new RuntimeException(e);
        } finally {
            if (session != null) session.close();
        }
        return saveId;
    }

    public  Manager get(Long id) {
        Session session = null;
        Transaction transaction = null;
        Manager manager = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            manager = session.get(Manager.class, id);
            System.out.println("И выведите их на консоль: " + manager + " и id: " + manager.getId());
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw new RuntimeException(e);
        } finally {
            if (session != null) session.close();
        }
        return manager;
    }

    public Manager joinManager() {
        Manager manager = new Manager(null, "Chaze", "Hatson",
                new Address("Zibitskaya", "Minsk","3A"));
        save(manager);
        return manager;
    }
}
