package com.example.clase25_basedatosfinal;

import androidx.room.Database;

@Database(entities = {Persona.class}, version = 1)
public abstract class BD extends androidx.room.RoomDatabase{
    public abstract PersonaDAO personaDao();
}
