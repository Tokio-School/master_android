package com.example.clase08_recyclerview;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.clase08_recyclerview.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<Persona> personas=new ArrayList<>();
        personas.add(new Persona("Pepe",33,"a@b.com",ContextCompat.getDrawable(this, R.drawable.baseline_person_24)
        ));
        personas.add(new Persona("María",19,"maria@b.com",ContextCompat.getDrawable(this, R.drawable.baseline_person_24)
        ));
        personas.add(new Persona("Jose Manuel",18,"jm@b.com",ContextCompat.getDrawable(this, R.drawable.baseline_person_24)
        ));

        MiPersonaAdapter adapter=new MiPersonaAdapter(personas);
        binding.rvListadoDatos.setAdapter(adapter);
        binding.rvListadoDatos.setLayoutManager(new LinearLayoutManager(this));
        //binding.rvListadoDatos.setLayoutManager(new GridLayoutManager(this,2));

        binding.bAnadir.setOnClickListener(v-> {
            personas.add(new Persona(binding.tietNombre.getText().toString(),
                    Integer.parseInt(binding.tietEdad.getText().toString()),
                    binding.tietMail.getText().toString(),
                    ContextCompat.getDrawable(this, R.drawable.baseline_person_24)
                    ));
            adapter.notifyDataSetChanged();
        });

    }
}