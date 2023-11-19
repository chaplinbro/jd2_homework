package org.example;


import org.example.dao.EmployerDao;
import org.example.dao.ManagerDao;
import org.example.dao.WorkerDao;
import org.example.dao.HierarchyDao;
import org.example.pojoJoined.Employee;
import org.example.pojoJoined.Person;
import org.example.pojoJoined.Student;
import org.example.pojoPerClass.Biologist;
import org.example.pojoPerClass.Chemist;
import org.example.pojoSingle.Noob;
import org.example.pojoSingle.Pro;
import org.example.pojoSingle.User;

public class Main {
    public static void main(String[] args) {

        EmployerDao employerDao = new EmployerDao(SessionFactoryClass.getSessionFactory());
        ManagerDao managerDao = new ManagerDao(SessionFactoryClass.getSessionFactory());
        WorkerDao workerDao = new WorkerDao(SessionFactoryClass.getSessionFactory());
        HierarchyDao hierarchyDao = new HierarchyDao(SessionFactoryClass.getSessionFactory());

        employerDao.createNewEmployer();
        managerDao.joinManager();
        workerDao.joinWorker();

        hierarchyDao.saveObject(new Biologist(0, "Biologist", "Bro", 5));
        hierarchyDao.saveObject(new Chemist(0, "Chemist", "Bro", 4));

        hierarchyDao.saveObject(new User(0,"User", "Bro"));
        hierarchyDao.saveObject(new Pro(0,"Pro", "Bro", 99));
        hierarchyDao.saveObject(new Noob(0,"noob", "Bro", 9));

        hierarchyDao.saveObject(new Person(0,"Person", "Bro"));
        hierarchyDao.saveObject(new Student(0,"Student", "Bro", "Epam", 90000));
        hierarchyDao.saveObject(new Employee(0,"Employee", "Bro", "Math", 10));

    }
}