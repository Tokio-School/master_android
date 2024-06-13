package com.example.clase34_servicios

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.example.clase34_servicios.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private lateinit var servicioReceiver: MiServicioStatusReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d("depurando", "onCreate del MainActivity")

        binding.buttonInciarServicio.setOnClickListener {
            Intent(this, MiServicio::class.java).also {
                startService(it)
                binding.textoServicio.text = "Servicio iniciado"
            }
        }

        binding.buttonDetenerServicio.setOnClickListener {
            Intent(this, MiServicio::class.java).also {
                stopService(it)
                binding.textoServicio.text = "Servicio detenido"
            }
        }

        binding.bComprobarEstado.setOnClickListener {
            Log.d("depurando", "comprobar estado desde el botón")
            checkServiceStatus()
        }

        servicioReceiver = MiServicioStatusReceiver(binding)
        val intentFilter = IntentFilter("MiServicioStatusReceiver")
        LocalBroadcastManager.getInstance(this).registerReceiver(servicioReceiver, intentFilter)

        binding.ibPlay.setOnClickListener {
            if (binding.ibPlay.tag == "PLAY") {
                Intent(this, MiServicioAudio::class.java).also {
                    it.action = "PLAY"
                    startService(it)
                }
                binding.ibPlay.tag = "PAUSE"
                binding.ibPlay.setImageResource(R.drawable.baseline_pause_circle_24)
            } else {
                Intent(this, MiServicioAudio::class.java).also {
                    it.action = "PAUSE"
                    startService(it)
                }
                binding.ibPlay.tag = "PLAY"
                binding.ibPlay.setImageResource(R.drawable.baseline_play_circle_24)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("depurando", "onDestroy del MainActivity")
        LocalBroadcastManager.getInstance(this).unregisterReceiver(servicioReceiver)
        Log.d("depurando", "BroadcastReceiver anulado el registro")
    }

    override fun onResume() {
        super.onResume()
        Log.d("depurando", "onResume del MainActivity")
        checkServiceStatus()
    }

    private fun checkServiceStatus() {
        Intent(this, MiServicio::class.java).also {
            it.action = "CHECK_STATUS"
            startService(it)
            Log.d("depurando", "Comprobando estado del servicio")
        }
    }
}
