package com.example.proposedapplication

import android.app.Activity
import android.os.Bundle
import android.widget.ImageView
class AboutActivity: Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)  // Your provided layout file

        // Back button closes the activity
        val backButton = findViewById<ImageView>(R.id.backButton)
        backButton.setOnClickListener {
            finish()
        }
    }
}