package com.tokioschol.travellingkotlin.presentation.features.home.fragments

import android.util.Log
import androidx.fragment.app.viewModels
import com.tokioschol.travellingkotlin.R
import com.tokioschol.travellingkotlin.core.base.BaseFragmentDb
import com.tokioschol.travellingkotlin.core.base.recycler.BaseRvAdapter
import com.tokioschol.travellingkotlin.databinding.FragmentHomeBinding
import com.tokioschol.travellingkotlin.domain.models.Hotel
import com.tokioschol.travellingkotlin.presentation.features.home.vm.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment:BaseFragmentDb<FragmentHomeBinding, HomeViewModel>() {

    override val viewModel: HomeViewModel by viewModels()
    override fun getLayout(): Int  = R.layout.fragment_home


    override fun eventListeners() {

    }

    override fun initViewModels() {
        viewModel.loadHotelList()
    }

    override fun observeViewModels() {

    }
}