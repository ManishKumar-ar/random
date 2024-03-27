package com.example.navigation24

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun ScreenA(navController: NavController) {
    
    Column {
        
        Text(text ="Screen of A")
        
        Button(onClick = {
            navController.navigate("B")
        }) {
            Text(text = "Go to screen B")
        }
        
        
    }
}
