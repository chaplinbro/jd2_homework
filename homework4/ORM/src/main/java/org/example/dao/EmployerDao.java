package org.example.dao;

import org.example.pojo.Employer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class EmployerDao {

    SessionFactory sessionFactory;

    public EmployerDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Integer save(Employer employer) {
        Session session = null;
        Transaction transaction = null;
        Integer saveId = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            saveId = (Integer) session.save(employer);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw new RuntimeException(e);
        } finally {
            if (session != null) session.close();
        }
        return saveId;
    }

    public  Employer get(Integer id) {
        Session session = null;
        Transaction transaction = null;
        Employer employer = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            employer = session.get(Employer.class, id);
            System.out.println("И выведите их на консоль: " + employer + " и id: " + employer.getId());
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw new RuntimeException(e);
        } finally {
            if (session != null) session.close();
        }
        return employer;
    }

    public Employer createNewEmployer() {
        Employer employer = new Employer(null, 24, "Fredi","Mercury");
        save(employer);
        return employer;
    }
}
