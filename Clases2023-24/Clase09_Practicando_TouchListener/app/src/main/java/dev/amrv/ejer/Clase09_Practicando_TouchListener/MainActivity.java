package dev.amrv.ejer.Clase09_Practicando_TouchListener;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // getViews se encarga de recoger todas las views que se van a usar
        // en variables para que no haya que usar findViewById demasiadas veces
        // ensuciando el código
        getViews();

        // Crea un nuevo adaptador para el ListView que estará vacío
        lvPersonas.setAdapter(new ArrayAdapter<Persona>(
                getApplicationContext(), android.R.layout.simple_list_item_1, new ArrayList<>()));

        // Activa o desactiva el botón dependiendo del valor del ToggleButton
        tbonOff.setOnCheckedChangeListener(
            (compoundButton, b) -> bttGrabar.setEnabled(b)
        );

        bttGrabar.setOnClickListener(view -> bttGrabarOnClick(view));
        //bttGrabar.setOnClickListener(this::bttGrabarOnClick);

        lvPersonas.setOnItemClickListener(this::lvPersonasOnItemClick);

        tvBorrar.setOnTouchListener(this::tvBorrarOnTouch);
    }

    private void bttGrabarOnClick(View view) {
        String nombre = etNombre.getText().toString();
        String edad = etEdad.getText().toString();
        String ciudad = spCiudad.getSelectedItem().toString();
        // Si tiene algún valor vacío no continuamos
        if (nombre.isEmpty() || edad.isEmpty())
            return;

        // Añade a la lista de personas
        Persona p = new Persona(nombre, edad, ciudad);
        ArrayAdapter<Persona> ad = (ArrayAdapter<Persona>) lvPersonas.getAdapter();
        ad.add(p);

        // Borra los valores de los EditText (para que sea más cómodo para el usuario)
        etNombre.setText("");
        etEdad.setText("");
    }

    private void lvPersonasOnItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Persona p = (Persona) lvPersonas.getItemAtPosition(i);
        // Ya que el toString de persona solo incluye el nombre, debemos crear un string personalizado
        // Nombre - Edad (Ciudad). He usado el String.format porque es más cómodo
        String pString = String.format("%s - %s (%s)", p.getNombre(), p.getEdad(), p.getCiudad());
        Toast.makeText(getApplicationContext(), pString, Toast.LENGTH_SHORT).show();
    }

    float startingX;
    private boolean tvBorrarOnTouch(View view, MotionEvent motionEvent) {
        // Guardamos la posición del ratón cuando el action es down.
        // Esto nos servirá como posición inicial desde la cual empieza
        // el movimiento de arrastrar, ya que el arrastre es precedido
        // siempre por un action down
        if (motionEvent.getAction() == MotionEvent.ACTION_DOWN)
            startingX = motionEvent.getX();

        // Si la acción no es la de arrastrar, nos salimos
        if (motionEvent.getAction() != MotionEvent.ACTION_MOVE)
            return true;

        // Comprobamos que se haya movido más de 200 píxeles en X
        if (Math.abs(startingX - motionEvent.getX()) < 200)
            return true;

        // Borramos todos los items dentro de la lista
        ArrayAdapter<Persona> ad = (ArrayAdapter<Persona>) lvPersonas.getAdapter();
        ad.clear();
        return true;
    }

    private ToggleButton tbonOff;
    private EditText etNombre;
    private EditText etEdad;
    private Spinner spCiudad;
    private Button bttGrabar;
    private TextView tvBorrar;
    private ListView lvPersonas;

    private void getViews() {
        tbonOff = findViewById(R.id.tb_on_off);
        etNombre = findViewById(R.id.et_nombre);
        etEdad = findViewById(R.id.et_edad);
        spCiudad = findViewById(R.id.sp_ciudad);
        bttGrabar = findViewById(R.id.btt_grabar);
        tvBorrar = findViewById(R.id.tv_borrar);
        lvPersonas = findViewById(R.id.lv_personas);
    }
}