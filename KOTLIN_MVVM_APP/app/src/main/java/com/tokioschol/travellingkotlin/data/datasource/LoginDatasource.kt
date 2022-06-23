package com.tokioschol.travellingkotlin.data.datasource

import com.tokioschol.travellingkotlin.data.response.UserResponse
import kotlinx.coroutines.flow.Flow

interface LoginDatasource {
    fun registerUser()
    fun logOut()
    fun logIng(user: String, pass: String): Flow<UserResponse>
}