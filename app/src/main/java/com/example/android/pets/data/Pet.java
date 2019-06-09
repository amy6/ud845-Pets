package com.example.android.pets.data;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "pets")
public class Pet {

    @PrimaryKey
    private int id;
    private String name;
    private String breed;
    private int gender;
    private double weight;

    public Pet(int id, String name, String breed, int gender, double weight) {
        this.id = id;
        this.name = name;
        this.breed = breed;
        this.gender = gender;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBreed() {
        return breed;
    }

    public int getGender() {
        return gender;
    }

    public double getWeight() {
        return weight;
    }
}
