package com.example.clase07_activitys;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.clase07_activitys.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        binding.bPasarSegundoActivity.setOnClickListener(
                (view)->{
                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    Persona usuario=new Persona(binding.tietNombre.getText().toString(),binding.tietContrasena.getText().toString());
                    Bundle bundle = new Bundle();
                    //bundle.putString("nombre", binding.tietNombre.getText().toString());
                    //intent.putExtra("nombre", binding.tietNombre.getText().toString());
                   // bundle.putSerializable("usuario",usuario);
                    bundle.putParcelable("usuario",usuario);

                    intent.putExtras(bundle);
                    startActivity(intent);
                }
        );
       /* binding.bPasarSegundoActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });*/

        ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK) {
                        // There are no request codes
                        Intent data = result.getData();
                        Bundle bundle=data.getBundleExtra("usuario");
                        Persona usuario=bundle.getParcelable("usuario");
                        binding.setUsuario(usuario);
                    }
                });


        binding.bPasarSegundoActivityYRecibirPosteriormente.setOnClickListener(
                (view)->{
                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    Persona usuario=new Persona(binding.tietNombre.getText().toString(),binding.tietContrasena.getText().toString());
                    Bundle bundle = new Bundle();
                    //bundle.putString("nombre", binding.tietNombre.getText().toString());
                    //intent.putExtra("nombre", binding.tietNombre.getText().toString());
                    // bundle.putSerializable("usuario",usuario);
                    bundle.putParcelable("usuario",usuario);
                    intent.putExtras(bundle);
                    activityResultLauncher.launch(intent);
                }
        );



    }
}