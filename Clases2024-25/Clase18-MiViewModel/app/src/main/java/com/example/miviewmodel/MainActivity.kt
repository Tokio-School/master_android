package com.example.miviewmodel

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.miviewmodel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val datosLista: DatosLista by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //var listaNombre= mutableListOf("Pedro","Juan","Maria","Jose")

        //var adaptadorLista=ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,listaNombre)
        var adaptadorLista=ArrayAdapter<Persona>(this,android.R.layout.simple_list_item_1,datosLista.listaNombre)

        binding.lvNombres.adapter=adaptadorLista

        binding.button.setOnClickListener {
                //listaNombre.add(binding.tietNombre.text.toString())
                datosLista.listaNombre.add(Persona(binding.tietNombre.text.toString(),23))
                adaptadorLista.notifyDataSetChanged()
                binding.tietNombre.text?.clear()
        }

        binding.lvNombres.setOnItemClickListener(
            AdapterView.OnItemClickListener { parent, view, position, id ->
                val objetoSeleccionado = datosLista.listaNombre[position]
                val fragment = FragmentNombre.newInstance(objetoSeleccionado.nombre)
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainerView, fragment)
                    .commit()
            }
        )

        val launcher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val nombre = result.data?.getStringExtra("nombre")
                if (nombre != null) {
                    datosLista.listaNombre.add(Persona(nombre,33))
                    adaptadorLista.notifyDataSetChanged()
                }
            }
        }

        binding.bAnadirActivity?.setOnClickListener {
            val intent = Intent(this, ActivityNombre::class.java)
            intent.putExtra("nombre", binding.tietNombre.text.toString())
            launcher.launch(intent)
        }
    }
}