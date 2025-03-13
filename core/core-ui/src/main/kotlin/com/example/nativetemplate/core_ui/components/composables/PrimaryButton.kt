package com.example.nativetemplate.core_ui.components.composables

import androidx.compose.foundation.background
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import com.example.nativetemplate.core_ui.theme.AppColors
import com.example.nativetemplate.core_ui.theme.AppTypography
import com.example.nativetemplate.core_ui.theme.ApplicationShapes

@Composable
fun PrimaryButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    isLoading: Boolean = false,
    text: String = "",
    enabled: Boolean = true,
    shape: Shape = ApplicationShapes.Rounded8,
) {
    Button(
        modifier = modifier
            .clip(shape = shape)
            .background(
                brush = if (enabled) Brush.linearGradient(listOf(AppColors.blue, AppColors.primary))
                else Brush.linearGradient(listOf(AppColors.gray, AppColors.gray))
            ),
        shape = shape,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,
            disabledContainerColor = Color.Transparent
        ),
        enabled = enabled,
        onClick = onClick
    ) {
        if (isLoading) CircularProgressIndicator(color = AppColors.white)
        else Text(text = text, style = AppTypography.semiBold16, color = AppColors.white)
    }
}