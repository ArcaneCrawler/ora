package com.math.epidemic.Entities;

import javafx.beans.property.*;

public class JournalDto {

    private LongProperty id;
    private StringProperty date;
    private IntegerProperty popul_left;
    private IntegerProperty popul_daed;
    private FloatProperty suspected;
    private FloatProperty latent;
    private FloatProperty infected;
    private FloatProperty cured;

    public JournalDto() {
        this.id = new SimpleLongProperty();
        this.date = new SimpleStringProperty();
        this.popul_left = new SimpleIntegerProperty();
        this.popul_daed = new SimpleIntegerProperty();
        this.suspected = new SimpleFloatProperty();
        this.latent = new SimpleFloatProperty();
        this.infected = new SimpleFloatProperty();
        this.cured = new SimpleFloatProperty();
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

    public String getDate() {
        return date.get();
    }

    public StringProperty dateProperty() {
        return date;
    }

    public void setDate(String date) {
        this.date.set(date);
    }

    public int getPopul_left() {
        return popul_left.get();
    }

    public IntegerProperty popul_leftProperty() {
        return popul_left;
    }

    public void setPopul_left(int popul_left) {
        this.popul_left.set(popul_left);
    }

    public int getPopul_daed() {
        return popul_daed.get();
    }

    public IntegerProperty popul_daedProperty() {
        return popul_daed;
    }

    public void setPopul_daed(int popul_daed) {
        this.popul_daed.set(popul_daed);
    }

    public float getSuspected() {
        return suspected.get();
    }

    public FloatProperty suspectedProperty() {
        return suspected;
    }

    public void setSuspected(float suspected) {
        this.suspected.set(suspected);
    }

    public float getLatent() {
        return latent.get();
    }

    public FloatProperty latentProperty() {
        return latent;
    }

    public void setLatent(float latent) {
        this.latent.set(latent);
    }

    public float getInfected() {
        return infected.get();
    }

    public FloatProperty infectedProperty() {
        return infected;
    }

    public void setInfected(float infected) {
        this.infected.set(infected);
    }

    public float getCured() {
        return cured.get();
    }

    public FloatProperty curedProperty() {
        return cured;
    }

    public void setCured(float cured) {
        this.cured.set(cured);
    }
}
