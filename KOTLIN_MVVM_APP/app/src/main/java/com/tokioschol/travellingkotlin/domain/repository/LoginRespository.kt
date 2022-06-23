package com.tokioschol.travellingkotlin.domain.repository

import com.tokioschol.travellingkotlin.domain.models.User
import kotlinx.coroutines.flow.Flow

interface LoginRespository {
    fun logIn(userName:String, password:String): Flow<User>
    suspend fun logInFaceBook(token: String): User
}