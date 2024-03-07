package com.example.notificaciones2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.notificaciones2.databinding.ActivityMain2Binding;

public class MainActivity2 extends AppCompatActivity {

    ActivityMain2Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.bVolver.setOnClickListener(
                (boton) -> {
                    finish();
                });
    }
}