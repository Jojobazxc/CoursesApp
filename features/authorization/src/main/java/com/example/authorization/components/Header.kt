package com.example.authorization.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.ui.ui.theme.WhiteTextColor
import com.example.ui.ui.theme.mainFontFamily

@Composable
fun Header() {
    Text(
        text = "Вход",
        fontFamily = mainFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 28.sp,
        lineHeight = 36.sp,
        color = WhiteTextColor
    )
}