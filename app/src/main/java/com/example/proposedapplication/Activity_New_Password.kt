package com.example.proposedapplication

import android.os.Bundle
import android.util.Patterns
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import org.json.JSONObject

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

        // Send email button click listener
        findViewById<MaterialButton>(R.id.sendEmailButton).setOnClickListener {
            val email = findViewById<TextInputEditText>(R.id.emailEditText).text.toString()

            // Check if email is valid
            if (email.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                // Send email to the backend
                sendVerificationCodeToEmail(email)
            } else {
                // Show error for invalid email
                findViewById<TextInputLayout>(R.id.emailInputLayout).error = "Please enter a valid email"
            }
        }
    }

    private fun sendVerificationCodeToEmail(email: String) {
        // Prepare the JSON object with email data
        val jsonBody = JSONObject().apply {
            put("email", email)
        }

        val url = "http://10.0.2.2:3000/send-code"  // Use the emulator's IP (10.0.2.2) if testing locally on an emulator

        // Create a POST request using Volley
        val request = JsonObjectRequest(Request.Method.POST, url, jsonBody,
            Response.Listener { response ->
                // Handle successful response
                Toast.makeText(this, "Password reset code sent to $email", Toast.LENGTH_SHORT).show()
            },
            Response.ErrorListener { error ->
                // Handle error response
                Toast.makeText(this, "Failed to send code", Toast.LENGTH_SHORT).show()
            })

        // Add the request to the Volley request queue
        val queue = Volley.newRequestQueue(this)
        queue.add(request)
    }
}
