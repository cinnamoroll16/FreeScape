package com.example.proposedapplication

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.proposedapplication.databinding.ActivityPremiumPlanBinding

class Activity_Premium_Plan : AppCompatActivity() {

    private lateinit var backArrow: ImageView
    private lateinit var subscribedButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_premium_plan)

        // Initialize views
        backArrow = findViewById(R.id.backArrow)
        subscribedButton = findViewById(R.id.subscribedButton)

        // Back button behavior
        backArrow.setOnClickListener {
            finish() // Close activity
        }

        // Simulated condition for already subscribed
        val alreadySubscribed = true

        // Update UI based on subscription status
        if (alreadySubscribed) {
            subscribedButton.isEnabled = false
            subscribedButton.text = "Subscribed"
        } else {
            subscribedButton.setOnClickListener {
                Toast.makeText(this, "Subscription activated!", Toast.LENGTH_SHORT).show()
                // Add real logic for enabling subscription here
            }
        }
    }
}
