package com.example.clase24_sharedpreference_final;

import androidx.appcompat.app.AppCompatActivity;
import androidx.datastore.preferences.core.MutablePreferences;
import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.preferences.core.PreferencesKeys;
import androidx.datastore.preferences.rxjava2.RxPreferenceDataStoreBuilder;
import androidx.datastore.rxjava2.RxDataStore;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import com.example.clase24_sharedpreference_final.databinding.ActivityMainBinding;

import io.reactivex.Single;

public class MainActivity extends AppCompatActivity {


    private RxDataStore<Preferences> dataStore;


    private SharedPreferences.Editor preferencias;
    private SharedPreferences preferenciasLectura;

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //Cargar DataStore
        /* Mejor no utilizarla por el momento
       dataStore=new RxPreferenceDataStoreBuilder(this, "mispreferencias2").build();

        Preferences.Key<String> usuarioKey= PreferencesKeys.stringKey("usuario");
        dataStore.data().map(preferencias->preferencias.get(usuarioKey)).subscribe(user->binding.tietUsuario.setText(user));
        Preferences.Key<String> passwordKey= PreferencesKeys.stringKey("password");
        dataStore.data().map(preferencias->preferencias.get(passwordKey)).subscribe(password->binding.tietContrasena.setText(password));
*/






        preferenciasLectura=getSharedPreferences("mispreferencias",MODE_PRIVATE);
        preferencias=preferenciasLectura.edit();


        Usuario pepe=new Usuario(
                preferenciasLectura.getString("usuario","usuario"),
                preferenciasLectura.getString("contrasena","contrasena"));
        binding.setUsuario(pepe);

        binding.bGuardarDatosUsuario.setOnClickListener(boton->{
            Usuario usuario=new Usuario(binding.tietUsuario.getText().toString(),binding.tietContrasena.getText().toString());
            preferencias.putString("usuario",usuario.getUsuario());
            preferencias.putString("contrasena",usuario.getPassword());
            preferencias.commit();



            //Almacenar con Datastore
      /*      Single<Preferences> single = dataStore.updateDataAsync(preferences -> {
                MutablePreferences mutablePreferences = preferences.toMutablePreferences();
                mutablePreferences.set(PreferencesKeys.stringKey("usuario"), usuario.getUsuario());
                mutablePreferences.set(PreferencesKeys.stringKey("password"), usuario.getPassword());
                return Single.just(mutablePreferences);
            });
            single.subscribe();*/


        });

        binding.bContador.setOnClickListener(boton->{
            int numero=0;
            numero=preferenciasLectura.getInt("contador",0);
            binding.tvContador.setText(String.valueOf(numero+1));
            preferencias.putInt("contador",numero+1);
            preferencias.commit();
        });

        preferenciasLectura.getAll().forEach((k,v)->{
            Log.d("depurando",k+" "+v);
        });

    }
}