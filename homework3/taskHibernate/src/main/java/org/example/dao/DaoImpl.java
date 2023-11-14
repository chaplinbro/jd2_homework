package org.example.dao;

import org.example.SessionFactoryClass;
import org.example.pojo.Person;
import org.hibernate.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class DaoImpl implements Dao {

    SessionFactory sessionFactory;

    public DaoImpl(SessionFactory sessionFactory) {
        if (sessionFactory == null) {
            throw new IllegalArgumentException("ошибочка");
        }
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Long savePerson(Person person) {
        Session session = null;
        Transaction transaction = null;
        Long saveId = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            saveId = (Long) session.save(person);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw new RuntimeException(e);
        } finally {
            if (session != null) session.close();
        }
        return saveId;
    }

    @Override
    public boolean deletePerson(Long id) {
        Session session = null;
        Transaction transaction = null;
        Person person;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            person = session.get(Person.class, id);
            if (person == null) return false;
            session.delete(person);
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
    public Person findPerson(Long id) {
        Session session = null;
        Transaction transaction = null;
        Person person;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            person = session.find(Person.class, id);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw new RuntimeException(e);
        } finally {
            if (session != null) session.close();
        }
        return person;
    }

    @Override
    public Person getPerson(Long id) {
        Session session = null;
        Transaction transaction = null;
        Person person;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            person = session.get(Person.class, id);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw new RuntimeException(e);
        } finally {
            if (session != null) session.close();
        }
        return person;
    }

    @Override
    public Person loadPerson(Long id) {
        Session session = null;
        Transaction transaction = null;
        Person person;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            person = session.load(Person.class, id);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw new RuntimeException(e);
        } finally {
            if (session != null) session.close();
        }
        return person;
    }



    @Override
    public void updatePerson(Person person) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.update(person);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw new RuntimeException(e);
        } finally {
            if (session != null) session.close();
        }
    }

    public void start() {
        System.out.println("Please choose command:\n" +
                "1. Delete Person \n" +
                "2. Find Person \n" +
                "3. Save or Update Person \n" +
                "4. Exit\n" +
                "Your choose - ");
        DaoImpl dao = new DaoImpl(sessionFactory);
        Scanner scanner = new Scanner(System.in);
        int choose = Integer.parseInt(scanner.nextLine());
        if (choose > 4) {
            System.out.println("Wrong number of command.");
            dao.start();
        }

        switch (choose) {
            case 1:
                System.out.println("Your choose - 1 \n" +
                        "Please enter id:");
                dao.deletePerson(scanner.nextLong());
                System.out.println("Person is deleted.");
                dao.start();
                break;
            case 2:
                System.out.println("Your choose - 1 \n" +
                        "Please enter id:");
                System.out.println(dao.getPerson(scanner.nextLong()));
                dao.start();
                break;
            case 3:
                String name;
                String surname;
                int number;
                System.out.println("Your choose - 3\n");
                System.out.println("Please insert Person description:\n" +
                        "Name - ");
                name = scanner.nextLine();
                System.out.println("Please insert Person description:\n" +
                        "Surname - ");
                surname = scanner.nextLine();
                System.out.println("Please insert Person description:\n" +
                        "Number - ");
                number = Integer.parseInt(scanner.nextLine());

                Person personSave = new Person(null, name, surname, number);
                long id = dao.savePerson(personSave);

                LocalDateTime date = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                String dateTime = date.format(formatter);

                System.out.println(dateTime + " INFO - PERSON: id = " + id);
                dao.start();
                break;
            case 4:
                System.out.println("Program end successful.");
                break;
        }
    }
}