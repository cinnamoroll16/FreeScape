package com.example.proposedapplication
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface UserApi {
    @POST("/api/register")
    fun registerUser(@Body user: UserModel): Call<Void>

    @POST("/api/login")
    fun loginUser(@Body user: LoginModel): Call<Void>
}


