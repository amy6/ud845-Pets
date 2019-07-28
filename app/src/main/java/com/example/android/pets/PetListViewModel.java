package com.example.android.pets;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.example.android.pets.data.Pet;
import com.example.android.pets.data.PetRepository;

import java.util.List;

public class PetListViewModel extends AndroidViewModel {

    private PetRepository petRepository;
    private LiveData<List<Pet>> pets;

    public PetListViewModel(@NonNull Application application) {
        super(application);
        petRepository = new PetRepository(application);
        pets = petRepository.getPets();
    }

    public LiveData<List<Pet>> getPets() {
        return pets;
    }

    public void insertDummyPet(Pet dummyPet) {
        petRepository.insertPet(dummyPet);
    }

    public void deleteAllPets( List<Pet> pets) {
        petRepository.deletePets(pets);
    }
}
