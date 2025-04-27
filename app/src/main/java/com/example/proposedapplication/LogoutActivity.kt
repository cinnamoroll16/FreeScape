package com.example.proposedapplication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button

class LogoutActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logout)

        val logoutButton = findViewById<Button>(R.id.logout_button)
        val cancelButton = findViewById<Button>(R.id.cancel_button) // Find cancel button

        // Logout button navigates to LoginActivity
        logoutButton.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish() // Close LogoutActivity
        }

        // Cancel button navigates back to SettingActivity
        cancelButton.setOnClickListener {
            val intent = Intent(this, SettingActivity::class.java)
            startActivity(intent)
            finish() // Close LogoutActivity
        }
    }
}
