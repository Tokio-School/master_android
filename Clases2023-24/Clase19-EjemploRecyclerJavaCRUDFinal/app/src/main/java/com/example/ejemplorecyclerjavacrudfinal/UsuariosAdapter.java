package com.example.ejemplorecyclerjavacrudfinal;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ejemplorecyclerjavacrudfinal.databinding.DatoUsuarioBinding;

import java.util.ArrayList;

public class UsuariosAdapter extends RecyclerView.Adapter<UsuariosAdapter.UsuarioHolder> {

    DatoUsuarioBinding binding;
    private ArrayList<Usuario> usuarios;
    public UsuariosAdapter(ArrayList<Usuario> usuarios) {
        this.usuarios=usuarios;
    }


    @NonNull
    @Override
    public UsuariosAdapter.UsuarioHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.dato_usuario, null);
        return new UsuarioHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UsuariosAdapter.UsuarioHolder holder, int position) {
        binding.setUser(usuarios.get(position));
    }

    @Override
    public int getItemCount() {
        return usuarios.size();
    }

    public class UsuarioHolder extends RecyclerView.ViewHolder {


        public UsuarioHolder(@NonNull View itemView) {
            super(itemView);
            binding = DatoUsuarioBinding.bind(itemView);

            binding.glDatos.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int posicion = getAdapterPosition();
                    if (posicion != RecyclerView.NO_POSITION) {
                        Usuario usuario = usuarios.get(posicion);
                        usuarios.remove(posicion);
                        notifyItemRemoved(posicion);
                    }
                }
            });

        }
    }
}
