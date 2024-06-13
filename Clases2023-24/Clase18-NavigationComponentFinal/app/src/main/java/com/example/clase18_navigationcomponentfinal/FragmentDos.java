package com.example.clase18_navigationcomponentfinal;

import static androidx.navigation.Navigation.findNavController;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.clase18_navigationcomponentfinal.databinding.FragmentDosBinding;


public class FragmentDos extends Fragment {

    FragmentDosBinding binding;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding= FragmentDosBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getParentFragmentManager().setFragmentResultListener("EnviarDato", getViewLifecycleOwner(), (requestKey, result) -> {
            binding.tvDatoRecibidoPorListener.setText("Dato recibido por listener: "+result.getString("dato"));
        });



        binding.tvDatoRecibido.setText("Dato recibido: "+getArguments().getString("dato"));

        binding.bFragDosIrAlTres.setOnClickListener(boton -> {
                findNavController(view).navigate(R.id.action_fragmentDos_to_fragmentTres);
        });

        binding.bFragDosIrAlUno.setOnClickListener(boton -> {
                findNavController(view).navigate(R.id.action_fragmentDos_to_fragmentUno);
        });


    }
}