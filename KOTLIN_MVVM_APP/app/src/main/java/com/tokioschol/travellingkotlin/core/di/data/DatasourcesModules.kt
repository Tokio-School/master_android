package com.tokioschol.travellingkotlin.core.di.data

import com.tokioschol.travellingkotlin.data.datasource.*
import com.tokioschol.travellingkotlin.data.datasource.impl.HotelsDatasourceImpl
import com.tokioschol.travellingkotlin.data.datasource.impl.LoginDatasourceImpl
import com.tokioschol.travellingkotlin.data.datasource.impl.WheatherDatasourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class DatasourcesModules {
    @Binds
    abstract fun bindingLoginDatasource(loginDatasourImpl: LoginDatasourceImpl):LoginDatasource

    @Binds
    abstract fun bindingHotelsDatasource(impl: HotelsDatasourceImpl): HotelsDatasource

    @Binds
    abstract fun bindingWeatherDatasource(impl: WheatherDatasourceImpl): WheatherDatasource
}