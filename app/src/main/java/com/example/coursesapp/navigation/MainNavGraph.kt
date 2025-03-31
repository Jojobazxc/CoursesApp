package com.example.coursesapp.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.authorization.ui.AuthScreen
import com.example.authorization.viewmodels.AuthViewModel
import com.example.main.ui.MainScreen
import com.example.onboarding.ui.OnboardingScreen
import com.example.navigation.Screen

@Composable
fun MainNavGraph(
    navController: NavHostController = rememberNavController()
) {
    val authViewModel: AuthViewModel = hiltViewModel()
    val token = authViewModel.token.collectAsState()
    Log.d("TokenOnNav", "${token.value}")
    NavHost(
        navController = navController,
        startDestination = if (token.value == null) Screen.OnboardingScreen.route else Screen.MainScreen.route
    ) {
        onboardingScreen(navController)
        authorizationScreen(navController)
        mainScreen(navController)
    }
}

private fun NavGraphBuilder.mainScreen(navController: NavHostController) {
    composable(Screen.MainScreen.route) {
        MainScreen(
            onNavigateToFavouritesScreen = {

            },
            onNavigateToProfileScreen = {

            }
        )
    }
}

private fun NavGraphBuilder.onboardingScreen(navController: NavHostController) {
    composable(Screen.OnboardingScreen.route) {
        OnboardingScreen(
            onNavigateToAuth = {
                navController.navigate(Screen.AuthorizationScreen.route)
            }
        )
    }
}

private fun NavGraphBuilder.authorizationScreen(navController: NavHostController) {
    composable(Screen.AuthorizationScreen.route) {
        AuthScreen(
            onNavigateToMain = {
                navController.navigate(Screen.MainScreen.route) {
                    popUpTo(Screen.OnboardingScreen.route) {
                        inclusive = true
                    }
                }
            }
        )
    }
}