package com.tokioschol.miprimeraappkotlin

open class Moto: Vehiculo() {

    var cilindrada:Int = 100

    override val tipoMotor: String
        get() = "2 cilindros"

    override fun getTipoMoto() {
        print("soy la moto")
    }

    override fun getPrueba(nombreCoche: String) {
       print("soy la moto")
    }
}