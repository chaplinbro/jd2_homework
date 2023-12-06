package org.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestSpring {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SpringConfig.class);

        // Берем бин из спринг.контекста
        School school = context.getBean("school", School.class);
        System.out.println(school.doSomething());

        context.close();
    }
}
