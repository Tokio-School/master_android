package com.tokioschol.travellingkotlin.core.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class BaseViewModel : ViewModel() {
    protected val _loading = MutableLiveData(false)
    val loading: LiveData<Boolean> get() = _loading

    protected val _error = MutableLiveData<SingleEvent<Throwable>>()
    val error: LiveData<SingleEvent<Throwable>> get() = _error

}