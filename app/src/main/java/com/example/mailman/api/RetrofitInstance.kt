package com.example.mailman.api

import com.example.mailman.util.Constants.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response


object RetrofitInstance {
    private val retrofit by lazy {
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(object : Interceptor {
            override fun intercept(chain: Interceptor.Chain): Response {
                // TODO: Figure out how to get bearer token
                val newRequest: Request = chain.request().newBuilder()
                    //.addHeader("Authorization", "Bearer $token")
                    .build()
                return chain.proceed(newRequest)
            }
        }).build()

        Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: GmailApi by lazy {
        retrofit.create(GmailApi::class.java)
    }
}