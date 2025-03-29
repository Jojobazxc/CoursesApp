package com.example.ui.ui.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.ui.theme.GreenTextAndButtonColor
import com.example.ui.ui.theme.RowItemBoxColor
import com.example.ui.ui.theme.mainFontFamily

@Composable
fun AppButton(
    text: String,
    route: String,
    onNavigateToAuth: () -> Unit,
    enabled: Boolean,
    modifier: Modifier
) {
    Button(
        modifier = modifier,
        onClick = {
            onNavigateToAuth.invoke()
        },
        enabled = enabled,
        shape = RoundedCornerShape(100.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = GreenTextAndButtonColor,
            disabledContainerColor = RowItemBoxColor
        ),
        content = {
            Text(
                text = text,
                fontFamily = mainFontFamily,
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp,
                lineHeight = 20.sp,
                letterSpacing = 0.1.sp,
                color = Color.White
            )
        }
    )
}