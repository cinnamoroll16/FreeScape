package com.example.proposedapplication.model

import com.example.proposedapplication.Client

data class MatchRequest(
    val creationDetails: CreationDetails,
    val client: Client
)
data class GenericResponse(val message: String)
