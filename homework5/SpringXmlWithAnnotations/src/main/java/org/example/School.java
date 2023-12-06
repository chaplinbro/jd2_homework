package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class School {

    // внедряем бин через поле
//    @Autowired
//    @Qualifier("teacher")
    private final Person person;

    private final Address address;

    //внедряем бин через конструктор
    //Здесь меняем в @Qualifier бин, который хотим реализовать
    @Autowired
    public School(@Qualifier("director") Person person, @Qualifier("student") Address address) {
        this.person = person;
        this.address = address;
    }

    public void doSomething() {
        System.out.println("метод что-то делает... \n"
                + "Имя: " + person.getName()
                + "\nВозраст: " + person.getAge()
                + "\nГород: " + address.getCity()
                + "\nУлица: " + address.getStreet());
    }

    public void init() {
        System.out.println("init-method");
    }

    public void destroy() {
        System.out.println("destroy-method");
    }
}
