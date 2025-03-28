package network

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @GET("courses")
    suspend fun getCourses(): CoursesResponse

    @POST("auth")
    suspend fun getAuth(@Body authData: AuthData): Token
}