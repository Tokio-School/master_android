package com.example.clase06_ejem02_recuperandorg_cb_lv;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    EditText et_nombre;
    Spinner sp_ciudad;
    Switch sw_casado;
    RadioGroup rg_profesiones;
    CheckBox cb_baloncesto,cb_futbol,cb_voleibol;
    Button b_recuperarTexto;
    Spinner sp_datosUsuario2;

    ArrayList<Usuario> datos=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recuperarComponentes();
        anadirListener();
    }

    private void anadirListener() {
        b_recuperarTexto.setOnClickListener(view -> {
            String nombre = et_nombre.getText().toString();
            String ciudad = sp_ciudad.getSelectedItem().toString();
            boolean casado = sw_casado.isChecked();
            String profesion = ((RadioButton)findViewById(rg_profesiones.getCheckedRadioButtonId())).getText().toString();
            String deportes = "";
            ArrayList<String> deportesSeleccionados = new ArrayList<>();

            if(cb_baloncesto.isChecked()){
                deportesSeleccionados.add("Baloncesto");
            }
            if(cb_futbol.isChecked()){
                deportesSeleccionados.add("Futbol");
            }
            if(cb_voleibol.isChecked()){
                deportesSeleccionados.add("Voleibol");
            }
            String mensaje = "Nombre: "+nombre+"\nCiudad: "+ciudad+"\nCasado: "+casado+"\nProfesion: "+profesion+"\nDeportes: ";
            Snackbar.make(view,mensaje,Snackbar.LENGTH_LONG).show();

            Usuario usuario = new Usuario(nombre,ciudad,casado,profesion,deportesSeleccionados);
            datos.add(usuario);
            sp_datosUsuario2.setAdapter(new ArrayAdapter<Usuario>(this,android.R.layout.simple_list_item_1,datos ));

        });

        rg_profesiones.setOnCheckedChangeListener((radioGroup,i) -> {
            RadioButton rb = findViewById(i);
            Log.d("depurando",rb.getText().toString());
        });

        sp_ciudad.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l){
                Log.d("depurando",((TextView)view).getText().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        CompoundButton.OnCheckedChangeListener escuchadorCB=new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    Log.d("depurando",compoundButton.getText().toString());
                }
            }
        };
        cb_futbol.setOnCheckedChangeListener(escuchadorCB);
        cb_voleibol.setOnCheckedChangeListener(escuchadorCB);
        cb_baloncesto.setOnCheckedChangeListener(escuchadorCB);


    }

    private void recuperarComponentes() {
        et_nombre = (EditText) findViewById(R.id.et_nombre);
        sp_ciudad = (Spinner)findViewById(R.id.sp_ciudad);
        sw_casado = (Switch)findViewById(R.id.sw_casado);
        rg_profesiones = (RadioGroup) findViewById(R.id.rg_profesiones);
        cb_baloncesto = (CheckBox) findViewById(R.id.cb_baloncesto);
        cb_futbol =(CheckBox) findViewById(R.id.cb_futbol);
        cb_voleibol = (CheckBox) findViewById(R.id.cb_voleibol);
        b_recuperarTexto = (Button) findViewById(R.id.b_recuperarTexto);
        sp_datosUsuario2= (Spinner) findViewById(R.id.sp_datosUsuario2);
    }
}