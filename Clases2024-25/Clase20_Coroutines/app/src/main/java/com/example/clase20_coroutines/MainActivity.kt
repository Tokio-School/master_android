package com.example.clase20_coroutines

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.room.Room
import com.example.clase20_coroutines.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var bindind: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindind.root)

        val baseDatos= Room.databaseBuilder(this, BD::class.java, "MiBaseDatos").build()


        bindind.shimmer.startShimmer()
        CoroutineScope(Dispatchers.Main).launch {
            delay(3000)
            bindind.shimmer.stopShimmer()
            bindind.shimmer.hideShimmer()
            bindind.shimmer.visibility = android.view.View.GONE
        }




        bindind.bIniciarProgreso.setOnClickListener() {
            bindind.pbBarra.max = 10

            CoroutineScope(Dispatchers.Default).launch {
                for (i in 0..10) {
                    bindind.pbBarra.progress = i
                    kotlinx.coroutines.delay(1000)
                }
            }
        }




        val datosIniciales  = mutableListOf<Persona>(
            Persona("Juan"),
            Persona("Ana"),
            Persona("Luis"),
            Persona("Marta")
        )

        val adaptadorVista = ArrayAdapter(this, android.R.layout.simple_list_item_1, datosIniciales)
        bindind.lvDatos.adapter = adaptadorVista

        bindind.bAlmacenarBD.setOnClickListener() {
            val personaDao = baseDatos.personaDao()
            CoroutineScope(Dispatchers.Default).launch {
                // Insertar datos en la base de datos
                personaDao.insertPersona(Persona(bindind.tietNombre.text.toString()))
            }
        }



    }
}