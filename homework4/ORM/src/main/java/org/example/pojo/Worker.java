package org.example.pojo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "worker")
public class Worker {

    @Id
    @GenericGenerator(strategy = "uuid", name = "worker_uuid")
    @GeneratedValue(generator = "worker_uuid")
    @Column(name = "id")
    private  String id;
    @Column
    private String name;
    @Column
    private String surname;
    @Embedded
    private Address address;

    public Worker() {
    }

    public Worker(String id, String name, String surname, Address address) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Worker worker = (Worker) o;
        return Objects.equals(id, worker.id) && Objects.equals(name, worker.name) && Objects.equals(surname, worker.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname);
    }

    @Override
    public String toString() {
        return "Worker{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
