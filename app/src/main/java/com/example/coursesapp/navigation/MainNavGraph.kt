package com.example.coursesapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.onboarding.ui.OnboardingScreen
import com.example.navigation.Screen

@Composable
fun MainNavGraph(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = Screen.OnboardingScreen.route
    ) {
        onboardingScreen(navController)
    }
}

private fun NavGraphBuilder.onboardingScreen(navController: NavHostController) {
    composable(Screen.OnboardingScreen.route) {
        OnboardingScreen(
            onNavigateToAuth = {
                navController.navigate(Screen.MainScreen.route)
            }
        )
    }
}