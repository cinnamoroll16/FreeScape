package com.example.proposedapplication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class ForgotPasswordActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        val backArrow = findViewById<ImageView>(R.id.backArrow)
        val sendEmailButton = findViewById<MaterialButton>(R.id.sendEmailButton)
        val emailEditText = findViewById<TextInputEditText>(R.id.emailEditText)
        val loginText = findViewById<TextView>(R.id.loginText)

        backArrow.setOnClickListener {
            finish() // Close the activity
        }

        sendEmailButton.setOnClickListener {
            val email = emailEditText.text?.toString()?.trim()

            if (email.isNullOrEmpty()) {
                Toast.makeText(this, "Please enter your email", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                Toast.makeText(this, "Please enter a valid email address", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Simulate sending the reset code (replace with actual logic)
            Toast.makeText(this, "Reset code sent to $email", Toast.LENGTH_LONG).show()

            // Optionally, navigate to a verification or reset password screen here
             startActivity(Intent(this, ForgotPasswordActivity::class.java))
        }

        loginText.setOnClickListener {
            // Navigate back to login screen (adjust class name if needed)
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
