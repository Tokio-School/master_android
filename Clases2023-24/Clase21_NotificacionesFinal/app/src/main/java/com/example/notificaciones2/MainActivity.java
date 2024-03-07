package com.example.notificaciones2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.Manifest;
import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;

import com.example.notificaciones2.databinding.ActivityMainBinding;

/*
La clase java.util.Calendar en Java es una clase abstracta que proporciona
 métodos para trabajar con fechas y horas en el calendario
 */
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_POST_NOTIFICATIONS_PERMISSION = 2;
    ActivityMainBinding binding;

    PendingIntent pendingIntent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.bMostrarNotificacion.setOnClickListener(
                (boton) -> {
                    showNotification();
                });

        binding.bNotificacionAlerta.setOnClickListener(
                (boton) -> {
                    showNotificationAlerta();
                });


    }

    private void showNotificationAlerta() {

        Calendar cal=Calendar.getInstance();
        Intent intent = new Intent(this, MainActivity2.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_IMMUTABLE);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        int segundos=Integer.parseInt(binding.tietSegundos.getText().toString());
        // System.currentTimeMillis() + 1000*segundos -> otra opción para lanzar en un tiempo determinado
        alarmManager.set(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis()+segundos*1000, pendingIntent);

    }


    private void showNotification() {

        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.POST_NOTIFICATIONS) == PackageManager.PERMISSION_GRANTED) {
            Log.i("Info", "Permiso concedido");
            //Comprobar si la version es compatible, android SDK 26 o superior
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                Log.i("Info", "Version correcta");
                String id = "my_channel_01";
                //NotificationManager
                NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(this);

                //Canal de notificaciones
                NotificationChannel channel = new NotificationChannel(id, "chanelName", NotificationManager.IMPORTANCE_HIGH);
                channel.enableVibration(true);


                notificationManagerCompat.createNotificationChannel(channel);

                Bitmap imgBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.notification_img);

                lanzarIntentNotificacion();
                //Crear notificación
                NotificationCompat.Builder noBuilder = new NotificationCompat.Builder(this, id)
                        .setContentTitle("Bienvenido a la app"+getString(R.string.app_name))
                        .setContentText("Nos alegra verte .")
                        .setSmallIcon(R.drawable.baseline_announcement_24)
                        .setContentIntent(pendingIntent)
                        .setLargeIcon(imgBitmap);

                notificationManagerCompat.notify(1, noBuilder.build());
            }
        }else {
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.POST_NOTIFICATIONS},REQUEST_CODE_POST_NOTIFICATIONS_PERMISSION);
            Log.i("Info", "Permiso no concedido");
        }

    }
    public void lanzarIntentNotificacion()
    {
        Intent intent = new Intent(this, MainActivity2.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(MainActivity2.class);
        stackBuilder.addNextIntent(intent);
        //pendingIntent = stackBuilder.getPendingIntent(1, PendingIntent.FLAG_UPDATE_CURRENT);

        /* Para evitar error tenemos que mostrar este if, si no se produciría éste error.
        java.lang.IllegalArgumentException: com.example.notificaciones2: Targeting S+ (version 31 and above) requires that one of FLAG_IMMUTABLE or FLAG_MUTABLE be specified when creating a PendingIntent.
         */
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.S) {
            pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_MUTABLE);
        }
/*        else
        {
            pendingIntent = PendingIntent.getActivity
                    (this, 0, intent, PendingIntent.FLAG_ONE_SHOT);
        }*/
    }
}