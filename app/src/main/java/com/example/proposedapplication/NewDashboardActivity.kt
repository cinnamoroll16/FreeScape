package com.example.proposedapplication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout

class NewDashboardActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_dashboard)

        // Initialize Creation button
        val creationButton = findViewById<ConstraintLayout>(R.id.creation_button)
        creationButton.setOnClickListener {
            val intent = Intent(this, NewCreationActivity::class.java)
            startActivity(intent)
        }

        // Initialize History button (currently commented out, can be re-enabled if needed)
        /*
        val historyButton = findViewById<ConstraintLayout>(R.id.history_button)
        historyButton.setOnClickListener {
            val intent = Intent(this, HistoryActivity::class.java)
            startActivity(intent)
        }
        */


        // Initialize Premium button (currently commented out, can be re-enabled if needed)
        /*
        val premiumButton = findViewById<ConstraintLayout>(R.id.premium_button)
        premiumButton.setOnClickListener {
            val intent = Intent(this, PremiumActivity::class.java)
            startActivity(intent)
        }
        */


        // Initialize Settings button
        val settingButton = findViewById<ConstraintLayout>(R.id.setting_button)
        settingButton.setOnClickListener {
            Toast.makeText(this, "Navigating to Settings...", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, SettingActivity::class.java)
            startActivity(intent)
        }
    }
}
