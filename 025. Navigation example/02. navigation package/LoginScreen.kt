package com.example.navigation24.screens


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.navigation24.navigation.Screens

@Composable
fun LoginScreen(navController: NavController, modifier: Modifier = Modifier) {
    Column(
        modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Login Screen", fontSize = 40.sp)
        Spacer(modifier.height(40.dp))
        Button(onClick = {

            navController.navigate("Home")

        }) {
            Text(text = "Login (go to Home)", fontSize = 25.sp)
        }
        Spacer(modifier.height(40.dp))
        Button(onClick = {

            navController.navigate("ForgetPass")

        }) {
            Text(text = "Forgot password", fontSize = 25.sp)
        }
        Spacer(modifier.height(40.dp))
        Button(onClick = {
            navController.navigate("Register")

        }) {
            Text(text = "Register", fontSize = 25.sp)
        }
    }

}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginScreenPreview() {
    val navController = rememberNavController()

    LoginScreen(navController = navController, modifier = Modifier)
}