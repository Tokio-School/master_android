package com.example.clase31_accesobasedatos_coroutines

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.clase31_accesobasedatos_coroutines.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    var personas = mutableListOf<Persona>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        val baseDatos= Room.databaseBuilder(this,BD::class.java,"MiBaseDatos").build()
        val personaDao : PersonaDao=baseDatos.personaDao()

        binding.bInsertar.setOnClickListener({
            CoroutineScope(Dispatchers.Default).launch {
                var personaTemp=Persona(binding.etNombre.text.toString(),
                    binding.etEdad.text.toString().toInt(),
                    binding.etDireccion.text.toString())
                personaDao.insertPersona(personaTemp)
                binding.persona=Persona("",0,"")
            }
        })

        binding.bActualizar.setOnClickListener({
            CoroutineScope(Dispatchers.Default).launch {
                var personaTemp=Persona(binding.etNombre.text.toString(),
                    binding.etEdad.text.toString().toInt(),
                    binding.etDireccion.text.toString())
                personaTemp.id=binding.etIdBorrar.text.toString().toInt()
                // Opción 1: personaDao.updatePersona(personaTemp.nombre,personaTemp.edad,personaTemp.direccion,binding.etIdBorrar.text.toString().toInt())
                // Opción 2:
                personaDao.updatePersona(personaTemp)
            }
        })
        binding.bListar.setOnClickListener() {
            CoroutineScope(Dispatchers.IO).launch {
                // Obtener la lista de personas desde el PersonaDao
                personas = personaDao.getAll()
            }
                    binding.rvListaDatos.adapter = PersonaAdapter(personas)
                    binding.rvListaDatos.layoutManager =
                        LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)



            //Habiltamos el boton de borrar porque ya se ha cargado la lista
            binding.bBorrar.isEnabled=true

        }

        binding.bBorrar.setOnClickListener(){
            lateinit var personaTemp:Persona
            //Borrar base datos
            CoroutineScope(Dispatchers.IO).launch {

                personaTemp=buscarPersona(binding.etIdBorrar.text.toString().toInt())
                Log.d("depurando","Borraré la posicion "+personaTemp.toString())
                personas.removeAt(personas.indexOf(personaTemp))
            }

                    //personaDao.deletePersona(personaTemp)
                    //listaPersonas.remove(personaTemp)

                    //listaPersonas=personaDao.getAll()

                    binding.rvListaDatos.adapter?.notifyItemRemoved(personas.indexOf(personaTemp) )
                    binding.rvListaDatos.adapter?.notifyDataSetChanged()

                    //  Borra el primero.notifyItemRemoved(listaPersonas.indexOf(personaTemp) )


                Log.d("depurando", "Borrado"+personaTemp.toString())

        }
    }
    private fun buscarPersona(id : Int): Persona {
        var personaTemp : Persona= Persona("No encontrado", 0, "No encontrado")
        for (persona in personas) {
            if (persona.id == id) {
                personaTemp=persona
            }
        }
        return personaTemp
    }
}