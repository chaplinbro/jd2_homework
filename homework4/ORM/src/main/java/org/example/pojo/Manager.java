package org.example.pojo;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "manager")
public class Manager {

    @Id
    @GeneratedValue(strategy =  GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;
    @Column
    private  String name;
    @Column
    private String surname;
    @Embedded
    private Address address;


    public Manager() {
    }

    public Manager(Long id, String name, String surname, Address address) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
        Manager manager = (Manager) object;
        return Objects.equals(id, manager.id) && Objects.equals(name, manager.name) && Objects.equals(surname, manager.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname);
    }

    @Override
    public String toString() {
        return "Manager{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
