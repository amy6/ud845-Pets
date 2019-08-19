package com.example.android.pets.data;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface PetDao {

    @Insert
    void insertPet(Pet pet);

    @Query("SELECT * FROM pets")
    LiveData<List<Pet>> getPets();

    @Query("SELECT * FROM pets WHERE id = :id")
    LiveData<Pet> getPet(int id);

    @Update()
    void updatePet(Pet pet);

    @Delete
    void deletePet(Pet pet);

    @Query("DELETE FROM pets")
    void deleteAllPets();

}
