package com.example.clase08_recyclerview;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.clase08_recyclerview.databinding.PersonaItemBinding;


public class FragmentPersona extends Fragment {


    private static final String ARG_PARAM1 = "param1";


    // TODO: Rename and change types of parameters
    private Persona mParam1;


    public FragmentPersona() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment FragmentPersona.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentPersona newInstance(Persona param1) {
        FragmentPersona fragment = new FragmentPersona();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getSerializable(ARG_PARAM1, Persona.class);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        PersonaItemBinding binding = PersonaItemBinding.inflate(inflater, container, false);
        binding.setPersona(mParam1);

        return binding.getRoot();
    }
}