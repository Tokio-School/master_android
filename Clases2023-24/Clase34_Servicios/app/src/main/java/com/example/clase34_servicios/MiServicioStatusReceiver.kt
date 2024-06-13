package com.example.clase34_servicios

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import com.example.clase34_servicios.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MiServicioStatusReceiver(private val binding: ActivityMainBinding) : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        Log.d("depurando", "onReceive del MiServicioStatusReceiver")
        val isRunningService = intent?.getBooleanExtra("isRunning", false) ?: false
        val message = if (isRunningService) "El servicio está en funcionamiento" else "El servicio está detenido"
        Log.d("depurando", "onReceive del MiServicioStatusReceiver: $message")
        binding.textoServicio.text = message
        Snackbar.make(binding.root, message, Snackbar.LENGTH_LONG).show()
    }
}
