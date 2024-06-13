package com.example.clase32_kotlinrecyclerviewlivedata

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.clase32_kotlinrecyclerviewlivedata.databinding.PersonaItemBinding

class PersonaAdapter(private val personas: MutableList<Persona>) :
    RecyclerView.Adapter<PersonaAdapter.PersonaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonaViewHolder {
        val binding = PersonaItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PersonaViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return personas.size
    }

    override fun onBindViewHolder(holder: PersonaViewHolder, position: Int) {
        holder.bind(personas[position])
    }



    inner class PersonaViewHolder(val binding: PersonaItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(persona: Persona){
            /*binding.nombreTextView.text = persona.nombre
            binding.edadTextView.text = "${persona.edad} años"*/
            binding.person = persona
        }
    }


}