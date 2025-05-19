package com.example.proposedapplication

import com.example.proposedapplication.GCashRequest
import com.example.proposedapplication.GCashResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface GCashApi {
    @POST("/api/gcash/create")
    fun createPayment(@Body request: GCashRequest): Call<GCashResponse>
}
