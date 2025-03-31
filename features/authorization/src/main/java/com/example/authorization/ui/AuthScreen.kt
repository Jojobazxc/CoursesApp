package com.example.authorization.ui

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.authorization.components.Header
import com.example.authorization.components.MainBlock
import com.example.ui.ui.components.OKButton
import com.example.ui.ui.components.VKButton
import com.example.ui.ui.components.validateEmail
import com.example.ui.ui.theme.MainBGColor
import com.example.ui.ui.theme.OKGradientFirstColor
import com.example.ui.ui.theme.OKGradientSecondColor

@Composable
fun AuthScreen(onNavigateToMain: () -> Unit) {
    val emailState = remember {
        mutableStateOf("")
    }
    val passwordState = remember {
        mutableStateOf("")
    }
    var isEmailCorrect by remember {
        mutableStateOf(false)
    }
    Log.d("Email", "$isEmailCorrect")
    LaunchedEffect(emailState.value) {
        isEmailCorrect = validateEmail(emailState.value)
    }
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(MainBGColor)
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillParentMaxHeight(0.26f)
                    .padding(bottom = 32.dp),
                contentAlignment = Alignment.BottomStart
            ) {
                Header()
            }
        }
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillParentMaxHeight(0.4f)
            ) {
                MainBlock(
                    email = emailState,
                    password = passwordState,
                    onNavigateToMain = onNavigateToMain,
                    enabled = (isEmailCorrect && passwordState.value.isNotEmpty())
                )
            }
        }
        item {
            Row(
                modifier = Modifier
                    .padding(top = 32.dp)
                    .fillMaxWidth()
            ) {
                VKButton(
                    modifier = Modifier
                        .height(40.dp)
                        .weight(1f)
                        .padding(end = 8.dp)
                )
                OKButton(
                    modifier = Modifier
                        .clip(RoundedCornerShape(30.dp))
                        .background(
                            Brush.verticalGradient(
                                colors = listOf(
                                    OKGradientFirstColor,
                                    OKGradientSecondColor
                                )
                            )
                        )
                        .height(40.dp)
                        .weight(1f)
                        .padding(start = 8.dp)
                )
            }
        }
    }
}

@Preview
@Composable
private fun Preview() {
    AuthScreen { }
}