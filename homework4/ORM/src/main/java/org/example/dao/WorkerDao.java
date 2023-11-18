package org.example.dao;

import org.example.pojo.Address;
import org.example.pojo.Worker;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class WorkerDao {

    SessionFactory sessionFactory;

    public WorkerDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public String save(Worker worker) {
        Session session = null;
        Transaction transaction = null;
        String saveId = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            saveId = (String) session.save(worker);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw new RuntimeException(e);
        } finally {
            if (session != null) session.close();
        }
        return saveId;
    }

    public Worker get(String id) {
        Session session = null;
        Transaction transaction = null;
        Worker worker = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            worker = session.get(Worker.class, id);
            System.out.println("И выведите их на консоль: " + worker + " и id: " + worker.getId());
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw new RuntimeException(e);
        } finally {
            if (session != null) session.close();
        }
        return worker;
    }

    public Worker joinWorker() {
        Worker worker = new Worker(null, "Chaplin", "Charlie",
                new Address("Moskoyskaya", "Minsk", "13"));
        save(worker);
        return worker;
    }

}
