package com.example.miviewmodel

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.miviewmodel.databinding.ActivityNombreBinding

class ActivityNombre : AppCompatActivity() {

    lateinit var binding : ActivityNombreBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNombreBinding.inflate(layoutInflater)
        setContentView(binding.root)

        intent.extras?.let {
            val nombre = it.getString("nombre")
            binding.tvNombrePasadoAlActivity.text = nombre
        }

        binding.button2.setOnClickListener(
            View.OnClickListener {
                val nombre = binding.etDatoADevolver.text.toString()
                val intent = intent
                intent.putExtra("nombre", nombre)
                setResult(RESULT_OK, intent)
                finish()
            }
        )


    }
}