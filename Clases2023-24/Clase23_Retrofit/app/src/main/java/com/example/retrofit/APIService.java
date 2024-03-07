package com.example.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/* Define cómo nos vamos a comunicar con el servidor */
public interface APIService {

    // Recibimos un array puesto que es un listado de lenguajes el que recibimos.
    @GET("/0.2/languages")
    public Call<List<Lenguaje>> getLanguage();

    @GET("/posts")
    public Call<List<RespuestaTypicode>> getRespuestaTypicode();

    @Headers("Authorization: Bearer 6df0d1afd925f7fe1c89bad7454844fb")
    @FormUrlEncoded
    @POST("/0.2/detect")
    public Call<DetectionResponse> getTextLanguage(@Field("q") String q);

}
