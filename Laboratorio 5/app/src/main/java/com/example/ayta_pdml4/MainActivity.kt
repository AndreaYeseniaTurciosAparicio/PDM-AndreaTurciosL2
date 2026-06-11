package com.example.ayta_pdml4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.ayta_pdml4.Navegation.navegacion
import com.example.ayta_pdml4.ui.theme.AYTAPDML4Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AYTAPDML4Theme {
                navegacion()
            }
        }
    }
}
