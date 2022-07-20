package com.tokioschol.travellingkotlin.domain.usecase

import com.tokioschol.travellingkotlin.core.base.FlowUseCase
import com.tokioschol.travellingkotlin.core.di.domain.di.IoDispatcher
import com.tokioschol.travellingkotlin.domain.repository.LoginRespository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

class EjemploUseCase @Inject constructor(
    @IoDispatcher dispatcher: CoroutineDispatcher,
    private val userRepository: LoginRespository
) : FlowUseCase<String, String>(dispatcher) {

    override fun execute(params: String): Flow<String> {
       return  flowOf("hola")
    }


}