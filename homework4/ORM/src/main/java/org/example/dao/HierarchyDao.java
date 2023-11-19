package org.example.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class HierarchyDao {

    SessionFactory sessionFactory;

    public HierarchyDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Integer saveObject(Object object) {
        Session session = null;
        Transaction transaction = null;
        Integer saveId = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            saveId = (Integer) session.save(object);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw new RuntimeException(e);
        } finally {
            if (session != null) session.close();
        }
        return saveId;
    }

}
