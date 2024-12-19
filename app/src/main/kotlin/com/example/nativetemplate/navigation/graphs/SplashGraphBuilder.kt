package com.example.nativetemplate.navigation.graphs

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import com.example.splash.graph.splashGraph

fun NavGraphBuilder.setSplashGraph(navController: NavController) {
    splashGraph(navController)
}