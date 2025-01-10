package com.example.clase08_recyclerview;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.example.clase08_recyclerview.databinding.PersonaItemBinding;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class AdaptadorPersona extends RecyclerView.Adapter<AdaptadorPersona.PersonaViewHolder> {

    private final List<Persona> listaPersonas;

    public AdaptadorPersona(List<Persona> listaPersonas) {
        this.listaPersonas = listaPersonas;
    }


    // Se ejecuta cuando el RecyclerView necesita una nueva vista para mostrar un elemento.
    @Override
    public PersonaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        PersonaItemBinding binding = PersonaItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new PersonaViewHolder(binding);
    }

    //Vincula datos específicos a una vista existente
    @Override
    public void onBindViewHolder(PersonaViewHolder holder, int position) {
        Persona persona = listaPersonas.get(position);
        holder.bind(persona);
    }

    @Override
    public int getItemCount() {
        return listaPersonas.size();
    }


    //Cada una de las filas
    class PersonaViewHolder extends RecyclerView.ViewHolder {
        private final PersonaItemBinding binding;

        public PersonaViewHolder(PersonaItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Persona persona) {
            // Asignar valores al binding
            binding.setPersona(persona);

            // Manejo del botón borrar
            binding.imBorrar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int posicion = getAdapterPosition();
                    if (posicion != RecyclerView.NO_POSITION) {
                        listaPersonas.remove(posicion);
                        notifyItemRemoved(posicion);
                    }
                }
            });
            binding.lyPrincipalPersona.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    Snackbar.make(view, "Persona: " + persona.getNombre(), Snackbar.LENGTH_SHORT).show();
                    Intent intent = new Intent(view.getContext(), ActivityPersona.class);
                    intent.putExtra("persona", persona);
                    view.getContext().startActivity(intent);
                    return false;
                }
            });
        }
    }
}