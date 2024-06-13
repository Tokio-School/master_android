package com.example.clase36_widgets

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.widget.RemoteViews
import android.widget.RemoteViews.RemoteView
import com.example.clase36_widgets.databinding.AppwidgetLayoutBinding

class MyAppWidgetProvider : AppWidgetProvider() {

    //lateinit var binding: AppwidgetLayoutBinding

    companion object {
        private const val ACTION_UPDATE_TEXT = "com.example.clase36_widgets.ACTION_UPDATE_TEXT"
        private var contador = 0

        private fun getPendingSelfIntent(context: Context, action: String): PendingIntent {
            val intent = Intent(context, MyAppWidgetProvider::class.java)
            intent.action = action
            return PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE)
        }
    }


    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        super.onUpdate(context, appWidgetManager, appWidgetIds)
       // binding= AppwidgetLayoutBinding.inflate(LayoutInflater.from(context))



        val views = RemoteViews(context.packageName, R.layout.appwidget_layout)

        // Set the Update Text button
        views.setOnClickPendingIntent(R.id.button_update, getPendingSelfIntent(context, ACTION_UPDATE_TEXT))

        // Set the Open Activity button
        val openActivityIntent = Intent(context, MainActivity::class.java)
        val openActivityPendingIntent = PendingIntent.getActivity(context, 0, openActivityIntent, PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE)
        views.setOnClickPendingIntent(R.id.button_open_activity, openActivityPendingIntent)

        //  Lanzamos la notificación a través del método showNotification()
        // Deberemos crear un pendintIntent para que al pulsar el botón muestre la notificación

        val notificationIntent = Intent(context, WidgetReceiver::class.java).apply {
            action = "ACTION_SHOW_NOTIFICATION"
        }
        val notificationPendingIntent = PendingIntent.getBroadcast(context, 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE)
        views.setOnClickPendingIntent(R.id.button_notification, notificationPendingIntent)

        appWidgetManager.updateAppWidget(appWidgetIds, views)
    }


    override fun onReceive(context: Context, intent: Intent) {
        super.onReceive(context, intent)

        Log.d("depurando", "onReceive - ")

        if (intent.action == ACTION_UPDATE_TEXT) {
            val appWidgetManager = AppWidgetManager.getInstance(context)
            val thisAppWidget = ComponentName(context.packageName, MyAppWidgetProvider::class.java.name)
            val appWidgetIds = appWidgetManager.getAppWidgetIds(thisAppWidget)

            for (appWidgetId in appWidgetIds) {
                val views = RemoteViews(context.packageName, R.layout.appwidget_layout)
                views.setTextViewText(R.id.widget_text, "Texto actualizado!")


                views.setTextViewText(R.id.tv_contador, contador++.toString())
                appWidgetManager.updateAppWidget(appWidgetId, views)
            }
        }

    }
}