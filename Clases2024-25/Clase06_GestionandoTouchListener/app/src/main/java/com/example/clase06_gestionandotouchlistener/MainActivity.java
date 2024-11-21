package com.example.clase06_gestionandotouchlistener;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.clase06_gestionandotouchlistener.databinding.ActivityMainBinding;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        /*binding.bRecuperarDato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Hola", Toast.LENGTH_SHORT).show();
            }
        });*/


        binding.bRecuperarDato.setOnClickListener(vista-> {
                Toast.makeText(MainActivity.this, "Hola", Toast.LENGTH_SHORT).show();
        });

        /*binding.llFondoSalmon.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, android.view.MotionEvent motionEvent) {
                Toast.makeText(MainActivity.this, "Tocaste el fondo", Toast.LENGTH_SHORT).show();
                return false;
            }
        });*/

        binding.llFondoSalmon.setOnTouchListener( (view, motionEvent) ->{
                Toast.makeText(MainActivity.this, "Tocaste el fondo salmón", Toast.LENGTH_SHORT).show();
                return false;
        });

        binding.llFrenteVerde.setOnTouchListener( (view, motionEvent) ->{
            //Toast.makeText(MainActivity.this, "Tocaste el frente verde", Toast.LENGTH_SHORT).show();

            if (motionEvent.getAction() == android.view.MotionEvent.ACTION_DOWN) {
                Toast.makeText(MainActivity.this, "Presionaste el frente verde", Toast.LENGTH_SHORT).show();
            }else if (motionEvent.getAction() == android.view.MotionEvent.ACTION_UP) {
                Toast.makeText(MainActivity.this, "Soltaste el frente verde", Toast.LENGTH_SHORT).show();
            } else if (motionEvent.getAction()== android.view.MotionEvent.ACTION_MOVE) {
                binding.tvCoordenada.setText(motionEvent.getX()+" -"+motionEvent.getY());
            }
            return true;
        });



        binding.tietNombre.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Log.d("depurando", charSequence.toString());
                Pattern patronNombre = Pattern.compile("[a-zA-Z ]+");


               /* if (charSequence.toString().length()>10) {
                    binding.tietNombre.setError("El nombre no puede tener más de 10 caracteres");
                    binding.tilNombre.setError("OJO");
                }else
                {
                    binding.tietNombre.setError(null);
                    binding.tilNombre.setError(null);
                }

                if (!patronNombre.matcher(charSequence.toString()).matches()) {
                    binding.tietNombre.setError("El nombre solo puede tener letras");
                    binding.tilNombre.setError("OJO");
                }*/
                if (binding.tietNombre.getText().toString().length()>10)
                    binding.bRecuperarDato.setEnabled(true);
                else
                    binding.bRecuperarDato.setEnabled(false);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });





    }
}