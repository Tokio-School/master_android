package com.example.clase25_basedatosfinal;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public abstract class PersonaDAO {

    @Query("SELECT * FROM persona ORDER BY id ASC")
    public abstract List<Persona> getAll();

    @Insert
    public abstract void insertaPersona(Persona persona );

    @Delete
    public abstract void deletePersona(Persona p);

    @Update
    public abstract void actualizaPersona(Persona persona);

}
