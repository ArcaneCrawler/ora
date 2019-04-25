package com.math.epidemic.Entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "VirusType")
public class VirusType implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String type;

    public VirusType(String type) {
        this.type = type;
    }

    public VirusType() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}