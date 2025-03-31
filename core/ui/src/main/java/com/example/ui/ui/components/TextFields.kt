package com.example.ui.ui.components

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.ui.theme.TextFieldColor
import com.example.ui.ui.theme.WhiteTextColor
import com.example.ui.ui.theme.mainFontFamily

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldForEmail(
    email: MutableState<String>,
) {
    val interactionSource = remember { MutableInteractionSource() }
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = "Email",
            fontFamily = mainFontFamily,
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp,
            color = WhiteTextColor,
            letterSpacing = 0.15.sp,
            lineHeight = 18.sp
        )
        BasicTextField(
            value = email.value,
            onValueChange = { email.value = it },
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp),
            maxLines = 1,
            interactionSource = interactionSource,
            textStyle = LocalTextStyle.current.copy(
                color = WhiteTextColor,
                fontSize = 14.sp,
                fontFamily = mainFontFamily,
                fontWeight = FontWeight.Normal,
                letterSpacing = 0.25.sp
            ),
            cursorBrush = SolidColor(WhiteTextColor),
            decorationBox = { innerTextField ->
                TextFieldDefaults.DecorationBox(
                    value = email.value,
                    innerTextField = innerTextField,
                    singleLine = true,
                    visualTransformation = VisualTransformation.None,
                    interactionSource = interactionSource,
                    contentPadding = PaddingValues(8.dp),
                    enabled = true,
                    colors = TextFieldDefaults.colors(
                        unfocusedContainerColor = TextFieldColor,
                        focusedContainerColor = TextFieldColor,
                        unfocusedIndicatorColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        focusedTextColor = WhiteTextColor,
                        unfocusedTextColor = WhiteTextColor,
                        cursorColor = WhiteTextColor,
                    ),
                    shape = RoundedCornerShape(30.dp),
                    placeholder = {
                        Text(
                            text = "example@gmail.com",
                            color = WhiteTextColor.copy(alpha = 0.7f),
                            fontFamily = mainFontFamily,
                            fontWeight = FontWeight.Normal,
                            letterSpacing = 0.25.sp,
                            modifier = Modifier
                                .offset(x = (2).dp)
                        )
                    }
                )
            }
        )

    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldForPassword(
    passwordState: MutableState<String>
) {
    val interactionSource = remember { MutableInteractionSource() }
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = "Пароль",
            fontFamily = mainFontFamily,
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp,
            color = WhiteTextColor,
            letterSpacing = 0.15.sp,
            lineHeight = 18.sp
        )
        BasicTextField(
            value = passwordState.value,
            onValueChange = { passwordState.value = it },
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp),
            maxLines = 1,
            interactionSource = interactionSource,
            textStyle = LocalTextStyle.current.copy(
                color = WhiteTextColor,
                fontSize = 14.sp,
                fontFamily = mainFontFamily,
                fontWeight = FontWeight.Normal,
                letterSpacing = 0.25.sp
            ),
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            cursorBrush = SolidColor(WhiteTextColor),
            decorationBox = { innerTextField ->
                TextFieldDefaults.DecorationBox(
                    value = passwordState.value,
                    innerTextField = innerTextField,
                    singleLine = true,
                    visualTransformation = PasswordVisualTransformation(),
                    interactionSource = interactionSource,
                    contentPadding = PaddingValues(8.dp),
                    enabled = true,
                    colors = TextFieldDefaults.colors(
                        unfocusedContainerColor = TextFieldColor,
                        focusedContainerColor = TextFieldColor,
                        unfocusedIndicatorColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        focusedTextColor = WhiteTextColor,
                        unfocusedTextColor = WhiteTextColor,
                        cursorColor = WhiteTextColor,
                    ),
                    shape = RoundedCornerShape(30.dp),
                    placeholder = {
                        Text(
                            text = "Введите пароль",
                            color = WhiteTextColor.copy(alpha = 0.7f),
                            fontFamily = mainFontFamily,
                            fontWeight = FontWeight.Normal,
                            letterSpacing = 0.25.sp,
                            modifier = Modifier
                                .offset(x = 2.dp)
                        )
                    }
                )
            }
        )

    }
}

@Composable
@Preview
private fun Preview() {
    TextFieldForEmail(
        email = remember { mutableStateOf("") }
    )
}