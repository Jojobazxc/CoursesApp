package com.example.ui.ui.components

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.example.ui.R
import com.example.ui.ui.theme.VKColor

@Composable
fun VKButton(
    modifier: Modifier
) {
    val context = LocalContext.current
    Button(
        onClick = {
            val intent = Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse("https://vk.com")
                flags = Intent.FLAG_ACTIVITY_NEW_TASK
            }
            context.startActivity(intent)
        },
        modifier = modifier,
        content = {
            Image(
                imageVector = ImageVector.vectorResource(R.drawable.ic_vk),
                contentDescription = "vk button"
            )
        },
        shape = RoundedCornerShape(30.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = VKColor
        )
    )
}

@Composable
fun OKButton(
    modifier: Modifier
) {
    val context = LocalContext.current
    Button(
        onClick = {
            val intent = Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse("https://ok.ru")
                flags = Intent.FLAG_ACTIVITY_NEW_TASK
            }
            context.startActivity(intent)
        },
        modifier = modifier,
        content = {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_ok_head),
                    contentDescription = "ok button",
                    contentScale = ContentScale.FillBounds
                )
                Image(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_ok_legs),
                    contentDescription = "ok button",
                    contentScale = ContentScale.FillBounds
                )
            }
        },
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent
        )
    )
}