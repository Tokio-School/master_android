package com.tokioschol.travellingkotlin.presentation.core.di

import com.tokioschol.travellingkotlin.presentation.features.login.presenter.LoginPresenter
import com.tokioschol.travellingkotlin.presentation.features.login.presenter.LoginPresenterImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@Module
@InstallIn(FragmentComponent::class)
abstract class PresenterModule {

    @Binds
    abstract fun bindLoginPresenter(impl: LoginPresenterImpl):LoginPresenter.Presenter
}