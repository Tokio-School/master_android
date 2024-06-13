package com.example.clase34_servicios

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import androidx.localbroadcastmanager.content.LocalBroadcastManager

class MiServicio : Service() {

    private var isRunning: Boolean = false

    init {
        Log.d("depurando", "Servicio iniciado")
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()
        isRunning = true
        Log.d("depurando", "onCreate del MiServicio")
    }

    override fun onDestroy() {
        super.onDestroy()
        isRunning = false
        Log.d("depurando", "onDestroy del MiServicio")
        // Enviar un broadcast para indicar que el servicio se ha detenido
        val broadcastIntent = Intent("MiServicioStatusReceiver")
        broadcastIntent.putExtra("isRunning", isRunning)
        LocalBroadcastManager.getInstance(this).sendBroadcast(broadcastIntent)
        Log.d("depurando", "Broadcast enviado desde onDestroy con estado: $isRunning")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d("depurando", "onStartCommand del MiServicio")
        intent?.let {
            if (it.action == "CHECK_STATUS") {
                Log.d("depurando", "CHECK_STATUS - onStartCommand del MiServicio")
                val broadcastIntent = Intent("MiServicioStatusReceiver")
                broadcastIntent.putExtra("isRunning", isRunning)
                LocalBroadcastManager.getInstance(this).sendBroadcast(broadcastIntent)
                Log.d("depurando", "Broadcast enviado con estado: $isRunning")
            } else {
                Log.d("depurando", "El valor de it.action es: ${it.action}")
            }
        }
        return START_STICKY
    }
}
