package com.tokioschol.travellingkotlin.presentation.features.home.fragments

import androidx.fragment.app.viewModels
import com.tokioschol.travellingkotlin.R
import com.tokioschol.travellingkotlin.core.base.BaseFragmentDb
import com.tokioschol.travellingkotlin.databinding.FragmentHomeBinding
import com.tokioschol.travellingkotlin.presentation.features.home.vm.HomeViewModel

class HomeFragment:BaseFragmentDb<FragmentHomeBinding, HomeViewModel>() {

    override val viewModel: HomeViewModel by viewModels()
    override fun getLayout(): Int  = R.layout.fragment_home




    override fun initViewModels() {

    }

    override fun observeViewModels() {

    }




}