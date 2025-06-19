package com.example.clase21_viewpager2_

import androidx.viewpager2.adapter.FragmentStateAdapter

class MyAdaptadorViewpager2Fragments(mainActivity: MainActivity) : FragmentStateAdapter(mainActivity) {

    override fun createFragment(position: Int) = when (position) {
        0 -> FragmentUno()
        1 -> FragmentDos()
        2 -> FragmentTres()
        3 -> FragmentCuatro()
        else -> FragmentUno() // Default case
    }

    override fun getItemCount(): Int = 4

}
