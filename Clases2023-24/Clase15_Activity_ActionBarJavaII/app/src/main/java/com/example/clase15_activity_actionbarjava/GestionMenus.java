package com.example.clase15_activity_actionbarjava;

import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

public class GestionMenus extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mi_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==R.id.opcion4)
            Snackbar.make(findViewById(R.id.opcion4),"Opcion 4",Snackbar.LENGTH_LONG).show();
        if (item.getItemId()==R.id.opcion3)
            Snackbar.make(findViewById(R.id.opcion4),"Opcion 3",Snackbar.LENGTH_LONG).show();
        if (item.getItemId()==R.id.opcion2)
            Snackbar.make(findViewById(R.id.opcion4),"Opcion 2",Snackbar.LENGTH_LONG).show();
        if (item.getItemId()==R.id.opcion1)
            Snackbar.make(findViewById(R.id.opcion4),"Opcion 1",Snackbar.LENGTH_LONG).show();

        return super.onOptionsItemSelected(item);
    }
}
