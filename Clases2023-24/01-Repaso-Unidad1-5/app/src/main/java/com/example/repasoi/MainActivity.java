package com.example.repasoi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.repasoi.databinding.ActivityMainBinding;
import com.example.repasoi.databinding.NuevoInterfazBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    NuevoInterfazBinding binding2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
      /*  binding2 = NuevoInterfazBinding.inflate(getLayoutInflater());
        setContentView(binding2.getRoot());*/

        binding.button.setOnClickListener(v -> {
            Toast.makeText(this, "Pulsación", Toast.LENGTH_SHORT).show();
            binding.setVariableUsuario(new Usuario());
        });




    }
}