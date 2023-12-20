package com.example.clase13_databinding;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Persona persona=new Persona("Victor","Valladolid","123456789");
        ((EditText)findViewById(R.id.et_nombre)).setText(persona.getNombre());
        ((EditText)findViewById(R.id.et_ciudadNacimiento)).setText(persona.getCiudadNacimiento());
        ((EditText)findViewById(R.id.et_telefono)).setText(persona.getTelefono());



        ((Button)findViewById(R.id.b_guardarDAtos)).setOnClickListener((view)->{
            Persona persona2=new Persona("Nombre","Valladolid","123456789");
            ((TextView)findViewById(R.id.tv_nombre)).setText(persona.getNombre());
            ((TextView)findViewById(R.id.tv_ciudadNacimiento)).setText(persona.getCiudadNacimiento());
            ((TextView)findViewById(R.id.tv_telefono)).setText(persona.getTelefono());
        });

    }
}