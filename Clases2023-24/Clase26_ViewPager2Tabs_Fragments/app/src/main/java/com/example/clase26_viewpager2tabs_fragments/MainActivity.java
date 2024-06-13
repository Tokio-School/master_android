package com.example.clase26_viewpager2tabs_fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;

import com.example.clase26_viewpager2tabs_fragments.databinding.ActivityMainBinding;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.viewpager2.setAdapter(new MyAdaptadorViewpager2Fragments(getSupportFragmentManager(),getLifecycle()));

        new TabLayoutMediator(binding.tabLayout, binding.viewpager2,
                (tab, position) -> tab.setText("Tab " + (position + 1))
        ).attach();

        // Establecer los iconos y colores para cada pestaña
        binding.tabLayout.getTabAt(0).setIcon(R.drawable.baseline_1k_24);
        binding.tabLayout.getTabAt(1).setIcon(R.drawable.baseline_2k_24);
        binding.tabLayout.getTabAt(2).setIcon(R.drawable.baseline_3k_24);
        binding.tabLayout.getTabAt(3).setIcon(R.drawable.baseline_4k_24);

        binding.tabLayout.getTabAt(0).view.setBackgroundColor(ContextCompat.getColor(this, android.R.color.holo_blue_light));
        binding.tabLayout.getTabAt(1).view.setBackgroundColor(ContextCompat.getColor(this, android.R.color.holo_green_light));
        binding.tabLayout.getTabAt(2).view.setBackgroundColor(ContextCompat.getColor(this, android.R.color.holo_orange_light));
        binding.tabLayout.getTabAt(3).view.setBackgroundColor(ContextCompat.getColor(this, android.R.color.holo_purple));

        binding.tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                // Cambiar el color de fondo de la pestaña seleccionada
               // tab.view.setBackgroundColor(ContextCompat.getColor(MainActivity.this, android.R.color.white));
                binding.tabLayout.setTabTextColors(ContextCompat.getColor(MainActivity.this, android.R.color.black), ContextCompat.getColor(MainActivity.this, android.R.color.holo_green_light));
              //  binding.tabLayout.setSelectedTabIndicatorColor(ContextCompat.getColor(MainActivity.this, android.R.color.white));
                //Cambiar el color del icono
                tab.getIcon().setTint(ContextCompat.getColor(MainActivity.this, android.R.color.holo_red_dark));
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                // Cambiar el color de fondo de la pestaña no seleccionada

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });





    }
}