package org.example;


import org.example.dao.EmployerDao;
import org.example.dao.ManagerDao;
import org.example.dao.WorkerDao;

public class Main {
    public static void main(String[] args) {

        EmployerDao employerDao = new EmployerDao(SessionFactoryClass.getSessionFactory());
        ManagerDao managerDao = new ManagerDao(SessionFactoryClass.getSessionFactory());
        WorkerDao workerDao = new WorkerDao(SessionFactoryClass.getSessionFactory());

        employerDao.createNewEmployer();
        managerDao.joinManager();
        workerDao.joinWorker();

    }
}