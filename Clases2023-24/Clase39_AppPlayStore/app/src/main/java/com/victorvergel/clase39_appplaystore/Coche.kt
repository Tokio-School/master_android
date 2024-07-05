package com.victorvergel.clase39_appplaystore

/**
 * Coche
 *
 * @property cilindrada
 * @property marca
 * @constructor
 *
 * @param int
 * @param null
 */
data class Coche(var cilindrada:Int, var marca: String, var color: String)
{
    /**
     * Acelerar
     *
     * @param velocidad
     */
    fun acelerar(velocidad:Int)
    {

        println("El coche esta acelerando a $velocidad km/h")
    }

    /**
     * Frenar
     *
     */
    fun frenar()
    {
        println("El coche esta frenando")
    }

}
