package com.example.clase15_kotlin

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
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



//        val personas:HashMap<String, Persona> = HashMap()
        //val personas:ArrayList<Persona> = ArrayList()
        //mutabletListOf<Persona>()
        val personas= mutableListOf<Persona>()
        personas.add(persona)
        personas.add(persona2)
        personas.add(persona3)

        persona.nombre="Juanito"
        persona2.nombre="Pedrito"

        Toast.makeText(this,persona.saludar(persona2), Toast.LENGTH_LONG).show()

        val person1:Persona = Persona("Juanito", 34, 78.5)
        val person2:Persona = Persona("Juanito", 34, 78.5)
        if (person1==person2)
            Snackbar.make(binding.root,"Son iguales", Snackbar.LENGTH_LONG).show()
        else
            Snackbar.make(binding.root,"Son diferentes", Snackbar.LENGTH_LONG).show()


       /* binding.lvDatosPersonas.adapter=ArrayAdapter(this,android.R.layout.simple_list_item_1,personas).also { adapter->
            binding.lvDatosPersonas.adapter=adapter
        }
        binding.lvDatosPersonas.onItemClickListener=object: OnItemClickListener{
            override fun onItemClick(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                val personaSeleccionada = parent.getItemAtPosition(position) as Persona
                Snackbar.make(binding.root,"El nombre es: ${personaSeleccionada.nombre}"+"- ${personaSeleccionada.edad}", Snackbar.LENGTH_LONG).show()
            }

        }*/

        /*ArrayAdapter(this,android.R.layout.simple_spinner_item,personas).also { adapter->
            binding.spDatosUsuarios.adapter=adapter
        }*/
        binding.spDatosUsuarios.adapter=ArrayAdapter(this,android.R.layout.simple_spinner_item,personas)


        binding.spDatosUsuarios.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                val personaSeleccionada = parent.getItemAtPosition(position) as Persona
                Snackbar.make(binding.root,"El nombre es: ${personaSeleccionada.nombre}"+"- ${personaSeleccionada.edad}", Snackbar.LENGTH_LONG).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // No action needed
            }
        }

/*
        val listaPersonas= arrayListOf<String>()
        for (i in personas.keys){
            Snackbar.make(binding.root,"El dni es: $i y la persona es: ${personas.get(i)}", Snackbar.LENGTH_LONG).show()
            listaPersonas.add(personas.get(i)!!.nombre)
        }

        binding.lvDatosPersonas.adapter=ArrayAdapter(this,android.R.layout.simple_list_item_1,listaPersonas).also { adapter->
            binding.lvDatosPersonas.adapter=adapter
        }

*/

        val personaFinal:Persona=Persona("Juan", 34, 78.5)
        //var longitudNombre:Int=personaFinal.nombre.length
        var longitudNombre:Int=personaFinal.let{
            it.nombre="Juanito"
            it.saludar(persona2)
            it.nombre.length
        }
        Log.d("depurando","La longitud del nombre es: $longitudNombre")

        var marta:Persona=Persona("Marta", 34, 78.5).apply {
            nombre="Martita"
        }.also {
            Log.d("depurando",it.saludar(persona2))
        }

        //Creacion de una Mascota para la persona
        var mascota:Persona.Mascota=persona.Mascota("Perro", 5)


        binding.rvDatosPersonas.adapter=AdaptadorPersona(personas)
        binding.rvDatosPersonas.layoutManager=LinearLayoutManager(this)




        binding.bGuardar.setOnClickListener(){
            val datoPersona:Persona=Persona(binding.tietNombre.text.toString(),
                binding.tietEdad.text.toString().toInt(),
                binding.tietPeso.text.toString().toDouble())
            Snackbar.make(binding.root,datoPersona.toString(), Snackbar.LENGTH_LONG).show()

            personas.add(datoPersona)
           // binding.rvDatosPersonas.adapter?.notifyDataSetChanged()
            binding.rvDatosPersonas.adapter?.notifyItemInserted(personas.size-1)


        }


    }
}