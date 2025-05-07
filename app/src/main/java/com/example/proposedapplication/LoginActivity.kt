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
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class LoginActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val editTextEmail = findViewById<EditText>(R.id.email)
        val editTextPassword = findViewById<EditText>(R.id.password)
        val loginButton = findViewById<Button>(R.id.login_button)
        val btnRegister = findViewById<TextView>(R.id.btn_register)
        val forgotPasswordText = findViewById<TextView>(R.id.forgot_password)

        // Underline Forgot Password text
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

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Email and Password cannot be empty!", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            // 🔽 Call login function here
            loginUser(email, password)
        }
    }

    private fun loginUser(email: String, password: String) {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://your-api-url.com/") // Replace with your real backend URL
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(UserApi::class.java)
        val user = LoginModel(email, password)

        api.loginUser(user).enqueue(object : Callback<Void> {
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                if (response.isSuccessful) {
                    Toast.makeText(this@LoginActivity, "Login successful!", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this@LoginActivity, NewDashboardActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    Toast.makeText(this@LoginActivity, "Invalid credentials", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                Toast.makeText(this@LoginActivity, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
