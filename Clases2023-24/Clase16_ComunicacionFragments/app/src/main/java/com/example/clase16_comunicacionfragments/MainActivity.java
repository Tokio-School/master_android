package com.example.clase16_comunicacionfragments;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.clase16_comunicacionfragments.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements FragmentUno.GestionarPulsacionFragment{

    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.bEnviarDato.setOnClickListener(boton -> {
            getSupportFragmentManager().
                    beginTransaction(). // replace , remove ..... fragments
                    add(R.id.fcv_uno,FragmentUno.newInstance(binding.etDatoEnviar.getText().toString())).
                    commit();
        });



        /*binding.bCambiarFragments.setOnClickListener(boton -> {
            getSupportFragmentManager().
                    beginTransaction().
                    replace(R.id.fcv_dos,FragmentUno.newInstance("hola","mundo")).
                    commit();
        });*/





    }

    @Override
    public void escribirDatoDelFragment(String dato) {
        binding.etDatoEnviar.setText(dato);
    }
}