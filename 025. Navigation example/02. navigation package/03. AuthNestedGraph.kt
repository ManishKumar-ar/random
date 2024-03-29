package com.example.navigation24.navigation
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.navigation24.screens.ForgetPassScreen
import com.example.navigation24.screens.LoginScreen
import com.example.navigation24.screens.RegisterScreen


fun NavGraphBuilder.authGraph(navController: NavController){

    navigation(startDestination = Screens.ScreenLoginRoute.route, route =Screens.AuthRoute.route){

        composable(route = Screens.ScreenLoginRoute.route){
            LoginScreen(navController = navController)
        }
        composable(route = Screens.ScreenRegisterRoute.route){
            RegisterScreen(navController = navController)
        }
        composable(route = Screens.ScreenForgetPassRoute.route){
            ForgetPassScreen(navController = navController)
        }

    }
}
