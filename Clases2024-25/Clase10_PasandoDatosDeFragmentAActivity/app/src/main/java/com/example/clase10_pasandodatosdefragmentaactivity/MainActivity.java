package com.example.clase10_pasandodatosdefragmentaactivity;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.clase10_pasandodatosdefragmentaactivity.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements FragmentUno.EnviarDatos {

    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



    }

    @Override
    public void enviarDatos(String dato) {
        binding.tvDatoDelFragment.setText(dato);
    }
}