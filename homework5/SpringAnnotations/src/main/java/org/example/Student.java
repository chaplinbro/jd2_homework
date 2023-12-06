package org.example;

import org.springframework.stereotype.Component;

public class Student implements Person, Address {

    @Override
    public String getName() {
        return "Student Vika";
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
