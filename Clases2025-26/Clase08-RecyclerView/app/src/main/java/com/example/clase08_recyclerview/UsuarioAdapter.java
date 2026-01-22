package com.example.clase08_recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.clase08_recyclerview.databinding.UsuarioBinding;

import java.util.ArrayList;

public class UsuarioAdapter extends RecyclerView.Adapter<UsuarioAdapter.UsuarioViewHolder> {
    private ArrayList<Usuario> usuarios;
    public UsuarioAdapter(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    @NonNull
    @Override
    public UsuarioAdapter.UsuarioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        UsuarioBinding binding=UsuarioBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new UsuarioViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull UsuarioAdapter.UsuarioViewHolder holder, int position) {
        Usuario usuario=usuarios.get(position);
        holder.bind(usuario);
    }

    @Override
    public int getItemCount() {
        return usuarios.size();
    }

    public class UsuarioViewHolder  extends RecyclerView.ViewHolder{

        private UsuarioBinding binding;
        public UsuarioViewHolder(UsuarioBinding binding) {
            super(binding.getRoot());
            this.binding=binding;

        }

        public void bind(Usuario usuario){
            binding.setUser(usuario);
        }




    }
}
