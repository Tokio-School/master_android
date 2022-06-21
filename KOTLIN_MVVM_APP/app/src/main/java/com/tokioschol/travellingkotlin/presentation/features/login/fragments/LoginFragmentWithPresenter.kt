package com.tokioschol.travellingkotlin.presentation.features.login.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.tokioschol.travellingkotlin.databinding.FragmentLoginBinding
import com.tokioschol.travellingkotlin.domain.models.User
import com.tokioschol.travellingkotlin.presentation.core.extension.viewBinding
import com.tokioschol.travellingkotlin.presentation.features.login.presenter.LoginPresenter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class LoginFragmentWithPresenter: Fragment(),LoginPresenter.View {

    private lateinit var bindingNotDelegate: FragmentLoginBinding
    //private val binding by viewBinding(FragmentLoginBinding::bind)
    @Inject
    lateinit var presenter: LoginPresenter.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.attachView(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        bindingNotDelegate =  FragmentLoginBinding.inflate(layoutInflater,container,false)
        return bindingNotDelegate.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.logIn("jose","1234")

    }

    override fun logInResult(user: User) {
        bindingNotDelegate.loginUser.text = user.name
    }

    override fun showErrorLogIn(it: Throwable) {
        //TODO("Not yet implemented")
    }

    override fun showProgress() {
        bindingNotDelegate.loginProgress.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        bindingNotDelegate.loginProgress.visibility = View.GONE
    }
}