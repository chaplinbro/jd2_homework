package org.example;

import org.springframework.stereotype.Component;

@Component
public class Teacher implements Person{

    @Override
    public String getName() {
        return "Teacher";
    }
    @Override
    public int getAge() {
        return 33;
    }
}
