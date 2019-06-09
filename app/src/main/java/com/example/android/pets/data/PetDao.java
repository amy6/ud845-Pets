package com.example.android.pets.data;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface PetDao {

    @Query("SELECT * FROM pets")
    LiveData<List<Pet>> getPets();

    @Query("SELECT * FROM pets WHERE id = :id")
    Pet getPet(int id);

    @Delete
    void deletePet(Pet pet);

}
