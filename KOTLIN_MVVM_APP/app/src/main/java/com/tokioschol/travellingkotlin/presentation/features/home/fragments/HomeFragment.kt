package com.tokioschol.travellingkotlin.presentation.features.home.fragments

import android.util.Log
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.google.android.material.snackbar.Snackbar
import com.tokioschol.travellingkotlin.R
import com.tokioschol.travellingkotlin.core.base.BaseFragmentDb
import com.tokioschol.travellingkotlin.core.base.recycler.BaseRvAdapter
import com.tokioschol.travellingkotlin.core.extension.snack
import com.tokioschol.travellingkotlin.databinding.FragmentHomeBinding
import com.tokioschol.travellingkotlin.domain.models.Hotel
import com.tokioschol.travellingkotlin.domain.models.SnackbarMessage
import com.tokioschol.travellingkotlin.presentation.features.home.vm.HomeViewModel
import com.tokioschol.travellingkotlin.presentation.features.home.vm.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment:BaseFragmentDb<FragmentHomeBinding, HomeViewModel>() {

    override val viewModel: HomeViewModel by viewModels()
    val shareViewModel: MainViewModel by activityViewModels()
    override fun getLayout(): Int  = R.layout.fragment_home

    private val adapter by lazy {
        BaseRvAdapter<Hotel>(R.layout.item_hotel_list){ hotel ->
            hotel?.let {
                shareViewModel.setSelectedHotel(hotel)
                snack(SnackbarMessage(R.string.selected_hotel,it.name)).show()
            }
        }
    }

    override fun eventListeners() {
        dataBinding.homeRv.adapter = adapter
    }

    override fun initViewModels() {
        viewModel.loadHotelList()
    }

    override fun observeViewModels() {
        viewModel.hotelList.observe(viewLifecycleOwner){
            adapter.items = it
        }
    }

}