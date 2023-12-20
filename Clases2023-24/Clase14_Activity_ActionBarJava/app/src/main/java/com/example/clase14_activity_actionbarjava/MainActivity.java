package com.example.clase14_activity_actionbarjava;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.clase14_activity_actionbarjava.databinding.ActivityMainBinding;

public class MainActivity extends GestionMenus {

    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(findViewById(R.id.mi_appbarlayout).findViewById(R.id.toolbar));
        getActionBar().setTitle("Mi Toolbar");




        binding.bEnviarDato.setOnClickListener(view -> {
            String dato = binding.etDato.getText().toString();

            Usuario usuario = new Usuario(dato);

            Intent intent = new Intent(this, MainActivity2.class);
            //intent.putExtra("dato",dato );
            Bundle bundle = new Bundle();
            bundle.putSerializable("dato",usuario);
            //bundle.putParcelable("dato",new UsuarioParcelable(dato));
            intent.putExtra("datobundle",bundle);
            //intent.putExtra("dato",usuario);

            startActivity(intent);

        });




    }



}