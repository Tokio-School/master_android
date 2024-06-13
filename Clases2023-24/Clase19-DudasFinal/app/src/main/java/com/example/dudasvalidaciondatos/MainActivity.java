package com.example.dudasvalidaciondatos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.dudasvalidaciondatos.databinding.ActivityMainBinding;
import com.google.android.material.snackbar.Snackbar;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.button.setOnClickListener(view -> {
            boolean nombre = validarNombre(binding.tietNombre.getText().toString());
            boolean dni = validarDNI(binding.tietDni.getText().toString());
            boolean correo = validarCorreo(binding.tietCorreo.getText().toString());
            boolean fechaNacimiento = validarFechaNacimiento(binding.tietFechaNac.getText().toString());
            Log.d("depurando", "onCreate: " + nombre + " " + dni + " " + correo + " " + fechaNacimiento);
            if (nombre && dni && correo && fechaNacimiento){
                Snackbar.make(view, "Datos correctos", Snackbar.LENGTH_LONG).show();
                binding.bGuardar.setEnabled(true);
            }
            else
                Snackbar.make(view, "Datos incorrectos", Snackbar.LENGTH_LONG).show();
        });





    }

    private boolean validarFechaNacimiento(String fechaNac) {
        Pattern patron = Pattern.compile("[0-9]{2}/[0-9]{2}/[0-9]{4}");
        if (patron.matcher(fechaNac).matches())
            return true;
        else
            return false;


    }

    private boolean validarCorreo(String correo) {

        Pattern patron = Pattern.compile("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+");
        if (patron.matcher(correo).matches())
            return true;
        else
            return false;
    }

    private boolean validarDNI(String dni) {
        Pattern patron = Pattern.compile("[0-9]{8}[A-Za-z]");
        if (patron.matcher(dni).matches())
            return true;
        else
            return false;
    }

    private boolean validarNombre(String nombre) {
        // https://docs.oracle.com/javase/7/docs/api/java/util/regex/Pattern.html

        Pattern patron = Pattern.compile("[A-Z][a-z]+");
        if (patron.matcher(nombre).matches())
            return true;
        else
            return false;

    }
}
