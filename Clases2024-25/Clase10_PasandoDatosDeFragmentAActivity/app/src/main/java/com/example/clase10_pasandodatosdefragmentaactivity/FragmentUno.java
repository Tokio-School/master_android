package com.example.clase10_pasandodatosdefragmentaactivity;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.clase10_pasandodatosdefragmentaactivity.databinding.FragmentUnoBinding;

public class FragmentUno extends Fragment {

    FragmentUnoBinding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentUnoBinding.inflate(inflater,container,false);

        binding.bPasarInformacionActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((EnviarDatos)getActivity()).enviarDatos(binding.etDatoAPasar.getText().toString());
            }
        });

        return binding.getRoot();
    }
    interface EnviarDatos{
        void enviarDatos(String dato);
    }
}