package com.example.clase21_viewpager2_

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.clase21_viewpager2_.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.viewpager2.adapter = MyAdaptadorViewpager2Fragments(this)

        TabLayoutMediator(
            binding.tabLayout, binding.viewpager2
        ) { tab, position ->
            tab.text = "Tab ${position + 1}"
        }.attach()

        binding.tabLayout.addOnTabSelectedListener(object : OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                Log.d("depurando", "Pestaña seleccionada: ${tab.text}")
                tab.icon!!.setTint(
                    ContextCompat.getColor(
                        this@MainActivity,
                        android.R.color.holo_red_light
                    )
                )
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }
        }

        )

        cambiarPropiedadesPestanas(0,R.drawable.baseline_snowmobile_24,android.R.color.holo_blue_light)
        cambiarPropiedadesPestanas(1,R.drawable.baseline_accessibility_24,android.R.color.holo_red_light)
        cambiarPropiedadesPestanas(2,R.drawable.baseline_snowshoeing_24,android.R.color.holo_green_light)
        cambiarPropiedadesPestanas(3,R.drawable.baseline_sports_baseball_24,android.R.color.holo_purple)


    }

    private fun cambiarPropiedadesPestanas(tabIndex :Int, icono:Int,color: Int) {
        binding.tabLayout.getTabAt(tabIndex).let {
            it?.icon = ContextCompat.getDrawable(this, icono)
            it?.view?.setBackgroundColor(
                ContextCompat.getColor(
                    this,
                    color
                )
            )
        }
    }
}