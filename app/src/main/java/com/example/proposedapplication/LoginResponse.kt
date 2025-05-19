package com.example.proposedapplication.model

import com.example.proposedapplication.User

data class LoginResponse(
    val success: Boolean,
    val message: String,
    val user: User  // This includes the _id, firstname, lastname, email, etc.
)

