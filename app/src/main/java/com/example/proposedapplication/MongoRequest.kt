package com.example.proposedapplication

data class MongoRequest(
    val dataSource: String = "MyCluster", // Check your exact cluster name
    val database: String = "userdb",
    val collection: String = "users",
    val document: User
)
