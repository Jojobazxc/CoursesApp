package com.example.features.ui.commponents

import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.navigation.NavController
import com.example.features.ui.theme.GreenTextAndButtonColor
import com.example.features.ui.theme.RowItemBoxColor
import com.example.features.ui.theme.mainFontFamily

@Composable
fun AppButton(
    text: String,
    route: String,
    navController: NavController,
    enabled: Boolean,
    modifier: Modifier
) {
    Button(
        modifier = modifier,
        onClick = {
            navController.navigate(route)
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