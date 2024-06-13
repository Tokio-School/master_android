package com.example.clase31_accesobasedatos_coroutines

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "persona")
data class Persona(
                    @PrimaryKey(autoGenerate = true) var id: Int,
                    @ColumnInfo var nombre :String,
                   @ColumnInfo var edad : Int,
                   @ColumnInfo var direccion:String) {
    constructor(nombre :String, edad : Int, direccion:String) : this(0,nombre,edad,direccion)
    override fun toString(): String {
        return "Persona(nombre='$nombre', edad=$edad, direccion='$direccion', id=$id)"
    }
}
