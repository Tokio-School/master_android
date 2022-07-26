package com.tokioschol.travellingkotlin.data.datasource.impl

import com.tokioschol.travellingkotlin.data.api.ApiLogin
import com.tokioschol.travellingkotlin.data.datasource.LoginDatasource
import com.tokioschol.travellingkotlin.data.response.UserResponse
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class LoginDatasourceImpl @Inject constructor(
 private val apiLogin: ApiLogin
): LoginDatasource {

    override fun logIng(user:String, pass:String): Flow<UserResponse>  = flow {
        delay(5000)
        emit(apiLogin.logInUser(mapOf("usuario" to user, "password" to pass )))
    }


    override fun registerUser() {
        TODO("Not yet implemented")
    }

    override fun logOut() {
        TODO("Not yet implemented")
    }
}