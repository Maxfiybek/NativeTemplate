package com.example.splash.graph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.splash.screens.SplashRoute
import com.example.splash.screens.SplashScreen
import kotlinx.serialization.Serializable

@Serializable
object SplashGraph

fun NavGraphBuilder.splashGraph(navController: NavController) {
    navigation<SplashGraph>(startDestination = SplashRoute) {
        composable<SplashRoute> { SplashScreen() }
    }
}