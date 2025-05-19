package com.example.proposedapplication.api

import com.example.proposedapplication.MatchResponse
import com.example.proposedapplication.MatchStatusResponse
import com.example.proposedapplication.PaymentSessionResponse
import com.example.proposedapplication.User
import com.example.proposedapplication.model.ApiResponse
import com.example.proposedapplication.model.LoginRequest
import com.example.proposedapplication.model.LoginResponse
import com.example.proposedapplication.model.MatchRequest
import com.example.proposedapplication.model.RegisterRequest
import com.example.proposedapplication.model.RegisterResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface ApiService {

    @POST("register")
    fun registerUser(@Body request: RegisterRequest): Call<RegisterResponse>

    @POST("login")
    fun loginUser(@Body request: LoginRequest): Call<LoginResponse>

    @POST("match")
    fun saveMatch(@Body matchRequest: MatchRequest): Call<MatchResponse>

    @DELETE("users/{id}")
    fun deleteUser(@Path("id") userId: String): Call<ApiResponse>

    @GET("match/{matchId}/status")
    fun getMatchStatus(@Path("matchId") matchId: String): Call<MatchStatusResponse>

    @POST("freescape-payment")
    fun createFreeScapePaymentSession(@Body request: Map<String, String>): Call<PaymentSessionResponse>


    @GET("user/{id}")
    fun getUser(@Path("id") userId: String): Call<User>
    @PUT("user/{id}")
    fun updateUser(@Path("id") userId: String, @Body updatedUser: User): Call<ApiResponse>
}