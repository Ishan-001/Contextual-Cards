package com.fampay.contextualcards.api

import com.fampay.contextualcards.api.model.ApiResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("04a04703-5557-4c84-a127-8c55335bb3b4")
    suspend fun getCards() : Response<ApiResponse>
}