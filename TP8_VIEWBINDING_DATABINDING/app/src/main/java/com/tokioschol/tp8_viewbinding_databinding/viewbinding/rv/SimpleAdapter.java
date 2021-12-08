package com.tokioschol.tp8_viewbinding_databinding.viewbinding.rv;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tokioschol.tp8_viewbinding_databinding.databinding.ItemExampleListBinding;
import com.tokioschol.tp8_viewbinding_databinding.viewbinding.domain.SimpleModel;

import java.util.List;

public class SimpleAdapter extends RecyclerView.Adapter<SimpleViewHolder> {

    private List<SimpleModel> items;

    public SimpleAdapter(List<SimpleModel> provideList) {
        this.items = provideList;
    }

    @NonNull
    @Override
    public SimpleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //1 Instanciar el objeto generado del layout
        ItemExampleListBinding binding = ItemExampleListBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        //2 Devolvemos una instancia del ViewHolder y como parametro le pasamos el binding generado
        return new SimpleViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull SimpleViewHolder holder, int position) {
        //Bindeamos para renderizar el item que recibimos. Para ello recogemos la posición de la lista.
        holder.bind(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}






