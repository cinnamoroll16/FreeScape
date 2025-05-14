package com.example.proposedapplication

import android.app.Activity
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Switch
import android.widget.Toast

class PreferencesActivity : Activity() {

    private lateinit var switchNotifications: Switch
    private lateinit var themeRadioGroup: RadioGroup
    private lateinit var radioLight: RadioButton
    private lateinit var radioDark: RadioButton
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preferences)

        // Back button - close activity
        val backButton = findViewById<ImageView>(R.id.backButton)
        backButton.setOnClickListener {
            finish()
        }

        sharedPreferences = getSharedPreferences("app_preferences", MODE_PRIVATE)

        switchNotifications = findViewById(R.id.switch_notifications)
        themeRadioGroup = findViewById(R.id.themeRadioGroup)
        radioLight = findViewById(R.id.radio_light)
        radioDark = findViewById(R.id.radio_dark)

        // Load saved preferences
        loadPreferences()

        // Save notification toggle changes
        switchNotifications.setOnCheckedChangeListener { _, isChecked ->
            sharedPreferences.edit().putBoolean("notifications_enabled", isChecked).apply()
            Toast.makeText(this, "Push Notifications " + if (isChecked) "Enabled" else "Disabled", Toast.LENGTH_SHORT).show()
        }

        // Save theme selection changes
        themeRadioGroup.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.radio_light -> {
                    sharedPreferences.edit().putString("theme_mode", "light").apply()
                    Toast.makeText(this, "Light Mode selected", Toast.LENGTH_SHORT).show()
                    // TODO: apply light theme if you implement runtime theme switching
                }
                R.id.radio_dark -> {
                    sharedPreferences.edit().putString("theme_mode", "dark").apply()
                    Toast.makeText(this, "Dark Mode selected", Toast.LENGTH_SHORT).show()
                    // TODO: apply dark theme if you implement runtime theme switching
                }
            }
        }
    }

    private fun loadPreferences() {
        val notificationsEnabled = sharedPreferences.getBoolean("notifications_enabled", true)
        switchNotifications.isChecked = notificationsEnabled

        val themeMode = sharedPreferences.getString("theme_mode", "light")
        if (themeMode == "dark") {
            radioDark.isChecked = true
        } else {
            radioLight.isChecked = true
        }
    }
}
