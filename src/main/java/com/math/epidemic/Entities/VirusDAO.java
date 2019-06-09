package com.math.epidemic.Entities;


public interface VirusDAO {

    void insert(Virus virus);
    Virus findById(int id);
}