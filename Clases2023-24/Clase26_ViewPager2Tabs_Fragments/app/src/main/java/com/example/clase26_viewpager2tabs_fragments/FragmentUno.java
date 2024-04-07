package com.example.clase26_viewpager2tabs_fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.clase26_viewpager2tabs_fragments.databinding.FragmentUnoBinding;
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
        view.findViewById(R.id.b_saludar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Fragment Uno", Snackbar.LENGTH_SHORT).show();
                String datoAPasar=binding.tietDato.getText().toString();
                //Definir el dato a pasar al segundo framgent a través del gestor de fragments
                Bundle bundle = new Bundle();
                bundle.putString("dato",datoAPasar);
                //Obtener el gestor de fragments
                getParentFragmentManager().setFragmentResult("valor", bundle);

            }
        });



    }
}