package com.example.clase34_servicios

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder

class MiServicioAudio : Service() {
    private lateinit var mediaPlayer: MediaPlayer


    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        mediaPlayer = MediaPlayer.create(this, R.raw.enya)
        mediaPlayer.isLooping = true

        if (intent?.action == "PLAY") {
            mediaPlayer.start()
        } else if (intent?.action == "PAUSE") {
            mediaPlayer.pause()
        }


        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.stop()
    }
}