package com.example.clase08_recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.clase08_recyclerview.databinding.PersonaItemBinding;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class __MiPersonaAdapter extends RecyclerView.Adapter {
    private ArrayList<Persona> personas;
    PersonaItemBinding binding;


    public __MiPersonaAdapter(ArrayList<Persona> personas) {
        this.personas=personas;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding=PersonaItemBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new PersonaViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        PersonaViewHolder personaViewHolder=(PersonaViewHolder)holder;
        binding.setPersona(personas.get(position));

        binding.imBorrar.setOnClickListener(v->{
            personas.remove(position);
            notifyItemRemoved(position);
        });
        binding.tvNombre.setOnClickListener(v->{
            Snackbar.make(binding.getRoot(),personas.get(position).toString(),Snackbar.LENGTH_SHORT).show();
        });



    }

    @Override
    public int getItemCount() {
        return personas.size();
    }


    class PersonaViewHolder extends RecyclerView.ViewHolder{
        public PersonaViewHolder(@NonNull View view) {
            super(view);
        }
    }

}
