package com.example.favourites.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.network.ApiService
import com.example.network.Course
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavViewModel @Inject constructor (
    private val apiService: ApiService
): ViewModel() {
    private val _favCourses = MutableStateFlow<List<Course>>(emptyList())
    val favCourses = _favCourses.asStateFlow()

    init {
        loadFavCourse()
    }

    private fun loadFavCourse() {
        viewModelScope.launch {
            _favCourses.value = apiService.getCourses().courses.filter {
                it.isLiked
            }
        }
    }
}