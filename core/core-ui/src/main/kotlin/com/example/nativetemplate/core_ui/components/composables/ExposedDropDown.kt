package com.example.nativetemplate.core_ui.components.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuBoxScope
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.nativetemplate.core_ui.theme.AppColors
import com.example.nativetemplate.core_ui.theme.ApplicationShapes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ApplicationExposedDropdownWithLabel(
    modifier: Modifier = Modifier,
    label: String = "",
    labelVisibility: Boolean = false,
    expanded: Boolean = false,
    menuItemsContent: @Composable () -> Unit,
    content: @Composable ExposedDropdownMenuBoxScope.() -> Unit,
    onMenuBoxClicked: () -> Unit,
    onDismissRequest: () -> Unit = {},
    onExpandedChange: (Boolean) -> Unit = {},
) {
    val rippleEffect = ripple(bounded = false, color = AppColors.blue)
    Column(modifier = modifier) {
        ErrorLabelWithAnimation(
            state = labelVisibility,
            message = label
        )
        ExposedDropdownMenuBox(
            modifier = Modifier
                .clip(ApplicationShapes.Rounded8)
                .withBorder()
                .clickable(
                    onClick = onMenuBoxClicked,
                    indication = rippleEffect,
                    interactionSource = remember { MutableInteractionSource() }
                ),
            expanded = expanded,
            onExpandedChange = onExpandedChange,
        ) {
            content()
            ExposedDropdownMenu(
                modifier = Modifier.heightIn(max = 150.dp),
                scrollState = rememberScrollState(),
                expanded = expanded,
                onDismissRequest = onDismissRequest,
            ) {
                menuItemsContent()
            }
        }
    }
}