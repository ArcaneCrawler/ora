package com.math.epidemic.Entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Login")

public class Login implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String password;

      public Login() {
    }

    @Override
    public String toString() {
        return String.format(name);
    }

    public Login(String name, String password) {
        this.name = name;
        this.password = password;

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

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}