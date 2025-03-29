package com.example.features.onboarding

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.features.onboarding.components.CoursesRow
import com.example.features.onboarding.components.Header
import com.example.features.ui.commponents.AppButton
import com.example.features.ui.theme.MainBGColor

@Composable
fun OnboardingScreen(navController: NavController) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(MainBGColor)
            .padding(bottom = 42.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillParentMaxHeight(0.33f)
                    .padding(bottom = 32.dp),
                contentAlignment = Alignment.BottomCenter
            ) {
                Header()
            }
        }

        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillParentMaxHeight(0.33f),
                contentAlignment = Alignment.Center
            ) {
                CoursesRow()
            }
        }
        item {
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillParentMaxHeight(0.27f)
            )
        }
        item {
            AppButton(
                text = "Продолжить",
                route = "",
                navController = navController,
                enabled = true,
                modifier = Modifier
                    .padding(
                        start = 16.dp,
                        end = 16.dp,
                    )
                    .fillMaxWidth()
                    .fillParentMaxHeight(0.06f),
            )
        }

    }
}

@Composable
@Preview
private fun Preview() {
    OnboardingScreen(
        navController = rememberNavController()
    )
}