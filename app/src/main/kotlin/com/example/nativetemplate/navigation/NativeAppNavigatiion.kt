package com.example.nativetemplate.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.nativetemplate.navigation.graphs.setSplashGraph
import com.example.nativetemplate.splash.graph.SplashGraph

@Composable
fun NativeAppNavigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = SplashGraph
    ) {
        setSplashGraph(navController)
    }
}