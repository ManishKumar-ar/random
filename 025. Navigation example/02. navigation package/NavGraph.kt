package com.example.navigation24.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import androidx.navigation.compose.rememberNavController
import com.example.navigation24.screens.ForgetPassScreen
import com.example.navigation24.screens.HomeScreen
import com.example.navigation24.screens.LoginScreen
import com.example.navigation24.screens.RegisterScreen
import com.example.navigation24.screens.ScreenA
import com.example.navigation24.screens.ScreenB


@Composable
fun Nav() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Login") {


        composable(route = "Login"){
            LoginScreen(navController = navController)
        }
        composable(route = "Register"){
            RegisterScreen(navController = navController)
        }
        composable(route = "ForgetPass"){
            ForgetPassScreen(navController = navController)
        }


        ///////////////////////////////////


        composable(route = "Home"){
            HomeScreen(navController = navController)
        }
        composable(route = "ScreenA"){
            ScreenA(navController = navController)
        }
        composable(route = "ScreenB"){
            ScreenB(navController = navController)
        }


    }

}