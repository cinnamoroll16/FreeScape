package com.example.proposedapplication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView


class NewRegisterActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_register)
        // Inside your Activity or Fragment

        val registerButton = findViewById<Button>(R.id.btn_register)

        registerButton.setOnClickListener(View.OnClickListener {
            val etFirstname = findViewById<EditText>(R.id.et_firstname)
            val etLastname = findViewById<EditText>(R.id.et_lastname)
            val etEmail = findViewById<EditText>(R.id.et_email)
            val etPassword = findViewById<EditText>(R.id.et_password)
            // please add re type password
            // val etRepassword = findViewById<EditText>(R.id.et_repassword)

            // Check if any field is empty
            if (etFirstname.text.toString().trim { it <= ' ' }.isEmpty()) {
                etFirstname.error = "First name is required"
                return@OnClickListener
            }
            if (etLastname.text.toString().trim { it <= ' ' }.isEmpty()) {
                etLastname.error = "Last name is required"
                return@OnClickListener
            }
            if (etEmail.text.toString().trim { it <= ' ' }.isEmpty()) {
                etEmail.error = "Email is required"
                return@OnClickListener
            }
            if (etPassword.text.toString().trim { it <= ' ' }.isEmpty()) {
                etPassword.error = "Password is required"
                return@OnClickListener
            }
            //if (etRepassword.text.toString().trim { it <= ' ' }.isEmpty()) {
            //    etRepassword.error = "Please confirm your password"
            //    return@OnClickListener
            //}

            // You can add further validation logic here (e.g., password matching)

            // Proceed with registration if all fields are valid
            // For example, call a method to submit the form
        })

        val btnLogin = findViewById<TextView>(R.id.btn_login)
        btnLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

    }
}