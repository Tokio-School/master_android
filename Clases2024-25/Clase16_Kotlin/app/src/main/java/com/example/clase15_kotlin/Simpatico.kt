package com.example.clase15_kotlin

interface Simpatico {
    fun saludar(otraPersona: Persona):String {
        return "Hola, mi nombre es ${otraPersona.nombre} y tengo ${otraPersona.edad} años"
    }
}