package com.tokioschol.travellingkotlin.core.di.data

import com.tokioschol.travellingkotlin.data.api.ApiHotels
import com.tokioschol.travellingkotlin.data.api.ApiLogin
import com.tokioschol.travellingkotlin.data.api.ApiWeather
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Provides
    fun provideApiLogin(retrofit: Retrofit): ApiLogin{
        return retrofit.create(ApiLogin::class.java)
    }

    @Provides
    fun provideApiHotels(retrofit: Retrofit): ApiHotels{
        return retrofit.create(ApiHotels::class.java)
    }

    @Provides
    fun provideApiWeahter(retrofit: Retrofit): ApiWeather{
        return retrofit.create(ApiWeather::class.java)
    }


}