package com.example.clase15_kotlin

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.clase15_kotlin.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {


    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val persona = Persona("Juan", 34, 78.5)
        var persona2 = Persona("Pedro", 45, 85.0)
        persona2.nombre = "Pedro2"
        var persona3= Persona("Maria")
        Snackbar.make(binding.root, "Hola ${persona3.toString()}", Snackbar.LENGTH_LONG).show()

        Snackbar.make(binding.root,persona2.saludar(persona), Snackbar.LENGTH_LONG).show()


        binding.bGuardar.setOnClickListener(){
            val datoPersona:Persona=Persona(binding.tietNombre.text.toString(),
            binding.tietEdad.text.toString().toInt(),
            binding.tietPeso.text.toString().toDouble())
            Snackbar.make(binding.root,datoPersona.toString(), Snackbar.LENGTH_LONG).show()
        }

        val personas:HashMap<String, Persona> = HashMap()
        personas.put("1234A",persona)
        personas.put("1234B",persona2)
        personas.put("1234C",persona3)

        val listaPersonas= arrayListOf<String>()
        for (i in personas.keys){
            Snackbar.make(binding.root,"El dni es: $i y la persona es: ${personas.get(i)}", Snackbar.LENGTH_LONG).show()
            listaPersonas.add(personas.get(i)!!.nombre)
        }

        binding.lvDatosPersonas.adapter=ArrayAdapter(this,android.R.layout.simple_list_item_1,listaPersonas).also { adapter->
            binding.lvDatosPersonas.adapter=adapter
        }

    }
}