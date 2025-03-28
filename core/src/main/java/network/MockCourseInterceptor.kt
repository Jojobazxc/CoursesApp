package network

import android.content.Context
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.Protocol
import okhttp3.Response
import okhttp3.ResponseBody.Companion.toResponseBody

class MockCourseInterceptor(
    private val context: Context,
    private val jsonFileName: String = "courses.json"
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {

        val json = loadFromAssets(context, jsonFileName)

        return Response.Builder()
            .code(200)
            .message("OK")
            .request(chain.request())
            .protocol(Protocol.HTTP_1_1)
            .body(json.toResponseBody("application/json".toMediaType()))
            .build()
    }

    private fun loadFromAssets(context: Context, fileName: String): String {
        return context.assets.open(fileName).bufferedReader().use { it.readText() }
    }
}