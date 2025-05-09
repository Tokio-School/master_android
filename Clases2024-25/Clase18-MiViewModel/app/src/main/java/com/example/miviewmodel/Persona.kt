package com.example.miviewmodel

data class Persona(val  nombre: String, val  edad: Int) {
    override fun toString(): String {
        return nombre + " --> " + edad.toString()
    }
}
