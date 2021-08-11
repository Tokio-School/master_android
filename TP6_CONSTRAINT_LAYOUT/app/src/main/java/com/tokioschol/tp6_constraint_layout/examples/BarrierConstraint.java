package com.tokioschol.tp6_constraint_layout.examples;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.tokioschol.tp6_constraint_layout.databinding.ActivityBarrierConstraintBinding;

import java.util.Random;

public class BarrierConstraint extends AppCompatActivity {

    private ActivityBarrierConstraintBinding binding;
    //1 Generar un array de 3 textos
    String[] textosDinamicos = {"corto", "Texto Medio", "Soy el texto mas largo", "Había una vez", "un cuento que explicaba", "cuando nadie", "se iva", "a casa"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBarrierConstraintBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //2 seteo de inicio de los valores
        settingDinamicText(null);

        //3 Capturar el listener del boton
        binding.barrierBtn.setOnClickListener(this::settingDinamicText);
    }

    private void settingDinamicText(View view) {
        //4 asignarlos aleatoriamente a los textos dinamicos.
        binding.textoDinamico1.setText(textosDinamicos[new Random().nextInt(8)]);
        binding.textoDinamico2.setText(textosDinamicos[new Random().nextInt(8)]);
        binding.textoDinamico3.setText(textosDinamicos[new Random().nextInt(8)]);
    }
}