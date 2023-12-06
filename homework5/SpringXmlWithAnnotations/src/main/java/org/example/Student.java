package org.example;

import org.springframework.stereotype.Component;

@Component
public class Student implements Person, Address {

    @Override
    public String getName() {
        return "Student";
    }
    @Override
    public int getAge() {
        return 12;
    }

    @Override
    public String getCity() {
        return "Karachi";
    }

    @Override
    public String getStreet() {
        return "Pakistan Street";
    }
}
