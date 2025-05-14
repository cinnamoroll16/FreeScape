package com.example.proposedapplication.model

// RegisterRequest.kt
data class RegisterRequest(
    val firstname: String,
    val lastname: String,
    val email: String,
    val password: String
)

data class RegisterResponse(
    val message: String
)




