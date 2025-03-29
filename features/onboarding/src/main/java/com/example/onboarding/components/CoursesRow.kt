package com.example.onboarding.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.staggeredgrid.LazyHorizontalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.example.ui.ui.theme.GreenTextAndButtonColor
import com.example.ui.ui.theme.MainBGColor
import com.example.ui.ui.theme.RowItemBoxColor
import com.example.ui.ui.theme.WhiteTextColor
import com.example.ui.ui.theme.mainFontFamily

@Composable
fun CoursesRow() {
    val coursesList = Courses.getListOfCourses()
    LazyHorizontalStaggeredGrid(
        rows = StaggeredGridCells.Fixed(4),
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalItemSpacing = 4.dp
    ) {
        item {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MainBGColor)
                    .zIndex(1f)
            )
        }
        items(coursesList) { item ->
            RowItem(
                text = item,
                height = 52.dp
            )
        }
    }

}


@Composable
fun RowItem(
    text: String,
    height: Dp
) {

    var isClicked by remember { mutableStateOf(false) }

    val rotation by animateFloatAsState(
        targetValue = if (isClicked) (15f) else 0f,
        animationSpec = tween(durationMillis = 300)
    )

    val backgroundColor by animateColorAsState(
        targetValue = if (isClicked) GreenTextAndButtonColor else RowItemBoxColor,
        animationSpec = tween(durationMillis = 300)
    )

    Card(
        modifier = Modifier
            .height(height)
            .widthIn(min = 100.dp)
            .clickable {
                isClicked = !isClicked
            }
            .graphicsLayer {
                rotationZ = rotation
            }
            .zIndex(1f),
        shape = RoundedCornerShape(110.dp),
        colors = CardDefaults.cardColors(
            containerColor = backgroundColor
        ),
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),

            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = text,
                fontFamily = mainFontFamily,
                fontWeight = FontWeight.Medium,
                color = WhiteTextColor,
                fontSize = 14.sp,
                letterSpacing = 0.1.sp,
                modifier = Modifier
                    .padding(
                        horizontal = 24.dp,
                        vertical = 20.dp
                    )
            )
        }
    }
}

@Composable
@Preview
private fun Preview() {
    CoursesRow()
}