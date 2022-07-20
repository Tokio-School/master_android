package com.tokioschol.travellingkotlin.domain.usecase

import com.facebook.AccessToken
import com.tokioschol.travellingkotlin.core.base.FlowUseCase
import com.tokioschol.travellingkotlin.core.di.domain.di.IoDispatcher
import com.tokioschol.travellingkotlin.domain.models.User
import com.tokioschol.travellingkotlin.domain.repository.LoginRespository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetLogInFacebookUseCase @Inject constructor(
    @IoDispatcher dispatcher: CoroutineDispatcher,
    private val loginRespository: LoginRespository
): FlowUseCase<AccessToken, User>(dispatcher) {

    override fun execute(params: AccessToken): Flow<User> =
        loginRespository.logInFaceBook(params)

}