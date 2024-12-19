package com.example.nativetemplate.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.nativetemplate.navigation.graphs.setSplashGraph
import com.example.splash.graph.SplashGraph
import com.example.splash.graph.splashGraph

@Composable
fun NativeAppNavigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = SplashGraph
    ){
        splashGraph(navController)
    }
}