package com.example.clase07_activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import com.example.clase07_activities.databinding.ActivityMainBinding;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding= ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        ActivityResultLauncher<Intent> launcherActivity = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK) {
                        Intent data = result.getData();
                        Usuario usuarioDevuelto = data.getParcelableExtra("user_Register_activity");
                        Log.d("depurando", "Usuario devuelto: " + usuarioDevuelto.toString());
                        binding.setUser(usuarioDevuelto);
                    }
                    else
                        Snackbar.make(binding.tietNombre,
                                "Operación cancelada",
                                Snackbar.LENGTH_LONG).show();
                }
        );


        binding.bEnviarUsuario.setOnClickListener(v -> {
            String nombre= binding.tietNombre.getText().toString();
            int edad= Integer.parseInt(binding.tietEdad.getText().toString());
            Usuario usuario= new Usuario(nombre, edad);
            Usuario vacio=new Usuario("",0);
            binding.setUser(vacio);
            Log.d("depurando",usuario.toString());


            Intent intent= new Intent(this, ActivityRegistro.class);
            //intent.putExtra("info","Victor Vergel");
            intent.putExtra("user_activity", usuario);
            //startActivity(intent);

            launcherActivity.launch(intent);


        });


        binding.bLanzarNavegador.setOnClickListener(v ->
                // lanzar el navegador
                {

                    Intent intentNavegador= new Intent(Intent.ACTION_VIEW);
                    intentNavegador.setData(android.net.Uri.parse("https://www.google.com"));
                    startActivity(intentNavegador);
                }


                );




    }
}