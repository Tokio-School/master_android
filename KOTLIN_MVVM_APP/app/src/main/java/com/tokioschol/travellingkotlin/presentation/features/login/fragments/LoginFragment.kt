package com.tokioschol.travellingkotlin.presentation.features.login.fragments

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.tokioschol.travellingkotlin.R
import com.tokioschol.travellingkotlin.core.base.BaseFragmentDb
import com.tokioschol.travellingkotlin.databinding.FragmentLoginBinding
import com.tokioschol.travellingkotlin.domain.models.User
import com.tokioschol.travellingkotlin.presentation.features.login.vm.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : BaseFragmentDb<FragmentLoginBinding,LoginViewModel>() {

    override fun getLayout(): Int  = R.layout.fragment_login
    override val viewModel: LoginViewModel by viewModels()

    override fun setBindingLayout() {
        dataBinding.viewModel = viewModel
    }

    override fun observeViewModels() {
        viewModel.errorUserName.observe(viewLifecycleOwner,::errorUserName)
        viewModel.user.observe(viewLifecycleOwner,::loginSucess)
        //TODO pendiente manejarlo en la clase base
        viewModel.error.observe(viewLifecycleOwner,::failLogIn)
    }

    private fun failLogIn(throwable: Throwable?) {
        Log.e("manel","se ha producido un error ${throwable?.message}")
        Snackbar.make(dataBinding.loginContentRoot,getString(R.string.error_logIn_service,throwable?.message),Snackbar.LENGTH_LONG).show()
    }

    private fun loginSucess(user: User?) {
        //TODO pasar usuario y prevent double click navigation
        Log.e("manel","el usuario es ${user?.name}")
        navigate(R.id.action_loginFragment_to_mainActivity)

    }

    private fun errorUserName(isValid: Boolean?) {
        isValid?.let {
            when(isValid){
                true -> dataBinding.loginInputLayoutUserName.error = getString(R.string.login_error_user)
                false -> dataBinding.loginInputLayoutUserName.error = null
            }
        }
    }
}