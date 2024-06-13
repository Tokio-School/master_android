package com.example.practica10_dosnivelesnavegacion;

import static androidx.navigation.Navigation.findNavController;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


import com.example.practica10_dosnivelesnavegacion.databinding.FragmentDosBinding;

public class FragmentDos extends Fragment {

    FragmentDosBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentDosBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.bFragDosIrAlTres.setOnClickListener(boton -> {
            findNavController(view).navigate(R.id.action_fragmentDos_to_fragmentTres);
        });

        binding.bFragDosIrAlUno.setOnClickListener(boton -> {
            findNavController(view).navigate(R.id.action_fragmentDos_to_fragmentUno);
        });
        binding.bDeeplink.setOnClickListener(boton -> {
            findNavController(view).navigate(R.id.deepLinkAction);
        });
    }
}