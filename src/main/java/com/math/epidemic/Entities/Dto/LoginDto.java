package com.math.epidemic.Entities.Dto;

import javafx.beans.property.*;

public class LoginDto {

    private LongProperty id;
    private StringProperty name;
    private StringProperty password;

    public LoginDto() {
        this.id = new SimpleLongProperty();
        this.name = new SimpleStringProperty();
        this.password = new SimpleStringProperty();

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

    public String getPassword() {
        return password.get();
    }

    public StringProperty passwordProperty() {
        return password;
    }

    public void setPassword(String password) {
        this.password.set(password);
    }
}
