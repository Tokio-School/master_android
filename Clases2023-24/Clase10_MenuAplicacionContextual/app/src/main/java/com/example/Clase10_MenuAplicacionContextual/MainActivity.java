package com.example.Clase10_MenuAplicacionContextual;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       registerForContextMenu(((LinearLayout)findViewById(R.id.ly_panelFondo)));

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menucontextual,menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        LinearLayout fonpri = (LinearLayout)findViewById(R.id.ly_panelFondo);
        switch (item.getItemId()){
            case R.id.limpiar:
                //fonpri.setBackgroundColor(Color.GREEN);
                //API Level 23
                //fonpri.setBackgroundColor(getResources().getColor(R.color.color_victor));
                fonpri.setBackgroundColor(ContextCompat.getColor(this,R.color.color_victor));

        }

        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mimenu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        LinearLayout fonpri = (LinearLayout)findViewById(R.id.ly_panelFondo);
        switch (item.getItemId()){
            case R.id.red:
                fonpri.setBackgroundColor(Color.RED);
                break;
            case R.id.green:
                fonpri.setBackgroundColor(Color.GREEN);
                break;
            case R.id.yellow:
                fonpri.setBackgroundColor(Color.YELLOW);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}