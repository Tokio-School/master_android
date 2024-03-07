package com.example.clase20_permisosllamandointents;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import com.example.clase20_permisosllamandointents.databinding.ActivityMainBinding;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.bEnviarMail.setOnClickListener(view -> {
            Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
            emailIntent.setType("plain/text");
            emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL,new String[] { "a@b.com" });
            emailIntent.putExtra(android.content.Intent.EXTRA_CC,new String[] { "b@a.com" });
            emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT,new String[] { "Comentario Formulario"});
            emailIntent.putExtra(android.content.Intent.EXTRA_TEXT,"Hola Don Pepito, te digo : "+binding.etDatoEnviar.getText().toString());
            startActivity(Intent.createChooser(emailIntent, "Enviar correo..."));
        });

        binding.bLlamadaTelefono.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(android.net.Uri.parse("tel:"+binding.etDatoEnviar.getText().toString()));
            startActivity(intent);
        });

        binding.bAbrirNavegador.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            //intent.setData(android.net.Uri.parse("http://www.google.es"));
            intent.setData(android.net.Uri.parse("http://www."+binding.etDatoEnviar.getText().toString()));
            startActivity(intent);
        });

        binding.bAbrirMaps.setOnClickListener(view -> {
            Intent intent_maps= new Intent(Intent.ACTION_VIEW);
            intent_maps.setData(android.net.Uri.parse("geo:"+41.39+","+4.44+"?q=Valladolid"));
            startActivity(intent_maps);
        });






        ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK) {
                        Intent data = result.getData();
                        String datoDevuelto = data.getStringExtra("datoDevuelto");
                        Snackbar.make(binding.getRoot(), datoDevuelto, Snackbar.LENGTH_LONG).show();
                    }
                });


        binding.bAbrirSegundoActivity.setOnClickListener(view -> {
            Intent intent = new Intent(this, MainActivity2.class);
            intent.putExtra("dato",binding.etDatoEnviar.getText().toString());
            //startActivity(intent);
            activityResultLauncher.launch(intent);
        });



        ActivityResultLauncher<Intent> activityResultLancherContactos= registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
            if (result.getResultCode() == RESULT_OK) {
                Uri uri = result.getData().getData();
                String[] proyeccion = new String[] {android.provider.ContactsContract.CommonDataKinds.Phone.NUMBER,
                        android.provider.ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME
                };
                android.database.Cursor c = getContentResolver().query(uri, proyeccion, null, null, null);
                c.moveToFirst();
                binding.tvDatoRecuperado.setText(c.getString(1));
                binding.etDatoEnviar.setText(c.getString(0));
            }
        });


        binding.bRecuperarContacto.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_PICK, Uri.parse("content://contacts"));
            intent.setType(android.provider.ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE);
            //startActivity(intent);
            activityResultLancherContactos.launch(intent);

        });



        ActivityResultLauncher<Intent> activityResultLancherCamara= registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
            if (result.getResultCode() == RESULT_OK) {
                Log.d("depurando", "onActivityResult: llega la imagen");
                Intent data = result.getData();
                //binding.ivImagenCamara.setImageURI(data.getData());
                binding.ivImagenCamara.setImageBitmap((android.graphics.Bitmap) data.getExtras().get("data"));
            }
        });


        binding.bLanzarCamara.setOnClickListener(view -> {
            Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
            activityResultLancherCamara.launch(intent);
        });





    }
}