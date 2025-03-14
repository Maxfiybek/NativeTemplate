package com.example.nativetemplate.splash.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.nativetemplate.core_ui.theme.AppTypography
import kotlinx.serialization.Serializable

@Serializable
internal object SplashRoute

@Composable
internal fun SplashScreen() {
    Scaffold { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            Text(
                modifier = Modifier.align(Alignment.Center),
                text = "Splash Screen",
                style = AppTypography.regular16
            )
        }
    }
}