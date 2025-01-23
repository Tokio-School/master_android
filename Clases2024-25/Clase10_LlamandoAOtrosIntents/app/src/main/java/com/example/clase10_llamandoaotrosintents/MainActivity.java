package com.example.clase10_llamandoaotrosintents;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.clase10_llamandoaotrosintents.databinding.ActivityMainBinding;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.bAbrirNavegador.setOnClickListener(v->{
            Intent intent=new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://www.google.com"));
            startActivity(intent);
        });


        binding.bLlamarPorTelefono.setOnClickListener(v->{
            Intent intent=new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:123456789"));
            startActivity(intent);
        });

        binding.bAbrirMaps.setOnClickListener(v->
        {
            Intent intent=new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("geo:0,0?q=Madrid"));
            startActivity(intent);
        });

        binding.bAbrirCorreo.setOnClickListener(v-> {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_EMAIL, new String[] {"a@b.com","b@c.com"});
            intent.putExtra(Intent.EXTRA_SUBJECT, "Asunto");
            intent.putExtra(Intent.EXTRA_TEXT, "Texto del correo");
            startActivity(intent);

        });

        ActivityResultLauncher<Intent> activityResultCamara = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK) {
                        Intent data = result.getData();
                        Bitmap imageBitmap = (Bitmap) data.getExtras().get("data");
                        binding.imageView.setImageBitmap(imageBitmap);
                    }
                }
        );
        binding.bCamaraFotos.setOnClickListener(v->{
            Intent intent=new Intent("android.media.action.IMAGE_CAPTURE");
            activityResultCamara.launch(intent);
        });


    }
}