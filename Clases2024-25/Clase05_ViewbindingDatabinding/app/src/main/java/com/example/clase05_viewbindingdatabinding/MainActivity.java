package com.example.clase05_viewbindingdatabinding;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.clase05_viewbindingdatabinding.databinding.ActivityMainBinding;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    ArrayList<Usuario> usuarios=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // EdgeToEdge.enable(this);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //setContentView(R.layout.activity_main);
       /* ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });*/

      /*  ((Button)findViewById(R.id.b_recogerDatos)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre=((TextInputEditText)findViewById(R.id.tiet_nombre)).getText().toString();
                String edad=((TextInputEditText)findViewById(R.id.tiet_edad)).getText().toString();
                Toast.makeText(MainActivity.this, "Hola "+nombre+" se que tienes "+edad+ " años ", Toast.LENGTH_SHORT).show();
            }
        });*/

       /* binding.tietNombre.setText("Juan");
        binding.tietEdad.setText("25");*/
        Usuario usuario=new Usuario("Juan II",35);
        binding.setUser(usuario);

        (binding.bRecogerDatos).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre=binding.tietNombre.getText().toString();
                String edad=binding.tietEdad.getText().toString();
                Toast.makeText(MainActivity.this, "Hola "+nombre+" se que tienes "+edad+ " años ", Toast.LENGTH_SHORT).show();

                Usuario usuario=new Usuario(nombre,Integer.parseInt(edad));
               /* usuarios.add(usuario);
                ((ArrayAdapter<Usuario> )binding.lvDatos.getAdapter()).notifyDataSetChanged();*/

                ((ArrayAdapter<Usuario> )binding.lvDatos.getAdapter()).add(usuario);
                binding.setUser(new Usuario());
            }
        });




        usuarios.add(new Usuario("Juan",25));
        usuarios.add(new Usuario("Pedro",35));
        usuarios.add(new Usuario("Maria",45));
        usuarios.add(new Usuario("Ana",55));
        ArrayAdapter<Usuario> adapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,usuarios);
        binding.lvDatos.setAdapter(adapter);


        binding.lvDatos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Snackbar.make(view,usuarios.get(i).getNombre(),Snackbar.LENGTH_SHORT).show();
                binding.setUser(usuarios.get(i));
            }
        });

        binding.spDesplegable.setAdapter(adapter);
        binding.spDesplegable.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                binding.setUser(adapter.getItem(i));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}