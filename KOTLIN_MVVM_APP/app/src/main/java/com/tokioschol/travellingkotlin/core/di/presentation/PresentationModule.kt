package com.tokioschol.travellingkotlin.core.di.presentation

import com.tokioschol.travellingkotlin.core.di.domain.di.IoDispatcher
import com.tokioschol.travellingkotlin.presentation.core.LoadingDelegate
import com.tokioschol.travellingkotlin.presentation.core.LoadingDelegateViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class PresentationModule {

    @Provides
    @Singleton
    fun provideEventsApp(@IoDispatcher workerScope: CoroutineScope):LoadingDelegateViewModel{
        return LoadingDelegate(workerScope)
    }
}
