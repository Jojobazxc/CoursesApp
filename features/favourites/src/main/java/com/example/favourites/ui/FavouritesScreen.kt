package com.example.favourites.ui

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.favourites.viewmodels.FavViewModel
import com.example.ui.ui.components.AppNavigationBar
import com.example.ui.ui.components.CoursesItem
import com.example.ui.ui.theme.MainBGColor
import com.example.ui.ui.theme.WhiteTextColor
import com.example.ui.ui.theme.mainFontFamily

@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun FavouritesScreen(
    onNavigateToMain: () -> Unit,
    onNavigateToFavourites: () -> Unit,
    onNavigateToProfile: () -> Unit
) {
    val viewModel: FavViewModel = hiltViewModel()
    val favCourses by viewModel.favCourses.collectAsState()

    val listOfImages = listOf(
        com.example.ui.R.drawable.im_course_mok_image1,
        com.example.ui.R.drawable.im_course_mok_image2,
        com.example.ui.R.drawable.im_course_mok_image3
    )
    //В course.json нет ссылки на картинку,
    //поэтому заменил таким способом, чтобы
    //у всех не было одной картинки

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
        LazyColumn (
            modifier = Modifier
                .background(MainBGColor)
                .padding(16.dp)
                .fillMaxSize()
        ) {
            item {
                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = innerPadding.calculateTopPadding()),
                    horizontalArrangement = Arrangement.Start
                ) {
                    Text(
                        text = "Избранное",
                        modifier = Modifier,
                        fontFamily = mainFontFamily,
                        fontWeight = FontWeight.Normal,
                        color = WhiteTextColor,
                        fontSize = 22.sp,
                        lineHeight = 28.sp,
                    )
                }
            }
            items(favCourses) { favCourse ->
                CoursesItem(
                    id = favCourse.id,
                    title = favCourse.title,
                    text = favCourse.description,
                    price = favCourse.price,
                    rate = favCourse.rating,
                    startDate = favCourse.startDate,
                    hasLike = favCourse.isLiked,
                    publishDate = favCourse.publishDate,
                    image = listOfImages.shuffled().take(1)[0]
                )
            }
        }
    }
}

@Preview
@Composable
private fun Preview() {
    FavouritesScreen(
        {}, {}
    ) { }
}
