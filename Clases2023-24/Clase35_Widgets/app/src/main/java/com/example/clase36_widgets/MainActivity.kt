package com.example.clase36_widgets

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.loader.R
import com.example.clase36_widgets.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        if (ActivityCompat.checkSelfPermission(
                binding.root.context,
                Manifest.permission.POST_NOTIFICATIONS
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            Log.d("depurando", "Permiso concedido")
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                Log.i("Info", "Version correcta")
                val id = "my_channel_01"
                val notificationManagerCompat = NotificationManagerCompat.from(binding.root.context)
                val channel = NotificationChannel(id, "chanelName", NotificationManager.IMPORTANCE_HIGH)
                channel.enableVibration(true)
                notificationManagerCompat.createNotificationChannel(channel)

                val intent = Intent(binding.root.context, MainActivity::class.java)
                val pendingIntent: PendingIntent =
                    PendingIntent.getActivity(binding.root.context, 0, intent, PendingIntent.FLAG_MUTABLE)

                val noBuilder: NotificationCompat.Builder = NotificationCompat.Builder(binding.root.context, id)
                    .setContentTitle("Notificación desde el Widget")
                    .setContentText("Yujuuu.")
                    .setSmallIcon(R.drawable.notification_bg)
                    .setContentIntent(pendingIntent)

                notificationManagerCompat.notify(1, noBuilder.build())
            }
        } else {
            // No podemos solicitar permisos dentro de un BroadcastReceiver. POr eso lo hacemos desde el Activity

            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.POST_NOTIFICATIONS),
                1
            )
            Log.d("depurando", "Permiso no concedido")
        }


    }
}