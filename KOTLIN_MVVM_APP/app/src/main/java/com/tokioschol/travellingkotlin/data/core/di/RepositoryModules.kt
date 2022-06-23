package com.tokioschol.travellingkotlin.data.core.di

import com.tokioschol.travellingkotlin.data.repository.LoginRespositoryImpl
import com.tokioschol.travellingkotlin.domain.repository.LoginRespository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class RepositoryModules {
    @Binds
    abstract fun bindinLoginRepository(impl: LoginRespositoryImpl): LoginRespository
}