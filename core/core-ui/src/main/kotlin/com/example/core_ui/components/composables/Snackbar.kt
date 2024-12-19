package com.example.core_ui.components.composables

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.core_ui.theme.AppColors
import com.example.core_ui.theme.ApplicationShapes


@Composable
fun ApplicationSnackbar(
    modifier: Modifier = Modifier,
    @DrawableRes icon: Int,
    showSnackBar: Boolean,
    textColor: Color = AppColors.blue,
    iconTint: Color = Color.Unspecified,
    text: String = "",
    onIconClick: () -> Unit,
) {
    val snackbarHostState = remember { SnackbarHostState() }
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        SnackbarHost(
            modifier = Modifier.align(Alignment.TopCenter),
            hostState = snackbarHostState,
            snackbar = { _ ->
                HorecaSnackbarContent(
                    icon = icon,
                    text = text,
                    iconTint = iconTint,
                    textColor = textColor,
                    onIconClick = {
                        onIconClick()
                        snackbarHostState.currentSnackbarData?.dismiss()
                    }
                )
            }
        )
        if (showSnackBar) {
            LaunchedEffect(Unit) {
                snackbarHostState.showSnackbar(
                    message = "",
                    duration = SnackbarDuration.Short
                )
            }
        }

    }
}

@Composable
private fun HorecaSnackbarContent(
    modifier: Modifier = Modifier,
    onIconClick: () -> Unit,
    @DrawableRes icon: Int,
    iconTint: Color,
    text: String = "",
    textColor: Color,
) {
    Box(
        modifier = modifier
            .height(60.dp)
            .fillMaxWidth()
            .shadow(
                elevation = 2.dp,
                shape = ApplicationShapes.Rounded12,
                ambientColor = Color.Gray,
                spotColor = Color.DarkGray
            )
            .background(
                brush = Brush.verticalGradient(listOf(AppColors.primary, AppColors.blue)),
                shape = ApplicationShapes.Rounded12
            )
    ) {
        Row(
            modifier = modifier
                .fillMaxSize()
                .padding(horizontal = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(
                modifier = modifier
                    .padding(end = 10.dp)
                    .clip(ApplicationShapes.Rounded10)
                    .clickable { onIconClick() }
                    .padding(6.dp),
                painter = painterResource(icon),
                contentDescription = "cancel icon",
                tint = iconTint
            )
            Text(
                text = text,
                fontWeight = FontWeight.W700,
                color = textColor
            )
        }
    }
}