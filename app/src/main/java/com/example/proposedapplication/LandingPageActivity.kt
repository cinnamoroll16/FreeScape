package com.example.proposedapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class LandingPageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("LandingPage", "onCreate triggered")
        setContentView(R.layout.activity_landing_page)

        val getStartedButton = findViewById<MaterialButton>(R.id.getStartedButton)
        getStartedButton.setOnClickListener {
            Log.d("LandingPage", "Button clicked")
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}

