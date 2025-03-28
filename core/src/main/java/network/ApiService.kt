package network

import retrofit2.http.GET

interface ApiService {
    @GET("courses")
    suspend fun getCourses(): CoursesResponse
}