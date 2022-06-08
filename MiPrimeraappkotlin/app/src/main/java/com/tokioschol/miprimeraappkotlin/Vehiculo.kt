package com.tokioschol.miprimeraappkotlin

import android.util.Log

abstract class Vehiculo {
     var combustible:String?=null

    abstract val tipoMotor:String

    abstract fun getTipoMoto()

    open fun getPrueba(value:String){
        value agregar "cc"
        combustible?.let {
            Log.e("manel", "el combustible es $it con un poco de $value")
        }
    }
}