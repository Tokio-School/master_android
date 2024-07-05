package com.victorvergel.clase39_appplaystore

import java.time.LocalDate

/**
 * Se trata de una clase que permitirá crear objetos de tipo Persona.
 *
 * @property nombre Es el nombre que se recibe para asignar a la persona
 * @property edad Es la edad que se recibe para asignar a la persona
 * @property fecha_nacimiento
 */
data class Persona(var nombre:String,var edad:Int,var fecha_nacimiento:LocalDate)
{
    /**
     * Función que permite saber si la persona es mayor de edad.
     *
     * @return Devolverá verdadero si el usuario es mayor de edad.
     */
    fun esMayorDeEdad():Boolean
    {
        return edad >= 18
    }

    /**
     * Sumamos los años que introduzcan por parámetro.
     * <B>IMPORTANTE</B>
     *
     * @param anosASumar
     */
    fun incrementarEdad(anosASumar:Int)
    {
        edad+=anosASumar
    }

}
