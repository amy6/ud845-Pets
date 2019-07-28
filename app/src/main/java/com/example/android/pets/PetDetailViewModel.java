package com.example.android.pets;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.example.android.pets.data.Pet;
import com.example.android.pets.data.PetRepository;

public class PetDetailViewModel extends AndroidViewModel {

    private PetRepository petRepository;

    public PetDetailViewModel(@NonNull Application application) {
        super(application);
        petRepository = new PetRepository(application);
    }

    public void deletePet(Pet pet) {
        petRepository.deletePet(pet);
    }

    public void updatePet(Pet pet) {
        petRepository.updatePet(pet);
    }

    public void insertPet(Pet pet) {
        petRepository.insertPet(pet);
    }
}
