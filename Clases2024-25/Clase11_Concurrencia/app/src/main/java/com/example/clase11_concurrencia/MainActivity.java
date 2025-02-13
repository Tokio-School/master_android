package com.example.clase11_concurrencia;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.clase11_concurrencia.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {


    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.shimmer.stopShimmer();



        binding.bIncrementar.setOnClickListener(v -> {
            binding.tvContador.setText(String.valueOf(Integer.parseInt(binding.tvContador.getText().toString()) + 1));
        });



        binding.bIniciarShimmer.setOnClickListener(v-> {
            binding.shimmer.startShimmer();
            Handler handler = new Handler(this.getMainLooper());
            handler.postDelayed(() -> {
                binding.shimmer.stopShimmer();
                binding.shimmer.hideShimmer();
                binding.shimmer.setVisibility(View.GONE);
            },3000);
        });

        binding.pbBarraTareas.setMax(10);
        Thread proceso=new Thread(() -> {
            for (int i = 0; i <= 10; i++) {
                try {
                    Thread.sleep(5000);
                    binding.pbBarraTareas.setProgress(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        proceso.start();
        /*Handler handler = new Handler(this.getMainLooper());
        handler.post(() -> {
            if (binding.pbBarraTareas.getProgress() < binding.pbBarraTareas.getMax() ) {
                binding.pbBarraTareas.incrementProgressBy(1);
                handler.postDelayed(Thread.currentThread(), 1000);
            }
        });*/

    }
}