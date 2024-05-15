package com.example.clase32_kotlinrecyclerviewlivedata

data class Persona(val nombre: String, val edad: Int)

class PersonaLiveData(initialValue: Persona) : androidx.lifecycle.MutableLiveData<Persona>(initialValue)