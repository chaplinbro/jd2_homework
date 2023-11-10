package org.example.pojo;

import javax.persistence.*;

@Entity
@Table(name = "receiver")
public class Receiver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int num;
    private String name;

    public Receiver(int num, String name) {
        this.num = num;
        this.name = name;
    }

    public Receiver() {
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
