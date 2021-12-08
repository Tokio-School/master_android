package com.tokioschol.tp9_actionbar_toolbar.features.actionbar;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

import com.tokioschol.tp9_actionbar_toolbar.R;

public class ActionBarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_bar);
        /**
         * 1) Definir estilo  en el archivo de theme
         * {@link R.style.Theme_TP9_ACTIONBAR}
         *
         * 1.A) El título de la toolbar se puede poner en el manifest.
         */

        //agregamos el boton back en dicha activity
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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
     * @param item: es el actionView pulsado
     * @return debe devolver un boolean
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.shoppingcart){
            Toast.makeText(this,"hemos pusado en carrito",Toast.LENGTH_SHORT).show();
        }
        if(item.getItemId()==android.R.id.home){
            //Declarar en manifest a donde debe volver.
            NavUtils.navigateUpFromSameTask(this);
            overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
            //Otra opción es simplemente eliminar la activity y volvera al anterior del stack
            //finish
        }
        return super.onOptionsItemSelected(item);
    }


}