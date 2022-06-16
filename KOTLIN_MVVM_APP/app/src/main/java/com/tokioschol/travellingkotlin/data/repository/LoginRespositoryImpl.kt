package com.tokioschol.travellingkotlin.data.repository

import com.tokioschol.travellingkotlin.domain.models.User
import com.tokioschol.travellingkotlin.domain.repository.LoginRespository
import javax.inject.Inject

class LoginRespositoryImpl @Inject constructor(): LoginRespository {

    override fun logIn(userName: String, password: String): User {
        return User("maneu","password",32)
    }
}