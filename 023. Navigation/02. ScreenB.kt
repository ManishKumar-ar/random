package com.example.navigation24

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun ScreenB(navController: NavController) {
    
    Column {
        
        Text(text ="Screen of B")
        
        Button(onClick = {
            navController.navigate("C")

        }) {
            Text(text = "Go to screen C")
        }
        
        
    }
}
