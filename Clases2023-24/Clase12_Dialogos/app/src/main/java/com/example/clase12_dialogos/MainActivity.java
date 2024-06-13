package com.example.clase12_dialogos;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    Button b_seleccion_multiple,b_aceptar_cancelar,b_lista,b_personalizado,b_alerta;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setViews();
        setListeners();

    }

    private void setListeners() {
        b_alerta.setOnClickListener(view -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Alerta");
            builder.setMessage("Esto es una alerta");

            builder.setPositiveButton("Aceptar", (dialogInterface, i) -> {
                dialogInterface.dismiss();
            });
            builder.show();

        });

        b_aceptar_cancelar.setOnClickListener(view -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Alerta");
            builder.setMessage("Esto es una alerta");

            builder.setPositiveButton("Aceptar", (dialogInterface, i) -> {
                Snackbar.make(view,"Has aceptado",Snackbar.LENGTH_LONG).show();
                dialogInterface.dismiss();
            });
            builder.setNegativeButton("Cancelar", (dialogInterface, i) -> {
                dialogInterface.dismiss();
            });
            builder.show();

        });

        b_lista.setOnClickListener(view -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            String opciones[] = {"Opcion 1","Opcion 2","Opcion 3"};

            builder.setTitle("Alerta multiples opciones");

            builder.setItems(opciones, (dialogInterface, i) -> {
                Snackbar.make(view,"Has seleccionado "+opciones[i],Snackbar.LENGTH_LONG).show();
                switch (opciones[i])
                {
                    case "Opcion 1":

                        break;
                    case "Opcion 2":

                        break;
                    case "Opcion 3":

                        break;
                }
                dialogInterface.dismiss();
            });
            builder.show();

        });

        b_personalizado.setOnClickListener(view -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            View viewAlert=getLayoutInflater().inflate(R.layout.dialogo_personalizado,null);
            ((Button)viewAlert.findViewById(R.id.b_saludar)).setOnClickListener(view1 -> {
                Snackbar.make(viewAlert,"Hola",Snackbar.LENGTH_LONG).show();
            });


            builder.setView(viewAlert);
            builder.setTitle("Diálogo personalizado");

            builder.setPositiveButton("Aceptar", (dialogInterface, i) -> {
                String nombre=((TextInputEditText)viewAlert.findViewById(R.id.tiet_nombre)).getText().toString();
                int edad=Integer.parseInt(((TextInputEditText)viewAlert.findViewById(R.id.tiet_edad)).getText().toString());

                Persona persona=new Persona(nombre,edad);
                Snackbar.make(view,"Has aceptado "+persona.toString(),Snackbar.LENGTH_LONG).show();

                dialogInterface.dismiss();
            });


            builder.show();

        });

        b_seleccion_multiple.setOnClickListener(view -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            String opciones[] = {"Opcion 1","Opcion 2","Opcion 3"};
            boolean selecciones[]={false,false,false};

            builder.setTitle("Alerta multiples opciones");

            //builder.setMultiChoiceItems(opciones, new boolean[]{false,true,false}, (dialogInterface, i, b) -> {
            builder.setMultiChoiceItems(opciones, selecciones, (dialogInterface, i, b) -> {
                Snackbar.make(view,"Has seleccionado "+opciones[i],Snackbar.LENGTH_LONG).show();
                selecciones[i]=b;
           });
            builder.setPositiveButton("Aceptar", (dialogInterface, i) -> {
                Snackbar.make(view,"Has aceptado"+ Arrays.toString(selecciones),Snackbar.LENGTH_LONG).show();
                dialogInterface.dismiss();
            });

            builder.show();

        });

    }

    private void setViews() {
        b_aceptar_cancelar=(Button)findViewById(R.id.b_aceptar_cancelar);
        b_alerta=(Button)findViewById(R.id.b_alerta);
        b_personalizado=((Button)findViewById(R.id.b_personalizado));
        b_lista=((Button)findViewById(R.id.b_multiple));
        b_seleccion_multiple =((Button)findViewById(R.id.b_selecion_multiple));



    }


}