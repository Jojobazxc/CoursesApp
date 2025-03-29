package com.example.main.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import network.ApiService
import network.Course
import javax.inject.Inject

@HiltViewModel
class CoursesViewModel @Inject constructor(
    private val apiService: ApiService
): ViewModel() {
    private val _courses = MutableStateFlow<List<Course>>(emptyList())
    val courses = _courses.asStateFlow()

    init {
        loadCourses()
    }

    private fun loadCourses() {
        viewModelScope.launch {
            _courses.value = apiService.getCourses().courses
        }
    }
}