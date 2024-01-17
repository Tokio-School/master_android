package com.example.clase16_trabajandoconfragments;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.clase16_trabajandoconfragments.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements FragmentUno.GestionarPulsacionFragment {

    FragmentUno fragmentUno;
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        //setContentView(R.layout.activity_main);
        setContentView(binding.getRoot());

        binding.bEnviarDatoFragment.setOnClickListener(boton -> {
            Log.d("depurando",binding.etDatoAEnviar.getText().toString());

            fragmentUno = FragmentUno.newInstance(binding.etDatoAEnviar.getText().toString());
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragmentContainerView,fragmentUno)
                    .commit();

        });

        binding.bBorrarFragment.setOnClickListener(boton -> {

            /*getSupportFragmentManager()
                    .beginTransaction()
                    .remove(fragmentUno)
                    .commit(); */
            getSupportFragmentManager()
                    .beginTransaction()
                    .remove(getSupportFragmentManager().findFragmentById(R.id.fragmentContainerView))
                    .commit();

        });


    }

    @Override
    public void escribirDatoDelFragment(String dato) {
        binding.tvDatoRecibido.setText(dato);
    }
}