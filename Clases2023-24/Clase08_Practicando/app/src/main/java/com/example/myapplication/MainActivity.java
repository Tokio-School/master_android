package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    ListView lista;
    Spinner sp_listado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        lista=((ListView)findViewById(R.id.lv_datos));
        lista.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, getResources().getStringArray(R.array.planets_array)));


        sp_listado=((Spinner)findViewById(R.id.sp_listadoSpinner));
        sp_listado.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.planets_array)));

        ((Button)findViewById(R.id.b_recuperarDatos)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gestionarEvento();

            }
        });


        ((TextView)findViewById(R.id.tv_recuperarTouchListener)).setOnTouchListener((view,motionEvent)->{
            if (motionEvent.getAction()== MotionEvent.ACTION_UP) {
                gestionarEvento();
                Snackbar.make(view, R.string.saludo, Snackbar.LENGTH_LONG).show();

            }

            return true;
        });

    }

    private void gestionarEvento() {
        //El siguiente método sólo funciona cuando el adapatador es del tipo CursorAdapter o SimpleCursorAdapter
        Log.d("depurando", Arrays.toString(lista.getCheckedItemIds())+"-");

        //Así no hay necesidad de coger otro adaptador no utilizado hasta el momento como el CursorAdapter.
        SparseBooleanArray checkedItemPositions = lista.getCheckedItemPositions();
        int itemCount = lista.getCount();
        for (int i = 0; i < itemCount; i++) {
            if (checkedItemPositions.get(i)) {
                // El elemento en la posición 'i' está seleccionado
                // Haz algo con este elemento
                String selectedItem = (String) lista.getItemAtPosition(i);
                Log.d("depurando", selectedItem);
            }
        }
    }
}