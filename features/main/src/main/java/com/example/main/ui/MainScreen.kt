package com.example.main.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.main.viewmodels.CoursesViewModel
import com.example.ui.ui.components.AppNavigationBar
import com.example.ui.ui.theme.MainBGColor

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(
    onNavigateToFavouritesScreen: () -> Unit,
    onNavigateToProfileScreen:() -> Unit,
) {
//    val viewModel: CoursesViewModel = hiltViewModel()
//    val courses by viewModel.courses.collectAsState()

    Surface (
        modifier = Modifier
            .fillMaxSize()
            .background(MainBGColor),
        color = MainBGColor
    ) {
        Scaffold (
            modifier = Modifier,
            containerColor = Color.Transparent,
            bottomBar = {
                AppNavigationBar(
                    onNavigateToMain = {},
                    onNavigateToFavourites = onNavigateToFavouritesScreen,
                    onNavigateToProfile = onNavigateToProfileScreen
                )
            }
        ) {

        }
    }
}

@Composable
@Preview
private fun Preview() {
    MainScreen(
        {}
    ) { }
}