package com.example.ejem02_primeroscomponentes;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Log.d("depurando","Hola mundo en consola");

        ((TextView)findViewById(R.id.tv_holaMundo)).setText("Hola....");

        ((Button)findViewById(R.id.b_saludar)).setText("Pulsa...");

        EditText edit_nombre=((EditText)findViewById(R.id.et_nombre));
        edit_nombre.setText("Victor");

        Log.d("depurando",edit_nombre.getText().toString());






    }
}