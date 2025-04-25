package com.example.clase15_kotlin

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.clase15_kotlin.databinding.PersonaBinding

class AdaptadorPersona(private val listaPersonas:MutableList<Persona>) :RecyclerView.Adapter<AdaptadorPersona.PersonaViewHolder>(){
    inner class PersonaViewHolder(private val binding:PersonaBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(persona: Persona){
            binding.personaItem=persona

            binding.ivBorrar.setOnClickListener(){
                listaPersonas.removeAt(adapterPosition)
                notifyItemRemoved(adapterPosition)
            }


        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonaViewHolder {
        val binding=PersonaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PersonaViewHolder(binding)
    }

    /*override fun getItemCount(): Int {
        return listaPersonas.size
    }*/
    override fun getItemCount(): Int = listaPersonas.size

    override fun onBindViewHolder(holder: PersonaViewHolder, position: Int) {
        holder.bind(listaPersonas[position])
    }
}