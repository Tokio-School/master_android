package com.example.practica6;

import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class Activity_ConMenu extends AppCompatActivity {

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Log.d("depurando", "onOptionsItemSelected del Activity_Home");
        if (item.getItemId()==R.id.navegador)
        {
            //Lanzamos una actividad de una url, http://www.google.es
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.es"));
            startActivity(intent);
        }
        if (item.getItemId()==R.id.opcion1)
        {
            //Lanzamos una actividad de una url, http://www.google.es
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.es"));
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mi_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }



}
