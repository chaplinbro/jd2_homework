package org.example;

import org.example.dao.DaoImpl;
import org.hibernate.SessionFactory;

public class Main {


    public static void main(String[] args) {

        SessionFactory sessionFactory = SessionFactoryClass.getSessionFactory();
        DaoImpl dao = new DaoImpl(sessionFactory);

    }
}