package org.example;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        // Берем бин из спринг.контекста
        School school = context.getBean("school", School.class);
        System.out.println("Год основания: " + school.getYearOfFoundation());

        school.doSomething();
        context.close();
    }
}
