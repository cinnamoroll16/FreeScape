package com.example.proposedapplication

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast

class UserProfileActivity : Activity() {
    // Declare views
    private lateinit var backArrow: ImageView
    private lateinit var profileName: TextView
    private lateinit var profileEmail: TextView

    private lateinit var editProfile: LinearLayout
    private lateinit var subscription: LinearLayout
    private lateinit var deactivateAccount: LinearLayout
    private lateinit var settings: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_profile)

        // Initialize views
        backArrow = findViewById(R.id.iv_backarrow)
        profileName = findViewById(R.id.profile_name)
        profileEmail = findViewById(R.id.profile_email)

        editProfile = findViewById(R.id.edit_profile)
        subscription = findViewById(R.id.subscription)
        deactivateAccount = findViewById(R.id.deactivate_account)
        settings = findViewById(R.id.settings)

        // Setup user data (can be dynamic from DB or SharedPreferences)
        profileName.text = "Adriana Lorenz"
        profileEmail.text = "adrianalorenz23@gmail.com"

        // Click Listeners
        backArrow.setOnClickListener {
            finish() // Navigate back
        }


        subscription.setOnClickListener {
            startActivity(Intent(this, Activity_New_Premium_Plan::class.java))
        }

        deactivateAccount.setOnClickListener {
            showDeactivateDialog()
        }

        settings.setOnClickListener {
            startActivity(Intent(this, SettingActivity::class.java))
        }
    }

    private fun showDeactivateDialog() {
        AlertDialog.Builder(this)
            .setTitle("Deactivate Account")
            .setMessage("Are you sure you want to deactivate your account?")
            .setPositiveButton("Yes") { dialog, _ ->
                // Logic for deactivation goes here
                Toast.makeText(this, "Account deactivated", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }
            .setNegativeButton("Cancel") { dialog, _ ->
                dialog.dismiss()
            }
            .show()
    }
}
