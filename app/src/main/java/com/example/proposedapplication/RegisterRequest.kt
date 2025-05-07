package com.example.proposedapplication

data class RegisterRequest(
    val firstname: String,
    val lastname: String,
    val email: String,
    val password: String
)

data class ApiResponse(
    val message: String
)
