package com.example.aytados.pantallas

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.serialization.Serializable

@Serializable
object listaNombres
@Serializable
object sensores
@Serializable
object home

@Composable
fun Navegacion(
    modifier: Modifier = Modifier
){
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "home",
        modifier = modifier
    ) {

        composable("home") {
            home(
                onNavigateTolistaNombres = { navController.navigate("listaNombres") },
                onNavigateTosensores = { navController.navigate("sensores") }
            )
        }

        composable("listaNombres") {
            AppLista(
                onNavigateTohome = { navController.popBackStack() }
            )
        }

        composable("sensores") {
            GyroscopeSensor(
                onBack = { navController.popBackStack() }
            )
        }
    }
}


//@Preview(showBackground = true)
@Composable
fun home(onNavigateTolistaNombres: () -> Unit,
         onNavigateTosensores: () -> Unit){
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(16.dp),
            contentAlignment = Alignment.Center

        ) {
            Column(
                modifier = Modifier
                    .padding(70.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(20.dp))
                Button(
                    onClick = {
                        onNavigateTolistaNombres()
                    },
                    modifier = Modifier
                        .fillMaxWidth(),

                ) {
                    Text("Lista de nombres")
                }
                Spacer(modifier = Modifier.height(20.dp))
                Button(
                    onClick = {
                        onNavigateTosensores()
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text("Sensores")
                }
            }
        }
    }

