package com.example.repasoaplicaciongastos.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "usuario")
data class Usuario(
    @PrimaryKey(autoGenerate = true) var idUsuario: Int,
    @ColumnInfo var nombre :String,
    @ColumnInfo var contrasena:String) {
    constructor(nombre :String, contrasena:String) : this(0,nombre,contrasena)

    override fun toString(): String {
        return "Usuario(nombre='$nombre', contrasena='$contrasena', idUsuario=$idUsuario)"
    }
}
