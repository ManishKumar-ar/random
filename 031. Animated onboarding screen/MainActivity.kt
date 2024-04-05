package com.example.navigation24

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
//
            NavHost(navController = navController, startDestination = "Splash") {
                composable("Splash") {
                    SplashScreen(navController = navController, context = this@MainActivity)
                }
                composable("Onboarding") {
                    OnboardingScreen(navController = navController,context = this@MainActivity )
                }
                composable("Home") {
                    HomeScreen()
                }
            }

        }
    }
}
