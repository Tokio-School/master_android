package com.tokioschol.travellingkotlin.presentation.features.login.presenter

import com.tokioschol.travellingkotlin.domain.repository.LoginRespository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject


class LoginPresenterImpl @Inject constructor(
    private val loginRespository: LoginRespository,
) : LoginPresenter.Presenter {

    val scope: CoroutineScope = CoroutineScope(Dispatchers.Main + SupervisorJob())
    lateinit var view: LoginPresenter.View

    override fun logIn(userName: String, password: String) {
        scope.launch {
            loginRespository.logIn(userName, password).flowOn(Dispatchers.IO)
                .onStart { view.showProgress() }
                .onCompletion { view.hideProgress() }
                .catch {
                    view.showErrorLogIn(it) }
                .collect {
                    view.logInResult(it) }
        }
    }

    override fun logInFaceBook(token: String) {
        scope.launch {
            flow {
                emit(loginRespository.logInFaceBook(token))
            }.onStart { view.showProgress() }
                .onCompletion { view.hideProgress() }
                .catch { view.showErrorLogIn(it) }
                .collect { view.loginResultFacebook(it) }
        }
    }

    override fun attachView(view: LoginPresenter.View) {
        this.view = view
    }
}