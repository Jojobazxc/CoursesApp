package com.example.authorization.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.ui.ui.components.TextFieldForEmail
import com.example.ui.ui.components.TextFieldForPassword

@Composable
fun TextFieldsColumn(
    email: MutableState<String>,
    password: MutableState<String>,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        TextFieldForEmail(email)
        TextFieldForPassword(password)
    }
}