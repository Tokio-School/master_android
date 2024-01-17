package com.example.clase15_activity_actionbarjava;

import android.os.Bundle;

import com.example.clase15_activity_actionbarjava.databinding.ActivityMain2Binding;
import com.example.clase15_activity_actionbarjava.databinding.ActivityMainBinding;

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
        setActionBar(findViewById(R.id.toolbar));
        getActionBar().setTitle("Mi Toolbar segundo activity");
        getActionBar().setDisplayHomeAsUpEnabled(true);




    }


}