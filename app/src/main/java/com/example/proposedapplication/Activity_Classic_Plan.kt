package com.example.proposedapplication

import android.app.Activity
import android.os.Bundle
import android.widget.ImageView

class Activity_Classic_Plan : Activity() {
    private lateinit var backArrow: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_classic_plans)
        // Initialize views
        backArrow = this.findViewById(R.id.backArrow)

        // Back button behavior
        backArrow.setOnClickListener {
            finish() // Close activity
        }
    }
}