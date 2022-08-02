package com.tokioschol.travellingkotlin.data.repository

import android.content.Context
import android.util.Log
import com.facebook.AccessToken
import com.google.firebase.auth.FacebookAuthProvider
import com.google.firebase.auth.FirebaseAuth
import com.tokioschol.travellingkotlin.data.datasource.LoginDatasource
import com.tokioschol.travellingkotlin.data.mappers.mapToUser
import com.tokioschol.travellingkotlin.domain.models.User
import com.tokioschol.travellingkotlin.domain.repository.LoginRespository
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class LoginRespositoryImpl @Inject constructor(
    private val loginDatasource: LoginDatasource,
    @ApplicationContext private val context: Context,
    private val auth: FirebaseAuth,
) : LoginRespository {

    override fun logIn(userName: String, password: String): Flow<User> =
        loginDatasource.logIng(userName, password).map { it.mapToUser() }


    override fun logInFaceBook(token: AccessToken): Flow<User> = flow {
        kotlin.run {
            val credential = FacebookAuthProvider.getCredential(token.token)
            auth.signInWithCredential(credential).await()?.let { authResult ->
                emit(authResult.mapToUser())
            }
        }
    }
}