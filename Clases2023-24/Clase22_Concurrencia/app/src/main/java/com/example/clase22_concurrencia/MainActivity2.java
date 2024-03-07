package com.example.clase22_concurrencia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;

import com.example.clase22_concurrencia.databinding.ActivityMain2Binding;

public class MainActivity2 extends AppCompatActivity {

    ActivityMain2Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.shimmer.startShimmer();
        Handler handler = new Handler(super.getMainLooper());
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                binding.shimmer.stopShimmer();
                binding.shimmer.hideShimmer();
                binding.shimmer.setVisibility(android.view.View.GONE);
            }
        }, 3000);



    }
}