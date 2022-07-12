package com.tokioschol.travellingkotlin.presentation.features.login.fragments

import androidx.fragment.app.viewModels
import com.tokioschol.travellingkotlin.R
import com.tokioschol.travellingkotlin.core.base.BaseFragmentDb
import com.tokioschol.travellingkotlin.databinding.FragmentLoginBinding
import com.tokioschol.travellingkotlin.presentation.features.login.vm.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : BaseFragmentDb<FragmentLoginBinding,LoginViewModel>() {

    override fun getLayout(): Int  = R.layout.fragment_login
    override val viewModel: LoginViewModel by viewModels()

    override fun setBindingLayout() {
        super.setBindingLayout()
        dataBinding.viewModel = viewModel
    }

    override fun observeViewModels() {
        viewModel.errorUserName.observe(viewLifecycleOwner,::errorUserName)
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