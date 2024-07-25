package com.example.clase42_peliculas_final

import androidx.compose.foundation.background
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun ListadoPeliculas() {
    val peliculas = remember { mutableStateListOf(*PeliculasData.peliculas.toTypedArray()) }

    LazyColumn(Modifier.background(color= Color.Yellow)) {
        itemsIndexed(peliculas) { index, pelicula ->
            PeliculaCard(pelicula = pelicula, onVistaChange = { vista ->
                peliculas[index] = peliculas[index].copy(vista = vista)
            })
        }
    }


}


