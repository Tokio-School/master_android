package com.tokioschol.travellingkotlin.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.tokioschol.travellingkotlin.databinding.ActivityMainBinding
import com.tokioschol.travellingkotlin.presentation.core.extension.viewBinding


class MainActivity : AppCompatActivity() {
    private val binding by viewBinding(ActivityMainBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

}