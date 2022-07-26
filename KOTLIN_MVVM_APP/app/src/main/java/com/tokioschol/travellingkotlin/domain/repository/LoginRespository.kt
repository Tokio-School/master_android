package com.tokioschol.travellingkotlin.domain.repository

import com.facebook.AccessToken
import com.tokioschol.travellingkotlin.domain.models.User
import kotlinx.coroutines.flow.Flow

interface LoginRespository {
    fun logIn(userName:String, password:String): Flow<User>
    fun logInFaceBook(token: AccessToken): Flow<User>
}