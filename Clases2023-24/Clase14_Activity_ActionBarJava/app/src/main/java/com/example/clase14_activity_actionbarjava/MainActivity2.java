package com.example.clase14_activity_actionbarjava;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.clase14_activity_actionbarjava.databinding.ActivityMain2Binding;
import com.example.clase14_activity_actionbarjava.databinding.ActivityMainBinding;

public class MainActivity2 extends GestionMenus {

    ActivityMain2Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //String dato = getIntent().getStringExtra("dato");
        //Usuario usuario=(Usuario) getIntent().getSerializableExtra("dato");
        //binding.tvDatoRecuperado.setText(dato);
        Bundle bundle = getIntent().getBundleExtra("datobundle");
        Usuario usuario=(Usuario)bundle.getSerializable("dato");
        binding.setUsuario(usuario);

        binding.bCerrarActivity.setOnClickListener(view -> {
            finish();
        });


    }


}