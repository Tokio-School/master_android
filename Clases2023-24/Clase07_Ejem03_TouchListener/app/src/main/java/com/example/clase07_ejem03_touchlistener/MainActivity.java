package com.example.clase07_ejem03_touchlistener;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout ly_fondo = ((LinearLayout) findViewById(R.id.ly_fondo));
        LinearLayout ly_superior = ((LinearLayout) findViewById(R.id.ly_superior));
        TextView tv_mensaje= ((TextView) findViewById(R.id.tv_mensaje));

       /* ly_fondo.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return false;
            }
        });*/
        ly_fondo.setOnTouchListener((view,motionEvent)->{
            Snackbar.make(view,"Pulsado fondo",Snackbar.LENGTH_SHORT).show();
            return false;
        });

        ly_superior.setOnTouchListener((view,motionEvent)->{
            //Snackbar.make(view,"Pulsado Superior",Snackbar.LENGTH_SHORT).show();
            switch (motionEvent.getAction())
            {
                /*case MotionEvent.ACTION_DOWN:
                    Snackbar.make(view,"Presionando Superior",Snackbar.LENGTH_SHORT).show();
                    break;*/
                case MotionEvent.ACTION_MOVE:
                    tv_mensaje.setText("X: "+motionEvent.getX()+" Y: "+motionEvent.getY());
                    break;
               /* case MotionEvent.ACTION_UP:
                    Snackbar.make(view,"Levantando Superior",Snackbar.LENGTH_SHORT).show();
                    break;*/
            }
            return true;
        });




    }
}