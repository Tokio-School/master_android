package com.tokioschol.travellingkotlin.presentation.features.home.fragments

import androidx.fragment.app.viewModels
import com.tokioschol.travellingkotlin.R
import com.tokioschol.travellingkotlin.core.base.BaseFragmentDb
import com.tokioschol.travellingkotlin.databinding.FragmentHomeBinding
import com.tokioschol.travellingkotlin.databinding.FragmentHotelMapsBinding
import com.tokioschol.travellingkotlin.presentation.features.home.vm.HomeViewModel

class HotelMapsFragment:BaseFragmentDb<FragmentHotelMapsBinding, HomeViewModel>() {

    override val viewModel: HomeViewModel by viewModels()
    override fun getLayout(): Int  = R.layout.fragment_hotel_maps

    override fun setBindingLayout() {

    }

    override fun eventListeners() {
    }

    override fun initViewModels() {

    }

    override fun observeViewModels() {

    }




}