package com.tokioschol.travellingkotlin.domain.usecase

import com.tokioschol.travellingkotlin.core.base.FlowUseCase
import com.tokioschol.travellingkotlin.core.di.domain.di.IoDispatcher
import com.tokioschol.travellingkotlin.domain.models.User
import com.tokioschol.travellingkotlin.domain.repository.LoginRespository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetLogInUseCase @Inject constructor(
    @IoDispatcher dispatcher: CoroutineDispatcher,
    private val loginRespository: LoginRespository
): FlowUseCase<GetLogInUseCase.Params, User>(dispatcher) {

    override fun execute(params: Params): Flow<User> =
        loginRespository.logIn(params.userName,params.password)


    data class Params(val userName:String, val password:String)
}