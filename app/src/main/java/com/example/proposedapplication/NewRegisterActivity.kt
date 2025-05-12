package com.example.proposedapplication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class NewRegisterActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_register)

        val registerButton = findViewById<Button>(R.id.btn_register)

        registerButton.setOnClickListener {
            val firstname = findViewById<EditText>(R.id.et_firstname).text.toString()
            val lastname = findViewById<EditText>(R.id.et_lastname).text.toString()
            val email = findViewById<EditText>(R.id.et_email).text.toString()
            val password = findViewById<EditText>(R.id.et_password).text.toString()

            if (firstname.isEmpty() || lastname.isEmpty() || email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val fullName = "$firstname $lastname"
            val request = RegisterRequest(fullName, email, password)

            RetrofitClient.instance.registerUser(request)
                .enqueue(object : Callback<RegisterResponse> {
                    override fun onResponse(
                        call: Call<RegisterResponse>,
                        response: Response<RegisterResponse>
                    ) {
                        if (response.isSuccessful && response.body()?.success == true) {
                            Toast.makeText(this@NewRegisterActivity, "Registered successfully!", Toast.LENGTH_LONG).show()
                            // Optional: Go to login
                            startActivity(Intent(this@NewRegisterActivity, LoginActivity::class.java))
                        } else {
                            Toast.makeText(this@NewRegisterActivity, "Registration failed", Toast.LENGTH_LONG).show()
                        }
                    }

                    override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                        Toast.makeText(this@NewRegisterActivity, "Error: ${t.message}", Toast.LENGTH_LONG).show()
                    }
                })
        }

        val btnLogin = findViewById<TextView>(R.id.btn_login)
        btnLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "Register button clicked", Toast.LENGTH_SHORT).show()
        }

    }
}
