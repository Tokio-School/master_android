package com.example.clase05_ejem02_spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText et_nombre, et_edad;
    CheckBox cb_casado;
    Button boton;
    Spinner spinner;
    ListView lista;
    ArrayList<Usuario> datos=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recuperarComponentesVista();

       /* datos.add("Pepe");
        datos.add("Juan");
        datos.add("Victor");*/
        Usuario prueba=new Usuario("Pepe",20,true);
        Log.d("depurando",prueba.toString());

        datos.add(prueba);
        datos.add(new Usuario("Juan",30,false));
        datos.add(new Usuario("Victor",40,true));


        ArrayAdapter<Usuario> adaptador=new ArrayAdapter<Usuario>(this,android.R.layout.simple_list_item_1,datos);
        spinner.setAdapter(adaptador);

        lista.setAdapter(adaptador);

        asignarListeners();
    }

    private void asignarListeners() {
        boton.setOnClickListener((vista)-> {
                    String nombre = et_nombre.getText().toString();
                    String edad = et_edad.getText().toString();
                    String casado = cb_casado.isChecked() ? "Casado" : "Soltero";
                    String mensaje = String.format("Hola %s, tienes %s años y eres %s", nombre, edad, casado);


            Snackbar.make(vista, mensaje, Snackbar.LENGTH_LONG).show();
                });
                    //((ArrayAdapter)spinner.getAdapter()).add(nombre);

        spinner.getSelectedItem();
            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int posicion, long l) {
                    Log.d("depurando","prueba......");
                    String datosUsuario=datos.get(posicion).getNombre()+" "+datos.get(posicion).getEdad()+" "+datos.get(posicion).isCasado();
                    Snackbar.make(view,datosUsuario,Snackbar.LENGTH_LONG).show();
                    Log.d("depurando",datosUsuario);
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });



          /*  spinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    String datosUsuario=datos.get(i).getNombre()+" "+datos.get(i).getEdad()+" "+datos.get(i).isCasado();
                    Snackbar.make(view,datosUsuario,Snackbar.LENGTH_LONG).show();
                    Log.d("depurando",datosUsuario);
                }
            });*/

         /*   spinner.setOnItemClickListener((adapterView, view, position, id) ->
            {
                    ////
            });*/





    }

    private void recuperarComponentesVista() {
        et_nombre=((EditText)findViewById(R.id.et_nombre));
        et_edad=((EditText)findViewById(R.id.et_edad));
        cb_casado=((CheckBox)findViewById(R.id.cb_casado));
        boton=((Button)findViewById(R.id.b_Guardar));
        spinner=((Spinner)findViewById(R.id.spinner));
        lista = ((ListView) findViewById(R.id.lv_usuarios));
    }
}