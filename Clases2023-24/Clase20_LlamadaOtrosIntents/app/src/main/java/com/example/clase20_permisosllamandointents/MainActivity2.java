package com.example.clase20_permisosllamandointents;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.clase20_permisosllamandointents.databinding.ActivityMain2Binding;

public class MainActivity2 extends AppCompatActivity {

    ActivityMain2Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String dato = getIntent().getStringExtra("dato");
        binding.tvDatoEnviado.setText(dato);

        binding.bFinalizarActivity2.setOnClickListener(view -> {
            setResult(RESULT_OK, getIntent().putExtra("datoDevuelto", "Victor"));
            finish();
        });

    }
}