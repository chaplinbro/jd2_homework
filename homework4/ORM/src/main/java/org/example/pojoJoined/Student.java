package org.example.pojoJoined;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "student")
@PrimaryKeyJoinColumn(name = "person_id")
public class Student extends Person{

    @Column
    private  String faculty;
    @Column
    private  int mark;

    public Student() {
    }

    public Student(int id, String name, String surname, String faculty, int mark) {
        super(id, name, surname);
        this.faculty = faculty;
        this.mark = mark;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Student student = (Student) object;
        return mark == student.mark && Objects.equals(faculty, student.faculty);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), faculty, mark);
    }
}
