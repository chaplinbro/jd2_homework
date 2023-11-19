package org.example.pojoSingle;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "pro")
@DiscriminatorValue("pro")
public class Pro extends User{

    @Column
    private int skillProLvl;

    public Pro() {
    }

    public Pro(int id, String name, String surname, int skillLvl) {
        super(id, name, surname);
        this.skillProLvl = skillLvl;
    }

    public int getSkillProLvl() {
        return skillProLvl;
    }

    public void setSkillProLvl(int skillProLvl) {
        this.skillProLvl = skillProLvl;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Pro pro = (Pro) object;
        return skillProLvl == pro.skillProLvl;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), skillProLvl);
    }
}
