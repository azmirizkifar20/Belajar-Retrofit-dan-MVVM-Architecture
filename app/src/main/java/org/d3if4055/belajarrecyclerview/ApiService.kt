package org.d3if4055.belajarrecyclerview

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

const val BASE_URL = "https://us-central1-rizkifar-project.cloudfunctions.net/api/"

val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

// API Data
interface ApiService {
    @GET("countries")
    suspend fun showList(): List<Negara>
}

object ApiNegara {
    val retrofitService = retrofit.create(ApiService::class.java)
}