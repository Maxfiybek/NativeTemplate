package com.example.nativetemplate.navigation.graphs

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import com.example.nativetemplate.splash.graph.splashGraph

fun NavGraphBuilder.setSplashGraph(navController: NavController) {
    splashGraph(navController)
}