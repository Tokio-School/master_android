package com.example.clase07_activities;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.clase07_activities.databinding.ActivityMainBinding;
import com.example.clase07_activities.databinding.ActivityRegistroBinding;

public class ActivityRegistro extends AppCompatActivity {

    private ActivityRegistroBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding= ActivityRegistroBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        //Usuario pepe= new Usuario("Pepe", 30);
        binding.setUser(getIntent().getParcelableExtra("user_activity"));

        //Toast.makeText(this, getIntent().getStringExtra("info"),Toast.LENGTH_LONG).show();


        binding.bDevolverUsuario.setOnClickListener(v ->
                {
                    //Usuario usuarioModificado= binding.getUser();
                    Usuario usuarioModificado= new Usuario(
                            binding.tietNombre.getText().toString(),
                            Integer.parseInt(binding.tietEdad.getText().toString())
                    );
                    getIntent().putExtra("user_Register_activity", usuarioModificado);
                    Log.d("depurando", "Usuario modificado: " + usuarioModificado.toString());
                    setResult(RESULT_OK, getIntent());
                    finish();

                }

        );

    }
}