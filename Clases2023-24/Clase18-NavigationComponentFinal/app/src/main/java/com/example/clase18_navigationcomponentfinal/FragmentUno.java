package com.example.clase18_navigationcomponentfinal;

import static androidx.navigation.Navigation.findNavController;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.clase18_navigationcomponentfinal.databinding.FragmentUnoBinding;
import com.google.android.material.snackbar.Snackbar;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentUno#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentUno extends Fragment {

    FragmentUnoBinding binding;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding= FragmentUnoBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);





        binding.bFragUnoIrAlDos.setOnClickListener(boton -> {
            Snackbar.make(view, "Ir al Fragment Dos", Snackbar.LENGTH_SHORT).show();

            Bundle bundle=new Bundle();
            bundle.putString("dato", binding.etDatoAPasar.getText().toString());


            getParentFragmentManager().setFragmentResult("EnviarDato", bundle);


            findNavController(view).navigate(R.id.action_fragmentUno_to_fragmentDos,bundle);

        });


    }
}