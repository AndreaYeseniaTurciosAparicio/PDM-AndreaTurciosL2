package com.example.ayta_pdml4.ui.View


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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.ayta_pdml4.ViewModel.GeneralViewModel


//@Preview(showBackground = true)
@Composable
fun home(navController: NavHostController, viewModel: GeneralViewModel){
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
                    navController.navigate("Greeting")
                },
                modifier = Modifier
                    .fillMaxWidth(),

                ) {
                Text("Greeting")
            }
            Spacer(modifier = Modifier.height(20.dp))

        }
    }
}