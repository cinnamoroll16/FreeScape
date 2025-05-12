package com.example.proposedapplication

// RegisterRequest.kt
data class RegisterRequest(
    val name: String,
    val email: String,
    val password: String // optional, if you're saving it
)



