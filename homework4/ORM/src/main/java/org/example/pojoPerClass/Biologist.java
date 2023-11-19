package org.example.pojoPerClass;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "biologist")
public class Biologist extends  Teacher {

    @Column
    private  int diplomGradeBiologist;

    public Biologist() {
    }

    public Biologist(int diplomGradeBiologist) {
        this.diplomGradeBiologist = diplomGradeBiologist;
    }

    public Biologist(int id, String name, String surname, int diplomGradeBiologist) {
        super(id, name, surname);
        this.diplomGradeBiologist = diplomGradeBiologist;
    }

    public int getDiplomGradeBiologist() {
        return diplomGradeBiologist;
    }

    public void setDiplomGradeBiologist(int diplomGradeBiologist) {
        this.diplomGradeBiologist = diplomGradeBiologist;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Biologist biologist = (Biologist) object;
        return diplomGradeBiologist == biologist.diplomGradeBiologist;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), diplomGradeBiologist);
    }
}
