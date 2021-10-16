package com.tokioschol.tp9_actionbar_toolbar.features.actionbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.tokioschol.tp9_actionbar_toolbar.R;
import com.tokioschol.tp9_actionbar_toolbar.features.material.MaterialCollapsingActivity;

public class ActionBarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_bar);
        /**
         * 1) Definir estilo  en el archivo de theme
         * {@link R.style.Theme_TP9_ACTIONBAR}
         *
         * 1.A) El título de la toolbar se pone en el manifest
         */
    }

    /**
     * 2) Si queremos poner un menu solamente tenemos que inflarlo
     * en este metodo
     * @param menu el menu que queremos
     * @return debe devolver un boolean
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actionbar_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    /**
     * En este método es donde generamos las acciones de
     * los iconos del menu.
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}