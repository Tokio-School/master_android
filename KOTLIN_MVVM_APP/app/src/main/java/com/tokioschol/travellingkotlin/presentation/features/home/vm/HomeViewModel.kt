package com.tokioschol.travellingkotlin.presentation.features.home.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.tokioschol.travellingkotlin.core.base.BaseViewModel
import com.tokioschol.travellingkotlin.core.base.SingleEvent
import com.tokioschol.travellingkotlin.domain.models.Hotel
import com.tokioschol.travellingkotlin.domain.usecase.GetListHotelsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val hotelListUseCase: GetListHotelsUseCase,
) : BaseViewModel() {

    private val _hotelList = MutableLiveData<List<Hotel>>()
    val hotelList: LiveData<List<Hotel>> get() = _hotelList

    private val _newListString = MutableLiveData<List<String>>()
    val newListString: LiveData<List<String>> get() = _newListString

    fun loadHotelList() {
        viewModelScope.launch {
            hotelListUseCase.execute(Unit)
                .onStart { _loading.value = true }
                .onCompletion { _loading.value = false }
                .catch { _error.value = SingleEvent(it) }
                .collect { _hotelList.value = it }
        }
    }
}