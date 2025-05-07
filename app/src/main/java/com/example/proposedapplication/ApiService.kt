package com.example.proposedapplication

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("api/register")
    fun registerUser(@Body request: RegisterRequest): Call<ApiResponse>
}
