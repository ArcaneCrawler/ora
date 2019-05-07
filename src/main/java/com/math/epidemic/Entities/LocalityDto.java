package com.math.epidemic.Entities;

import javafx.beans.property.*;

public class LocalityDto {

    private LongProperty id;
    private StringProperty name;
    private IntegerProperty population;
    private FloatProperty pop_density;
    private FloatProperty birth_rate;
    private FloatProperty death_rate;

    public LocalityDto() {
        this.id = new SimpleLongProperty();
        this.name = new SimpleStringProperty();
        this.population = new SimpleIntegerProperty();
        this.pop_density = new SimpleFloatProperty();
        this.birth_rate = new SimpleFloatProperty();
        this.death_rate = new SimpleFloatProperty();

    }


    public long getId() {
        return id.get();
    }

    public LongProperty idProperty() {
        return id;
    }

    public void setId(long id) {
        this.id.set(id);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }


    public int getPopulation() {
        return population.get();
    }

    public IntegerProperty populationProperty() {
        return population;
    }

    public void setPopulation(int population) {
        this.population.set(population);
    }

    public float getPop_density() {
        return pop_density.get();
    }

    public FloatProperty pop_densityProperty() {
        return pop_density;
    }

    public void setPop_density(float pop_density) {
        this.pop_density.set(pop_density);
    }

    public float getBirth_rate() {
        return birth_rate.get();
    }

    public FloatProperty birth_rateProperty() {
        return birth_rate;
    }

    public void setBirth_rate(float birth_rate) {
        this.birth_rate.set(birth_rate);
    }

    public float getDeath_rate() {
        return death_rate.get();
    }

    public FloatProperty death_rateProperty() {
        return death_rate;
    }

    public void setDeath_rate(float death_rate) {
        this.death_rate.set(death_rate);
    }
}
