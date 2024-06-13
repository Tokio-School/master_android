package com.example.repasoaplicaciongastos.services

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.repasoaplicaciongastos.dao.UsuarioDao
import com.example.repasoaplicaciongastos.entities.Categoria
import com.example.repasoaplicaciongastos.entities.Gasto
import com.example.repasoaplicaciongastos.entities.Usuario

@Database(entities = [Usuario::class], version = 1)
public abstract class BD : RoomDatabase(){
    abstract fun usuarioDao(): UsuarioDao
}