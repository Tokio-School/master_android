package com.tokioschol.tp8_viewbinding_databinding.viewbinding;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.tokioschol.tp8_viewbinding_databinding.databinding.FragmentViewbindingInflateBinding;


public class ViewBindingInflateFragment extends Fragment {

    //Variable del binding del Fragment
    private FragmentViewbindingInflateBinding binding;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //Crear la vista del Fragment
        binding = FragmentViewbindingInflateBinding.inflate(inflater, container, false);
        binding.txtInflateBinding.setText("ESTAMOS EN VIEWBINDING INFLATE");
        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        //No guardar la referencia de la vista si no es necesaria en memoria.
        binding = null;
        super.onDestroyView();
    }
}
