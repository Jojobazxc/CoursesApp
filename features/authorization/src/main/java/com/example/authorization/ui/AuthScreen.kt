package com.example.authorization.ui

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.authorization.components.Header
import com.example.authorization.components.TextFieldsColumn
import com.example.ui.ui.components.validateEmail
import com.example.ui.ui.theme.MainBGColor

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
                    .fillParentMaxHeight(0.25f)
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
                TextFieldsColumn(
                    email = emailState,
                    password = passwordState
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