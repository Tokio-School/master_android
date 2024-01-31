package com.example.clase18_navigationcomponentfinal;

import static androidx.navigation.Navigation.findNavController;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.clase18_navigationcomponentfinal.databinding.FragmentTresBinding;


public class FragmentTres extends Fragment {

    FragmentTresBinding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding= FragmentTresBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.bFragTresIrAlDos.setOnClickListener(boton->{
            findNavController(view).navigate(R.id.action_fragmentTres_to_fragmentDos);
        });


    }
}