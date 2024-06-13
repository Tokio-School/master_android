package com.example.clase31_accesobasedatos_coroutines

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface PersonaDao {
    //CRUD - Create, Read, Update, Delete
    @Query("SELECT * FROM persona ORDER BY id ASC")
    suspend fun getAll(): MutableList<Persona>

    @Query("SELECT * FROM persona WHERE id = (:personaIds)")
    suspend fun getPersonaById(personaIds: IntArray): Persona

    @Insert
    suspend fun insertPersona(vararg persona: Persona)

    @Delete
    suspend fun deletePersona(persona: Persona)

    /** Opción 1
     * @Query("UPDATE persona SET nombre = :nombre, edad = :edad, direccion = :direccion WHERE id = :id")
     * suspend fun updatePersona(nombre: String, edad: Int, direccion: String, id: Int)
     */


    // Opción 2
    @Update
     suspend fun updatePersona(persona: Persona)
     /*
    @Query("INSERT INTO persona (nombre, edad, direccion) VALUES (:nombre, :edad, :direccion)")
    fun insertPersona(nombre: String, edad: Int, direccion: String)
    */

}