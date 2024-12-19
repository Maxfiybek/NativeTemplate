package com.example.core_ui.theme

import androidx.compose.foundation.LocalIndication
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp

@Composable
fun PrimaryTheme(content: @Composable () -> Unit) {
    val colors = ColorsProvider.themeLight
    val colorScheme = MaterialTheme.colorScheme.copy(
        primary = colors.primary,
        secondary = colors.secondary,
        surface = colors.surface,
        onPrimary = colors.primary,
        onSurface = colors.surface,
        onBackground = colors.background,
        background = colors.background,
    )
    CompositionLocalProvider(
        LocalColors provides colors,
        LocalIndication provides ripple(radius = Dp.Unspecified, bounded = true),
    ) {
        MaterialTheme{
            content()
        }
    }
}

val AppColors
    @Composable
    get() = LocalColors.current

val LocalColors = staticCompositionLocalOf<ColorsHolder> {
    error("No LocalColors specified")
}