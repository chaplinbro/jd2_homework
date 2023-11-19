package org.example.pojoPerClass;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "teacher")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE) // TABLE_PER_CLASS работает только с SEQUENCE
    @Column(name = "id")
    private int id;
    @Column
    private String name;
    @Column
    private String surname;

    public Teacher() {
    }

    public Teacher(Integer id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Teacher teacher = (Teacher) object;
        return id == teacher.id && Objects.equals(name, teacher.name) && Objects.equals(surname, teacher.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname);
    }
}
