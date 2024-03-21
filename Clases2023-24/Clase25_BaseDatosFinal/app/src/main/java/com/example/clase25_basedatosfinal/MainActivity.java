package com.example.clase25_basedatosfinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.util.Log;

import com.example.clase25_basedatosfinal.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

       BD basedatos= Room.databaseBuilder(this, BD.class, "bdPersonas").allowMainThreadQueries().build();
       PersonaDAO personaDAO=basedatos.personaDao();

        binding.bInsertar.setOnClickListener(boton->{
            Persona p=recuperarPersonaInterfaz();
            Persona p2=new Persona();
            binding.setPersona(p2);
            personaDAO.insertaPersona(p);
        });

        binding.bListar.setOnClickListener(boton->{
            List<Persona> datos=personaDAO.getAll();
            for(Persona p:datos){
                Log.d("depurando",p.toString());
            }
        });

        binding.bBorrar.setOnClickListener(boton->{
            int id=Integer.parseInt(binding.tietId.getText().toString());
            Persona p=new Persona();
            p.setId(id);
            personaDAO.deletePersona(p);
        });

        binding.bActualizar.setOnClickListener(boton->{
            Persona p=recuperarPersonaInterfaz();
            p.setId(Integer.parseInt(binding.tietId.getText().toString()));
            personaDAO.actualizaPersona(p);
        });

    }

    private Persona recuperarPersonaInterfaz() {
        return new Persona(
                binding.tietNombre.getText().toString(),
                Integer.parseInt(binding.tietEdad.getText().toString()),
                binding.tietDireccion.getText().toString()
        );
    }
}