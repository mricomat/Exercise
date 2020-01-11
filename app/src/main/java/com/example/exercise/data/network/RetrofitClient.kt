package com.example.exercise.data.network

import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Initialize Retrofit Client
 */
class RetrofitClient {

    companion object {
        private const val BASE_URL = "https://api.myjson.com/bins/"

        private var retrofit: Retrofit? = null

        val client: Retrofit
            get() {
                if (retrofit == null) {
                    retrofit = Retrofit.Builder()
                        .addConverterFactory(
                            GsonConverterFactory.create(
                                GsonBuilder()
                                    .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                                    .create()
                            )
                        )
                        .baseUrl(BASE_URL)
                        .callFactory(
                            OkHttpClient.Builder()
                                .build()
                        )
                        .build()
                }
                return retrofit!!
            }
    }
}