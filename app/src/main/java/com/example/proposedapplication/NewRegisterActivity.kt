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
            val etFirstname = findViewById<EditText>(R.id.et_firstname)
            val etLastname = findViewById<EditText>(R.id.et_lastname)
            val etEmail = findViewById<EditText>(R.id.et_email)
            val etPassword = findViewById<EditText>(R.id.et_password)

            val firstname = etFirstname.text.toString()
            val lastname = etLastname.text.toString()
            val email = etEmail.text.toString()
            val password = etPassword.text.toString()

            if (firstname.isEmpty() || lastname.isEmpty() || email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Create Retrofit instance
            val retrofit = Retrofit.Builder()
                .baseUrl("http://10.0.2.2:3000/")  // Localhost for emulator or your server's IP for a real device
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            val apiService = retrofit.create(ApiService::class.java)

            val request = RegisterRequest(firstname, lastname, email, password)

            // Call the register endpoint
            apiService.registerUser(request).enqueue(object : Callback<ApiResponse> {
                override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                    if (response.isSuccessful) {
                        Toast.makeText(this@NewRegisterActivity, "Registration Successful", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this@NewRegisterActivity, "Error: ${response.message()}", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                    Toast.makeText(this@NewRegisterActivity, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
                }
            })

        }



        val btnLogin = findViewById<TextView>(R.id.btn_login)
        btnLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

    }


}
