package com.example.android.pets.data;

import android.app.Application;
import android.arch.lifecycle.LiveData;

import com.example.android.pets.AppExecutors;

import java.util.List;

public class PetRepository {

    private PetDao petDao;
    private AppExecutors appExecutors;

    private LiveData<List<Pet>> pets;

    public PetRepository(Application application) {
        petDao = PetDatabase.getInstance(application).PetDao();
        appExecutors = AppExecutors.getExecutorInstance();
        pets = petDao.getPets();
    }

    public LiveData<List<Pet>> getPets() {
        return pets;
    }

    public Pet getPet(int id) {
        return petDao.getPet(id);
    }

    public void updatePet(Pet pet) {
        appExecutors.getDiskIO().execute(() -> {
            petDao.updatePet(pet);
        });
    }

    public void insertPet(Pet pet) {
        appExecutors.getDiskIO().execute(() -> {
            petDao.insertPet(pet);
        });
    }

    public void deletePet(Pet pet) {
        appExecutors.getDiskIO().execute(() -> {
            petDao.deletePet(pet);
        });
    }

    public void deletePets() {
        appExecutors.getDiskIO().execute(() -> {
            petDao.deleteAllPets();
        });
    }
}
