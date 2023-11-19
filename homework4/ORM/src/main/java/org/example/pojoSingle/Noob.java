package org.example.pojoSingle;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "noob")
@DiscriminatorValue("noob")
public class Noob extends User{

    @Column
    private int skillNoobLvl;

    public Noob() {
    }

    public Noob(int id, String name, String surname, int skillNoobLvl) {
        super(id, name, surname);
        this.skillNoobLvl = skillNoobLvl;
    }

    public int getSkillNoobLvl() {
        return skillNoobLvl;
    }

    public void setSkillNoobLvl(int skillNoobLvl) {
        this.skillNoobLvl = skillNoobLvl;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Noob noob = (Noob) object;
        return skillNoobLvl == noob.skillNoobLvl;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), skillNoobLvl);
    }
}
