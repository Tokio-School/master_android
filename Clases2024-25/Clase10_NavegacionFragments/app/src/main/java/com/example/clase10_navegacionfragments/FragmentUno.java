package com.example.clase10_navegacionfragments;

import static androidx.navigation.Navigation.findNavController;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.clase10_navegacionfragments.databinding.FragmentUnoBinding;


public class FragmentUno extends Fragment {


    FragmentUnoBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding= FragmentUnoBinding.inflate(inflater,container,false);
        binding.bFragUnoIrAlDos.setOnClickListener(boton -> {
            Bundle bundle=new Bundle();
            bundle.putString("dato", binding.etDatoAPasar.getText().toString());

            findNavController(boton).navigate(R.id.action_fragmentUno_to_fragmentDos,bundle);
        });



        return binding.getRoot();
    }
}