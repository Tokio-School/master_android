package com.example.clase11_procesos;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.clase11_procesos.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private int contador=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Handler handler = new Handler(this.getMainLooper());

        binding.pbProgreso.setMax(20);
        binding.pbProgreso.setMin(0);

        binding.bContador.setOnClickListener(view -> {
            // Resetear contador si es necesario al empezar
            contador = 0;

            // Creamos la tarea que se ejecutará repetidamente
            Runnable progressRunnable = new Runnable() {
                @Override
                public void run() {
                    // 1. Condición de parada (en lugar de un bucle for)
                    if (contador <= 20) {
                        // 2. Actualizamos la interfaz (esto es seguro porque el Handler usa el MainLooper)
                        binding.tvContador.setText(String.valueOf(contador));
                        binding.pbProgreso.setProgress(contador);

                        contador++;

                        // 3. Programamos la SIGUIENTE ejecución en 500ms
                        // Esto hace que la UI no se bloquee y el usuario vea el cambio
                        handler.postDelayed(this, 500);
                    }
                }
            };

            // Iniciamos la primera ejecución
            handler.post(progressRunnable);
        });
           /* for (int i = 0; i < 30; i++) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                binding.tvContador.setText(String.valueOf(contador));
                contador++;
            }
        });*/



        binding.bCambiarActivity.setOnClickListener(view ->
                {
                    Intent testigoActivity2 = new Intent(this, MainActivity2.class);
                    startActivity(testigoActivity2);
                }
                );


    }
}