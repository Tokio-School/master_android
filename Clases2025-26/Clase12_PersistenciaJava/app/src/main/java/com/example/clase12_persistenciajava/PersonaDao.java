package com.example.clase12_persistenciajava;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public abstract class PersonaDao {
    @Insert
    public abstract void insertar(Persona persona);

    @Query("SELECT * FROM persona")
    public abstract List<Persona> listar();

    /*@Delete
    public abstract void borrar(Persona persona);*/

    @Query("DELETE FROM persona WHERE id=:id")
    public abstract void borrar(int id);



}
