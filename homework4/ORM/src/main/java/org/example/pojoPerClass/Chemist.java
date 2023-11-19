package org.example.pojoPerClass;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "chemist")
public class Chemist extends Teacher {

    @Column
    private  int diplomGradeChemist;

    public Chemist() {
    }

    public Chemist(int diplomGradeChemist) {
        this.diplomGradeChemist = diplomGradeChemist;
    }

    public Chemist(int id, String name, String surname, int diplomGrade) {
        super(id, name, surname);
        this.diplomGradeChemist = diplomGrade;
    }

    public int getDiplomGradeChemist() {
        return diplomGradeChemist;
    }

    public void setDiplomGradeChemist(int diplomGradeChemist) {
        this.diplomGradeChemist = diplomGradeChemist;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Chemist chemist = (Chemist) object;
        return diplomGradeChemist == chemist.diplomGradeChemist;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), diplomGradeChemist);
    }
}
