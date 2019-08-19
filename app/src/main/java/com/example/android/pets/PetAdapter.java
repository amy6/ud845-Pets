package com.example.android.pets;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.pets.data.Pet;

import java.util.List;

public class PetAdapter extends RecyclerView.Adapter<PetAdapter.PetViewHolder> {

    public static final String PET_ID = "pet_id";
    private List<Pet> pets;

    @NonNull @Override public PetViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new PetViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item,
                viewGroup, false));
    }

    @Override public void onBindViewHolder(@NonNull PetViewHolder petViewHolder, int i) {
        Pet pet = pets.get(i);
        if (pet != null) {
            petViewHolder.name.setText(pet.getName());
            petViewHolder.summary.setText(pet.getBreed());
        }
    }

    @Override public int getItemCount() {
        return pets != null ? pets.size() : 0;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
        notifyDataSetChanged();
    }

    class PetViewHolder extends RecyclerView.ViewHolder {

        private TextView name;
        private TextView summary;

        PetViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            summary = itemView.findViewById(R.id.summary);

            itemView.setOnClickListener(v -> {
                Pet pet = pets.get(getAdapterPosition());
                Intent intent = new Intent(itemView.getContext(), EditorActivity.class);
                intent.putExtra(PET_ID, pet.getId());
                itemView.getContext().startActivity(intent);
            });
        }
    }
}
