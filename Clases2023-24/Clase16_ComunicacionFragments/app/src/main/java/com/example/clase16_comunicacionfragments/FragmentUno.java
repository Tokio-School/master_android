package com.example.clase16_comunicacionfragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class FragmentUno extends Fragment {


    private static final String ARG_PARAM1 = "param1";


    // TODO: Rename and change types of parameters
    private String mParam1;

    public FragmentUno() {
        // Required empty public constructor
    }


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
        View view= inflater.inflate(R.layout.fragment_uno, container, false);

        ((TextView)view.findViewById(R.id.tv_datoRecibido)).setText(mParam1);

        ((Button)view.findViewById(R.id.b_fragmentTOfragment)).setOnClickListener(boton -> {
            Bundle bundle = new Bundle();
            bundle.putString("dato",mParam1);
            getParentFragmentManager().setFragmentResult("datoEnviado",bundle);
        });

        ((Button)view.findViewById(R.id.b_fragmenTOactivity)).setOnClickListener(boton -> {
            //((MainActivity)getActivity()).recibirDato(mParam1);
            String texto=((EditText)view.findViewById(R.id.et_datoFragmentAActivity)).getText().toString();
            ((MainActivity)getActivity()).escribirDatoDelFragment(texto);
        });


        return view;
    }

    /*@Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }*/
    interface GestionarPulsacionFragment{
        public void escribirDatoDelFragment(String dato);
    }
}