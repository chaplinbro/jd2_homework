package org.example.dao;

import org.example.pojoRelationship.Car;
import org.example.pojoRelationship.CarDetail;
import org.example.pojoRelationship.Parking;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class RelationshipDao {

    SessionFactory sessionFactory;

    public RelationshipDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void saveCarWithCarDetail() {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Car car = new Car(null, "BMW", 246);
            CarDetail carDetail = new CarDetail(null,"M60", "Sedan", 21);
            car.setCarDetail(carDetail);
            session.save(car);
            session.flush();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw new RuntimeException(e);
        } finally {
            if (session != null) session.close();
        }
    }



    public void saveParkingWithCars() {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Parking parking = new Parking(null, "Zelenaya 15", 60);
            Car car = new Car(null, "Porshe", 499);
            List<Car> cars = new ArrayList<Car>();
            cars.add(car);
            parking.setCars(cars);
            session.save(car);
            session.save(parking);
            session.flush();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw new RuntimeException(e);
        } finally {
            if (session != null) session.close();
        }
    }
}
