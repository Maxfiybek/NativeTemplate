package com.example.nativetemplate.core_ui.components.composables

import androidx.annotation.DrawableRes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.nativetemplate.core_ui.theme.AppColors
import com.example.nativetemplate.core_ui.theme.AppTypography
import com.example.nativetemplate.core_ui.theme.ApplicationShapes

@Composable
fun ApplicationOutlinedTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    singleLine: Boolean = true,
    readOnly: Boolean = false,
    shape: Shape = ApplicationShapes.Rounded8,
    keyBoardType: KeyboardType = KeyboardType.Unspecified,
    imeAction: ImeAction = ImeAction.Default,
    colors: TextFieldColors = OutlinedTextFieldDefaults.colors(
        unfocusedTextColor = AppColors.textPrimary,
        focusedTextColor = AppColors.textPrimary,
        unfocusedBorderColor = AppColors.blue,
        focusedBorderColor = AppColors.blue,
        unfocusedContainerColor = AppColors.background,
        focusedContainerColor = AppColors.background
    ),
    textStyle: TextStyle = AppTypography.regular16,
    @DrawableRes trailingIcon: Int? = null,
    onTrailingIconClick: () -> Unit = {},
    placeHolder: String = "",
) {
    OutlinedTextField(
        modifier = modifier,
        value = value,
        onValueChange = onValueChange,
        textStyle = textStyle,
        shape = shape,
        colors = colors,
        readOnly = readOnly,
        placeholder = {
            Text(
                text = placeHolder,
                style = textStyle,
                color = AppColors.textSecondary
            )
        },
        trailingIcon = {
            AnimatedVisibility(visible = value.isNotBlank() || value.isNotEmpty()) {
                trailingIcon?.let {
                    VirtualBankIconButton(
                        modifier = Modifier.size(24.dp),
                        icon = it,
                        onClick = onTrailingIconClick
                    )
                }
            }
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = keyBoardType,
            imeAction = imeAction
        ),
        singleLine = singleLine
    )
}