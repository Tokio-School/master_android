package com.example.ejem01_touchlistener_keylistener;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    /*getPointerbyId(int): recupera el identificador del putnero a traves de su indice
    //findPointerIndex(int)
            //problema! si quitamos un puntero, disminuye el indice de los otros q tengo
    //tengo 1-2-3-4, desaparece 2...tendria 1 igual y 3 -> 2 , 4 ->3
    //para ello utilizaremos los identificadores en vez de los indices
    si se el identificador puedo sacar su indice
    cuando hacemos getX()introducimos por parámetro el INDICE, no su identificador
    con getPointerId ,recupera el identificador a traves de su índice sería interesante recorrer con for los punteros que hay
    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        ((android.widget.LinearLayout)findViewById(R.id.ly_principal)).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                String acciones[] = { "ACTION_DOWN", "ACTION_UP", "ACTION_MOVE", "ACTION_CANCEL","ACTION_OUTSIDE", "ACTION_POINTER_DOWN", "ACTION_POINTER_UP" };
                TextView salida=((TextView)findViewById(R.id.textView));
                salida.setMovementMethod(new android.text.method.ScrollingMovementMethod());

                if (motionEvent.getPointerCount()>1) {
                    int accion = motionEvent.getAction();
                    int codigoAccion = accion & MotionEvent.ACTION_MASK;

                    salida.append(acciones[codigoAccion]);
                    for (int i = 0; i < motionEvent.getPointerCount(); i++) {
                       /* salida.append(" puntero:" + motionEvent.getPointerId(i) +
                                " x:" + motionEvent.getX(i) + " y:" + motionEvent.getY(i));*/
                        salida.append("ID: "+motionEvent.getPointerId(i)+"\t Indice: "+ motionEvent.findPointerIndex(motionEvent.getPointerId(i))+"\n CoordenadaX: "+motionEvent.getX(i)+"\n CoordenadaY: "+ motionEvent.getY(i));
                    }
                    salida.append("\n");
                }
                Toast.makeText(MainActivity.this.getApplicationContext(),"prueba"+motionEvent.getPointerCount(),Toast.LENGTH_SHORT).show();
                return true;
            }
        });


        ((EditText)findViewById(R.id.et_recogidaDatos)).setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {

                if ( keyEvent.getKeyCode() == KeyEvent.KEYCODE_A ) {

                    Log.d("depurando", "A pulsada");
                }
                if( keyEvent.getKeyCode() == KeyEvent.KEYCODE_ENTER ) {
                    if( keyEvent.getAction() == KeyEvent.ACTION_UP ) {
                        Log.d("depurando", "Intro levantado");
                    }
                }
                if (keyEvent.getAction() == KeyEvent.ACTION_DOWN) {
                    switch (keyEvent.getKeyCode()) {
                        case KeyEvent.KEYCODE_MENU:
                            Log.d("depurando", "Check del cuadro de texto  ");
                             break;

                    }
                }
                return true;
            }
        });

        TextView texto_largo=((TextView)findViewById(R.id.tv_datosConScroll));
        texto_largo.setMovementMethod(new android.text.method.ScrollingMovementMethod());
        ((Button)findViewById(R.id.b_meterDatosLargos)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cadena=((EditText)findViewById(R.id.et_recogidaDatos)).getText().toString();
                texto_largo.append(cadena);
            }
        });



    }
}