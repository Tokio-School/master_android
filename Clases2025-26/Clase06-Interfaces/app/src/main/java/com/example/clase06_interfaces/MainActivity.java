package com.example.clase06_interfaces;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.clase06_interfaces.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        Button boton=new Button(this);
        boton.setText("Pulsar aqui");

        binding.llVertical.addView(boton);




        binding.llVertical.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.d("depurando","Pulsado sobre el fondo"+ event.getX()+" , "+event.getY());
                binding.tvCoordenadas.setText("Pulsado sobre el fondo"+ event.getX()+" , "+event.getY());


                return false;
            }
        });

        binding.llMarronFrontal.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                String tipoAccion="";
                switch (event.getAction())
                {
                    case MotionEvent.ACTION_DOWN:
                        Log.d("depurando","ACTION_DOWN");
                        tipoAccion="ACTION_DOWN";
                        break;
                    case MotionEvent.ACTION_MOVE:
                        Log.d("depurando","ACTION_MOVE");
                        tipoAccion="ACTION_MOVE";
                        break;
                    case MotionEvent.ACTION_UP:
                        Log.d("depurando","ACTION_UP");
                        tipoAccion="ACTION_UP";
                        break;
                }

                Log.d("depurando","Pulsado sobre el frente"+ event.getX()+" , "+event.getY()+" tipo de accion "+ tipoAccion);
                binding.tvCoordenadas.setText("Pulsado sobre el frente"+ event.getX()+" , "+event.getY());


                return true;
            }
        });




    }
}