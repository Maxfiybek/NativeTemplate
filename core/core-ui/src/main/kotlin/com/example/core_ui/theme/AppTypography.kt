package com.example.core_ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.core.coreui.R

object AppTypography {

    private val gilroyFonts = FontFamily(
        Font(R.font.gilroy_bold_700, FontWeight.Bold),
        Font(R.font.gilroy_semibold_600, FontWeight.SemiBold),
        Font(R.font.gilroy_medium_500, FontWeight.Medium),
        Font(R.font.gilroy_regular_400, FontWeight.Normal),
    )

    private val boldStyle: TextStyle
        @Composable
        get() = TextStyle(
            fontWeight = FontWeight.Bold,
            fontFamily = gilroyFonts,
            color = AppColors.textPrimary
        )

    val bold16: TextStyle
        @Composable
        get() = boldStyle.copy(fontSize = 16.sp)

    val bold20: TextStyle
        @Composable
        get() = boldStyle.copy(fontSize = 20.sp)

    val bold22: TextStyle
        @Composable
        get() = boldStyle.copy(fontSize = 22.sp)

    val bold24: TextStyle
        @Composable
        get() = boldStyle.copy(fontSize = 24.sp)

    val bold30: TextStyle
        @Composable
        get() = boldStyle.copy(fontSize = 30.sp)

    private val semiBoldStyle: TextStyle
        @Composable
        get() = TextStyle(
            fontWeight = FontWeight.SemiBold,
            fontFamily = gilroyFonts,
            color = AppColors.textPrimary
        )

    val semiBold14: TextStyle
        @Composable
        get() = semiBoldStyle.copy(fontSize = 14.sp)

    val semiBold16: TextStyle
        @Composable
        get() = semiBoldStyle.copy(fontSize = 16.sp)

    val semiBold30: TextStyle
        @Composable
        get() = semiBoldStyle.copy(fontSize = 30.sp)

    private val mediumStyle: TextStyle
        @Composable
        get() = TextStyle(
            fontWeight = FontWeight.Medium,
            fontFamily = gilroyFonts,
            color = AppColors.textPrimary
        )

    val medium14: TextStyle
        @Composable
        get() = mediumStyle.copy(fontSize = 14.sp)

    val medium15: TextStyle
        @Composable
        get() = mediumStyle.copy(fontSize = 15.sp)

    val medium16: TextStyle
        @Composable
        get() = mediumStyle.copy(fontSize = 16.sp)

    val medium20: TextStyle
        @Composable
        get() = mediumStyle.copy(fontSize = 20.sp)


    private val regularStyle: TextStyle
        @Composable
        get() = TextStyle(
            fontWeight = FontWeight.Normal,
            fontFamily = gilroyFonts,
            color = AppColors.textPrimary
        )

    val regular16: TextStyle
        @Composable
        get() = regularStyle.copy(fontSize = 16.sp)

    val regular14: TextStyle
        @Composable
        get() = regularStyle.copy(fontSize = 14.sp)

    val regular12: TextStyle
        @Composable
        get() = regularStyle.copy(fontSize = 12.sp)
}