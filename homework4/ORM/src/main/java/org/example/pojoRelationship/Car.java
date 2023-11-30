package org.example.pojoRelationship;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column
    private String brand;
    @Column
    private  int horsepower;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "car_detail_id")
    private CarDetail carDetail;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parking_id")
    private Parking parking;

    public Car() {
    }

    public Car(Long id, String brand, int horsepower) {
        this.id = id;
        this.brand = brand;
        this.horsepower = horsepower;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    public CarDetail getCarDetail() {
        return carDetail;
    }

    public void setCarDetail(CarDetail carDetail) {
        this.carDetail = carDetail;
    }

    public Parking getParking() {
        return parking;
    }

    public void setParking(Parking parking) {
        this.parking = parking;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Car car = (Car) object;
        return horsepower == car.horsepower && Objects.equals(id, car.id) && Objects.equals(brand, car.brand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, brand, horsepower);
    }
}
