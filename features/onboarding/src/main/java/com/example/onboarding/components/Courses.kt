package com.example.onboarding.components

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder

object Courses {
    fun getListOfCourses(): List<String> {
        return listOf(
            "1С Администрирование",
            "Rabbit MQ",
            "Трафик",
            "Интернет маркетинг",
            "B2B маркетинг",
            "Google Аналитика",
            "Исследователь",
            "Веб - аналитика",
            "Big Data",
            "Дизайн",
            "Веб-дизайн",
            "Cinema 4D",
            "Промпт",
            "View Course",
            "Three.js",
            "Парсинг",
            "Python-разработчик",
            "Java-разработчик",
            "Kotlin Dev",
            "Linux OC"
        )
    }
}

//Не все курсы соответствуют макету, так как некоторые просто не видно, поэтому написал сам.
