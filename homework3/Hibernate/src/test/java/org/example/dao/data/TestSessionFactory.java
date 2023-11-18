package org.example.dao.data;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestSessionFactory {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory(){
        if (sessionFactory == null){
            sessionFactory = new Configuration()
                    .configure("test.hibernate.cfg.xml")
                    .buildSessionFactory();
        }
        return sessionFactory;
    }
}
