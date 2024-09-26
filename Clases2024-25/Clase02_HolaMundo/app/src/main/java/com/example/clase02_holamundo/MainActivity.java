package com.example.clase02_holamundo;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

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
        ((Button)findViewById(R.id.b_recuperarDatos)).setOnClickListener(view->{
            String nombre=((EditText)findViewById(R.id.et_nombre)).getText().toString();
            String contrena=((EditText)findViewById(R.id.et_contrasena)).getText().toString();
            Log.d("depuracion","Se ha pulsado el boton: "+nombre+" "+contrena);
        });






    }
}