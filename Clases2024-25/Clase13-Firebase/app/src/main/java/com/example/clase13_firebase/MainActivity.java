package com.example.clase13_firebase;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.clase13_firebase.databinding.ActivityMainBinding;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {


    ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        FirebaseFirestore db = FirebaseFirestore.getInstance();


        binding.bGuardar.setOnClickListener(boton->{
            Persona persona = getPersona();
            Snackbar.make(binding.getRoot(),persona.toString(),Snackbar.LENGTH_SHORT).show();

            Map<String,Object> user=new HashMap<>();
            user.put("nombre",persona.getNombre());
            user.put("apellido",persona.getApellido());
            user.put("edad",persona.getEdad());

            db.collection("users").add(user).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                @Override
                public void onSuccess(DocumentReference documentReference) {
                    Log.d("depurando","Se ha realizado la inserción de forma correcta");
                }
            }).addOnFailureListener(e->{
                Log.d("depurando","Error al insertar el documento");
            });
        });

        binding.bEliminar.setOnClickListener(boton->{
            Persona persona = getPersona();
            String nombreUsuario=persona.getNombre();

            CollectionReference personas=db.collection("users");

            Query consulta=personas.whereEqualTo("nombre",nombreUsuario);
            Task<QuerySnapshot> querySnapshotTask=consulta.get();

            querySnapshotTask.addOnSuccessListener(queryDocumentSnapshots -> {
                for (int i = 0; i < queryDocumentSnapshots.size(); i++) {
                    queryDocumentSnapshots.getDocuments().get(i).getReference().delete();
                }
            });
        });

        binding.bActualizar.setOnClickListener(boton->{
            Persona persona = getPersona();
            String nombreUsuario=persona.getNombre();

            CollectionReference personas=db.collection("users");

            Query consulta=personas.whereEqualTo("nombre",nombreUsuario);
            Task<QuerySnapshot> querySnapshotTask=consulta.get();

            Map<String,Object> user=new HashMap<>();
            user.put("nombre",persona.getNombre());
            user.put("apellido",persona.getApellido());
            user.put("edad",persona.getEdad());

            querySnapshotTask.addOnSuccessListener(queryDocumentSnapshots -> {
                for (int i = 0; i < queryDocumentSnapshots.size(); i++) {
                    queryDocumentSnapshots.getDocuments().get(i).getReference().update(user);
                }
            });
        });


        binding.bRecuperar.setOnClickListener(boton->{
            Persona persona = getPersona();
            String nombreUsuario=persona.getNombre();

            CollectionReference personas=db.collection("users");

            Query consulta=personas.whereEqualTo("nombre",nombreUsuario);
            Task<QuerySnapshot> querySnapshotTask=consulta.get();

            querySnapshotTask.addOnSuccessListener(queryDocumentSnapshots -> {
                for (int i = 0; i < queryDocumentSnapshots.size(); i++) {
                    queryDocumentSnapshots.getDocuments().get(i).getReference().get().addOnSuccessListener(documentSnapshot -> {
                        Persona p=documentSnapshot.toObject(Persona.class);
                        binding.setPersona(p);
                    });
                }
            });
        });

    }

    private Persona getPersona(){
        return new Persona(binding.tietNombre.getText().toString(),
                    binding.tietApellido.getText().toString(),
                    Integer.parseInt(binding.tietEdad.getText().toString()));
    }


}