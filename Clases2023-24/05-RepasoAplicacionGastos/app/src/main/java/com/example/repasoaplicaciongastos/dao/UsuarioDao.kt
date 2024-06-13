package com.example.repasoaplicaciongastos.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.repasoaplicaciongastos.entities.Usuario


@Dao
interface UsuarioDao {
    // CRUD - Create, Read, Update, Delete
    @Query("SELECT * FROM usuario ORDER BY idUsuario ASC")
    suspend fun getAll(): MutableList<Usuario>

   /* @Query("SELECT * FROM usuario WHERE idUsuario = (:userIds)")
    suspend fun getUsuarioById(userIds: IntArray): Usuario*/

    @Query("SELECT * FROM usuario WHERE nombre = (:userNombre)")
    suspend fun getUsuarioByNombre(userNombre: String): Usuario

    @Insert
    suspend fun insertUsuario(vararg usuario: Usuario)

    @Delete
    suspend fun deleteUsuario(user: Usuario)

    /** Opción 1
     * @Query("UPDATE persona SET nombre = :nombre, edad = :edad, direccion = :direccion WHERE id = :id")
     * suspend fun updatePersona(nombre: String, edad: Int, direccion: String, id: Int)
     */


    // Opción 2
    @Update
    suspend fun updateUsuario(user: Usuario)
    /*
   @Query("INSERT INTO persona (nombre, edad, direccion) VALUES (:nombre, :edad, :direccion)")
   fun insertPersona(nombre: String, edad: Int, direccion: String)
   */

}