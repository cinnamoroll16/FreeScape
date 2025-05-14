package com.example.proposedapplication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.proposedapplication.api.RetrofitClient
import com.example.proposedapplication.model.RegisterRequest
import com.example.proposedapplication.model.RegisterResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewRegisterActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_register)

        val registerButton = findViewById<Button>(R.id.btn_register)

        registerButton.setOnClickListener {
            val firstname = findViewById<EditText>(R.id.et_firstname).text.toString().trim()
            val lastname = findViewById<EditText>(R.id.et_lastname).text.toString().trim()
            val email = findViewById<EditText>(R.id.et_email).text.toString().trim()
            val password = findViewById<EditText>(R.id.et_password).text.toString().trim()
            val btnLogin = findViewById<TextView>(R.id.btn_login)

            btnLogin.setOnClickListener {
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            }

            if (firstname.isEmpty() || lastname.isEmpty() || email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val request = RegisterRequest(firstname, lastname, email, password)

            RetrofitClient.apiService.registerUser(request).enqueue(object : Callback<RegisterResponse> {
                override fun onResponse(call: Call<RegisterResponse>, response: Response<RegisterResponse>) {
                    if (response.isSuccessful) {
                        Toast.makeText(
                            this@NewRegisterActivity,
                            response.body()?.message ?: "Registration successful",
                            Toast.LENGTH_LONG
                        ).show()
                    } else {
                        Toast.makeText(
                            this@NewRegisterActivity,
                            "Registration failed: ${response.code()}",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }

                override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                    Toast.makeText(
                        this@NewRegisterActivity,
                        "Network error: ${t.localizedMessage}",
                        Toast.LENGTH_LONG
                    ).show()
                }
            })
        }
    }
}
