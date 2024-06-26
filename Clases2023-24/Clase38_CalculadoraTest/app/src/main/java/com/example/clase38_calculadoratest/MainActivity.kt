package com.example.clase38_calculadoratest

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.clase38_calculadoratest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    
    lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var calc = Calculadora()


        binding.btnAdd.setOnClickListener {
            binding.tvResult.text = calc.sumar(
                binding.etNumber1.text.toString().toInt(),
                binding.etNumber2.text.toString().toInt()
            ).toString()
        }
        binding.btnSubtract.setOnClickListener {
            binding.tvResult.text = calc.restar(
                binding.etNumber1.text.toString().toInt(),
                binding.etNumber2.text.toString().toInt()
            ).toString()
        }
        binding.btnMultiply.setOnClickListener {
            binding.tvResult.text = calc.multiplicar(
                binding.etNumber1.text.toString().toInt(),
                binding.etNumber2.text.toString().toInt()
            ).toString()
        }
        binding.btnDivide.setOnClickListener {
            binding.tvResult.text = calc.dividir(
                binding.etNumber1.text.toString().toInt(),
                binding.etNumber2.text.toString().toInt()
            ).toString()
        }


    }
}