package com.example.core_ui.components.composables

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.core_ui.theme.AppTypography
import com.example.core.coreui.R
import com.example.core_ui.theme.AppColors

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ApplicationAppBar(
    title: String = "",
    withBackIcon: Boolean = true,
    navigationIcon: Int = R.drawable.ic_back,
    onNavigationBack: () -> Unit = {},
    colors: TopAppBarColors = TopAppBarDefaults.topAppBarColors(containerColor = AppColors.white),
    actions: @Composable (RowScope.() -> Unit) = {},
) {
    TopAppBar(
        title = {
            Text(text = title, style = AppTypography.bold16, color = AppColors.blue)
        },
        navigationIcon = {
            if (withBackIcon){
                VirtualBankIconButton(
                    modifier = Modifier.size(40.dp),
                    icon = navigationIcon,
                    onClick = onNavigationBack
                )
            }
        },
        colors = colors,
        actions = actions
    )
}