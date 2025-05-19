package com.example.proposedapplication

data class PaymentDetails(
    val transactionId: String? = null,
    val amount: Double? = null,
    val paymentMethod: String? = null,
    val status: String? = null
    // add more fields as needed
)

