package com.example.clase20_coroutines

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "persona")
data class Persona(@PrimaryKey(autoGenerate = true)
                   val id:Int = 0,
                   @ColumnInfo(name = "nombre")
                    val nombre:String) {
    override fun toString(): String {
        return nombre
    }
    constructor(nombre: String) : this(0, nombre)
}
