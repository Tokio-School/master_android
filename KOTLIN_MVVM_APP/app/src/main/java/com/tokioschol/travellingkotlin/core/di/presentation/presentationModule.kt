package com.tokioschol.travellingkotlin.core.di.presentation

import android.content.SharedPreferences
import com.tokioschol.travellingkotlin.domain.core.di.IoDispatcher
import com.tokioschol.travellingkotlin.presentation.core.EventsDelegate
import com.tokioschol.travellingkotlin.presentation.core.LoadingDelegateViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class presentationModule {

    @Provides
    @Singleton
    fun provideEventsApp(@IoDispatcher workerScope: CoroutineScope):LoadingDelegateViewModel{
        return EventsDelegate(workerScope)
    }
}



object FeatureAppModule {


}