package com.example.practica6;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.practica6.databinding.FragmentLoginBinding;
import com.google.android.material.snackbar.Snackbar;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentLogin#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentLogin extends Fragment {

    FragmentLoginBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentLoginBinding.inflate(inflater, container, false);

        getParentFragmentManager().setFragmentResultListener("dato", this, (requestKey, result) -> {
            String nombre = result.getString("nombre");
            String edad = result.getString("edad");
            binding.tvDatoDevueltoPorRegister.setText("Nombre: "+nombre+" Edad: "+edad);
            Snackbar.make(binding.getRoot(), "Nombre: "+nombre+" Edad: "+edad, Snackbar.LENGTH_LONG).show();
        });


        binding.bPasarRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((ActivityLogin) getActivity()).cambiarFragmento(new FragmentRegister());
            }
        });


        binding.bLanzarSegundoActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((ActivityLogin) getActivity()).cambiarActivity(new Activity_Home());
            }
        });


        return binding.getRoot();
    }
}