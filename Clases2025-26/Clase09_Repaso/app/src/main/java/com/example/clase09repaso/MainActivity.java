package com.example.clase09repaso;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.clase09repaso.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.setDatoNombre(new Dato("prueba",44));




        //ArrayList<String> datos = new ArrayList<>();
        ArrayList<Dato> datos = new ArrayList<>();
        /*binding.bAnadir.setOnClickListener(new View.OnClickListener() {
                                               @Override
                                               public void onClick(View boton) {

                                               }
                                           });*/


        binding.bAnadir.setOnClickListener(boton ->
       {
                String nombre = binding.tietNombre.getText().toString();
                Log.d("depurando", nombre);
                //datos.add(nombre);
                datos.add(new Dato(nombre,33));
                //((ArrayAdapter<String>)binding.lvDatos.getAdapter()).notifyDataSetChanged();
                ((ArrayAdapter<Dato>)binding.lvDatos.getAdapter()).notifyDataSetChanged();
            }

        );

        //ArrayAdapter<String> adapter= new    ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,datos);
        ArrayAdapter<Dato> adapter= new ArrayAdapter<Dato>(this,android.R.layout.simple_list_item_1,datos);
        binding.lvDatos.setAdapter(adapter);



        /*binding.lvDatos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //Log.d("depurando","Seleccionado: "+adapterView.getItemAtPosition(i).toString());
                Log.d("depurando","Seleccionado: "+view.toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });*/
        binding.lvDatos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Log.d("depurando","Seleccionado: "+view.toString());
                Log.d("depurando","Seleccionado: "+
                ((Dato)adapterView.getItemAtPosition(i)).getNombre()+" tiene "+
               + ((Dato)adapterView.getItemAtPosition(i)).getEdad()+" años");
            }
        });

    }
}