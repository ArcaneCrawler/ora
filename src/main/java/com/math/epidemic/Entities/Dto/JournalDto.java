package com.math.epidemic.Entities.Dto;

import javafx.beans.property.*;

public class JournalDto {

    private LongProperty id;
    private StringProperty date;
    private FloatProperty popul_left;
    private FloatProperty popul_daed;
    private FloatProperty suspected;
    private FloatProperty latent;
    private FloatProperty infected;
    private FloatProperty cured;
    private FloatProperty chem;
    private StringProperty model_lype;
    private StringProperty virus;
    private StringProperty locacity;

    public JournalDto() {
        this.id = new SimpleLongProperty();
        this.date = new SimpleStringProperty();
        this.popul_left = new SimpleFloatProperty();
        this.popul_daed = new SimpleFloatProperty();
        this.suspected = new SimpleFloatProperty();
        this.latent = new SimpleFloatProperty();
        this.infected = new SimpleFloatProperty();
        this.cured = new SimpleFloatProperty();
        this.chem = new SimpleFloatProperty();
        this.model_lype = new SimpleStringProperty();
        this.virus = new SimpleStringProperty();
        this.locacity = new SimpleStringProperty();
    }

    public long getId() {
        return id.get();
    }

    public void setId(long id) {
        this.id.set(id);
    }

    public LongProperty idProperty() {
        return id;
    }

    public String getDate() {
        return date.get();
    }

    public void setDate(String date) {
        this.date.set(date);
    }

    public StringProperty dateProperty() {
        return date;
    }


    public float getSuspected() {
        return suspected.get();
    }

    public void setSuspected(float suspected) {
        this.suspected.set(suspected);
    }

    public FloatProperty suspectedProperty() {
        return suspected;
    }

    public float getLatent() {
        return latent.get();
    }

    public void setLatent(float latent) {
        this.latent.set(latent);
    }

    public FloatProperty latentProperty() {
        return latent;
    }

    public float getInfected() {
        return infected.get();
    }

    public void setInfected(float infected) {
        this.infected.set(infected);
    }

    public FloatProperty infectedProperty() {
        return infected;
    }

    public float getCured() {
        return cured.get();
    }

    public void setCured(float cured) {
        this.cured.set(cured);
    }

    public FloatProperty curedProperty() {
        return cured;
    }

    public float getChem() {
        return chem.get();
    }

    public FloatProperty chemProperty() {
        return chem;
    }

    public void setChem(float chem) {
        this.chem.set(chem);
    }

    public String getModel_lype() {
        return model_lype.get();
    }

    public StringProperty model_lypeProperty() {
        return model_lype;
    }

    public void setModel_lype(String model_lype) {
        this.model_lype.set(model_lype);
    }



    public float getPopul_daed() {
        return popul_daed.get();
    }

    public FloatProperty popul_daedProperty() {
        return popul_daed;
    }

    public void setPopul_daed(float popul_daed) {
        this.popul_daed.set(popul_daed);
    }

    public float getPopul_left() {
        return popul_left.get();
    }

    public FloatProperty popul_leftProperty() {
        return popul_left;
    }

    public void setPopul_left(float popul_left) {
        this.popul_left.set(popul_left);
    }


    public String getVirus() {
        return virus.get();
    }

    public StringProperty virusProperty() {
        return virus;
    }

    public void setVirus(String virus) {
        this.virus.set(virus);
    }

    public String getLocacity() {
        return locacity.get();
    }

    public StringProperty locacityProperty() {
        return locacity;
    }

    public void setLocacity(String locacity) {
        this.locacity.set(locacity);
    }
}
