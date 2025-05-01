package com.example.proposedapplication

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface MongoAPI {
    @Headers(
        "Content-Type: application/json",
        "api-key: uuqmrbds"
    )
    @POST("action/insertOne")
    fun insertUser(@Body body: MongoRequest): Call<MongoResponse>
}
