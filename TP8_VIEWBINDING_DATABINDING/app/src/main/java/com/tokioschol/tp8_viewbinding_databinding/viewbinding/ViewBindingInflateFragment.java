package com.tokioschol.tp8_viewbinding_databinding.viewbinding;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.tokioschol.tp8_viewbinding_databinding.databinding.FragmentViewbindingInflateBinding;
import com.tokioschol.tp8_viewbinding_databinding.viewbinding.domain.SimpleModel;
import com.tokioschol.tp8_viewbinding_databinding.viewbinding.rv.SimpleAdapter;

import java.util.ArrayList;
import java.util.List;


public class ViewBindingInflateFragment extends Fragment {

    //Variable del binding del Fragment
    private FragmentViewbindingInflateBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //Crear la vista del Fragment
        binding = FragmentViewbindingInflateBinding.inflate(inflater, container, false);
        //Setter del título
        binding.txtInflateBinding.setText("ESTAMOS EN VIEWBINDING INFLATE");
        //Binding datos para el recyclerView o lista
        binding.recyclerViewbinding.setHasFixedSize(true);
        binding.recyclerViewbinding.setAdapter(new SimpleAdapter(provideList()));
        return binding.getRoot();
    }

    private List<SimpleModel> provideList() {
        List<SimpleModel> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new SimpleModel("TITULO "+i,"subtitulo "+i));
        }
        return list;
    }

    @Override
    public void onDestroyView() {
        //No guardar la referencia de la vista si no es necesaria en memoria.
        binding = null;
        super.onDestroyView();
    }
}
