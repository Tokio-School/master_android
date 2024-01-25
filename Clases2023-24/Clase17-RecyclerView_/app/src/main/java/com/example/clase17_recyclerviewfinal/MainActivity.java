package com.example.clase17_recyclerviewfinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.clase17_recyclerviewfinal.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Persona pepe=new Persona(20,"Pepe","123456");
        Persona maria=new Persona(23,"Maria","555456");
        Persona juan=new Persona(25,"Juan","123456");
        List<Persona> personas=new ArrayList<>();
        personas.add(pepe);
        personas.add(maria);
        personas.add(juan);personas.add(juan);personas.add(juan);personas.add(juan);personas.add(juan);personas.add(juan);personas.add(juan);personas.add(juan);personas.add(juan);

        binding.rvVistaDatos.setAdapter(new MyPersonaRecyclerViewAdapter(personas));
        //binding.rvVistaDatos.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        //binding.rvVistaDatos.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        binding.rvVistaDatos.setLayoutManager(new GridLayoutManager(this,2));




    }



}