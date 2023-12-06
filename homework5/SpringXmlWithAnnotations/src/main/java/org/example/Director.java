package org.example;

import org.springframework.stereotype.Component;

@Component
public class Director implements Person, Address{

    @Override
    public String getName() {
        return "Director Ahmed";
    }
    @Override
    public int getAge() {
        return 79;
    }

    @Override
    public String getCity() {
        return "Alaska";
    }

    @Override
    public String getStreet() {
        return "Penguin Street";
    }
}
