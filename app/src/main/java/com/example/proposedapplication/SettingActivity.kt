package com.example.proposedapplication

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast

class SettingActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)

        val logoutButton = findViewById<Button>(R.id.logout_button)
        val devButton = findViewById<LinearLayout>(R.id.dev_button)
        val userProfileButton = findViewById<LinearLayout>(R.id.userprofile) // Find user profile button
        val goBackImageView = findViewById<ImageView>(R.id.goback)

        // Set onClickListener for the go back ImageView
        goBackImageView.setOnClickListener {
            // Start NewDashboardActivity when the ImageView is clicked
            val intent = Intent(this, NewDashboardActivity::class.java)
            startActivity(intent)
            // Optional: finish current activity if you want to remove it from the back stack
            finish()
        }

        // User Profile button click event
        userProfileButton.setOnClickListener {
            Toast.makeText(this, "Opening User Profile...", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, UserProfileActivity::class.java)
            startActivity(intent)
        }

        // TODO: Notification button click event

        // Dev button click event
        devButton.setOnClickListener {
            Toast.makeText(this, "Opening Developer Options...", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, NewDeveloper1::class.java)
            startActivity(intent)
        }
        //country
        val countrybutton = findViewById<LinearLayout>(R.id.country)
        countrybutton.setOnClickListener {
            Toast.makeText(this, "Opening Country Options...", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, CountryActivity::class.java)
            startActivity(intent)
        }
        // Set the click listener for the privacy
        val privacyLayout = findViewById<LinearLayout>(R.id.privacy)
        privacyLayout.setOnClickListener {
            Toast.makeText(this, "Opening Privacy Policy...", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, PrivacyActivity::class.java)
            startActivity(intent)
        }
        // Set the click listener for the preferences
        val preferencesLayout = findViewById<LinearLayout>(R.id.preferences)
        preferencesLayout.setOnClickListener {
            Toast.makeText(this, "Opening Privacy Preferences...", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, PreferencesActivity::class.java)
            startActivity(intent)
        }


        // Set the click listener for the subscription
        val subscriptionLayout = findViewById<LinearLayout>(R.id.subscription)
        subscriptionLayout.setOnClickListener {
            Toast.makeText(this, "Opening Premium Plans...", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, Activity_Classic_Plan::class.java)
            startActivity(intent)
        }

        // Set the click listener for the terms
        val termsLayout = findViewById<LinearLayout>(R.id.terms)
        termsLayout.setOnClickListener {
            Toast.makeText(this, "Opening Terms of Service...", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, Activity_Terms_of_Service::class.java)
            startActivity(intent)
        }

        // Set the click listener for the about section
        val aboutLayout = findViewById<LinearLayout>(R.id.about)
        aboutLayout.setOnClickListener {
            Toast.makeText(this, "Opening About Page...", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, AboutActivity::class.java)
            startActivity(intent)
        }

        // Set the click listener for the logout button
        logoutButton.setOnClickListener {
            showLogoutOverlay()
        }
    }
    private fun showLogoutOverlay() {
        // Create a Dialog with custom layout
        val builder = AlertDialog.Builder(this)
        val inflater = layoutInflater
        val dialogView = inflater.inflate(R.layout.activity_logout, null)
        builder.setView(dialogView)

        val logoutButton = dialogView.findViewById<Button>(R.id.logout_button)
        val cancelButton = dialogView.findViewById<Button>(R.id.cancel_button)

        // Set up the Logout button action
        logoutButton.setOnClickListener {
            // Handle the Logout Action
            handleLogout()
        }

        // Set up the Cancel button action
        cancelButton.setOnClickListener {
            // Dismiss the dialog (overlay)
            dismissLogoutOverlay()
        }

        // Create and show the dialog
        val dialog = builder.create()
        dialog.setCancelable(false) // Prevent dismissal on outside touch

        // Center the dialog in the screen
        dialog.window?.setLayout(
            LinearLayout.LayoutParams.MATCH_PARENT,   // Set the width to match parent
            LinearLayout.LayoutParams.WRAP_CONTENT   // Set the height to wrap content
        )
        dialog.window?.setGravity(Gravity.CENTER) // Set the dialog to be centered on the screen

        dialog.show()
    }

    private fun handleLogout() {
        // Handle logout logic here, e.g., clear session or go to login screen
        // For demonstration, we're just showing a toast
        Toast.makeText(this, "Logged out successfully", Toast.LENGTH_SHORT).show()
        // Redirect to LoginActivity
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun dismissLogoutOverlay() {
        // This dismisses the overlay
        val dialog = (getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater)
        dialog.inflate(R.layout.activity_logout, null)?.rootView?.findViewById<Button>(R.id.cancel_button)?.performClick()
    }
}
