package com.example.clase07_ejem02_stringsyplurals;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText et_nombre,et_edad;
    Button boton;
    TextView tv_saludo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recuperarComponentes();
        boton.setOnClickListener(view -> {
            String nombre = et_nombre.getText().toString();
            int edad = Integer.parseInt(et_edad.getText().toString());
           // Si recuperamos de strings.xml
            // String cadenaSaludo=getResources().getString(R.string.saludo,nombre,edad);


            // Si recuperamos de plurals.xml
            String cadenaSaludo=getResources().getQuantityString(R.plurals.saludoPlural,edad,nombre,edad);
            tv_saludo.setText(cadenaSaludo);
        } );

    }

    private void recuperarComponentes() {
        et_nombre = ((EditText) findViewById(R.id.et_nombre));
        et_edad = ((EditText) findViewById(R.id.et_edad));
        boton= ((Button) findViewById(R.id.b_saludar));
        tv_saludo = ((TextView) findViewById(R.id.tv_saludo));
    }
}