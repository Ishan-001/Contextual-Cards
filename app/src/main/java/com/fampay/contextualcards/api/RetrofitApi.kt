package com.fampay.contextualcards.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitApi {
    private const val BASE_URL = " https://run.mocky.io/v3/"

    private fun retrofit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
    }

    val service: ApiService by lazy {
        retrofit().create(ApiService::class.java)
    }
}

