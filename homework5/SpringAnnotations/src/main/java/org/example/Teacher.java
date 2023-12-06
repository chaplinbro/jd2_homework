package org.example;

import org.springframework.stereotype.Component;

public class Teacher implements Person {

    @Override
    public String getName() {
        return "Teacher Afanacy";
    }

    @Override
    public int getAge() {
        return 33;
    }
}
