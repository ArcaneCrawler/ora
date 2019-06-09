package com.math.epidemic.Entities;

import org.springframework.data.repository.query.Param;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Virus")
public class Virus implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String strain;

    @Column(nullable = false)
    private float lethal;

    @Column(nullable = false)
    private float influence;

    @Column(nullable = false)
    private float chance;

    @Column(nullable = false)
    private float evol_rate;

    @Column(nullable = false)
    private float cure_rate;

    @Column(nullable = false)
    private float endurance;




    public Virus(String name, String strain, float lethal, float influence,float chance,float evol_rate,float cure_rate,float endurance) {
        this.name = name;
        this.strain = strain;
        this.lethal = lethal;
        this.influence = influence;
        this.chance = chance;
        this.evol_rate = evol_rate;
        this.cure_rate = cure_rate;
        this.endurance = endurance;

    }

    public Virus(String name) {
        this.name = name;

    }


    @Override
    public String toString() {
        return String.format(
                "Virus[name=%s']",
                name);
    }

    public Virus() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStrain() {
        return strain;
    }

    public void setStrain(String strain) {
        this.strain = strain;
    }

    public float getLethal() {
        return lethal;
    }

    public void setLethal(float lethal) {
        this.lethal = lethal;
    }

    public float getInfluence() {
        return influence;
    }

    public void setInfluence(float influence) {
        this.influence = influence;
    }

    public float getChance() {
        return chance;
    }

    public void setChance(float chance) {
        this.chance = chance;
    }

    public float getEvol_rate() {
        return evol_rate;
    }

    public void setEvol_rate(float evol_rate) {
        this.evol_rate = evol_rate;
    }

    public float getCure_rate() {
        return cure_rate;
    }

    public void setCure_rate(float cure_rate) {
        this.cure_rate = cure_rate;
    }

    public float getEndurance() {
        return endurance;
    }

    public void setEndurance(float endurance) {
        this.endurance = endurance;
    }
}
