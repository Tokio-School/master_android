package com.tokioschol.travellingkotlin.presentation.features.login.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import com.tokioschol.travellingkotlin.R
import com.tokioschol.travellingkotlin.databinding.FragmentLoginBinding
import com.tokioschol.travellingkotlin.domain.models.User
import com.tokioschol.travellingkotlin.presentation.core.extension.viewBinding
import com.tokioschol.travellingkotlin.presentation.features.login.presenter.LoginPresenter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class LoginFragmentWithPresenter : Fragment(R.layout.fragment_login), LoginPresenter.View {

    private val binding by viewBinding(FragmentLoginBinding::bind)

    @Inject
    lateinit var presenter: LoginPresenter.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.attachView(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listeners()
    }

    private fun listeners() {
        binding.loginUser.setOnClickListener { presenter.logIn("jose", "123") }
        binding.loginFacebook.setOnClickListener { presenter.logInFaceBook("tokenFacebook") }
    }

    override fun logInResult(user: User) {
        binding.loginResultUser.text = user.name
    }

    override fun loginResultFacebook(result: User) {
       binding.loginResultUser.text = result.name
    }

    override fun showErrorLogIn(it: Throwable) {
        Snackbar.make(binding.loginUser,it.message.toString(),Snackbar.LENGTH_LONG).show()
    }

    override fun showProgress() {
        binding.loginProgress.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        binding.loginProgress.visibility = View.GONE
    }
}