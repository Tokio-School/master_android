package com.tokioschol.tp9_acitivitys;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import com.tokioschol.tp9_acitivitys.databinding.ActivityMainBinding;
import com.tokioschol.tp9_acitivitys.domain.User;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static String KEY_INTENT_USER = "key_user";
    public static String KEY_INTENT_SIMPLE_STRING = "Key_simple_string";
    public static String KEY_INTENT_SIMPLE_INT = "Key_simple_int";
    public static String KEY_INTENT_SIMPLE_DOUBLE = "Key_simple_double";
    public static String KEY_INTENT_SIMPLE_BUNDLE = "Key_simple_bundle";

    private final ActivityResultLauncher<Intent> registred = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == Activity.RESULT_OK) {
                    if (result.getData() != null) {
                        Log.e(this.getClass().getName(), "resultado: " + result.getData().getStringExtra("resultado"));
                    } else {
                        Log.e(this.getClass().getName(), "Ufff, algo salio mal");
                    }
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        com.tokioschol.tp9_acitivitys.databinding.ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //Listener que se denomina Anonimo
        binding.intentsBtn.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, IntentsActivity.class)));
        //Listener definido a nivel de clase
        binding.activitySendObjectBtn.setOnClickListener(this);
        binding.simpleDateActivityBtn.setOnClickListener(this);
    }

    //Invocación del listener desde el layout.
    public void desdeLayout(View view) {
        registred.launch(new Intent(this, ForResultActivity.class));
    }

    /**
     * En vez de enviar 2 valores primitivos(String, int) tambien podemos enviar un Bundle
     * el cual es un objeto que recoge dichas propiedades, es decir podemos generar un Bundle que
     * tiene un String, un int y un double, entre otras opciones.
     */
    private void simpleActivity() {
        Intent sendSimple = new Intent(this, SimpleDateActivity.class);
        //O enviamos datos de forma simple o mediante bundle.
        //Comentar la linea 63 o 64 para cambiar el modo.
        simpleIntent(sendSimple);
        //sendSimple.putExtras(makeBundle());//Aqui no es necesario un identificador porque ya lo tiene dendtro del objeto bundle.
        startActivity(sendSimple);
    }

    private void simpleIntent(Intent sendSimple) {
        sendSimple.putExtra(KEY_INTENT_SIMPLE_STRING, "valor string");
        sendSimple.putExtra(KEY_INTENT_SIMPLE_INT, 21);
        sendSimple.putExtra(KEY_INTENT_SIMPLE_DOUBLE, 21.32);
    }

    private Bundle makeBundle() {
        Bundle bundle = new Bundle();
        bundle.putString(KEY_INTENT_SIMPLE_STRING, "Bundle string");
        bundle.putInt(KEY_INTENT_SIMPLE_INT, 12);
        bundle.putDouble(KEY_INTENT_SIMPLE_DOUBLE, 12.12);
        return bundle;
    }

    private void activityWithObjects() {
        //1 El objeto a enviar a la nueva activity debe ser un objeto parcelable
        User user = new User();
        user.setName("Jose");
        user.setLastName("García");
        user.setAge(25);

        //2 Crear un objeto intent con datos parcelables
        //EMISOR
        Intent sendIntent = new Intent(this, ObjectDateActivity.class)
                .putExtra(KEY_INTENT_USER, user);

        //3 Iniciar la activity con el intent creado
        startActivity(sendIntent);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.activity_send_object_btn:
                activityWithObjects();
                break;
            case R.id.simple_date_activity_btn:
                simpleActivity();
                break;
            default:
                break;
        }
    }
}