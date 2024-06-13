package com.example.clase05_ejem01_botones;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ArrayList<Button> listaBotones = new ArrayList<>();
    int primerDigito = Integer.MIN_VALUE;
    int segundoDigito = Integer.MIN_VALUE;
    int resultado = Integer.MIN_VALUE;
    boolean operadorBoolean = false;
    char operadorSeleccionado = ' ';
    String cadenaMostrar = " ";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((Button) findViewById(R.id.b_sumar)).setOnClickListener(this);
        ((Button) findViewById(R.id.b_restar)).setOnClickListener(this);
        ((Button) findViewById(R.id.b_ac)).setOnClickListener(this);
        ((Button) findViewById(R.id.b_igual)).setOnClickListener(this);


        for (int i = 0; i < 10; i++) {
            listaBotones.add((Button) findViewById(
                    getResources().getIdentifier("b_" + i, "id", getPackageName())
            ));
        }
        for (Button boton : listaBotones) {
            boton.setOnClickListener(this);
        }

        anadirBotonEnTiempoEjecucion();

    }

    private void anadirBotonEnTiempoEjecucion() {
        Button boton=new Button(this);
        boton.setBackgroundColor(ContextCompat.getColor(this,android.R.color.holo_blue_light));
        boton.setTextColor(ContextCompat.getColor(this,android.R.color.white));

        boton.setText("Saludar");
        // Make the same style as the other Main Activitys button






        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v,"Hola soy la calculdora",Snackbar.LENGTH_LONG).show();
            }
        });
        ((LinearLayout)findViewById(R.id.ly_inferior)).addView(boton);

    }


    @Override
    public void onClick(View v) {


        /*R.id.*, since ADT 14 are not more declared as final static int so you can not use in
         switch case construct. You could use if else clause instead.
         With Android Gradle Plugin 8.0.0 all your R-class resources are by default no longer declared as final/constant (hence won't work in switch statements). If you use the AGP upgrade wizard in Android Studio, it will actually add this line to your gradle.properties to keep the old behavior:
        android.nonFinalResIds=false
         */
        /*
        switch (v.getId())
        {
            case SUMA:
                break;
            default:
                break;

        }*/
        if (v.getId() == R.id.b_sumar) {
            seleccionarOperador((Button) v);
        } else if (v.getId() == R.id.b_restar) {
            seleccionarOperador((Button) v);
        } else if (v.getId() == R.id.b_ac) {
            resetear();
        } else if (v.getId() == R.id.b_igual) {
            calcularResultado();
            prepararSiguienteCalculo();
        } else {
            seleccionarDigitos((Button) v);
        }

        Log.d("depurando",String.valueOf(operadorSeleccionado));
        Log.d("depurando",String.valueOf(operadorBoolean));
        Log.d("depurando",String.valueOf(primerDigito));
        Log.d("depurando",String.valueOf(segundoDigito));
        ((TextView) findViewById(R.id.tv_solucion)).setText(cadenaMostrar);
    }
    private void seleccionarOperador(Button b) {
        if (!operadorBoolean) {
            operadorBoolean = true;
            cadenaMostrar = cadenaMostrar + " " + operadorSeleccionado;
        }

        if (segundoDigito != Integer.MIN_VALUE) {
            calcularResultado();
            prepararSiguienteCalculo();
            seleccionarOperador(b);
        } else {
            Log.d("depurando", "AAAAA" + cadenaMostrar);
            operadorSeleccionado = b.getText().toString().charAt(0);
            cadenaMostrar = cadenaMostrar.substring(0, cadenaMostrar.length() - 2) + " " + operadorSeleccionado;
        }
    }

    private void seleccionarDigitos(Button b) {
        if (!operadorBoolean) {
            primerDigito = primerDigito * 10 + Integer.parseInt(b.getText().toString());
            cadenaMostrar = String.valueOf(primerDigito);
        } else {
            segundoDigito = segundoDigito * 10 + Integer.parseInt(b.getText().toString());
            if (String.valueOf(segundoDigito).length() == 1) {
                cadenaMostrar = cadenaMostrar + " " + segundoDigito;
            } else {
                cadenaMostrar = cadenaMostrar.substring(0, cadenaMostrar.length() - String.valueOf(segundoDigito).length()) + " " + segundoDigito;
            }
            //calcularResultado();
            //prepararSiguienteCalculo();
        }

    }

    private void calcularResultado() {
        switch (operadorSeleccionado) {
            case '+':
                resultado = primerDigito + segundoDigito;
                break;
            case '-':
                resultado = primerDigito - segundoDigito;
                break;
        }
    }

    private void resetear() {
        primerDigito = 0;
        resultado = Integer.MIN_VALUE;
        segundoDigito = Integer.MIN_VALUE;
        operadorBoolean = false;
        operadorSeleccionado = ' ';
        cadenaMostrar = "0";
        cadenaMostrar = String.valueOf(primerDigito);
    }

    private void prepararSiguienteCalculo() {
        primerDigito = resultado;
        resultado = Integer.MIN_VALUE;
        segundoDigito = Integer.MIN_VALUE;
        operadorBoolean = false;
        operadorSeleccionado = ' ';
        cadenaMostrar = String.valueOf(primerDigito);
    }
}