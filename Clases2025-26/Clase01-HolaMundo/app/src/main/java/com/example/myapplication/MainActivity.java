package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

//    private int contador=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

     /*   binding.tietDireccion.setText("Calle Falsa 123");
        binding.tietNombre.setText("Juan Perez");*/




        /*binding.bRecogidaDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.d("depurando",binding.tietDireccion.getText().toString());
                Log.d("depurando",binding.tietNombre.getText().toString());

                Log.d("depurando",binding.sDesplegable.getSelectedItem().toString());
            }
        });*/

        // Notación Lambda
        binding.bRecogidaDatos.setOnClickListener((View view) -> {

                Log.d("depurando",((Button)view).getText().toString());
            //    ((Button) view).setText(String.valueOf(contador++));
                Log.d("depurando",binding.tietDireccion.getText().toString());
                Log.d("depurando",binding.tietNombre.getText().toString());
                Log.d("depurando",binding.sDesplegable.getSelectedItem().toString());
                Persona usuario=new Persona(binding.tietNombre.getText().toString(),
                        binding.tietDireccion.getText().toString(),
                        Integer.parseInt(binding.tietEdad.getText().toString()),
                        ((RadioButton)binding.rgOpciones.findViewById(binding.rgOpciones.getCheckedRadioButtonId())).getText().toString()
                        );
                Log.d("depurando",usuario.toString());

        });


        /*binding.rgOpciones.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull RadioGroup radioGroup, int i) {

            }
        });*/
        binding.rgOpciones.setOnCheckedChangeListener((@NonNull RadioGroup radioGroup, int i) -> {
            //Log.d("depurando",String.valueOf(radioGroup.getCheckedRadioButtonId()));
            Log.d("depurando",((RadioButton)radioGroup.findViewById(radioGroup.getCheckedRadioButtonId())).getText().toString());

        });

        binding.sDesplegable.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    Log.d("depurando1",adapterView.getSelectedItem().toString());
                    Log.d("depurando2",((TextView)view).getText().toString());
                    Log.d("depurando3",adapterView.getItemAtPosition(i).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        /*binding.sActibarBoton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull CompoundButton compoundButton, boolean b) {

            }
        });*/
        binding.sActibarBoton.setOnCheckedChangeListener((compoundButton, b) -> {
            binding.bRecogidaDatos.setEnabled(b);
            if (b)
                binding.sActibarBoton.setText("Desactivar botón");
            else
                binding.sActibarBoton.setText("Activar botón");
        });
    }
}