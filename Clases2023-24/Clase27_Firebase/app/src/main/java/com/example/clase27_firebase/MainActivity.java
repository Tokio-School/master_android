package com.example.clase27_firebase;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.clase27_firebase.databinding.ActivityMainBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
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
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        FirebaseFirestore db = FirebaseFirestore.getInstance();

        //CRUD
        // Create Read Update Delete

        binding.bGuardar.setOnClickListener(v -> {

            Map<String, Object> user = new HashMap<>();
            Persona person = getPersona();
            user.put("nombre", person.getNombre());
            user.put("apellido", person.getApellido());
            user.put("edad", person.getEdad());


            // Add a new document with a generated ID
            db.collection("users")
                    .add(user)
                    .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                        @Override
                        public void onSuccess(DocumentReference documentReference) {
                            Log.d("depurando", "DocumentSnapshot added with ID: " + documentReference.getId());
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Log.w("depurando", "Error adding document", e);
                        }
                    });
        });

        binding.bEliminar.setOnClickListener(v -> {
            // Actualizar el usuario con el nombre que le pasemos del campo nombre de Persona
            Persona person = getPersona();
            String nombreUsuario = binding.tietNombre.getText().toString();

            CollectionReference personasRef = db.collection("users");

            // Realizar una consulta para encontrar el documento que coincida con el nombre
            Query consulta = personasRef.whereEqualTo("nombre", nombreUsuario);
            Log.d("depurando", "consulta: " + consulta.toString());
            // Ejecutar la consulta y obtener el resultado
            Task<QuerySnapshot> querySnapshotTask = consulta.get();

            querySnapshotTask.addOnSuccessListener(querySnapshot -> {
                int numDocumentos = querySnapshot.size();
                Log.d("depurando", "Número de documentos encontrados: " + numDocumentos);

                for (DocumentSnapshot documentSnapshot : querySnapshot) {
                    // Obtener el ID del documento encontrado
                    String idUsuario = documentSnapshot.getId();

                    // Actualizar el documento encontrado con los datos actualizados
                    DocumentReference usuarioRef = personasRef.document(idUsuario);
                    usuarioRef.delete()
                            .addOnSuccessListener(aVoid -> {
                                Log.d("depurando", "Documento borrado correctamente.");
                            })
                            .addOnFailureListener(e -> {
                                Log.d("depurando", "Error en el borrado del documento:");
                                e.printStackTrace();
                            });
                }
            }).addOnFailureListener(e -> {
                // Manejar errores de consulta
                System.err.println("Error al ejecutar la consulta:");
                e.printStackTrace();
            });
        });

        binding.bActualizar.setOnClickListener(v -> {
            // Actualizar el usuario con el nombre que le pasemos del campo nombre de Persona
            Persona person = getPersona();
            String nombreUsuario = binding.tietNombre.getText().toString();

            CollectionReference personasRef = db.collection("users");

            // Realizar una consulta para encontrar el documento que coincida con el nombre
            Query consulta = personasRef.whereEqualTo("nombre", nombreUsuario);
            Log.d("depurando", "consulta: "+consulta.toString());
            // Ejecutar la consulta y obtener el resultado
            Task<QuerySnapshot> querySnapshotTask = consulta.get();

            querySnapshotTask.addOnSuccessListener(querySnapshot -> {
                int numDocumentos = querySnapshot.size();
                Log.d("depurando", "Número de documentos encontrados: " + numDocumentos);

                for (DocumentSnapshot documentSnapshot : querySnapshot) {
                    // Obtener el ID del documento encontrado
                    String idUsuario = documentSnapshot.getId();

                    // Actualizar el documento encontrado con los datos actualizados
                    DocumentReference usuarioRef = personasRef.document(idUsuario);
                    usuarioRef.set(person)
                            .addOnSuccessListener(aVoid -> {
                                Log.d("depurando","Documento actualizado correctamente.");
                            })
                            .addOnFailureListener(e -> {
                                Log.d("depurando","Error al actualizar el documento:");
                                e.printStackTrace();
                            });
                }
            }).addOnFailureListener(e -> {
                // Manejar errores de consulta
                System.err.println("Error al ejecutar la consulta:");
                e.printStackTrace();
            });

        });

        binding.bRecuperar.setOnClickListener(v -> {
            db.collection("users")
                    .get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if (task.isSuccessful()) {
                                for (QueryDocumentSnapshot document : task.getResult()) {
                                    Log.d("depurando", document.getId() + " => " + document.getData());
                                }
                            } else {
                                Log.w("depurando", "Error getting documents.", task.getException());
                            }
                        }
                    });
        });


        // Añadir un listener cuando alguien actualiza los datos de firestore
        db.collection("users")
                .addSnapshotListener((value, error) -> {
                    if (error != null) {
                        Log.w("depurando", "Listen failed.", error);
                        return;
                    }

                    for (DocumentChange dc : value.getDocumentChanges()) {
                        switch (dc.getType()) {
                            case ADDED:
                                Log.d("depurando", "Persona: " + dc.getDocument().getData());
                                break;
                            case MODIFIED:
                                Log.d("depurando", "Persona: " + dc.getDocument().getData());
                                break;
                            case REMOVED:
                                Log.d("depurando", "Persona: " + dc.getDocument().getData());
                                break;
                        }
                    }
                });


        binding.bRegistrarAcceso.setOnClickListener(v->{
                    Intent intent = new Intent(this, LoginActivity.class);
                    startActivity(intent);
                }
        );
        binding.bCerrarSesionGoogle.setOnClickListener(v->{
            FirebaseAuth.getInstance().signOut();
            binding.bDatosGoogle.setEnabled(false);
        });

        binding.bCerrarSesionGoogle.setOnClickListener(v->{
            FirebaseAuth.getInstance().signOut();
            binding.bDatosGoogle.setEnabled(false);
        });


    }

    @NonNull
    private Persona getPersona() {
        Persona person=new Persona(
                binding.tietNombre.getText().toString(),
                binding.tietApellido.getText().toString(),
                Integer.parseInt(binding.tietEdad.getText().toString()));
        return person;
    }



    @Override
    protected void onResume() {
        super.onResume();

        // Verificar si el usuario está logueado
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        Log.d("depurando", "Usuario logueado: "+user.getDisplayName());
        if (user != null) {
            // El usuario está logueado
            // Realiza las acciones correspondientes
            binding.bDatosGoogle.setEnabled(true);
        } else {
            // El usuario no está logueado
            // Realiza las acciones correspondientes, como redirigir a la pantalla de inicio de sesión
            Log.d("Login Status", "El usuario no está logueado");
        }
    }

}