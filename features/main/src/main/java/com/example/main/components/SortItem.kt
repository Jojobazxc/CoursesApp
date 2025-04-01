package com.example.main.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.main.R
import com.example.ui.ui.theme.GreenTextAndButtonColor
import com.example.ui.ui.theme.mainFontFamily

@Composable
fun SortItem(
    onClick: () -> Unit
) {
    Row (
        modifier = Modifier
            .padding(top = 16.dp)
            .fillMaxWidth()
            .clickable {
                onClick.invoke()
            },
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "По дате добавления",
            fontFamily = mainFontFamily,
            fontWeight = FontWeight.Medium,
            lineHeight = 20.sp,
            letterSpacing = 0.1.sp,
            color = GreenTextAndButtonColor,
            fontSize = 14.sp,
            modifier = Modifier
                .padding(end = 4.dp)
        )
        Image(
            imageVector = ImageVector.vectorResource(R.drawable.ic_sort_arrows),
            contentDescription = "sort icon"
        )
    }
}

@Composable
@Preview
private fun Preview(modifier: Modifier = Modifier) {
    SortItem {  }
}