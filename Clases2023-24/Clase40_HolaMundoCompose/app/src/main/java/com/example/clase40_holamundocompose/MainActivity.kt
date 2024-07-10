package com.example.clase40_holamundocompose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.Button
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.clase40_holamundocompose.ui.theme.Clase40_HolaMundoComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            visualizacionInterfaz()
        }
    }
}

@Composable
fun visualizacionInterfaz() {

    var nombre by remember { mutableStateOf("") }
    var sexo by remember { mutableStateOf("Hombre") }


    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Nombre: ", modifier = Modifier.weight(0.25f))
            TextField(value = nombre,
                modifier = Modifier.weight(0.75f),
                onValueChange = { nombre = it },
                placeholder = { Text("Inserte Nombre") })
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Sexo: ", modifier = Modifier.weight(0.25f))
            RadioButton(selected = sexo == "Hombre", onClick = { sexo = "Hombre" })
            Text(text = "Hombre")
            RadioButton(selected = sexo == "Mujer", onClick = { sexo = "Mujer" })
            Text(text = "Mujer")
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(onClick = {
                val usuario = Persona(nombre, sexo)
                Log.d("depurando", "Hola $usuario")
            }) {
                Text("Saludar", modifier = Modifier.padding(20.dp))
            }
        }
    }

}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    visualizacionInterfaz()
}

data class Persona(val nombre: String, val sexo: String) {
    override fun toString(): String {
        return "$nombre, $sexo"
    }
}