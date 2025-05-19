package com.example.proposedapplication

data class PaymentSessionResponse(
    val sessionId: String,
    val paymentUrl: String? // optional URL to redirect for payment
)

