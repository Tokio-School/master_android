package com.example.practica10_dosnivelesnavegacion;

import static androidx.navigation.Navigation.findNavController;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.practica10_dosnivelesnavegacion.databinding.FragmentTresBinding;
import com.google.android.material.snackbar.Snackbar;


public class FragmentTres extends Fragment {


    FragmentTresBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentTresBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



        binding.bFragTresIrAlCuatro.setOnClickListener(boton -> {
            findNavController(view).navigate(R.id.action_fragmentTres_to_fragmentCuatro);
        });

        binding.bDeeplink.setOnClickListener(boton -> {
            findNavController(view).navigate(R.id.deepLinkAction);
        });
    }
}