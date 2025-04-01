package com.example.navigation

sealed class Screen(val route: String) {
    data object OnboardingScreen: Screen("onboarding_screen")
    data object AuthorizationScreen: Screen("authorization_screen")
    data object MainScreen: Screen("main_screen")
    data object FavouritesScreen: Screen("favourites_screen")
}
