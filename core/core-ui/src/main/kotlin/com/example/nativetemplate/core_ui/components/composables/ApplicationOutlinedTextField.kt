package com.example.nativetemplate.core_ui.components.composables

import androidx.annotation.DrawableRes
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.nativetemplate.core_ui.theme.AppColors
import com.example.nativetemplate.core_ui.theme.AppTypography

@Composable
fun ApplicationTextField(
    modifier: Modifier = Modifier,
    onValueChange: (String) -> Unit,
    value: String,
    @DrawableRes trailingActions: Int? = null,
    onTrailingIconClick: () -> Unit = {},
    placeHolder: String = "",
    singleLine: Boolean = true,
    colors: TextFieldColors = OutlinedTextFieldDefaults.colors(
        unfocusedContainerColor = AppColors.white,
        focusedContainerColor = AppColors.white,
        unfocusedBorderColor = AppColors.blue,
        focusedBorderColor = AppColors.blue,
        unfocusedTextColor = AppColors.textPrimary,
        focusedTextColor = AppColors.textPrimary,
    ),
) {
    OutlinedTextField(
        modifier = modifier,
        value = value,
        onValueChange = onValueChange,
        singleLine = singleLine,
        colors = colors,
        trailingIcon = {
            trailingActions?.let { VirtualBankIconButton(icon = it, onClick = onTrailingIconClick) }
        },
        placeholder = {
            Text(
                text = placeHolder,
                style = AppTypography.regular16,
                color = AppColors.gray
            )
        }
    )
}