package com.example.network

import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.Protocol
import okhttp3.Response
import okhttp3.ResponseBody.Companion.toResponseBody

class MockAuthInterceptor(
    private val route: String
): Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()

        val mockJwt = getJWT()

        if (request.method == "POST" && request.url.encodedPath == route) {
            return Response.Builder()
                .code(200)
                .message("OK")
                .request(request)
                .protocol(Protocol.HTTP_1_1)
                .body(mockJwt.toResponseBody("application/json".toMediaType()))
                .build()
        }
        return chain.proceed(request)
    }

    //Функция возвращает моканный JWT, так как хочу обойтись без сторонних библиотек
    private fun getJWT(): String {
        return """
            {
                "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJiZWZ1bm55QGRvdWJsZXRhcHAu
                YWkiLCJtZXNzYWdlIjoiSGVsbG8sIEhhYnIhIn0.FAMoE435ZafgdICuc6181RsEuR5V1J7dJkzhZRWQk1Y"
            }
        """.trimIndent()

    }
}