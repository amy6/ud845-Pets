package com.example.android.pets.data;

import android.app.Application;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.example.android.pets.PetDetailViewModel;

public class PetDetailViewModelFactory implements ViewModelProvider.Factory {

    private Application application;
    private int petId;

    public PetDetailViewModelFactory(Application application, int petId) {
        this.application = application;
        this.petId = petId;
    }

    @NonNull @Override public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass == PetDetailViewModel.class) {
            return (T) new PetDetailViewModel(application, petId);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
