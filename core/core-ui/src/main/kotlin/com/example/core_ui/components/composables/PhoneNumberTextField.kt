package com.example.core_ui.components.composables

import androidx.annotation.DrawableRes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.core.coreui.R
import com.example.core_ui.components.PhoneVisualTransformation
import com.example.core_ui.theme.AppColors
import com.example.core_ui.theme.AppTypography
import com.example.core_ui.theme.ApplicationShapes
import com.example.core_ui.utils.PhoneConstants

@Composable
fun PhoneNumberTextField(
    modifier: Modifier = Modifier,
    onValueChange: (String) -> Unit,
    value: String,
    leadingText: String = "+998",
    onTrailingIconClick: () -> Unit = {},
    @DrawableRes trailingIcon: Int = R.drawable.ic_close,
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
        onValueChange = {
            if (it.length <= 9 || it.length < value.length) {
                onValueChange(it)
            }
        },
        value = value,
        shape = ApplicationShapes.Rounded8,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
        colors = colors,
        singleLine = true,
        visualTransformation = PhoneVisualTransformation(
            mask = PhoneConstants.PHONE_MASK,
            maskItem = PhoneConstants.PHONE_MASK_ITEM
        ),
        leadingIcon = {
            Text(
                modifier = Modifier.padding(start = 8.dp),
                text = leadingText,
                style = AppTypography.regular16,
                color = AppColors.textSecondary
            )
        },
        trailingIcon = {
            AnimatedVisibility(
                visible = value.isNotBlank() && value.isNotEmpty()
            ) {
                VirtualBankIconButton(
                    modifier = Modifier.size(24.dp),
                    icon = trailingIcon,
                    onClick = onTrailingIconClick
                )
            }
        }
    )
}