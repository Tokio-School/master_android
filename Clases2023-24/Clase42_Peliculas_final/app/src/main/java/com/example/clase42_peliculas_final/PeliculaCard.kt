package com.example.clase42_peliculas_final

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter


@Composable
fun PeliculaCard(pelicula: Pelicula, onVistaChange: (Boolean) -> Unit) {
    val colorFondo = if (pelicula.vista) Color.Gray else Color.White


    Card(
        elevation = CardDefaults.cardElevation(8.dp),
        colors = CardDefaults.cardColors(containerColor = colorFondo),
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
      ) {
        Column() {
            Image(
                painter = rememberImagePainter(data = pelicula.imagenUrl),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
                    .height(180.dp)
            )
            Text(
                text = pelicula.titulo,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(5.dp)
            )
            Text(
                text = pelicula.director,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(5.dp)
            )
            Text(
                text = pelicula.descripcion,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(5.dp)
            )
            Text(text = pelicula.valoracion.toString(), modifier = Modifier.padding(5.dp))
            Row{
                Checkbox(
                    checked = pelicula.vista,
                    onCheckedChange = {
                        onVistaChange(it)
                    }
                )
                Text(text = if (pelicula.vista) "Vista" else "No vista")
            }
        }
    }
}