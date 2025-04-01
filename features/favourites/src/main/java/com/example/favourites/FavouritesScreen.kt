package com.example.favourites

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.ui.ui.components.AppNavigationBar

@Composable
fun FavouritesScreen(
    onNavigateToMain: () -> Unit,
    onNavigateToFavourites: () -> Unit,
    onNavigateToProfile: () -> Unit
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            AppNavigationBar(
                onNavigateToMain = onNavigateToMain,
                onNavigateToFavourites = onNavigateToFavourites,
                onNavigateToProfile = onNavigateToProfile,
                currentScreen = "favourites_screen"
            )
        }
    ) { innerPadding ->
        Text(
            text = "Избранное",
            modifier = Modifier.padding(innerPadding)
        )
    }
}
