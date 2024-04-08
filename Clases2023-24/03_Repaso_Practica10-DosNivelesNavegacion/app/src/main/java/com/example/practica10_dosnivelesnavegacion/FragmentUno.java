package com.example.practica10_dosnivelesnavegacion;

import static androidx.navigation.Navigation.findNavController;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


import com.example.practica10_dosnivelesnavegacion.databinding.FragmentUnoBinding;
import com.google.android.material.snackbar.Snackbar;


public class FragmentUno extends Fragment {


    FragmentUnoBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentUnoBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.bFragUnoIrAlDos.setOnClickListener(boton -> {
            Snackbar.make(view, "Ir al Fragment Dos", Snackbar.LENGTH_SHORT).show();

            findNavController(view).navigate(R.id.action_fragmentUno_to_fragmentDos);

        });


    }
}