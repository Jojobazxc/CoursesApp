package com.example.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.ui.ui.components.AppNavigationBar
import com.example.ui.ui.theme.MainBGColor
import com.example.ui.ui.theme.WhiteTextColor
import com.example.ui.ui.theme.mainFontFamily

@Composable
fun ProfileScreen(
    onNavigateToMain: () -> Unit,
    onNavigateToFavourites: () -> Unit,
    onNavigateToProfile: () -> Unit
) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        bottomBar = {
            AppNavigationBar(
                currentScreen = "profile_screen",
                onNavigateToMain = onNavigateToMain,
                onNavigateToFavourites = onNavigateToFavourites,
                onNavigateToProfile = onNavigateToProfile
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(MainBGColor),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Text(
                    text = "Экран профиля",
                    fontFamily = mainFontFamily,
                    fontWeight = FontWeight.Medium,
                    color = WhiteTextColor,
                    fontSize = 22.sp
                )
            }
        }
    }
}

