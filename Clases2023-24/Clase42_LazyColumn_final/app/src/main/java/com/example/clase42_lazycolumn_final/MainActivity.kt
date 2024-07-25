package com.example.clase42_lazycolumn_final

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.clase42_lazycolumn_final.ui.theme.Clase42_LazyColumn_finalTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
          /*  Clase42_LazyColumn_finalTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }*/
            listaDatos()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun listaDatos() {
    /*Column (modifier = Modifier.fillMaxSize()){
        for (i in 0..100) {
            Text("Item #$i", modifier = Modifier.fillMaxWidth())
            Log.d("depurando", "Item #$i")
        }
    }*/
    LazyColumn(modifier = Modifier.fillMaxSize()){
        items(100) { index ->
            Text("Item #$index", modifier = Modifier.fillMaxWidth())
            Log.d("depurando", "Item #$index")
        }
    }
}
