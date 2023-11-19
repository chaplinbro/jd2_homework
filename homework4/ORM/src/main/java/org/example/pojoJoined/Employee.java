package org.example.pojoJoined;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "employee")
@PrimaryKeyJoinColumn(name = "person_id")
public class Employee extends Person {

    @Column
    private String company;
    @Column
    private int salary;

    public Employee() {
    }

    public Employee(int id, String name, String surname, String company, int salary) {
        super(id, name, surname);
        this.company = company;
        this.salary = salary;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Employee employee = (Employee) object;
        return salary == employee.salary && Objects.equals(company, employee.company);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), company, salary);
    }
}
