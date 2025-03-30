package com.example.ui.ui.components


fun validateEmail(
    email: String,
): Boolean {
    return email.matches(Regex("([a-zA-Z0-9._-]+@[a-zA-Z0-9._-]+\\.[a-zA-Z]{2,}+)"))

}