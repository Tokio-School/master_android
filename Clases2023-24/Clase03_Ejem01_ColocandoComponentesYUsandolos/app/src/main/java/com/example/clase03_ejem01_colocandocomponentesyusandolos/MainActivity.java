package com.example.clase03_ejem01_colocandocomponentesyusandolos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("depurando","Acaba de entrar");



        ((Button)findViewById(R.id.b_recogerNombre)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                EditText casillaNombre=((EditText)findViewById(R.id.et_nombre));
                String nombre=casillaNombre.getText().toString();

                Log.d("depurando","Estoy en el onClick y el nombre es:"+nombre);

                ((TextView)findViewById(R.id.tv_nombre)).setText(nombre);
                casillaNombre.setText("");
            }
        });


        ((Switch)findViewById(R.id.sw_apagado)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Log.d("depurando","Consigo entrar en el onCheckedChanged");
                ((Button)findViewById(R.id.b_recogerNombre)).setEnabled(b);
            }
        });


    }
}