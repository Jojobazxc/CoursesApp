package com.example.onboarding.ui

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
import com.example.ui.ui.components.AppButton
import com.example.onboarding.components.CoursesRow
import com.example.onboarding.components.Header

@Composable
fun OnboardingScreen(
    onNavigateToAuth: () -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(com.example.ui.ui.theme.MainBGColor)
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
                onClick = onNavigateToAuth,
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

}