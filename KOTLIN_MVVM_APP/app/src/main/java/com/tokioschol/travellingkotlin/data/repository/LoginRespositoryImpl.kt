package com.tokioschol.travellingkotlin.data.repository

import com.tokioschol.travellingkotlin.data.datasource.LoginDatasource
import com.tokioschol.travellingkotlin.data.mappers.mapToUser
import com.tokioschol.travellingkotlin.domain.models.User
import com.tokioschol.travellingkotlin.domain.repository.LoginRespository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class LoginRespositoryImpl @Inject constructor(
    private val loginDatasource: LoginDatasource
): LoginRespository {

    override fun logIn(userName: String, password: String): Flow<User>  =
        loginDatasource.logIng(userName,password).map { it.mapToUser() }


    override suspend fun logInFaceBook(token: String): User {
        delay(5000)
        //Comprobamos el token y devolvemos usuario
        return User("Jose","Apellido",23)
    }
}