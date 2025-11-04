package com.example.clase05_viewdatabinding;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.clase05_viewdatabinding.databinding.ActivityMainBinding;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });*/
        binding= ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Persona juan=new Persona("Juan Perez",30);
        binding.setPerson(juan);
        /*binding.tietNombre.setText("Juan Perez");
        binding.tietEdad.setText("30");*/

        ArrayList<Persona> personas=new ArrayList<>();
        personas.add(new Persona("Ana Gomez",25));
        personas.add(new Persona("Luis Rodriguez",28));
        personas.add(new Persona("Marta Sanchez",22));
        personas.add(new Persona("Carlos Fernandez",35));

        ArrayAdapter<Persona> adapter=new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                personas
        );
        binding.lvNombres.setAdapter(adapter);




        binding.bGuardarDatos.setOnClickListener((View view)->{
               /* String nombre=binding.tietNombre.getText().toString();
                int edad=Integer.parseInt(binding.tietEdad.getText().toString());*/

                Persona temp=binding.getPerson();

                Snackbar.make(MainActivity.this.binding.getRoot(),
                        //"Nombre: "+nombre+" - Edad: "+edad,
                        temp.toString(),
                        Snackbar.LENGTH_LONG).show();
                ((ArrayAdapter<Persona>)binding.lvNombres.getAdapter()).add(temp);
                ((ArrayAdapter<?>) binding.lvNombres.getAdapter()).notifyDataSetChanged();
                //binding.lvNombres.
            }
        );

        binding.lvNombres.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Persona seleccionado=(Persona) adapterView.getItemAtPosition(i);
                Toast.makeText(MainActivity.this,
                        "Seleccionado: "+seleccionado.getNombre()+" - Edad: "+seleccionado.getEdad(),
                        Toast.LENGTH_LONG).show();
            }
        });

    }
}