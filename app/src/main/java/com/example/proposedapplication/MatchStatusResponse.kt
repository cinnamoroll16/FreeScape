package com.example.proposedapplication

data class MatchStatusResponse(
    val paid: Boolean,
    val paymentDetails: Map<String, Any>? = null  // or make it a generic Map
)
