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
    private float contact;

    @Column(nullable = false)
    private float vaccine;

    @Column(nullable = false)
    private float birth_rate;

    @Column(nullable = false)
    private float death_rate;

    public Locacity() {
    }

    @Override
    public String toString() {
        return String.format(name);
    }

    public Locacity(String name, int population, float contact, float birth_rate, float death_rate, float vaccine) {
        this.name = name;
        this.population = population;
        this.contact = contact;
        this.birth_rate = birth_rate;
        this.death_rate = death_rate;
        this.death_rate = vaccine;
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

    public float getContact() {
        return contact;
    }

    public void setContact(float contact) {
        this.contact = contact;
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

    public float getVaccine() {
        return vaccine;
    }

    public void setVaccine(float vaccine) {
        this.vaccine = vaccine;
    }
}