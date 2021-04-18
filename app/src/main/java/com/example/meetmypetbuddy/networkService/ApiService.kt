package com.example.meetmypetbuddy.networkService

import com.example.meetmypetbuddy.models.Review
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://mmpb-api.herokuapp.com/"

private fun getHttpClient(): OkHttpClient {
    val logging = HttpLoggingInterceptor()
    logging.level = HttpLoggingInterceptor.Level.BODY
    val httpClient = OkHttpClient.Builder()
    httpClient.addInterceptor(logging)
    return httpClient.build()
}

private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

private val retrofit = Retrofit.Builder().addConverterFactory(MoshiConverterFactory.create(moshi)).baseUrl(BASE_URL).client(
    getHttpClient()).build()

interface ApiService {
    @GET("/review/api/reviews")
    suspend fun getReviews(): Response<List<Review>>
}

object ReviewApi {
    val retrofitService : ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}