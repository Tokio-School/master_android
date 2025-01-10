package com.example.clase08_recyclerview;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.clase08_recyclerview.databinding.ActivityPersonaBinding;
import com.example.clase08_recyclerview.databinding.PersonaItemBinding;
import com.google.android.material.snackbar.Snackbar;

public class ActivityPersona extends AppCompatActivity {

    ActivityPersonaBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding=ActivityPersonaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        Persona persona=(Persona)getIntent().getSerializableExtra("persona",Persona.class);
        Snackbar.make(binding.getRoot(),persona.toString(),Snackbar.LENGTH_SHORT).show();

        //Asigno los datos de la persona al include
        PersonaItemBinding itemBinding = binding.include;
        itemBinding.setPersona(persona);

        binding.bFinalizar.setOnClickListener(v->{
            finish();
        });


    }
}