package com.example.practica6;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

public class ActivityLogin extends Activity_ConMenu {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);





    }

    public void cambiarFragmento(FragmentRegister fragmentRegister) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentContainerView, fragmentRegister)
                .addToBackStack(null)
                .commit();
    }

    public void volverFragmentLogin() {
        getSupportFragmentManager().popBackStack();
    }

    public void cambiarActivity(Activity_Home activityHome) {
       Intent testigo=new Intent(this, Activity_Home.class);
       startActivity(testigo);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Log.d("depurando", "onOptionsItemSelected");
        if (item.getItemId()==R.id.navegador)
        {
            //Lanzamos una actividad de una url, http://www.google.es
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.es"));
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}