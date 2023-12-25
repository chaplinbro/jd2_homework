//package org.example;
//
//import org.example.entity.User;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.ImportResource;
//
//@Configuration
//@ImportResource("classpath:applicationContext.xml")
//public class ConfigWithXML {
//
//    private final SessionFactory sessionFactory;
//
//    @Autowired
//    public ConfigWithXML(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }
//
//    public void saveUser(User user) {
//        Session session = sessionFactory.openSession();
//        Transaction transaction = session.beginTransaction();
//        session.save(user);
//        transaction.commit();
//    }
//
//    public User getUser(Long id) {
//        Session session = sessionFactory.openSession();
//        Transaction transaction = session.beginTransaction();
//        User user = session.get(User.class, id);
//        transaction.commit();
//        return user;
//    }
//
//    public void deleteUser(Long id) {
//        Session session = sessionFactory.openSession();
//        Transaction transaction = session.beginTransaction();
//        User user = session.get(User.class, id);
//        session.delete(user);
//        transaction.commit();
//    }
//}