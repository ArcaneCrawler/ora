package com.math.epidemic.Entities;


import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Journal")
public class Journal implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = true)
    private String date;

    @Column(nullable = false)
    private int popul_left;

    @Column(nullable = false)
    private int popul_daed;

    @Column(nullable = true)
    private float suspected;

    @Column(nullable = true)
    private float latent;

    @Column(nullable = true)
    private float infected;

    @Column(nullable = true)
    private float cured;

    @Column(nullable = true)
    private float chem;

    @Column(nullable = true)
    private String model_type;

    @Column(nullable = true)
    private String virus;

    @Column(nullable = true)
    private String locacity;

    /*@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Virus_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Virus virus1;*/

    /*@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Locacity_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Locacity locacity1;*/

    public Journal(String date, int popul_left, int popul_daed, float suspected, float latent, float infected, float cured, float chem, String virus, String locacity, String model_type) {
        this.date = date;
        this.popul_left = popul_left;
        this.popul_daed = popul_daed;
        this.suspected = suspected;
        this.latent = latent;
        this.infected = infected;
        this.cured = cured;
        this.chem = chem;
        this.virus = virus;
        this.locacity = locacity;
        this.model_type = model_type;
    }

    public Journal() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getPopul_left() {
        return popul_left;
    }

    public void setPopul_left(int popul_left) {
        this.popul_left = popul_left;
    }

    public int getPopul_daed() {
        return popul_daed;
    }

    public void setPopul_daed(int popul_daed) {
        this.popul_daed = popul_daed;
    }

    public float getSuspected() {
        return suspected;
    }

    public void setSuspected(float suspected) {
        this.suspected = suspected;
    }

    public float getLatent() {
        return latent;
    }

    public void setLatent(float latent) {
        this.latent = latent;
    }

    public float getInfected() {
        return infected;
    }

    public void setInfected(float infected) {
        this.infected = infected;
    }

    public float getCured() {
        return cured;
    }

    public void setCured(float cured) {
        this.cured = cured;
    }



    public float getChem() {
        return chem;
    }

    public void setChem(float chem) {
        this.chem = chem;
    }

    public String getModel_type() {
        return model_type;
    }

    public void setModel_type(String model_type) {
        this.model_type = model_type;
    }

    public String getLocacity() {
        return locacity;
    }

    public void setLocacity(String locacity) {
        this.locacity = locacity;
    }

    public String getVirus() {
        return virus;
    }

    public void setVirus(String virus) {
        this.virus = virus;
    }
}