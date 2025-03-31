package com.example.authorization.components

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.authorization.viewmodels.AuthViewModel
import com.example.network.AuthData
import com.example.ui.ui.components.AppButton
import com.example.ui.ui.components.TextFieldForEmail
import com.example.ui.ui.components.TextFieldForPassword
import com.example.ui.ui.theme.DividerColor
import com.example.ui.ui.theme.GreenTextAndButtonColor
import com.example.ui.ui.theme.WhiteTextColor
import com.example.ui.ui.theme.mainFontFamily
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@Composable
fun MainBlock(
    email: MutableState<String>,
    password: MutableState<String>,
    onNavigateToMain: () -> Unit,
    enabled: Boolean
) {
    val scope = rememberCoroutineScope()
    val authViewModel: AuthViewModel = hiltViewModel()
    Log.d("TokenOnAuth", "${authViewModel.token.collectAsState().value}")
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        TextFieldForEmail(email)
        TextFieldForPassword(password)
        AppButton(
            text = "Вход",
            onClick = {
                scope.launch {
                    val success = authViewModel.authorize(
                        AuthData(
                            email = email.value,
                            password = password.value
                        )
                    )
                    if (success) {
                        withContext(Dispatchers.Main) {
                            onNavigateToMain.invoke()
                        }
                    } else {
                        //Логика обработки неуспешной авторизации
                    }
                }

            },
            enabled = enabled,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
        )
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Нету аккаунта?",
                    fontFamily = mainFontFamily,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 12.sp,
                    color = WhiteTextColor,
                    letterSpacing = 0.4.sp,
                    lineHeight = 15.sp
                )
                Text(
                    text = " Регистрация",
                    fontFamily = mainFontFamily,
                    color = GreenTextAndButtonColor,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 12.sp,
                    letterSpacing = 0.4.sp,
                    lineHeight = 15.sp,
                    modifier = Modifier
                        .clickable {
                            //Лямбда на навигацию на рег скрин
                        }
                )
            }
            Text(
                text = "Забыл пароль",
                fontFamily = mainFontFamily,
                color = GreenTextAndButtonColor,
                fontWeight = FontWeight.SemiBold,
                fontSize = 12.sp,
                letterSpacing = 0.4.sp,
                lineHeight = 15.sp,
                modifier = Modifier
                    .padding(top = 8.dp)
                    .clickable {
                        //Лямбда на навигацию на забыл пароль
                    }
            )
            HorizontalDivider(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .padding(top = 48.dp),
                color = DividerColor
            )
        }
    }
}