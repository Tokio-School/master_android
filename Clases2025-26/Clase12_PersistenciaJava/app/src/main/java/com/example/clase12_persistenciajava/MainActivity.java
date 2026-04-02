package com.example.clase12_persistenciajava;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.room.Room;

import com.example.clase12_persistenciajava.databinding.ActivityMainBinding;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BD basedatos= Room.databaseBuilder(this,BD.class,"basedatos").allowMainThreadQueries().build();




        SharedPreferences preferencesLectura = getSharedPreferences("datos", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferencesLectura.edit();


        Persona personaSharedPreference = new Persona(0,preferencesLectura.getString("nombre", ""),
                preferencesLectura.getInt("edad", 0),
                preferencesLectura.getString("direccion", ""));
        binding.setPersona( personaSharedPreference);




        binding.bAgregarShared.setOnClickListener(view ->
                {
                    Persona persona = new Persona(0,binding.tietNombre.getText().toString(),
                            Integer.parseInt(binding.tietEdad.getText().toString()),
                            binding.tietDireccion.getText().toString());
                    editor.putString("nombre",persona.getNombre());
                    editor.putInt("edad",persona.getEdad());
                    editor.putString("direccion",persona.getDireccion());
                    editor.apply();
                });


        binding.bInsertar.setOnClickListener(view -> {
            Persona persona = new Persona(0,binding.tietNombre.getText().toString(),
                    Integer.parseInt(binding.tietEdad.getText().toString()),
                    binding.tietDireccion.getText().toString());
            basedatos.personaDao().insertar(persona);
        });

        binding.bListar.setOnClickListener(view -> {
            List<Persona> personas = basedatos.personaDao().listar();
           for(Persona persona:personas)
           {
               Log.d("depurando",persona.toString());
           }
        });

        binding.bBorrar.setOnClickListener(view ->
        {
            basedatos.personaDao().borrar(Integer.parseInt(binding.tietId.getText().toString()));

        });

    }
}