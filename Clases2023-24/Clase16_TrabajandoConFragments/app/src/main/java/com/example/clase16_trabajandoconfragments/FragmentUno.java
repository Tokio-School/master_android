package com.example.clase16_trabajandoconfragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.clase16_trabajandoconfragments.databinding.FragmentUnoBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentUno#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentUno extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";


    // TODO: Rename and change types of parameters
    private String mParam1;

    private FragmentUnoBinding binding;

    public FragmentUno() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment FragmentUno.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentUno newInstance(String param1) {
        FragmentUno fragment = new FragmentUno();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }


    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_uno, container, false);
        binding = FragmentUnoBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //((TextView)view.findViewById(R.id.tv_datoRecibido)).setText(mParam1);
        binding.tvDatoRecibido.setText(mParam1);
        binding.bEnviarDatoAlActivity.setOnClickListener(boton -> {
            Log.d("depurando",binding.etDatoAEnviarAlActivity.getText().toString());
            ((MainActivity)getActivity()).escribirDatoDelFragment(binding.etDatoAEnviarAlActivity.getText().toString());
           // escribirDatoDelFragment(binding.etDatoAEnviarAlActivity.getText().toString());
        });

        binding.bEnviarAFragment.setOnClickListener(boton -> {
            Log.d("depurando",binding.etDatoAEnviarAlActivity.getText().toString());
            Bundle info=new Bundle();
            info.putString("dato",binding.etDatoAEnviarAlActivity.getText().toString());
            getParentFragmentManager().setFragmentResult("datoEnviado",info);
        });

    }

    interface GestionarPulsacionFragment {
        public void escribirDatoDelFragment(String dato);
    }
}