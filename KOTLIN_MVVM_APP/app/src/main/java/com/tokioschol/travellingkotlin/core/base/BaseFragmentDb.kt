package com.tokioschol.travellingkotlin.core.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.google.firebase.crashlytics.ktx.crashlytics
import com.google.firebase.ktx.Firebase

abstract class BaseFragmentDb<DB:ViewDataBinding,VM:BaseViewModel> : Fragment(){

    protected abstract val viewModel: VM
    protected lateinit var dataBinding: DB

    @LayoutRes
    abstract fun getLayout():Int

    open fun eventListeners(){
        //implemented in class
    }

    open fun initViewModels(){
        //implemented in class
    }

    open fun observeViewModels(){
        //implemented in class
    }

    open fun setBindingLayout(){
        //implemented in class
    }

    open fun showError(message: String?) {
        //implemented in class
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        super.onCreateView(inflater, container, savedInstanceState)
        dataBinding = DataBindingUtil.inflate<DB>(inflater, getLayout(), container, false).apply {
            lifecycleOwner = this@BaseFragmentDb
        }
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        eventListeners()
        initViewModels()
        observeViewModels()
        setBindingLayout()
        handleError()
    }

    private fun handleError() {
        viewModel.error.observe(viewLifecycleOwner){
            it.getContentIfNotHandled()?.let {
                showError(it.message)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        dataBinding.unbind()
    }

    /**
     * Prevent IllegalArgumentException cannot be found from the current destination Destination
     */
    protected fun navigate(destination: NavDirections) = with(findNavController()) {
        currentDestination?.getAction(destination.actionId)
            ?.let { navigate(destination) }
    }

    fun navigate(destination: Int, bundle: Bundle? = null) = with(findNavController()) {
        currentDestination?.getAction(destination)?.let { navigate(destination, bundle) }
    }


    fun navigateBack() = with(findNavController()) {
        currentDestination?.let { navigateUp() }
    }
}