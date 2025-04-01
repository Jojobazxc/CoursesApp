package com.example.ui.ui.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.example.ui.R
import com.example.ui.ui.theme.BlurColor
import com.example.ui.ui.theme.CourseCardColor
import com.example.ui.ui.theme.GreenTextAndButtonColor
import com.example.ui.ui.theme.WhiteTextColor
import com.example.ui.ui.theme.mainFontFamily
import dev.chrisbanes.haze.HazeDefaults
import dev.chrisbanes.haze.HazeState
import dev.chrisbanes.haze.HazeStyle
import dev.chrisbanes.haze.hazeEffect
import dev.chrisbanes.haze.materials.ExperimentalHazeMaterialsApi
import dev.chrisbanes.haze.materials.HazeMaterials
import java.text.SimpleDateFormat
import java.util.Locale

@OptIn(ExperimentalHazeMaterialsApi::class)
@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun CoursesItem(
    id: Int,
    title: String,
    text: String,
    price: String,
    rate: String,
    startDate: String,
    hasLike: Boolean,
    publishDate: String,
    image: Int
) {
    Card(
        modifier = Modifier
            .padding(top = 16.dp)
            .fillMaxWidth()
            .height(236.dp)
            .zIndex(1f),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = CourseCardColor
        )
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(114.dp)
                .zIndex(2f),
        ) {
            Image(
                painter = painterResource(image),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(
                        bottomStart = 12.dp,
                        bottomEnd = 12.dp
                    ))
            )
            Row (
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(bottom = 8.dp),
            ) {
                Card (
                    modifier = Modifier
                        .padding(
                            start = 8.dp,
                        )
                        .size(46.dp, 22.dp)
                        .zIndex(3f)
                    ,
                    colors = CardDefaults.cardColors(
                        containerColor = BlurColor.copy(0.7f)
                    )
                ) {
                    Row (
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 6.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Image(
                            imageVector = ImageVector.vectorResource(R.drawable.ic_rate),
                            contentDescription = null
                        )
                        Text(
                            text = rate,
                            fontFamily = mainFontFamily,
                            fontSize = 12.sp,
                            color = WhiteTextColor
                        )
                    }
                }
                Card (
                    modifier = Modifier
                        .padding(start = 4.dp)
                        .height(22.dp)
                        .zIndex(3f)
                    ,
                    colors = CardDefaults.cardColors(
                        containerColor = BlurColor.copy(0.7f)
                    ),
                ) {
                    Column (
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .fillMaxHeight()
                    ) {
                        Text(
                            text = formatData(date = startDate),
                            modifier = Modifier
                                .padding(
                                    horizontal = 6.dp,
                                    vertical = 4.dp
                                ),
                            fontSize = 12.sp,
                            fontFamily = mainFontFamily,
                            color = WhiteTextColor
                        )
                    }
                }
            }
            Box(
                modifier = Modifier
                    .padding(8.dp)
                    .align(Alignment.TopEnd)
                    .clip(RoundedCornerShape(20.dp))
                    .background(BlurColor.copy(0.7f))
                    .size(28.dp)
                    .clickable {
                        //Логика добавления в избранное
                    },
                contentAlignment = Alignment.Center

            ) {
                Image(
                    imageVector = ImageVector.vectorResource(if (hasLike) R.drawable.ic_liked_course else R.drawable.ic_bottom_bar_favourites),
                    contentDescription = null,
                    modifier = Modifier
                        .size(10.dp, 13.dp),
                )
            }
        }
        Column (
            modifier = Modifier
                .padding(16.dp)
        ) {
            Text(
                text = title,
                fontFamily = mainFontFamily,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = WhiteTextColor,
                lineHeight = 18.sp,
                letterSpacing = 0.15.sp
            )
            Text(
                text = text,
                fontFamily = mainFontFamily,
                fontWeight = FontWeight.Normal,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                fontSize = 12.sp,
                color = WhiteTextColor.copy(alpha = 0.7f),
                modifier = Modifier
                    .padding(top = 12.dp)
            )
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "$price ₽",
                    fontFamily = mainFontFamily,
                    fontWeight = FontWeight.Normal,
                    fontSize = 16.sp,
                    lineHeight = 18.sp,
                    letterSpacing = 0.15.sp,
                    color = WhiteTextColor,
                )
                Row (
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Подробнее",
                        fontFamily = mainFontFamily,
                        fontWeight = FontWeight.SemiBold,
                        color = GreenTextAndButtonColor,
                        fontSize = 12.sp,
                        lineHeight = 15.sp,
                        letterSpacing = 0.4.sp,
                        modifier = Modifier
                            .padding(end = 2.dp)
                    )
                    Image(
                        imageVector = ImageVector.vectorResource(R.drawable.ic_arrow_more),
                        contentDescription = "more",
                        modifier = Modifier
                            .offset(y = 0.75.dp)
                    )
                }
            }
        }
    }
}

private fun formatData(date: String): String {
    return try {
        val inputFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val outputFormat = SimpleDateFormat("d MMMM yyyy", Locale("ru"))
        outputFormat.format(inputFormat.parse(date)!!)
    } catch (e: NullPointerException) {
        date
    }

}

@RequiresApi(Build.VERSION_CODES.S)
@Composable
@Preview
private fun Preview() {
//    CoursesItem(
//        id = 1,
//        title = "Java-разработчик с нуля",
//        text = "Освойте backend-разработку и программирование на Java, фреймворки Spring и Maven, работу с базами данных и API. Создайте свой собственный проект, собрав портфолио и став востребованным специалистом для любой IT компании.",
//        price = "999",
//        rate = "4.1",
//        startDate = "2024-12-12",
//        hasLike = true,
//        publishDate = "2024-12-12"
//    )
}