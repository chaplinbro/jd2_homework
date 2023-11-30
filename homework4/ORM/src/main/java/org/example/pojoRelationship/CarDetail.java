package org.example.pojoRelationship;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "car_detail")
public class CarDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column
    private String engine;
    @Column
    private String bodyType;
    @Column
    private int wheelSize;

    public CarDetail() {
    }

    public CarDetail(Long id, String engine, String bodyType, int willSize) {
        this.id = id;
        this.engine = engine;
        this.bodyType = bodyType;
        this.wheelSize = willSize;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    public int getWheelSize() {
        return wheelSize;
    }

    public void setWheelSize(int wheelSize) {
        this.wheelSize = wheelSize;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        CarDetail that = (CarDetail) object;
        return wheelSize == that.wheelSize && Objects.equals(id, that.id) && Objects.equals(engine, that.engine) && Objects.equals(bodyType, that.bodyType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, engine, bodyType, wheelSize);
    }
}
