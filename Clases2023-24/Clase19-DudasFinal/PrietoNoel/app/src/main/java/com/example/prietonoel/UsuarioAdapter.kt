package com.example.prietonoel

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.prietonoel.databinding.DatoUsuarioBinding

class UsuarioAdapter(var datos: ArrayList<Usuario>) :
    RecyclerView.Adapter<UsuarioAdapter.UsuariosViewHolder>() {

    class UsuariosViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var binding = DatoUsuarioBinding.bind(view)
        fun bind(usuario: Usuario) {
            binding.user = usuario
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsuariosViewHolder {
        val inflater =
            LayoutInflater.from(parent.context).inflate(R.layout.dato_usuario, parent, false)
        return UsuariosViewHolder(inflater.rootView)
    }

    override fun getItemCount(): Int = datos.size

    override fun onBindViewHolder(holder: UsuariosViewHolder, position: Int) {
        var usuario = datos[position]
        holder.bind(usuario)
        holder.itemView.setOnClickListener {
            var builder = AlertDialog.Builder(holder.itemView.context)
            builder.setTitle("Confirmacion")
            builder.setMessage("¿Seguro que desea visualizar?")
            builder.setPositiveButton("Aceptar") { dialog, _ ->
                //lanzar la posicion
                val intent = Intent(holder.itemView.context, MainActivity::class.java)
                var bundle = Bundle().apply{
                    putInt("posicion", position)
                }
                intent.putExtra("posicion", bundle)
                startActivity(holder.itemView.context, intent, bundle)
                dialog.dismiss()
            }
            builder.setNegativeButton("Cancelar") { dialog, _ ->
                dialog.cancel()
            }
            builder.show()
        }
    }

}