package com.enigmacamp.myfulldaggerapp.data.api.interceptor

import android.util.Log
import com.enigmacamp.myfulldaggerapp.data.SharedPref
import okhttp3.Interceptor
import okhttp3.Response

class AuthTokenInterceptor(private val sharedPref: SharedPref) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        Log.d("Interceptor", "intercept: ${originalRequest.url()}")
        if (!originalRequest.url().toString().contains("login")) {
            Log.d("Interceptor", "intercept:")
            val requestBuilder = originalRequest.newBuilder()
                .header("Authorization", sharedPref.retrived("token"))
            val request = requestBuilder.build()
            return chain.proceed(request)
        }
        return chain.proceed(originalRequest)
    }

}