package com.example.practica6;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.practica6.databinding.FragmentRegisterBinding;

import java.util.regex.Pattern;


public class FragmentRegister extends Fragment {

    FragmentRegisterBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentRegisterBinding.inflate(inflater, container, false);


        binding.tietNombre.setOnKeyListener((v, keyCode, event) -> {
            Pattern patron = Pattern.compile("[a-z]+");
            if(!patron.matcher(binding.tietNombre.getText().toString()).matches())
                binding.tilTextoADevolver.setError("El nombre solo puede contener letras");
            else
                binding.tilTextoADevolver.setError(null);


          /*  if(binding.tietNombre.getText().toString().length()<5){
                binding.tilTextoADevolver.setError("El nombre debe tener al menos 5 caracteres");
            }else {
                binding.tilTextoADevolver.setError(null);
            }*/
            return false;
        });



        ((ActivityLogin) getActivity()).setSupportActionBar(binding.miToolbar.toolbar);
        ((ActivityLogin) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((ActivityLogin) getActivity()).getSupportActionBar().setTitle("Registro");
        ((ActivityLogin) getActivity()).getSupportActionBar().setHomeAsUpIndicator(R.drawable.baseline_menu_24);


        binding.bFragmentVolverALogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle info=new Bundle();
                info.putString("nombre",binding.tietNombre.getText().toString());
                info.putString("edad",binding.spinner.getSelectedItem().toString());
                getParentFragmentManager().setFragmentResult("dato", info);

                ((ActivityLogin) getActivity()).volverFragmentLogin();
            }
        });


        return binding.getRoot();
    }
}