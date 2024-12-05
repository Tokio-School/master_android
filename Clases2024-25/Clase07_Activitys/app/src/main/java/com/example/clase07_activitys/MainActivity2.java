package com.example.clase07_activitys;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.clase07_activitys.databinding.ActivityMain2Binding;


public class MainActivity2 extends AppCompatActivity {

    ActivityMain2Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding= ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //String cadenaNombre=getIntent().getExtras().getString("nombre");
        //binding.tvDatoRecibido.setText(cadenaNombre);
        //Persona usuario=(Persona) getIntent().getExtras().getSerializable("usuario");
        Persona usuario=getIntent().getExtras().getParcelable("usuario");
        binding.setUsuario(usuario);



        binding.bDevolverDatos.setOnClickListener(
                (view)->{
                    Persona usuario2=new Persona(binding.tietNombre.getText().toString(),binding.tietContrasena.getText().toString());
                    Bundle bundle=new Bundle();
                    bundle.putParcelable("usuario",usuario2);
                    getIntent().putExtra("usuario",bundle);
                    MainActivity2.this.setResult(RESULT_OK,getIntent());
                    finish();
                }
        );






    }
}