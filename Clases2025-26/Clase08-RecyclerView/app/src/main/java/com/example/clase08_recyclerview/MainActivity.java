package com.example.clase08_recyclerview;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.clase08_recyclerview.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private ArrayList<Usuario> usuarios=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        Usuario usuario=new Usuario("Juan Perez",30,"Calle Falsa 123");
        usuarios.add(usuario);
        usuarios.add(new Usuario("Ana Gomez",25,"Avenida Siempre Viva 742"));
        usuarios.add(new Usuario("Luis Martinez",40,"Plaza Mayor 1"));
        usuarios.add(new Usuario("Marta Rodriguez",28,"Calle del Sol 45"));
        System.out.println(usuario.toString());
        binding.setUser(usuario);


        binding.bAnadir.setOnClickListener(boton -> {
                Usuario nuevoUsuario=new Usuario(
                        binding.tietNombre.getText().toString(),
                        Integer.parseInt(binding.tietEdad.getText().toString()),
                        binding.tietDireccion.getText().toString()
                );

                usuarios.add(nuevoUsuario);
                Usuario usuarioVacio=new Usuario("",0,"");
                binding.setUser(usuarioVacio);
                binding.rvUsuarios.getAdapter().notifyDataSetChanged();
                Log.d("depurando","Usuario añadido: "+ Arrays.toString(usuarios.toArray()));

            }
        );

        UsuarioAdapter adapter=new UsuarioAdapter(usuarios);

        binding.rvUsuarios.setAdapter(adapter);
        binding.rvUsuarios.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));



    }
}