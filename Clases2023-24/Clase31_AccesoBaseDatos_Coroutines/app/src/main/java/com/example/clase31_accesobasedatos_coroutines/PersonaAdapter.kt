package com.example.clase31_accesobasedatos_coroutines

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.clase31_accesobasedatos_coroutines.databinding.PersonaBinding
import com.google.android.material.snackbar.Snackbar


class PersonaAdapter(val personas: MutableList<Persona>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    lateinit var binding: PersonaBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        binding= PersonaBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return PersonaViewHolder(binding.root)
    }

    class PersonaViewHolder(root: View) : RecyclerView.ViewHolder(root) {

    }


    override fun getItemCount(): Int {
        return personas.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        binding.persona=personas.get(position)
        binding.cvPersona.setOnClickListener(){
            Snackbar.make(it, "Persona seleccionada: "+personas.get(position).id, Snackbar.LENGTH_SHORT).show()
        }
    }

}
