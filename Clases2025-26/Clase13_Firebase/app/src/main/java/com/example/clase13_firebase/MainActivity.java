package com.example.clase13_firebase;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.clase13_firebase.databinding.ActivityMainBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.setPersona(new Persona());

        FirebaseFirestore db = FirebaseFirestore.getInstance();

        binding.bGuardar.setOnClickListener(view -> {
            Persona persona=binding.getPersona();
            Map<String,Object> personaMap=new HashMap<>();
            personaMap.put("nombre",persona.getNombre());
            personaMap.put("apellido",persona.getApellido());
            personaMap.put("edad",persona.getEdad());

            db.collection("personas")
                    .add(personaMap)
                    .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                        @Override
                        public void onSuccess(DocumentReference documentReference) {
                            Log.d("depurando", "inserción del objeto " + persona.toString() + " en la colección personas");
                        }})
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Log.d("depurando", "error al insertar el objeto " + persona.toString() + " en la colección personas");

                        }
                    });
        });

        binding.bEliminar.setOnClickListener(view -> {
            Persona persona = binding.getPersona();

            CollectionReference personas = db.collection("personas");
            Query query = personas.whereEqualTo("nombre", persona.getNombre());
            Task<QuerySnapshot> task = query.get();

            task.addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                @Override
                public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                    for (int i = 0; i < queryDocumentSnapshots.size(); i++) {
                        task.getResult().getDocuments().get(i).getReference().delete();
                    }
                }
            });
        });



        binding.bActualizar.setOnClickListener(boton-> {
            Persona persona = binding.getPersona();

            Map<String,Object> personaMap=new HashMap<>();
            personaMap.put("nombre",persona.getNombre());
            personaMap.put("apellido",persona.getApellido());
            personaMap.put("edad",persona.getEdad());

            CollectionReference personas = db.collection("personas");
            Query query = personas.whereEqualTo("nombre", persona.getNombre());
            Task<QuerySnapshot> task = query.get();

            task.addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                @Override
                public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                    for (int i = 0; i < queryDocumentSnapshots.size(); i++) {
                        task.getResult().getDocuments().get(i).getReference().update(personaMap);
                    }
                }
            });

        });



    }
}