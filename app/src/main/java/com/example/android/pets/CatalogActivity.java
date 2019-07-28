/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.pets;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.android.pets.data.Pet;
import com.example.android.pets.data.PetContract.PetEntry;

public class CatalogActivity extends AppCompatActivity {

    private PetAdapter petAdapter;
    private PetListViewModel petListViewModel;
    private RecyclerView petListView;
    private View emptyView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog);

        petListView = findViewById(R.id.list);
        emptyView = findViewById(R.id.empty_view);

        petAdapter = new PetAdapter();
        petListView.setLayoutManager(new LinearLayoutManager(this));
        petListView.setAdapter(petAdapter);

        petListViewModel = ViewModelProviders.of(this).get(PetListViewModel.class);
        petListViewModel.getPets().observe(this, pets -> {
            if (pets != null && pets.size() > 0) {
                emptyView.setVisibility(View.GONE);
                petListView.setVisibility(View.VISIBLE);
                petAdapter.setPets(pets);
            } else {
                emptyView.setVisibility(View.VISIBLE);
                petListView.setVisibility(View.GONE);
            }
        });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> {
            Intent intent = new Intent(CatalogActivity.this, EditorActivity.class);
            startActivity(intent);
        });
    }

    private void insertPet() {
        Pet pet = new Pet("Toto", "Terrier", PetEntry.GENDER_MALE, 7);
        petListViewModel.insertDummyPet(pet);
    }

    private void deleteAllPets() {
        petListViewModel.deleteAllPets();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_catalog, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_insert_dummy_data:
                insertPet();
                return true;
            case R.id.action_delete_all_entries:
                deleteAllPets();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
