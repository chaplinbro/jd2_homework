package org.example.dao;

import org.example.pojo.Person;


public interface Dao {

    Long savePerson (Person person);

    boolean deletePerson (Long id);

    Person findPerson (Long id);

    Person getPerson(Long id);

    Person loadPerson (Long id);

    Person updatePerson (Long id, String name, String surname, int number);



}
