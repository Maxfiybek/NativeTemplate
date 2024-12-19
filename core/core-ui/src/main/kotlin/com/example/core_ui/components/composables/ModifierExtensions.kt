package com.example.core_ui.components.composables

import android.annotation.SuppressLint
import androidx.compose.foundation.border
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.core_ui.theme.AppColors
import com.example.core_ui.theme.ApplicationShapes

@Composable
@SuppressLint("UnnecessaryComposedModifier")
fun Modifier.withBorder(
    width: Dp = 1.dp,
    color: Color = AppColors.blue,
    shape: Shape = ApplicationShapes.Rounded8,
): Modifier = composed {
    border(width = width, color = color, shape = shape)
}