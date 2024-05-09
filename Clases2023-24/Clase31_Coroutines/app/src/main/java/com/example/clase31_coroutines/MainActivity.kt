package com.example.clase31_coroutines

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.clase31_coroutines.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.shimmerFrameLayout.startShimmer()

        CoroutineScope(Dispatchers.Default).launch {
            delay(5000)
            launch(Dispatchers.Main) {
                binding.shimmerFrameLayout.stopShimmer()
                binding.shimmerFrameLayout.hideShimmer()
                binding.shimmerFrameLayout.visibility = View.GONE

            }
        }

        binding.bIniciarProgressbar.setOnClickListener {
            CoroutineScope(Dispatchers.Default).launch {
                for (i in 1..100) {
                    binding.pbHorizontal.progress = i
                    delay(100)
                }
            }
        }

        GlobalScope.launch {
            for (i in 1..100) {
                delay(1000)
                actualizarTextView(i)
            }
        }

        binding.bPasarASegundoActivity.setOnClickListener {
            startActivity(Intent(this, MainActivity2::class.java))
        }

        val resultado1 = CoroutineScope(Dispatchers.Default).async {  tarea1()}
        val resultado2 = CoroutineScope(Dispatchers.Default).async {  tarea2()}

        CoroutineScope(Dispatchers.Default).async {
            val resultadoFinal = (resultado1.await() + resultado2.await())
            Log.d("depurando","El resultado final es: $resultadoFinal")
        }

    }

    private suspend fun actualizarTextView(i: Int) {
        runOnUiThread {
            binding.tvContador.text = i.toString()
        }
    }

    suspend fun tarea1():Int {
        delay(2000)
        return 33
    }

    suspend fun tarea2():Int {
        delay(4000)
        return 55
    }
}