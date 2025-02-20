package com.example.clase12_persistencia;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Persona.class}, version = 1)
public abstract class BD extends RoomDatabase {
    public abstract PersonaDAO personaDao();
}
