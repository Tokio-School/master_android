package com.example.clase22_concurrencia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.example.clase22_concurrencia.databinding.ActivityMainBinding;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {


    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.pbContador.setMax(20);


        /*binding.bSaludar.setOnClickListener(v -> {
            String nombre = binding.etNombre.getText().toString();
            Snackbar.make(v, "Hola " + nombre, Snackbar.LENGTH_LONG).show();

            Thread contador=new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 20; i++) {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        binding.tvContador.setText("Contador: " + i);
                        binding.pbContador.incrementProgressBy(1);
                        Log.d("depurando", "contador: " + i);
                    }
                }
            });
            contador.start();
        });*/


        Handler handler = new Handler(this.getMainLooper());
        handler.post(new Runnable() {
            @Override
            public void run() {
                    if (binding.pbContador.getProgress() == binding.pbContador.getMax()) {
                        handler.removeCallbacks(this);
                    }
                    else {
                        // binding.tvContador.setText("Contador: " + i);
                        binding.pbContador.incrementProgressBy(1);
                        //Log.d("depurando", "contador: " + i);
                        handler.postDelayed(this, 1000);
                    }
            }
        });



        binding.bPasarSegundaActividad.setOnClickListener(v -> {
            Intent intent= new Intent(this, MainActivity2.class);
            startActivity(intent);
        });

    }
}