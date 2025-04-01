package com.example.main.viewmodels

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.network.ApiService
import com.example.network.Course
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.format.DateTimeFormatter
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

    @RequiresApi(Build.VERSION_CODES.O)
    fun sortCourses() {
        _courses.value = _courses.value.sortedByDescending {
            parseDate(it.publishDate)
        }
    }

    private fun loadCourses() {
        viewModelScope.launch {
            try {
                _courses.value = apiService.getCourses().courses
            } catch (e: Exception) {
                Log.e("CoursesViewModel", "Ошибка запроса на сервер")
                //Обработка ошибки
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun parseDate(date: String): LocalDate {
        val inputFormat = DateTimeFormatter.ofPattern("yyyy-DD-mm")
        return LocalDate.parse(date, inputFormat)
    }

}