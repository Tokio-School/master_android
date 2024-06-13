package com.example.clase13_databinding;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.clase13_databinding.databinding.ActivityMainBinding;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText nombre;
    EditText edad;
    CheckBox soltero;
    Button boton;

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<String> deportes=new ArrayList<>();
        deportes.add("Baloncesto");
        deportes.add("Futbol");
        deportes.add("Tenis");


        Persona persona=new Persona("Prueba inicial2",23,false);
        persona.setListaDeportes(deportes);
        binding.setPerson(persona);


        binding.bGuardarDAtos.setOnClickListener((view)->{
            Persona person=new Persona("",0,false);
            binding.setPerson(person);

            Persona persona2=new Persona(binding.etNombre.getText().toString(),
                                    Integer.parseInt(binding.etEdad.getText().toString()),
                                    binding.cbSoltero.isChecked());
            Snackbar.make(view,persona2.toString(),Snackbar.LENGTH_LONG).show();

        });

    }


}