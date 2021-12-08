package com.tokioschol.tp9_acitivitys;

import static com.tokioschol.tp9_acitivitys.MainActivity.KEY_INTENT_SIMPLE_BUNDLE;
import static com.tokioschol.tp9_acitivitys.MainActivity.KEY_INTENT_SIMPLE_DOUBLE;
import static com.tokioschol.tp9_acitivitys.MainActivity.KEY_INTENT_SIMPLE_INT;
import static com.tokioschol.tp9_acitivitys.MainActivity.KEY_INTENT_SIMPLE_STRING;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.tokioschol.tp9_acitivitys.databinding.ActivityForResultBinding;
import com.tokioschol.tp9_acitivitys.databinding.ActivitySimpleBinding;

public class SimpleDateActivity extends AppCompatActivity {

    private ActivitySimpleBinding binding;
    private String stringValue;
    private int intValue;
    private double doubleValue;
    private String stringBundleValue;
    private int intBundleValue;
    private double doubleBundleValue;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySimpleBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //1 Obtener los datos del emisor.
        getInitExtras();
        //2 Bindeamos el dato con el layout
        bindData();
    }

    private void getInitExtras() {
        if (getIntent().getExtras() != null) {
            stringValue = getIntent().getExtras().getString(KEY_INTENT_SIMPLE_STRING, "valor por si no hay nada");
            intValue = getIntent().getExtras().getInt(KEY_INTENT_SIMPLE_INT, -1);
            doubleValue = getIntent().getExtras().getDouble(KEY_INTENT_SIMPLE_DOUBLE, -1d);
        }else{
            //si no hay extras y los valore son necesarios hay que inicializarlos.
            stringValue = "sin valor";
            intValue = -1;
            doubleValue = -1d;
        }
    }

    private void bindData() {
        //Primitivos
        binding.simpleText.setText(stringValue);
        binding.simpleInt.setText(String.valueOf(intValue));
        binding.simpleDouble.setText(String.valueOf(doubleValue));
    }
}
