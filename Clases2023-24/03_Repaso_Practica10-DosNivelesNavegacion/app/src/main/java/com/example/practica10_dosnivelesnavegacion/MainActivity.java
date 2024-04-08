package com.example.practica10_dosnivelesnavegacion;

import static androidx.navigation.fragment.FragmentKt.findNavController;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.practica10_dosnivelesnavegacion.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


      /*  findNavController()



        binding.navView.setNavigationItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.fragmentUno:
                    binding.drawerLayout.closeDrawers();
                    break;
                case R.id.fragmentDos:
                    binding.drawerLayout.closeDrawers();
                    break;
                case R.id.fragmentTres:
                    binding.drawerLayout.closeDrawers();
                    break;
            }
            return true;
        });*/

    }

}