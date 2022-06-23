package com.tokioschol.travellingkotlin.presentation.features.login.vm

import androidx.lifecycle.ViewModel
import com.tokioschol.travellingkotlin.domain.repository.LoginRespository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
private val loginRespository: LoginRespository
):ViewModel() {


}