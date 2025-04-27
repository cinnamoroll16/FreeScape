package com.example.proposedapplication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.SpannableString
import android.text.style.UnderlineSpan
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast


class LoginActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val editTextEmail = findViewById<EditText>(R.id.email)
        val editTextPassword = findViewById<EditText>(R.id.password)
        val loginButton = findViewById<Button>(R.id.login_button)
        val btnRegister = findViewById<TextView>(R.id.btn_register) // Move this outside loginButton click listener
        val forgotPasswordText = findViewById<TextView>(R.id.forgot_password)

        // Set up Forgot Password text to be underlined
        val spannableString = SpannableString(forgotPasswordText.text)
        spannableString.setSpan(UnderlineSpan(), 0, spannableString.length, 0)
        forgotPasswordText.text = spannableString

        // Register button logic
        btnRegister.setOnClickListener {
            val intent = Intent(this, NewRegisterActivity::class.java)
            startActivity(intent)
        }

        // Login button logic
        loginButton.setOnClickListener {
            val email = editTextEmail.text.toString().trim()
            val password = editTextPassword.text.toString().trim()

            // Validation Check
            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Email and Password cannot be empty!", Toast.LENGTH_LONG).show()
                return@setOnClickListener // Stop further execution
            }

            // Proceed to Dashboard
            Log.e("Android Tutorial", "Button is Clicked!")
            Toast.makeText(this, "Opening the Dashboard Screen!", Toast.LENGTH_LONG).show()

            val intent = Intent(this, NewDashboardActivity::class.java)
            startActivity(intent)
        }
    }

    //https://developer.android.com/identity/sign-in/credential-manager-siwg
}