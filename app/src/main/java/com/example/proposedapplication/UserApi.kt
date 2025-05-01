package com.example.proposedapplication
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface UserApi {
    @POST("register") // Example path, update it based on your backend
    fun registerUser(@Body user: UserModel): Call<Void>
}
data class UserModel(
    val firstname: String,
    val lastname: String,
    val email: String,
    val password: String
)

