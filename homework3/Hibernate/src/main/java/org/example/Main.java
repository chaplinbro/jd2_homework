package org.example;

import org.example.dao.DaoImpl;

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
