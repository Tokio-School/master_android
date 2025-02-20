package com.example.clase12_persistencia;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.room.Room;

import com.example.clase12_persistencia.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    SharedPreferences.Editor preferencias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BD basedatos = Room.databaseBuilder(this, BD.class, "bdPersonas").allowMainThreadQueries().build();
        PersonaDAO personaDAO = basedatos.personaDao();

        SharedPreferences preferenciasLectura = getSharedPreferences("mispreferencias", MODE_PRIVATE);
        preferencias=preferenciasLectura.edit();


        //Persona pedro=new Persona("Pedro", 25, "Calle 1");
        Persona pedro=new Persona(preferenciasLectura.getString("nombre", "...."),25,"Calle 2");
        binding.setPersona(pedro);

        binding.bAgregarShared.setOnClickListener(boton->{
            Persona persona=new Persona(binding.tietNombre.getText().toString(), Integer.parseInt(binding.tietEdad.getText().toString()), binding.tietDireccion.getText().toString());
            preferencias.putString("nombre", persona.getNombre());
            preferencias.commit();
        });

        binding.bInsertar.setOnClickListener(boton->{
            Persona persona=new Persona(binding.tietNombre.getText().toString(), Integer.parseInt(binding.tietEdad.getText().toString()), binding.tietDireccion.getText().toString());
            personaDAO.insertaPersona(persona);

        });

        binding.bListar.setOnClickListener(boton->{

           /* personaDAO.getAll().forEach(p->{
                Log.d("depurando", p.toString());
            });*/
            for(Persona persona:personaDAO.getAll()){
                Log.d("depurando", persona.toString());
            }
        });


        binding.bBorrar.setOnClickListener(boton->{
            int id=Integer.parseInt(binding.tietId.getText().toString());
            Persona persona=new Persona();
            persona.setId(id);
            //personaDAO.deletePersona(persona);
            personaDAO.deletePersona(id);
        });


        binding.bActualizar.setOnClickListener(boton->{
            Persona persona=new Persona(binding.tietNombre.getText().toString(), Integer.parseInt(binding.tietEdad.getText().toString()), binding.tietDireccion.getText().toString());
            persona.setId(Integer.parseInt(binding.tietId.getText().toString()));
            //personaDAO.actualizaPersona(persona);
            personaDAO.actualizaPersona2(Integer.parseInt(binding.tietId.getText().toString()),
                    binding.tietNombre.getText().toString(),
                    Integer.parseInt(binding.tietEdad.getText().toString()),
                    binding.tietDireccion.getText().toString());
        });


    }
}