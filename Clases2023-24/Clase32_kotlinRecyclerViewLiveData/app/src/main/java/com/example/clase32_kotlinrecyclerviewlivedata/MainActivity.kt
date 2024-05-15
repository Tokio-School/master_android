package com.example.clase32_kotlinrecyclerviewlivedata

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.clase32_kotlinrecyclerviewlivedata.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var listaPersonas: MutableList<Persona>
    lateinit var personaLiveData: PersonaLiveData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        listaPersonas = PersonaProvider.getPersonas()
        personaLiveData = PersonaLiveData(Persona("", 0))

        personaLiveData.observe(this, Observer { persona ->
           /* binding.tvNombre.text = persona.nombre
            binding.tvEdad.text = persona.edad.toString()*/
            binding.persona = persona
            Snackbar.make(binding.root, "Se ha agregado una persona "+persona.nombre, Snackbar.LENGTH_SHORT).show()
            //listaPersonas.add(persona)
            //binding.recyclerView.adapter?.notifyDataSetChanged()
            CoroutineScope(Dispatchers.Main).launch {
                //binding.recyclerView.adapter?.notifyItemInserted(listaPersonas.size)
                mostrarDatosActualizados()
            }

        })



        binding.addButton.setOnClickListener {
            val nombre = binding.editTextName.text.toString()
            val edad = binding.editTextAge.text.toString().toIntOrNull()

            if (nombre.isNotBlank() && edad != null) {
                val nuevaPersona = Persona(nombre, edad)
                listaPersonas.add(nuevaPersona)
                //binding.recyclerView.adapter?.notifyDataSetChanged()
                //binding.persona=nuevaPersona
                binding.editTextName.text.clear()
                binding.editTextAge.text.clear()

                personaLiveData.value = nuevaPersona
            }
        }

        binding.recyclerView.adapter = PersonaAdapter(listaPersonas)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

    }

    suspend fun mostrarDatosActualizados() {
        for (listaPersona in listaPersonas) {
            Log.d("depurando", "Nombre: ${listaPersona.nombre} Edad: ${listaPersona.edad}")
        }
    }
}