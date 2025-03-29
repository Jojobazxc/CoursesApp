package com.example.main.ui

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.main.viewmodels.CoursesViewModel

@Composable
fun CoursesScreen() {
    val viewModel: CoursesViewModel = hiltViewModel()
    val courses by viewModel.courses.collectAsState()

    Log.d("Courses", "$courses")
}