package com.example.proposedapplication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast

class UserProfileActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_profile) // Your actual layout file name

        // Back button: close this activity
        val backButton = findViewById<ImageView>(R.id.back_button)
        backButton.setOnClickListener {
            finish()
        }

        // Profile info views (optional dynamic loading)
        val profileName = findViewById<TextView>(R.id.profile_name)
        val profileEmail = findViewById<TextView>(R.id.profile_email)
        val profileImage = findViewById<ImageView>(R.id.profile_image)
        // TODO: Load actual user info into these views

        // Edit Profile menu item
        val editProfileLayout = findViewById<LinearLayout>(R.id.editprofile)
        editProfileLayout.setOnClickListener {
            Toast.makeText(this, "Edit Profile clicked", Toast.LENGTH_SHORT).show()
            safeStartActivity(EditProfileActivity::class.java)
        }

        // Subscription menu item
        val subscriptionLayout = findViewById<LinearLayout>(R.id.subscription)
        subscriptionLayout.setOnClickListener {
            Toast.makeText(this, "Subscription clicked", Toast.LENGTH_SHORT).show()
            safeStartActivity(Activity_Premium_Plan::class.java)
        }

        // Deactivate Account menu item
        val deactivateLayout = findViewById<LinearLayout>(R.id.deactive)
        deactivateLayout.setOnClickListener {
            Toast.makeText(this, "Deactivate Account clicked", Toast.LENGTH_SHORT).show()
            // Instead of showing alert dialog, navigate to DeactiveActivity
            val intent = Intent(this, DeactiveActivity::class.java)
            startActivity(intent)
        }
    }

    // Helper method to safely start activities
    private fun safeStartActivity(activityClass: Class<*>) {
        try {
            val intent = Intent(this, activityClass)
            startActivity(intent)
        } catch (e: Exception) {
            Toast.makeText(this, "Cannot open activity", Toast.LENGTH_SHORT).show()
            e.printStackTrace()
        }
    }

    /*
    private fun showDeactivateConfirmationDialog() {
        AlertDialog.Builder(this)
            .setTitle("Deactivate Account")
            .setMessage("Are you sure you want to deactivate your account?")
            .setPositiveButton("Yes") { dialog, _ ->
                dialog.dismiss()
                Toast.makeText(this, "Account deactivated", Toast.LENGTH_SHORT).show()
                // TODO: Implement deactivation logic here (API call, logout, etc.)
            }
            .setNegativeButton("Cancel") { dialog, _ ->
                dialog.dismiss()
            }
            .show()
    }
     */
}
