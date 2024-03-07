package com.example.ejemplorecyclerjavacrudfinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

import com.example.ejemplorecyclerjavacrudfinal.databinding.ActivityMainBinding;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.tietNombre.setOnKeyListener((componente, keyCode, event) -> {

            if (((TextInputEditText)componente).getText().length()> 5) {
                binding.bRecuperarDatos.setEnabled(true);
            }
            else if (((TextInputEditText)componente).getText().length()<=5) {
                binding.bRecuperarDatos.setEnabled(false);
            }


            /*if (event.getAction() == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                binding.tietEdad.requestFocus();
                return true;
            }*/
            return false;
        });
        binding.bRecuperarDatos.setOnClickListener(boton -> {

            String nombre=binding.tietNombre.getText().toString();
            Pattern patron = Pattern.compile("^[A-Z][a-z]+");
            if (!patron.matcher(nombre).matches())
                binding.tietNombre.setError("Nombre no valido");
            else
                binding.tietNombre.setError(null);

            Usuario usuario =new Usuario(Integer.parseInt(binding.tietEdad.getText().toString()),
                    nombre,
                    binding.tietTelefono.getText().toString());

            Snackbar.make(boton,usuario.toString(),Snackbar.LENGTH_LONG).show();


        });


        binding.rvUsuarios.setLayoutManager(new LinearLayoutManager(this));
        UsuariosProvider datos=new UsuariosProvider();
        binding.rvUsuarios.setAdapter(new UsuariosAdapter(datos.getUsuarios()));


        binding.bAnadir.setOnClickListener(v -> {
            Usuario usuario = new Usuario(Integer.parseInt(binding.tietEdad.getText().toString()),
                    binding.tietNombre.getText().toString(),
                    binding.tietTelefono.getText().toString()
            );

            binding.setUser(new Usuario());

            datos.getUsuarios().add(0,usuario);
            binding.rvUsuarios.getAdapter().notifyItemInserted(0);
            binding.rvUsuarios.scrollToPosition(0);
        });



    }
}