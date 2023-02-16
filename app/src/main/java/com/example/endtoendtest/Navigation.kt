package com.example.endtoendtest

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(
        navController,
        startDestination = ScreenRoutes.FirstScreen.route
    ){
        composable(ScreenRoutes.FirstScreen.route){
            FirstScreen(
                onNavigateToNextScreen = {
                    navController.navigate(ScreenRoutes.SecondScreen.route)
                }
            )
        }
        composable(ScreenRoutes.SecondScreen.route){
            SecondScreen(
                onNavigateToNextScreen = {
                    navController.navigate(ScreenRoutes.ThirdScreen.route)
                }
            )
        }
        composable(ScreenRoutes.ThirdScreen.route){
            ThirdScreen()
        }

    }
}

sealed class ScreenRoutes(val route:String){
    object FirstScreen:ScreenRoutes(route = "first_screen")
    object SecondScreen:ScreenRoutes(route = "second_screen")
    object ThirdScreen:ScreenRoutes(route = "third_screen")
}