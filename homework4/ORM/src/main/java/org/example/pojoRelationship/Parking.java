package org.example.pojoRelationship;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "parking")
public class Parking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column
    private String address;
    @Column
    private int amountCarSpace;

    @OneToMany(mappedBy = "parking")
    private List<Car> cars;

    public Parking() {
    }

    public Parking(Long id, String address, int amountCarSpace) {
        this.id = id;
        this.address = address;
        this.amountCarSpace = amountCarSpace;
        cars = new ArrayList<Car>();
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAmountCarSpace(int amountCarSpace) {
        this.amountCarSpace = amountCarSpace;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Parking parking = (Parking) object;
        return amountCarSpace == parking.amountCarSpace && Objects.equals(id, parking.id) && Objects.equals(address, parking.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, address, amountCarSpace);
    }
}
