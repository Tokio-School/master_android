package com.example.clase11_constraintlayoutj;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textview.MaterialTextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText telNombre;
    private TextInputEditText telPrecio;
    private Button btnAnadir,bBorrar;
    private ArrayList<Producto> productos = new ArrayList<Producto>();
    private ListView listaProductos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recuperarComponentes();
//        listaProductos=(ListView)findViewById(R.id.lv_compra);
//        if (listaProductos == null) {
//            Log.d("depurando", "listaProductos es null");
//        }
        productos.add(new Producto("Leche", 1.5));
        productos.add(new Producto("Pan", 0.9));
        listaProductos.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, productos));
        colocarListeners();

    }

    private void colocarListeners() {
        btnAnadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre = telNombre.getText().toString();
                Double precio = Double.parseDouble(telPrecio.getText().toString());
                Producto producto = new Producto(nombre, precio);
                //1ª opcion
                //((ArrayAdapter<Producto>)listaProductos.getAdapter()).add(producto);

                //2º opcion
                productos.add(producto);
                ((ArrayAdapter<Producto>)listaProductos.getAdapter()).notifyDataSetChanged();

            }
        });
        listaProductos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d("depurando",((MaterialTextView)view).getText().toString());
                Snackbar.make(view, view.toString(), Snackbar.LENGTH_SHORT).show();
                Toast.makeText(MainActivity.this, view.toString(), Toast.LENGTH_SHORT).show();


                Producto producto = productos.get(i);
                telNombre.setText(producto.getNombre());
                telPrecio.setText(producto.getPrecio().toString());
            }
        });
        bBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((ArrayAdapter<Producto>)listaProductos.getAdapter()).clear();
            }
        });


    }

    private void recuperarComponentes() {

        telNombre = (TextInputEditText)findViewById(R.id.tiet_producto);
        telPrecio = (TextInputEditText)findViewById(R.id.tiet_precio);
        btnAnadir = (Button)findViewById(R.id.b_aniadir);
        listaProductos = (ListView)findViewById(R.id.lv_compra);
        bBorrar = (Button)findViewById(R.id.b_borrar);

    }
}