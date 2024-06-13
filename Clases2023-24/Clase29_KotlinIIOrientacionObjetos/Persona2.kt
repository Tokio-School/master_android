package com.example.clase29_orientacionobjetoskotlin

data class Persona2(var nombre: String, var edad: Int, var direccion: String, var color:ColorFavorito) : Simpatico,SerHumano(true)
{
    constructor(nombre: String): this(nombre, 0, "",ColorFavorito.ROJO_C)

    override fun saludo(nombre: String) {
        println("Hola $nombre")
    }

    override fun despedida(nombre: String) {
        println("Adios $nombre")
    }


    override fun toString(): String {
        return "Persona2(nombre='$nombre', edad=$edad, direccion='$direccion', vivo=$vivo, color=$color)"
    }
}
