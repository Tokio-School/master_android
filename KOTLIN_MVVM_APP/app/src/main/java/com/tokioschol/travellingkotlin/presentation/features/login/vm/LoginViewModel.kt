package com.tokioschol.travellingkotlin.presentation.features.login.vm


import android.util.Log
import androidx.lifecycle.*
import com.facebook.AccessToken
import com.tokioschol.travellingkotlin.core.base.BaseViewModel
import com.tokioschol.travellingkotlin.core.base.SingleEvent
import com.tokioschol.travellingkotlin.core.extension.combine
import com.tokioschol.travellingkotlin.core.extension.isEmail
import com.tokioschol.travellingkotlin.core.extension.isValidPass
import com.tokioschol.travellingkotlin.domain.models.User
import com.tokioschol.travellingkotlin.domain.repository.LoginRespository
import com.tokioschol.travellingkotlin.domain.usecase.EjemploUseCase
import com.tokioschol.travellingkotlin.domain.usecase.GetLogInFacebookUseCase
import com.tokioschol.travellingkotlin.domain.usecase.GetLogInUseCase
import com.tokioschol.travellingkotlin.presentation.core.LoadingDelegateViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val getLogInUseCase: GetLogInUseCase,
    private val getLogInFacebookUseCase: GetLogInFacebookUseCase
) : BaseViewModel() {
    val userName = MutableLiveData("")
    val errorUserName = liveData<Boolean> {
        emitSource(
            Transformations.map(enableBtn) {
                Log.e("manel","boton habilitado $it")
                return@map it && userName.value?.isEmail() == false
            }
        )
    }
    val password = MutableLiveData("")
    val enableBtn = userName.combine(password){ user,pass ->
        return@combine user.length > 3 && pass.isValidPass()
    }

    private val _user = MutableLiveData<User>()
    val user get() = _user

    fun logIn() {
        viewModelScope.launch {
            getLogInUseCase.execute(GetLogInUseCase.Params(userName.value?:"",password.value?:""))
                .onStart { _loading.value = true }
                .onCompletion { _loading.value = false }
                .catch { _error.value = SingleEvent(it) }
                .collect{ _user.value = it}
        }
    }

    fun logInFacebook(accessToken: AccessToken){
        viewModelScope.launch {
            getLogInFacebookUseCase.execute(accessToken)
                .onStart { _loading.value = true }
                .onCompletion { _loading.value = false }
                .catch { _error.value = SingleEvent(it) }
                .collect{ _user.value = it}
        }
    }

}