package com.example.prietonoel

import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.prietonoel.databinding.ActivityMainBinding

class MainActivity : ActivityMenu() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvUsuarios.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        binding.rvUsuarios.adapter = UsuarioAdapter(UsuariosProvider.usuarios)

        //la barra de tareas
        setSupportActionBar(binding.miToolbar.toolbar)
        supportActionBar?.title = "Inicio App"

        //recojo la posicion, si es nulo significa que no hay seleccinado ninguno
        val posicion = intent.extras?.getBundle("posicion")?.getInt("posicion")
        val usuario: Usuario
        if(posicion != null) {
            usuario = UsuariosProvider.usuarios[posicion]
            supportFragmentManager.beginTransaction().replace(
                R.id.fcv_fragment,
                FragmentUsuarios.newInstance(usuario.nombre, usuario.edad, usuario.telefono)
            ).commit()
        }

    }
}