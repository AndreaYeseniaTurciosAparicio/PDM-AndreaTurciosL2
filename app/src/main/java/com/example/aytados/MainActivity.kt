package com.example.aytados

import android.os.Bundle
import android.widget.NumberPicker
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.aytados.ui.theme.AYTADOSTheme
import kotlin.collections.mutableListOf

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppLista()
        }
    }
}

@Preview (showBackground = true)
@Composable
fun AppLista(){
    var nombre by remember { mutableStateOf("") }
    var lista = remember { mutableStateListOf<String>() }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(40.dp)

    )
    {
        TextField(
            modifier = Modifier
                .background(Color.Magenta)
                .align (Alignment.CenterHorizontally),
            value = nombre,
            onValueChange = {nombre = it},
            label = {Text("Nombre")}
        )
        Button(
            modifier = Modifier
                .align (Alignment.CenterHorizontally),
            onClick = {
                if (nombre.isNotBlank()) {
                    lista.add(nombre)
                    nombre = ""
                }
            }
        )
        {Text("Guardar")}
        Row(
            modifier = Modifier
                .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
        ) {
            Box(){
                Text("Listado de nombres y \n posicion en la lista")
            }
            Button(onClick = { lista.clear() }) {
                Text("Limpiar")
            }
        }

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .border(3.dp, Color.Blue)
                .padding(8.dp)
        ) {
            itemsIndexed(lista) { index, item ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = item)
                    Text(text = "${index + 1}")
                }

                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}