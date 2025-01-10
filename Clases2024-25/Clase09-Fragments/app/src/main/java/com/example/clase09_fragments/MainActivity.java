package com.example.clase09_fragments;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;

import com.example.clase09_fragments.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.bCargarFragment.setOnClickListener(v->{
            FragmentManager fragmentManager=getSupportFragmentManager();
            fragmentManager
                    .beginTransaction()
                    .add(binding.fragmentContainerView.getId(),new Fragment1())
                    .commit();

        });

        binding.bReemplazarFragment.setOnClickListener(v->{
            FragmentManager fragmentManager=getSupportFragmentManager();
            fragmentManager
                    .beginTransaction()
                    .replace(binding.fragmentContainerView.getId(),Fragment2.newInstance(binding.tietDato.getText().toString())   )
                    .commit();
        });



    }
}