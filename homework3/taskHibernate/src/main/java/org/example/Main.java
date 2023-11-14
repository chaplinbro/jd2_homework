package org.example;

import org.example.dao.Dao;
import org.example.dao.DaoImpl;
import org.hibernate.SessionFactory;

public class Main {
    public static void main(String[] args) {

        DaoImpl dao = new DaoImpl(SessionFactoryClass.getSessionFactory());

        try {
            dao.start();
        } catch (Exception e) {
            System.out.println("U failed..." + e.getMessage());
        }
    }
}
