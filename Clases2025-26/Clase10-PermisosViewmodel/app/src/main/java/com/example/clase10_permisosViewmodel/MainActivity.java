package com.example.clase10_permisosViewmodel;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.clase10_permisosViewmodel.databinding.ActivityMainBinding;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private Contador contadorNormal;
    private ContadorViewmodel contadorViewmodel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding= ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        contadorNormal= new Contador(0);
        contadorViewmodel= new ViewModelProvider(this).get(ContadorViewmodel.class);
        binding.setLifecycleOwner(this);
        binding.setContadorNormal(contadorNormal);
        binding.setContadorViewModel(contadorViewmodel);






        ActivityResultLauncher<Intent> launcherActivity = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK) {
                        Intent data = result.getData();
                        Usuario usuarioDevuelto = data.getParcelableExtra("user_Register_activity");
                        Log.d("depurando", "Usuario devuelto: " + usuarioDevuelto.toString());
                        binding.setUser(usuarioDevuelto);
                    }
                    else
                        Snackbar.make(binding.tietNombre,
                                "Operación cancelada",
                                Snackbar.LENGTH_LONG).show();
                }
        );


        binding.bEnviarUsuario.setOnClickListener(v -> {
            String nombre= binding.tietNombre.getText().toString();
            int edad= Integer.parseInt(binding.tietEdad.getText().toString());
            Usuario usuario= new Usuario(nombre, edad);
            Usuario vacio=new Usuario("",0);
            binding.setUser(vacio);
            Log.d("depurando",usuario.toString());


            Intent intent= new Intent(this, ActivityRegistro.class);
            //intent.putExtra("info","Victor Vergel");
            intent.putExtra("user_activity", usuario);
            //startActivity(intent);

            launcherActivity.launch(intent);


        });


        binding.bLanzarNavegador.setOnClickListener(v ->
                // lanzar el navegador
                {

                    Intent intentNavegador= new Intent(Intent.ACTION_VIEW);
                    intentNavegador.setData(android.net.Uri.parse("https://www.google.com"));
                    startActivity(intentNavegador);
                }


                );




        binding.bIncrementarNormal.setOnClickListener( boton -> {
                    contadorNormal.incrementar();
                    binding.setContadorNormal(contadorNormal);
                    //binding.tvContadorNormal.setText(contadorNormal.getNumero() + "");
                }
        );

        binding.bIncrementarContadorViewmodel.setOnClickListener( boton -> {
                    contadorViewmodel.incrementar();
                    binding.setContadorViewModel(contadorViewmodel);
                }
        );

        binding.bLanzarCamara.setOnClickListener(boton -> {
            lanzarCamara.launch(Manifest.permission.CAMERA);
        });


        binding.bRecuperarContacto.setOnClickListener(boton ->{
            Intent intent = new Intent(Intent.ACTION_PICK, ContactsContract.CommonDataKinds.Phone.CONTENT_URI);
            pickContactLauncher.launch(intent);
        });


    }


    private final ActivityResultLauncher<String> lanzarCamara= registerForActivityResult(new ActivityResultContracts.RequestPermission(),
            isGranted -> {
                if (isGranted) {
                    abrirCamara();
                }
                else {
                    Toast.makeText(this,"Permiso denegado",Toast.LENGTH_LONG).show();
                }
            });

    private final ActivityResultLauncher<Intent> tomarFoto = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == RESULT_OK) {
                    Bundle extras = result.getData().getExtras();
                    Bitmap imageBitmap = (Bitmap) extras.get("data");
                    binding.ivFotoCamara.setImageBitmap(imageBitmap);
                }
            });



    private void abrirCamara() {
        Intent intentCamara = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        tomarFoto.launch(intentCamara);

    }












    private final ActivityResultLauncher<Intent> pickContactLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == Activity.RESULT_OK && result.getData() != null) {
                    Uri contactUri = result.getData().getData();
                    obtenerNombreYTelefono(contactUri);
                }
            });


    private void obtenerNombreYTelefono(Uri uri) {
        String[] projection = {ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
                ContactsContract.CommonDataKinds.Phone.NUMBER};

        try (Cursor cursor = getContentResolver().query(uri, projection, null, null, null)) {
            if (cursor != null && cursor.moveToFirst()) {
                int nameIndex = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME);
                int numberIndex = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);

                String nombre = cursor.getString(nameIndex);
                String numero = cursor.getString(numberIndex);

                Toast.makeText(this, "Elegiste a: " + nombre + " (" + numero + ")", Toast.LENGTH_LONG).show();
            }
        }
    }








}