package com.tokioschol.travellingkotlin.data.repository

import com.tokioschol.travellingkotlin.domain.models.User
import com.tokioschol.travellingkotlin.domain.repository.LoginRespository
import kotlinx.coroutines.delay
import javax.inject.Inject

class LoginRespositoryImpl @Inject constructor(): LoginRespository {

    override suspend fun logIn(userName: String, password: String): User {
        delay(5000)
        return User("Manel","password",32)
    }
}