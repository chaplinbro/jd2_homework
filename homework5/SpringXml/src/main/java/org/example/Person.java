package org.example;

public class Person {

    private String name;

    private String surname;

    private Address address;

    public static Person getPerson() {
        return new Person();
    }

    public void init() {
        System.out.println("init-method: initialize");
    }

    public void destroy() {
        System.out.println("destroy-method: destroy");
    }

    private Person() {
    }

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
