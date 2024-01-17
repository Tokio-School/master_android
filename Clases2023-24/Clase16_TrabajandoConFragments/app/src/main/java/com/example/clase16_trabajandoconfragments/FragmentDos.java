package com.example.clase16_trabajandoconfragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.clase16_trabajandoconfragments.databinding.FragmentDosBinding;


public class FragmentDos extends Fragment {

    FragmentDosBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding=FragmentDosBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getParentFragmentManager().setFragmentResultListener("datoEnviado", getViewLifecycleOwner(), (requestKey, result) -> {
            String datoRecibido = result.getString("dato");
            binding.tvDatoRecibidoDeFragment.setText(datoRecibido);
        });
    }
}