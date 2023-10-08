package com.example.clase05_ejem02_spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    EditText et_nombre, et_edad;
    CheckBox cb_casado;
    Button boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recuperarComponentesVista();
        asignarListeners();
    }

    private void asignarListeners() {
        boton.setOnClickListener((vista)->{
            String nombre=et_nombre.getText().toString();
            String edad=et_edad.getText().toString();
            String casado=cb_casado.isChecked()?"Casado":"Soltero";
            String mensaje=String.format("Hola %s, tienes %s años y eres %s",nombre,edad,casado);
            Snackbar.make(vista,mensaje,Snackbar.LENGTH_LONG).show();
        });

    }

    private void recuperarComponentesVista() {
        et_nombre=((EditText)findViewById(R.id.et_nombre));
        et_edad=((EditText)findViewById(R.id.et_edad));
        cb_casado=((CheckBox)findViewById(R.id.cb_casado));
        boton=((Button)findViewById(R.id.b_Guardar));
    }
}