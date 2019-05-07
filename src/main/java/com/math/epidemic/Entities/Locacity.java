package com.math.epidemic.Entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Locacity")

public class Locacity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int population;

    @Column(nullable = false)
    private float pop_density;

    @Column(nullable = false)
    private float birth_rate;

    @Column(nullable = false)
    private float death_rate;


    public Locacity() {
    }

    public Locacity(String name, int population, float pop_density, float birth_rate, float death_rate) {
        this.name = name;
        this.population = population;
        this.pop_density = pop_density;
        this.birth_rate = birth_rate;
        this.death_rate = death_rate;
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

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public float getPop_density() {
        return pop_density;
    }

    public void setPop_density(float pop_density) {
        this.pop_density = pop_density;
    }

    public float getBirth_rate() {
        return birth_rate;
    }

    public void setBirth_rate(float birth_rate) {
        this.birth_rate = birth_rate;
    }

    public float getDeath_rate() {
        return death_rate;
    }

    public void setDeath_rate(float death_rate) {
        this.death_rate = death_rate;
    }
}