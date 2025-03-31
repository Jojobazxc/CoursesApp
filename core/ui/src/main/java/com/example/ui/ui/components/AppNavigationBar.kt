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
    onNavigateToMain: () -> Unit,
    onNavigateToFavourites: () -> Unit,
    onNavigateToProfile: () -> Unit
) {

    var selectedItemIndex by rememberSaveable {
        mutableStateOf(0)
    }

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
        ),

        )
    NavigationBar(
        containerColor = TextFieldColor,
    ) {
        listOfNavBarItems.forEachIndexed { index, bottomNavigationItem ->
            NavigationBarItem(
                selected = selectedItemIndex == index,
                onClick = when (bottomNavigationItem.title) {
                    "Главная" -> {
                        {
                            selectedItemIndex = index
                            onNavigateToMain.invoke()
                        }
                    }

                    "Избранное" -> {
                        {
                            selectedItemIndex = index
                            onNavigateToFavourites.invoke()
                        }

                    }

                    "Аккаунт" -> {
                        {
                            selectedItemIndex = index
                            onNavigateToProfile.invoke()
                        }

                    }

                    else -> {
                        {}
                    }
                },
                icon = {
                    Image(
                        imageVector = bottomNavigationItem.selectedIcon,
                        contentDescription = bottomNavigationItem.title,
                        colorFilter = if (selectedItemIndex == index) ColorFilter.tint(
                            GreenTextAndButtonColor
                        ) else ColorFilter.tint(WhiteTextColor)
                    )
                },
                modifier = Modifier
                    .background(TextFieldColor),
                enabled = true,
                label = {
                    Text(
                        text = bottomNavigationItem.title,
                        fontFamily = mainFontFamily,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 12.sp,
                        lineHeight = 15.sp,
                        letterSpacing = 0.4.sp,
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = GreenTextAndButtonColor,
                    selectedTextColor = GreenTextAndButtonColor,
                    unselectedIconColor = WhiteTextColor,
                    unselectedTextColor = WhiteTextColor,
                    indicatorColor = IndicatorNavBarColor,
                ),
            )
        }
    }
}