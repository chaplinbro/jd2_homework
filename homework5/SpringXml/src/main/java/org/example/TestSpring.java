package org.example;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        Person person = context.getBean("personBean", Person.class);

        System.out.println("name is: " + person.getName());
        System.out.println("surname is: " + person.getSurname());
        System.out.println("leaving in: " + person.getAddress() + " :D");

        context.close();
    }
}
