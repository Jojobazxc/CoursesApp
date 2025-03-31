package com.example.authorization.viewmodels

import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import com.example.network.ApiService
import com.example.network.AuthData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val prefs: SharedPreferences,
    private val apiService: ApiService
) : ViewModel() {

    private val _token = MutableStateFlow(prefs.getString("auth_token", null))
    val token: StateFlow<String?> = _token.asStateFlow()

    suspend fun authorize(body: AuthData): Boolean {
        return try {
            val response = apiService.getAuth(authData = body)
            saveToken(response.token)
            true
        } catch (e: Exception) {
            false
        }
    }

    private fun saveToken(token: String) {
        prefs.edit().putString("auth_token", token).apply()
        _token.value = token
    }

    fun clearToken() {
        prefs.edit().remove("auth_token").apply()
        _token.value = null
    }
}