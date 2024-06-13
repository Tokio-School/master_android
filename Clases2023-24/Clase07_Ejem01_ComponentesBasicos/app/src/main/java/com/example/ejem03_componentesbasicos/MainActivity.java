package com.example.ejem03_componentesbasicos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;




import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> ciudades = new ArrayList<>();
    private ArrayList<Usuario> usuarios = new ArrayList<>();
    Spinner sp_ciudades;
    Spinner desplegableUsuarios;

    Usuario usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Usuario usuario1 = new Usuario("Prueba","Soltero","Valladolid",new ArrayList<String>(Arrays.asList("Baloncesto","Futbol")));
        usuarios.add(usuario1);
        usuario1 = new Usuario("Prueba2","Casado","Zamora",new ArrayList<String>(Arrays.asList("Baloncesto","Futbol")));
        usuarios.add(usuario1);

        inicializarDesplegables();     //Inicializo el spinner de las ciudades y de Usuarios

        Button botonGuardar = ((Button) findViewById(R.id.b_guardar));

        botonGuardar.setOnClickListener((boton) -> {
            mostrarDatos();
        });


    }

    private void inicializarDesplegables() {
        ciudades.add("Valladolid");
        ciudades.add("Zamora");
        ciudades.add("Soria");
        ciudades.add("Salamanca");
        ciudades.add("Segovia");
        ciudades.add("Ávila");
        ciudades.add("Burgos");
        ciudades.add("Madrid");
        sp_ciudades = ((Spinner) findViewById(R.id.sp_ciudades));
        ArrayAdapter<String> adaptador_ciudades = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, ciudades);
        sp_ciudades.setAdapter(adaptador_ciudades);

        desplegableUsuarios = ((Spinner) findViewById(R.id.sp_usuarios));
        ArrayAdapter<Usuario> adaptadorUsuarios = new ArrayAdapter<Usuario>(this, android.R.layout.simple_list_item_1, usuarios);
        desplegableUsuarios.setAdapter(adaptadorUsuarios);

        desplegableUsuarios.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d("depurando","----------------------------");
                Log.d("depurando","nombre:" +usuarios.get(i).getNombre());
                Log.d("depurando","ciudad:" +usuarios.get(i).getCiudad());
                Log.d("depurando","Casado:"+usuarios.get(i).getEstadoCivil());
                Log.d("depurando","Deportes"+ Arrays.toString(usuarios.get(i).getDeportes().toArray()));

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }


    
    private void mostrarDatos() {
        //Radio Group
        RadioGroup rgEstado = findViewById(R.id.rg_estado);
        int IdSeleccionado = rgEstado.getCheckedRadioButtonId();
        RadioButton radioButton = findViewById(IdSeleccionado);
        String estadoCivil = radioButton.getText().toString();

        //Spinner Ciudades
        Spinner spinnerCiudades = findViewById(R.id.sp_ciudades);
        String ciudadSeleccionada = spinnerCiudades.getSelectedItem().toString();

        //Checkbox Deportes
        ArrayList<String> deportes = new ArrayList<>();
        if (((CheckBox) findViewById(R.id.cb_baloncesto)).isChecked()) {
            deportes.add("Baloncesto");
        }
        if (((CheckBox) findViewById(R.id.cb_futbol)).isChecked()) {
            deportes.add("Futbol");
        }
        if (((CheckBox) findViewById(R.id.cb_tenis)).isChecked()) {
            deportes.add("Tenis");
        }

        usuario = new Usuario();
        usuario.setNombre(String.valueOf(((EditText) findViewById(R.id.et_introduceNombre)).getText()));
        usuario.setEstadoCivil(estadoCivil);
        usuario.setCiudad(ciudadSeleccionada);
        usuario.setDeportes(deportes);

        usuarios.add(usuario);

        Log.d("depurando", "Nombre: " + ((EditText) findViewById(R.id.et_introduceNombre)).getText());
        Log.d("depurando", "Estado civil: " + estadoCivil);
        Log.d("depurando", "Ciudad: " + ciudadSeleccionada);
        Log.d("depurando", "Deporte escogido: " + Arrays.toString(deportes.toArray()));
    }


}


