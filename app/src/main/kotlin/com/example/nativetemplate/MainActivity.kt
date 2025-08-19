package com.example.nativetemplate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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

@Preview(showBackground = true)
@Composable
private fun PreviewExample() {
    Column(
        modifier = Modifier.size(200.dp).clip(CircleShape).background(Color.Red)
    ) {

    }
}