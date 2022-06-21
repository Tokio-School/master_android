package com.tokioschol.travellingkotlin.presentation.features.login.presenter

import com.tokioschol.travellingkotlin.domain.models.User
import com.tokioschol.travellingkotlin.presentation.core.base.BasePresenter
import com.tokioschol.travellingkotlin.presentation.core.base.BaseView
import com.tokioschol.travellingkotlin.presentation.features.login.fragments.LoginFragmentWithPresenter

interface LoginPresenter {

    interface Presenter:BasePresenter<BaseView>{
        //la implementacion del presenter
        fun logIn(userName:String, password:String)
        fun attachView(view: LoginPresenter.View)
    }

    interface View: BaseView{
        //Todo el resultado a mostrar en la vista
        fun logInResult(user:User)
        fun showErrorLogIn(it: Throwable)
    }

}