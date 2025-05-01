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

            // 🔽 Call the saving function
            saveUserToDatabase(firstname, lastname, email, password)
        }

        val btnLogin = findViewById<TextView>(R.id.btn_login)
        btnLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }

    private fun saveUserToDatabase(firstname: String, lastname: String, email: String, password: String) {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://your-api-url.com/") // Replace with your working Node.js backend URL
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(UserApi::class.java)

        val user = UserModel(firstname, lastname, email, password)

        val call = api.registerUser(user)
        call.enqueue(object : Callback<Void> {
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                if (response.isSuccessful) {
                    Toast.makeText(this@NewRegisterActivity, "User registered successfully", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this@NewRegisterActivity, "Registration failed", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                Toast.makeText(this@NewRegisterActivity, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
