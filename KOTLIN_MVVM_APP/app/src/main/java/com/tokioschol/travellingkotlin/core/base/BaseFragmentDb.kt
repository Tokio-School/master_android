package com.tokioschol.travellingkotlin.core.base

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

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

    @CallSuper
    open fun setBindingLayout(){
        Log.e("manel","invocamos al setBinding")
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
    }

    override fun onDestroy() {
        super.onDestroy()
        dataBinding.unbind()
    }
}