package com.example.clase10_ejem_constraintlayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //((ConstraintLayout)findViewById(R.id.cl_panelPrincipal)).setBackground(getResources().getColor(R.color.color_victor));



    }
}