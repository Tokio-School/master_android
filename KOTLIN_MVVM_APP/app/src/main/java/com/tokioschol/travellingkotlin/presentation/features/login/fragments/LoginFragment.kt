package com.tokioschol.travellingkotlin.presentation.features.login.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.tokioschol.travellingkotlin.databinding.FragmentLoginBinding
import com.tokioschol.travellingkotlin.presentation.core.extension.viewBinding
import com.tokioschol.travellingkotlin.presentation.features.login.vm.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment:Fragment() {

    private val binding by viewBinding(FragmentLoginBinding::bind)
    private val viewModel:LoginViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listeners()// gestion de eventos
        initViewModel()// inicialización de servicios o data
        observerViewModel()//observar el result data
    }

    private fun listeners() {
        //Not yet implemented
    }

    private fun initViewModel() {
        //Not yet implemented
    }

    private fun observerViewModel() {
        //Not yet implemented
    }
}