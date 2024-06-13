package com.example.clase36_widgets

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.util.Log
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.loader.R

class WidgetReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action == "ACTION_SHOW_NOTIFICATION") {
            showNotification(context)
        }
    }

    private fun showNotification(context: Context) {
        Log.d("depurando", "showNotification()")
        Log.d("depurando", "Permiso concedido")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Log.i("Info", "Version correcta")
            val id = "my_channel_01"
            val notificationManagerCompat = NotificationManagerCompat.from(context)
            val channel = NotificationChannel(id, "chanelName", NotificationManager.IMPORTANCE_HIGH)
            channel.enableVibration(true)
            notificationManagerCompat.createNotificationChannel(channel)

            val intent = Intent(context, MainActivity::class.java)
            val pendingIntent: PendingIntent =
                PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_MUTABLE)

            val noBuilder: NotificationCompat.Builder = NotificationCompat.Builder(context, id)
                .setContentTitle("Notificación desde el Widget")
                .setContentText("Yujuuu.")
                .setSmallIcon(R.drawable.notification_bg)
                .setContentIntent(pendingIntent)

            if (ActivityCompat.checkSelfPermission(
                    context,
                    Manifest.permission.POST_NOTIFICATIONS
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return
            }
            notificationManagerCompat.notify(1, noBuilder.build())
        }
    }
}