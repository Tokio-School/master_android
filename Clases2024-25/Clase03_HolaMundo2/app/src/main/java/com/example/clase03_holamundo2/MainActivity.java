package com.example.clase03_holamundo2;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.clase03_holamundo.R;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
/*        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });*/

        /*((Button)findViewById(R.id.b_recuperarDatos)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre=((EditText)findViewById(R.id.et_nombre)).getText().toString();
                String contrena=((EditText)findViewById(R.id.et_contrasena)).getText().toString();
                Log.d("depuracion","Se ha pulsado el boton: "+nombre+" "+contrena);
            }
        });*/
        // NOtación Lambda
        Button botonRecuperar=(Button)findViewById(R.id.b_recuperarDatos);
        botonRecuperar.setOnClickListener(view->{
            /*String nombre=((EditText)findViewById(R.id.et_nombre)).getText().toString();
            String contrena=((EditText)findViewById(R.id.et_contrasena)).getText().toString();*/

            String nombre=((TextInputEditText)findViewById(R.id.tiet_nombre)).getText().toString();
            String contrasena=((TextInputEditText)findViewById(R.id.tiet_contrasena)).getText().toString();

            int identificadorRBSeleccionado=((RadioGroup)findViewById(R.id.rg_tipoCurso)).getCheckedRadioButtonId();
            String tipoCurso=((RadioButton)findViewById(identificadorRBSeleccionado)).getText().toString();

            String github=((CheckBox)findViewById(R.id.cb_github)).isChecked() ? "Github" : "";
            String java= ((CheckBox)findViewById(R.id.cb_java)).isChecked() ? "Java" : "";
            String kotlin=((CheckBox)findViewById(R.id.cb_kotlin)).isChecked() ? "Kotlin" : "";
            String python=((CheckBox)findViewById(R.id.cb_python)).isChecked() ? "Python" : "";


            String ciudad=((Spinner)findViewById(R.id.sp_ciudades)).getSelectedItem().toString();


            Log.d("depuracion","Se ha pulsado el boton: Nombre:"+nombre+" Contraseña: "+contrasena+ " Tipo de curso: "+tipoCurso + " Conocimientos: "+github+" "+java+" "+kotlin+" "+python);
            Log.d("depuracion","Ciudad: "+ciudad);

        });

        ((RadioGroup)findViewById(R.id.rg_tipoCurso)).setOnCheckedChangeListener((radioGroup, checkedId) -> {
            Log.d("depuracion","Se ha seleccionado el radio button: "+((RadioButton)findViewById(checkedId)).getText().toString());
            Log.d("depuracion",radioGroup.getCheckedRadioButtonId()+"<---->"+checkedId);
        });


        ((Switch)findViewById(R.id.sw_apagar)).setOnCheckedChangeListener((compoundButton, activado) -> {
            botonRecuperar.setEnabled(activado);
            if (activado)
                ((Switch)compoundButton).setText("Apagado");
            else
                ((Switch)compoundButton).setText("Encendido");
        });

        ((Spinner)findViewById(R.id.sp_ciudades)).setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "Ciudad: "+((TextView)view).getText().toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



    }
}