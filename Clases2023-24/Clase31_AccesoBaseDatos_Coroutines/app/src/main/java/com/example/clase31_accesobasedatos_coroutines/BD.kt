package com.example.clase31_accesobasedatos_coroutines

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Persona::class], version = 1)
public abstract class BD : RoomDatabase() {
    abstract fun personaDao(): PersonaDao
}