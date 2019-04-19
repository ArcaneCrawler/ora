package com.math.epidemic.Entities;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Virus")
public class Virus implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private double incubTime;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "VirusType_ID", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private VirusType virusType;

    public Virus(String name, double incubTime, VirusType virusType) {
        this.name = name;
        this.incubTime = incubTime;
        this.virusType = virusType;
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

    public double getIncubTime() {
        return incubTime;
    }

    public void setIncubTime(double incubTime) {
        this.incubTime = incubTime;
    }

    public VirusType getVirusType() {
        return virusType;
    }

    public void setVirusType(VirusType virusType) {
        this.virusType = virusType;
    }
}
