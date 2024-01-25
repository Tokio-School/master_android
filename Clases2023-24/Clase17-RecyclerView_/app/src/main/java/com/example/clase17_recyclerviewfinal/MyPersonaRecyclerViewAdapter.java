package com.example.clase17_recyclerviewfinal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.clase17_recyclerviewfinal.databinding.PersonaBinding;

import java.util.List;

public class MyPersonaRecyclerViewAdapter extends RecyclerView.Adapter {
    List<Persona> personas;
    PersonaBinding binding;
    public MyPersonaRecyclerViewAdapter(List<Persona> personas) {
        this.personas=personas;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.persona ,parent,false);
        return new PersonaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        PersonaViewHolder personaViewHolder=(PersonaViewHolder)holder;
        binding.setPersona(personas.get(position));
    }

    @Override
    public int getItemCount() {
        return personas.size();
    }
    class PersonaViewHolder extends RecyclerView.ViewHolder{


        public PersonaViewHolder(@NonNull View view) {
            super(view);
            binding=PersonaBinding.bind(view);

        }
    }
}
