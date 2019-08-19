package com.example.android.pets;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.example.android.pets.data.Pet;
import com.example.android.pets.data.PetRepository;

public class PetDetailViewModel extends AndroidViewModel {

    private PetRepository petRepository;
    private int id;

    public PetDetailViewModel(@NonNull Application application, int petId) {
        super(application);
        petRepository = new PetRepository(application);
        id = petId;
    }

    public LiveData<Pet> getPet() {
        return petRepository.getPet(id);
    }

    public void deletePet(int petId) {
        petRepository.deletePet(petId);
    }

    public void updatePet(Pet pet) {
        petRepository.updatePet(pet);
    }

    public void insertPet(Pet pet) {
        petRepository.insertPet(pet);
    }
}
