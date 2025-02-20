package com.example.clase12_persistencia;

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

    @Query("DELETE FROM persona WHERE id = :id")
    public abstract void deletePersona(int id);


    @Update
    public abstract void actualizaPersona(Persona persona);

    @Query("UPDATE persona SET nombre = :nombre, edad = :edad, direccion = :direccion WHERE id = :id")
    public abstract void actualizaPersona2(int id, String nombre, int edad, String direccion);


}

