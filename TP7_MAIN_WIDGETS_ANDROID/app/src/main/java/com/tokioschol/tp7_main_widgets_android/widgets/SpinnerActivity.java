package com.tokioschol.tp7_main_widgets_android.widgets;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.google.android.material.snackbar.Snackbar;
import com.tokioschol.tp7_main_widgets_android.R;
import com.tokioschol.tp7_main_widgets_android.databinding.ActivitySpinnerBinding;

public class SpinnerActivity extends AppCompatActivity {

    private ActivitySpinnerBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySpinnerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        spinnerDatosEstaticosXml();
        spinnerDinamico();

    }

    private void spinnerDinamico() {
        String[] listaFrutas = getResources().getStringArray(R.array.lista_frutas);
        binding.spinnerDinamico.setAdapter(new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item,
                listaFrutas));
        binding.spinnerDinamico.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Snackbar.make(binding.spinnerDinamico, "el valor seleccionado es " + listaFrutas[position], Snackbar.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void spinnerDatosEstaticosXml() {
        binding.spinnerDatoEstatico.setPrompt("selecciona una version");
        binding.spinnerDatoEstatico.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                binding.seleccionSpinner.setText(parent.getAdapter().getItem(position).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}