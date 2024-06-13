package com.example.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.example.retrofit.databinding.ActivityMainBinding;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.bSolicitarIdioma.setOnClickListener(v -> {

            API api = new API(API.BASE_URL);
            Call<List<Lenguaje>> listaLenguajes = api.service.getLanguage();
            listaLenguajes.enqueue(new retrofit2.Callback<List<Lenguaje>>() {
                @Override
                public void onResponse(Call<List<Lenguaje>> call, Response<List<Lenguaje>> response) {
                    if (response.isSuccessful()) {
                        List<Lenguaje> lenguajes = response.body();
                        for (Lenguaje lenguaje : lenguajes) {
                            Log.d("depurando1", lenguaje.getName());
                            binding.tvResultado.append(lenguaje.getName() + "\n");
                        }
                    } else {
                        Log.d("depurando2", "Error: " + response.errorBody());
                    }
                }

                @Override
                public void onFailure(Call<List<Lenguaje>> call, Throwable t) {
                    Log.d("depurando3", "Error: " + t.getMessage() + "---" + t.getLocalizedMessage() + "---" + t.toString());
                }
            });
        });




        binding.bPreguntarPorIdioma.setOnClickListener(v -> {
            API api = new API(API.BASE_URL);
            Call<DetectionResponse> lenguaje = api.service.getTextLanguage(binding.etTexto.getText().toString());
            lenguaje.enqueue(new retrofit2.Callback<DetectionResponse>() {
                @Override
                public void onResponse(Call<DetectionResponse> call, Response<DetectionResponse> response) {
                    if (response.isSuccessful()) {
                        DetectionResponse detectionResponse = response.body();
                        Data data = detectionResponse.getData();
                        Detection detection = data.getDetections().get(0);
                        Log.d("depurando7", detection.getLanguage());
                    } else {
                        Log.d("depurando8", "Error: " + response.errorBody());
                    }
                }

                @Override
                public void onFailure(Call<DetectionResponse> call, Throwable t) {
                    Log.d("depurando9", "Error: " + t.getMessage() + "---" + t.getLocalizedMessage() + "---" + t.toString());
                }
            });
        });



        binding.bLlamada2.setOnClickListener(v -> {
            API api = new API(API.BASE_URL2);
            Call<List<RespuestaTypicode>> listaLenguajes = api.service.getRespuestaTypicode();
            listaLenguajes.enqueue(new retrofit2.Callback<List<RespuestaTypicode>>() {
                @Override
                public void onResponse(Call<List<RespuestaTypicode>> call, Response<List<RespuestaTypicode>> response) {
                    if (response.isSuccessful()) {
                        List<RespuestaTypicode> datos = response.body();
                        for (RespuestaTypicode dato : datos) {
                            Log.d("depurando4", dato.getTitle());

                        }
                    } else {
                        Log.d("depurando5", "Error: " + response.errorBody());
                    }
                }

                @Override
                public void onFailure(Call<List<RespuestaTypicode>> call, Throwable t) {
                    Log.d("depurando6", "Error: " + t.getMessage() + "---" + t.getLocalizedMessage() + "---" + t.toString());
                }
            });
        });
    }
}
