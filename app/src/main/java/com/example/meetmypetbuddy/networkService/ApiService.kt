package com.example.meetmypetbuddy.networkService

import com.example.meetmypetbuddy.models.Appointment
import com.example.meetmypetbuddy.models.Message
import com.example.meetmypetbuddy.models.Pet
import com.example.meetmypetbuddy.models.Review
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.ResponseBody
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

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
    @GET("/appointments")
    suspend fun getAppointments(): Response<List<Appointment>>
    @GET("/appointments/{owner_name}")
    suspend fun getUserAppointments(@Path("owner_name") owner_name: String ): Response<List<Appointment>>
    @POST("/appointments")
    suspend fun placeAnAppointment(@Body requestBody: RequestBody): Response<ResponseBody>
    @POST("/review/api/reviews")
    suspend fun insertReview(@Body requestBody: RequestBody) : Response<ResponseBody>
    @POST("/msg/api/")
    suspend fun insertMessage(@Body requestBody: RequestBody) : Response<ResponseBody>
    @GET("/msg/api/msg/pet/{pet_name}")
    suspend fun getMessagePet(@Path("pet_name") pet_name: String): Response<List<Message>>
    @GET("/pets/")
    suspend fun getPets(): Response<List<Pet>>
    @POST("/pets/")
    suspend fun insertNewPet(@Body requestBody: RequestBody) : Response<ResponseBody>

}

object Api {
    val retrofitService : ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}
