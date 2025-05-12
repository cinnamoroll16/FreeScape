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
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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

        forgotPasswordText.setOnClickListener {
            val intent = Intent(this, Activity_New_Password::class.java)
            startActivity(intent)
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        }

        // ✅ Login button logic (corrected)
        loginButton.setOnClickListener {
            val email = editTextEmail.text.toString().trim()
            val password = editTextPassword.text.toString().trim()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Email and Password cannot be empty!", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            val request = LoginRequest(email, password)

            RetrofitClient.instance.loginUser(request)
                .enqueue(object : Callback<LoginResponse> {
                    override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                        if (response.isSuccessful && response.body()?.success == true) {
                            val user = response.body()?.user
                            Toast.makeText(this@LoginActivity, "Welcome ${user?.name}", Toast.LENGTH_LONG).show()

                            val intent = Intent(this@LoginActivity, NewDashboardActivity::class.java)
                            startActivity(intent)
                            finish()
                        } else {
                            Toast.makeText(this@LoginActivity, "Invalid credentials", Toast.LENGTH_LONG).show()
                        }
                    }

                    override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                        Log.e("LOGIN_FAILURE", "Error: ${t.message}")
                        Toast.makeText(this@LoginActivity, "Login failed: ${t.message}", Toast.LENGTH_LONG).show()
                    }
                })
        }
    }
}
