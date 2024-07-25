package com.example.clase41_holamundocompose_final

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarData
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.clase41_holamundocompose_final.ui.theme.Clase41_HolaMundoCompose_FINALTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            val personas = remember {
                mutableStateListOf(
                    Persona("Juan", "Hombre", 20),
                    Persona("Maria", "Mujer", 21),
                    Persona("Pedro", "Hombre", 22),
                    Persona("Ana", "Mujer", 23),
                    Persona("Luis", "Hombre", 24)
                )
            }
            visualizacionInterfaz(personas, { persona ->
                personas.add(persona)
            }, { persona -> personas.remove(persona) }, personas.size)
        }
    }
}

@Composable
fun visualizacionInterfaz(
    personas: MutableList<Persona>,
    pulsarBoton: (Persona) -> Unit,
    borrarPersona: (Persona) -> Unit,
    contador: Int
) {

    val contexto = LocalContext.current
    var nombre by remember { mutableStateOf("") }
    var sexo by remember { mutableStateOf("Hombre") }
    var edad by remember { mutableStateOf("") }


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
                .padding(20.dp)
        ) {
            Text(text = "Edad:", modifier = Modifier.weight(0.25f))
            TextField(value = edad,
                modifier = Modifier.weight(0.75f),
                onValueChange = { edad = it },
                placeholder = { Text("Inserte Edad") })
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            /* Button(onClick = {
                 val usuario = Persona(nombre, sexo, edad = edad.toInt())
                 Log.d("depurando", "Hola $usuario")
                 Toast.makeText(contexto, "Hola $usuario", Toast.LENGTH_SHORT).show()
             }) {
                 Text("Saludar", modifier = Modifier.padding(20.dp))
             }*/
            Text("Contador: $contador", modifier = Modifier.padding(20.dp))
            Button(onClick = {
                pulsarBoton(Persona(nombre, sexo, edad.toInt()))
            }) {
                Text("Saludar")
            }
        }

        Surface(modifier = Modifier.fillMaxWidth(), color = Color.Gray) {
            LazyColumn {
                items(personas.size) { index ->
                    val persona = personas[index]
                    Row {
                        Text(
                            text = persona.nombre,
                            modifier = Modifier.padding(16.dp),
                            color = Color.White
                        )
                        Spacer(modifier = Modifier.weight(1f),)
                        IconButton(onClick = { borrarPersona(persona) }) {
                            Icon(Icons.Default.Delete, contentDescription = "Delete", tint = Color.White)
                        }
                    }
                    HorizontalDivider(
                        modifier = Modifier
                            .height(4.dp)
                            .fillMaxWidth(0.85f)
                            .align(Alignment.CenterHorizontally),
                            color = Color.White
                    )
                }
            }
        }

    }

}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    val personas = remember {
        mutableStateListOf(
            Persona("Juan", "Hombre", 20),
            Persona("Maria", "Mujer", 21),
            Persona("Pedro", "Hombre", 22),
            Persona("Ana", "Mujer", 23),
            Persona("Luis", "Hombre", 24)
        )
    }
    visualizacionInterfaz(personas, { persona ->
        personas.add(persona)
    }, { persona -> personas.remove(persona) }, personas.size)
}

data class Persona(val nombre: String, val sexo: String, val edad: Int) {
    override fun toString(): String {
        return "$nombre, $sexo, $edad años"
    }
}