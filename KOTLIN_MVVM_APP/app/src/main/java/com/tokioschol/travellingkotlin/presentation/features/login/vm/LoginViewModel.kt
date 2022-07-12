package com.tokioschol.travellingkotlin.presentation.features.login.vm


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.liveData
import com.tokioschol.travellingkotlin.core.base.BaseViewModel
import com.tokioschol.travellingkotlin.core.extension.combine
import com.tokioschol.travellingkotlin.core.extension.isEmail
import com.tokioschol.travellingkotlin.core.extension.isValidPass
import com.tokioschol.travellingkotlin.domain.repository.LoginRespository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginRespository: LoginRespository,
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

    fun logIn() {
        //TODO LLAMAR REPOSITORY userName.value.
    }


}