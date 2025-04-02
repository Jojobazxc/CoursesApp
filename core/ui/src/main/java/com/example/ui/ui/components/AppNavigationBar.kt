package com.example.ui.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.ui.R
import com.example.ui.ui.theme.GreenTextAndButtonColor
import com.example.ui.ui.theme.IndicatorNavBarColor
import com.example.ui.ui.theme.TextFieldColor
import com.example.ui.ui.theme.WhiteTextColor
import com.example.ui.ui.theme.mainFontFamily

@Composable
fun AppNavigationBar(
    currentScreen: String,
    onNavigateToMain: () -> Unit,
    onNavigateToFavourites: () -> Unit,
    onNavigateToProfile: () -> Unit
) {
    val listOfNavBarItems = listOf(
        BottomNavigationItem(
            title = "Главная",
            selectedIcon = ImageVector.vectorResource(R.drawable.ic_bottom_bar_main),
            unselectedIcon = ImageVector.vectorResource(R.drawable.ic_bottom_bar_main),
        ),
        BottomNavigationItem(
            title = "Избранное",
            selectedIcon = ImageVector.vectorResource(R.drawable.ic_bottom_bar_favourites),
            unselectedIcon = ImageVector.vectorResource(R.drawable.ic_bottom_bar_favourites),
        ),
        BottomNavigationItem(
            title = "Аккаунт",
            selectedIcon = ImageVector.vectorResource(R.drawable.ic_bottom_bar_profile),
            unselectedIcon = ImageVector.vectorResource(R.drawable.ic_bottom_bar_profile),
        )
    )

    NavigationBar(
        containerColor = TextFieldColor,
    ) {
        listOfNavBarItems.forEachIndexed { index, item ->
            val isSelected = when (item.title) {
                "Главная" -> currentScreen == "main_screen"
                "Избранное" -> currentScreen == "favourites_screen"
                "Аккаунт" -> currentScreen == "profile_screen"
                else -> false
            }

            NavigationBarItem(
                selected = isSelected,
                onClick = {
                    when (item.title) {
                        "Главная" -> onNavigateToMain()
                        "Избранное" -> onNavigateToFavourites()
                        "Аккаунт" -> onNavigateToProfile()
                    }
                },
                icon = {
                    Image(
                        imageVector = if (isSelected) item.selectedIcon else item.unselectedIcon,
                        contentDescription = item.title,
                        colorFilter = if (isSelected) {
                            ColorFilter.tint(GreenTextAndButtonColor)
                        } else {
                            ColorFilter.tint(WhiteTextColor)
                        }
                    )
                },
                label = {
                    Text(
                        text = item.title,
                        fontFamily = mainFontFamily,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 12.sp,
                        color = if (isSelected) GreenTextAndButtonColor else WhiteTextColor
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = GreenTextAndButtonColor,
                    selectedTextColor = GreenTextAndButtonColor,
                    unselectedIconColor = WhiteTextColor,
                    unselectedTextColor = WhiteTextColor,
                    indicatorColor = IndicatorNavBarColor
                )
            )
        }
    }
}