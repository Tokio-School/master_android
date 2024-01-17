package com.example.clase15_activity_actionbarjava;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;

import android.content.Intent;
import android.os.Bundle;

import com.example.clase15_activity_actionbarjava.databinding.ActivityMainBinding;

public class MainActivity extends GestionMenus {

    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setActionBar(findViewById(R.id.toolbar));
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

        ActivityResultLauncher<Intent> resultLancher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
            if (result.getResultCode() == RESULT_OK) {
                String dato = result.getData().getStringExtra("dato");
                binding.etDato.setText(dato);
            }
        });




    }



}