package com.tokioschol.travellingkotlin.core.base


import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn


abstract class FlowUseCase<in P, R>(private val dispatcher: CoroutineDispatcher) {

    operator fun invoke(parameters: P): Flow<R> {
        return execute(parameters).flowOn(dispatcher)
    }

    abstract fun execute(params: P): Flow<R>
}
