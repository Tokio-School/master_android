package com.tokioschol.travellingkotlin.domain.repository

import com.tokioschol.travellingkotlin.domain.models.User

interface LoginRespository {
    fun logIn(userName:String,password:String): User
}