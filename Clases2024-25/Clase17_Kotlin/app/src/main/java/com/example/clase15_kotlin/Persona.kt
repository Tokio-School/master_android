package com.example.clase15_kotlin

data class Persona(var nombre: String, val edad: Int = 18 , val peso: Double=0.0,val soltero: Boolean? = false, var colorFavorito:ColorFavorito=ColorFavorito.ROJO_C): Simpatico, SerHumano(true) {
   /* fun saludar(otraPersona: Persona):String {
        return "Hola, mi nombre es $nombre y tengo ${edad} años, y te saludo a ti" +
                " ${otraPersona.nombre} que tienes ${otraPersona.edad} años"
    }*/
    constructor(nombre:String):this(nombre,18,0.0,false,ColorFavorito.ROJO_C){
        this.nombre = "---"+nombre+"---"
    }
    override fun saludar(otraPersona: Persona): String {
        return "Hola, mi nombre es $nombre y tengo ${edad} años, y te saludo a ti" +
                " ${otraPersona.nombre} que tienes ${otraPersona.edad} años"

    }
    override fun saludarDesdeElMasAlla(): String {
        return "Hola desde el mas alla (De la propia Clase Persona)"
    }

    override fun toString(): String {
        return nombre
    }


    inner class Mascota(var nombreMascota:String, var edadMascota:Int):Simpatico


}
