package com.example.proposedapplication

import android.app.Activity
import android.os.Bundle
import android.util.Patterns
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class Activity_New_Password : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password) // Your forgot password layout file name

        // Set click listener for back arrow
        findViewById<ImageView>(R.id.backArrow).setOnClickListener {
            finish() // Close this activity and return to login
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        }

        // Set click listener for login text at bottom
        findViewById<TextView>(R.id.loginText).setOnClickListener {
            finish() // Close this activity and return to login
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        }

        // You can add more logic here for the send email button
        findViewById<MaterialButton>(R.id.sendEmailButton).setOnClickListener {
            // Handle send email functionality here
            val email = findViewById<TextInputEditText>(R.id.emailEditText).text.toString()
            if (email.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                // Valid email - implement your password reset logic
                Toast.makeText(this, "Password reset email sent", Toast.LENGTH_SHORT).show()
            } else {
                findViewById<TextInputLayout>(R.id.emailInputLayout).error = "Please enter a valid email"
            }
        }
    }
}