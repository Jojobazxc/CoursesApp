package com.example.main.ui

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.main.R
import com.example.main.components.HeaderRow
import com.example.main.components.SortItem
import com.example.main.viewmodels.CoursesViewModel
import com.example.ui.ui.components.AppNavigationBar
import com.example.ui.ui.components.CoursesItem
import com.example.ui.ui.theme.MainBGColor

@RequiresApi(Build.VERSION_CODES.S)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(
    onNavigateToFavouritesScreen: () -> Unit,
    onNavigateToProfileScreen: () -> Unit,
) {
    val viewModel: CoursesViewModel = hiltViewModel()
    val courses by viewModel.courses.collectAsState()
    val listOfImages = listOf(
        com.example.ui.R.drawable.im_course_mok_image1,
        com.example.ui.R.drawable.im_course_mok_image2,
        com.example.ui.R.drawable.im_course_mok_image3
    )
    //В course.json нет ссылки на картинку,
    //поэтому заменил таким способом, чтобы
    //у всех не было одной картинки

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(MainBGColor),
        color = MainBGColor
    ) {
        Scaffold(
            modifier = Modifier,
            containerColor = Color.Transparent,
            bottomBar = {
                AppNavigationBar(
                    onNavigateToMain = {},
                    onNavigateToFavourites = onNavigateToFavouritesScreen,
                    onNavigateToProfile = onNavigateToProfileScreen
                )
            },
        ) { innerPadding ->
            LazyColumn(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxSize()
                    .padding(bottom = innerPadding.calculateBottomPadding()),
            ) {
                item {
                    HeaderRow(innerPadding.calculateTopPadding())
                }
                item {
                    SortItem {
                        viewModel.sortCourses()
                    }
                }
                items(courses) { course ->
                    CoursesItem(
                        id = course.id,
                        title = course.title,
                        text = course.description,
                        price = course.price,
                        rate = course.rating,
                        startDate = course.startDate,
                        hasLike = course.isLiked,
                        publishDate = course.publishDate,
                        image = listOfImages.shuffled().take(1)[0]
                    )
                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.S)
@Composable
@Preview
private fun Preview() {
    MainScreen(
        {}
    ) { }
}