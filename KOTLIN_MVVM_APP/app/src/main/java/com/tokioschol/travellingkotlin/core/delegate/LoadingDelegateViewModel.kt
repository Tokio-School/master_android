package com.tokioschol.travellingkotlin.presentation.core


import com.tokioschol.travellingkotlin.core.extension.tryOffer
import com.tokioschol.travellingkotlin.core.di.domain.di.IoDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

interface LoadingDelegateViewModel {
    val loading: Flow<Boolean>
    suspend fun emitLoading(value:Boolean)
}


internal class LoadingDelegate @Inject constructor(
    @IoDispatcher private val workerScoper: CoroutineScope,
):LoadingDelegateViewModel{

    private val _loading = Channel<Boolean>(2)
    override val loading = _loading.receiveAsFlow()
    override suspend fun emitLoading(value: Boolean) {
        workerScoper.launch {
            _loading.tryOffer(value)
        }
    }
}