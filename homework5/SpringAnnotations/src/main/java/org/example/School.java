package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;

public class School {

    @Value("${school.yearOfFoundation}")
    private int yearOfFoundation;

    public int getYearOfFoundation() {
        return yearOfFoundation;
    }

    public List<Person> personList;

    public School(List<Person> personList) {
        this.personList = personList;
    }

    public String doSomething() {
        StringBuilder result = new StringBuilder();
        for (Person person : personList) {
            result.append(person.getName()).append(" возраст: ")
                    .append(person.getAge()).append("\n");
        }
        return result.toString();
    }

    @PostConstruct
    public  void init() {
        System.out.println("init-method");
    }

    @PreDestroy
    public  void destroy() {
        System.out.println("destroy-method");
    }
}
