package com.example.repasoaplicaciongastos

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.room.Room
import com.example.repasoaplicaciongastos.databinding.ActivityLoginBinding
import com.example.repasoaplicaciongastos.entities.Usuario
import com.example.repasoaplicaciongastos.services.BD
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginActivity : AppCompatActivity() {

    lateinit var binding : ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val database= Room.databaseBuilder(this, BD::class.java,"MiBaseDatos").build()

        binding.bEntrar.setOnClickListener {
            val usuario = binding.tietNombre.text.toString()
            val password = binding.tietPassword.text.toString()

            binding.bEntrar.setOnClickListener {
                //Comprobacion
                val nombre = binding.tilUsuario.editText?.text.toString()
                val password = binding.tilPassword.editText?.text.toString()
                var msgError = ""
                var user: Usuario? = null
                var context = this

                CoroutineScope(Dispatchers.Default).launch {
                    Log.d("depurando", nombre)
                    user = database.usuarioDao().getUsuarioByNombre(nombre)

                    if (user == null) {
                        if (binding.cbGuardarDatos.isChecked) {
                            val usuarioNuevo = Usuario(nombre, password)
                            database.usuarioDao().insertUsuario(usuarioNuevo)
                            lanzarMainActivity(usuarioNuevo)
                        }
                    } else {
                        //comprobamos la contraseña
                        Log.d("depurando", "usuario:"+ user?.contrasena + "--- Password: " + password)
                        if (user?.contrasena == password) {
                            lanzarMainActivity(user!!)
                        } else {
                            Snackbar.make(
                                binding.root,
                                "La contraseña o el usuario no es correcto",
                                Snackbar.LENGTH_LONG
                            ).show()
                            var userVacio:Usuario=Usuario("", "")
                            binding.usuario=userVacio
                        }
                    }

                }
            }
        }

    }
    private fun lanzarMainActivity(usuario:Usuario) {

        val intent = Intent(binding.root.context, MainActivity::class.java).apply {
            putExtra("idUser", usuario?.idUsuario)
        }
        startActivity(intent)

    }
}