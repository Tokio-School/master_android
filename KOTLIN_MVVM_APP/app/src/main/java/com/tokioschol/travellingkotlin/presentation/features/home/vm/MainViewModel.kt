package com.tokioschol.travellingkotlin.presentation.features.home.vm

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations.map
import androidx.lifecycle.asFlow
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.bumptech.glide.Glide
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.tokioschol.travellingkotlin.core.base.BaseViewModel
import com.tokioschol.travellingkotlin.domain.models.Hotel
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : BaseViewModel() {
    private val _hotelSelected = MutableLiveData<Hotel>()


    val latLongMapHotel = map(_hotelSelected) {
        val latLong = LatLng(it.location.lat?:0.0, it.location.long?:0.0)
        latLong to MarkerOptions().position(latLong).title(it.name)
    }

    fun setSelectedHotel(hotel: Hotel) {
        _hotelSelected.value = hotel
    }

}