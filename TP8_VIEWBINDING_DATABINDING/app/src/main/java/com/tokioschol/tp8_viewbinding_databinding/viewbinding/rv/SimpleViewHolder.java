package com.tokioschol.tp8_viewbinding_databinding.viewbinding.rv;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tokioschol.tp8_viewbinding_databinding.databinding.ItemExampleListBinding;
import com.tokioschol.tp8_viewbinding_databinding.viewbinding.domain.SimpleModel;

public class SimpleViewHolder extends RecyclerView.ViewHolder {
    private final ItemExampleListBinding binding;

    public SimpleViewHolder(@NonNull ItemExampleListBinding binding) {
        //1 Al super debemos de pasarle un objeto view, por ello le pasamos el root del generado
        super(binding.getRoot());
        this.binding = binding;
    }

    //En el método bind aplicamos los setters y la lógica de la lista.
    public void bind(SimpleModel simpleModel) {
        binding.itemExampleTitle.setText(simpleModel.getTitle());
        binding.itemExampleSubTitle.setText(simpleModel.getSubTitle());
    }
}
