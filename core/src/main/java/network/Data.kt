package network

import com.google.gson.annotations.SerializedName

data class CoursesResponse(
    @SerializedName("courses") val courses: List<Course>
)

data class Course(
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String,
    @SerializedName("text") val description: String,
    @SerializedName("price") val price: String,
    @SerializedName("rate") val rating: String,
    @SerializedName("startDate") val startDate: String,
    @SerializedName("hasLike") val isLiked: Boolean,
    @SerializedName("publishDate") val publishDate: String
)