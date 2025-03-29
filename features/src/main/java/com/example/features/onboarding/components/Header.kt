package com.example.features.onboarding.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.features.ui.theme.WhiteTextColor
import com.example.features.ui.theme.mainFontFamily

@Composable
fun Header() {

    Text(
        text = "Тысячи курсов\nв одном месте",
        modifier = Modifier,
        color = WhiteTextColor,
        fontFamily = mainFontFamily,
        fontWeight = FontWeight.Normal,
        lineHeight = 36.sp,
        fontSize = 28.sp,
    )

}

@Composable
@Preview
private fun Preview() {
    Header()
}