package com.example.clase15_kotlin

data class Persona(var nombre: String, val edad: Int = 18 , val peso: Double=0.0,val soltero: Boolean? = false) {
    fun saludar(otraPersona: Persona):String {
        return "Hola, mi nombre es $nombre y tengo ${edad} años, y te saludo a ti" +
                " ${otraPersona.nombre} que tienes ${otraPersona.edad} años"
    }
}
