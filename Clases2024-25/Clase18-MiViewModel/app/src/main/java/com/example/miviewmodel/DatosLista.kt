package com.example.miviewmodel

import android.R
import android.widget.ArrayAdapter
import androidx.lifecycle.ViewModel

class DatosLista : ViewModel() {
    var listaNombre= mutableListOf<Persona>(
        Persona("Pedro", 20),
        Persona("Juan", 25),
        Persona("Maria", 30),
        Persona("Jose", 35)
    )
    /*var adaptadorLista= ArrayAdapter<String>(this, R.layout.simple_list_item_1,listaNombre)
    fun agregarNombre(nombre: String) {
        listaNombre.add(nombre)
        adaptadorLista.notifyDataSetChanged()
    }*/
}