package com.example.authorization.viewmodels

import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import com.example.network.ApiService
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val prefs: SharedPreferences,
    private val apiService: ApiService
) : ViewModel() {
    fun saveToken(token: String) {
        prefs.edit().putString("auth_token", token).apply()
    }

    fun getToken(): String? {
        return prefs.getString("auth_token", null)
    }
}