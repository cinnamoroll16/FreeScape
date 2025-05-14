package com.example.proposedapplication

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat

class Activity_Terms_of_Service : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_terms_of_service)

        // Enable edge-to-edge content (optional, adjusts system bars)
        enableEdgeToEdge()

        // Setup back button click
        val backButton = findViewById<ImageView>(R.id.backButton)
        backButton.setOnClickListener {
            finish()
        }
    }

    private fun enableEdgeToEdge() {
        // Let the content draw behind system bars
        WindowInsetsControllerCompat(window, window.decorView).let { controller ->
            controller.isAppearanceLightStatusBars = false // Change as needed
            controller.isAppearanceLightNavigationBars = false // Change as needed
        }
        ViewCompat.setOnApplyWindowInsetsListener(window.decorView) { view, insets ->
            val systemBarsInsets = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(0, systemBarsInsets.top, 0, systemBarsInsets.bottom)
            WindowInsetsCompat.CONSUMED
        }
    }
}
