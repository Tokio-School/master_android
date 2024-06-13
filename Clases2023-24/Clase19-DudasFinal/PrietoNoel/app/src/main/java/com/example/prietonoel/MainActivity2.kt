package com.example.prietonoel

import android.os.Bundle
import com.example.prietonoel.databinding.ActivityMain2Binding

class MainActivity2 : ActivityMenu() {

    lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        //la barra de tareas
        setSupportActionBar(binding.miToolbar.toolbar)
        supportActionBar?.title = "Fin App"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}