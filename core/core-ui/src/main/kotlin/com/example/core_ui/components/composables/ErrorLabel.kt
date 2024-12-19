package com.example.core.coreui.components.composables

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideInVertically
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.example.core_ui.theme.AppColors
import com.example.core_ui.theme.AppTypography
import com.example.core.coreui.R

@Composable
fun ErrorLabelWithAnimation(
    state: Boolean,
    message: String = stringResource(R.string.error),
    messageColor: Color = AppColors.red,
) {
    AnimatedVisibility(
        visible = state,
        enter = slideInVertically() + fadeIn(),
        exit = shrinkVertically() + fadeOut()
    ) {
        Text(
            text = message,
            style = AppTypography.regular16,
            color = messageColor
        )
    }
}