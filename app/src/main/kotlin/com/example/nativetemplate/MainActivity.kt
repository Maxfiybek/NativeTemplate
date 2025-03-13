package com.example.nativetemplate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.nativetemplate.core_ui.theme.PrimaryTheme
import com.example.nativetemplate.navigation.NativeAppNavigation

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PrimaryTheme {
                val navController = rememberNavController()
                NativeAppNavigation(navController = navController)
            }
        }
    }
}