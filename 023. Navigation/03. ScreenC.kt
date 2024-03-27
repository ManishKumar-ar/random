package com.example.navigation24

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun ScreenC(navController: NavController) {
    
    Column {
        
        Text(text ="Screen of C")
        
        Button(onClick = {
            navController.navigate("A")

//            navController.navigate("A"){                   /// due to this, if we reach at A from C then if we click to times back button then we came out from app
//                popUpTo("A")                            // let we want that, we came out from the app in a single click of back botton ,, ans - by using inclusive
//            }


//            navController.navigate("A"){                        // in a single click only
//                popUpTo("A"){ inclusive = true}
//            }

        }) {
            Text(text = "Go to screen A")
        }

        Button(onClick = {
            navController.navigate("B")

        }) {
            Text(text = "Go to screen B")
        }
        
        
    }
}
