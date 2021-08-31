package com.tokioschol.tp8_viewbinding_databinding.databinding;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class DataBindingFragment extends Fragment {

    private FragmentDatabindingInflateBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //Crear la vista del Fragment
        binding = FragmentDatabindingInflateBinding.inflate(inflater, container, false);
        binding.txtInflateBinding.setText("ESTAMOS EN DATABINDING INFLATE");
        return binding.getRoot();
    }
}
