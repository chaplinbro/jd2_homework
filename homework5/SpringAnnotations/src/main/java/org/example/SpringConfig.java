package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.Arrays;
import java.util.List;

@Configuration
@PropertySource("school.properties")
public class SpringConfig {

    // реализуем внедрение зависимостей и создание бинов вручную
    @Bean
    public Director director() {
        return new Director();
    }

    @Bean
    public School school() {
        return new School(personList());
    }

    @Bean
    public Student student() {
        return new Student();
    }

    @Bean
    public Teacher teacher() {
        return new Teacher();
    }

    @Bean
    public List<Person> personList() {
        return Arrays.asList(director(), teacher(), student());
    }
}
