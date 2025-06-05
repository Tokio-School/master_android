package com.example.clase20_coroutines

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface PersonaDao {
    @Insert
    suspend fun insertPersona(vararg persona: Persona)
}
