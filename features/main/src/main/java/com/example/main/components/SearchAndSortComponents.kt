package com.example.main.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.main.R
import com.example.ui.ui.theme.TextFieldColor
import com.example.ui.ui.theme.WhiteTextColor
import com.example.ui.ui.theme.mainFontFamily

@Composable
fun SearchTextField(
    modifier: Modifier
) {
    val search = remember {
        mutableStateOf("")
    }
    OutlinedTextField(
        value = search.value,
        onValueChange = {
            search.value = it
        },
        modifier = modifier,
        leadingIcon = {
            Image(
                imageVector = ImageVector.vectorResource(R.drawable.ic_search),
                contentDescription = "search",
                modifier = Modifier
                    .padding(start = 14.dp)
            )
        },
        placeholder = {
            Text(
                text = "Search courses...",
                fontFamily = mainFontFamily,
                fontWeight = FontWeight.Normal,
                color = WhiteTextColor.copy(alpha = 0.7f),
                lineHeight = 18.sp,
            )
        },
        colors = TextFieldDefaults.colors(
            focusedContainerColor = TextFieldColor,
            unfocusedContainerColor = TextFieldColor,
            cursorColor = WhiteTextColor,
            focusedTextColor = WhiteTextColor,
            unfocusedTextColor = WhiteTextColor,
            focusedIndicatorColor = TextFieldColor,
            unfocusedIndicatorColor = TextFieldColor
        )
    )
}

@Composable
fun FilterButton(
    modifier: Modifier
) {
    Button(
        modifier = modifier,
        onClick = {},
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = TextFieldColor
        )
    ) {
        Image(
            imageVector = ImageVector.vectorResource(R.drawable.ic_filter),
            contentDescription = "sort button",
            modifier = Modifier.size(40.dp, 32.dp),
        )
    }
}

@Composable
fun HeaderRow(
    padding: Dp
) {
    Row(
        modifier = Modifier
            .padding(top = padding)
            .fillMaxWidth()
            .height(60.dp)
    ) {
        SearchTextField(
            modifier = Modifier
                .fillMaxHeight()
                .padding(end = 4.dp)
                .weight(4.5f)
                .clip(RoundedCornerShape(30.dp))
        )
        FilterButton(
            modifier = Modifier
                .fillMaxHeight()
                .padding(start = 4.dp)
                .size(56.dp)
                .clip(RoundedCornerShape(30.dp))
                .weight(1f)
        )
    }
}

@Composable
@Preview
private fun Preview() {
//    HeaderRow()
}