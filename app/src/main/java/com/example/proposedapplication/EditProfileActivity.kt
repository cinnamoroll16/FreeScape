package com.example.proposedapplication

import android.app.Activity
import android.os.Bundle
import android.widget.Toast
import com.example.proposedapplication.api.RetrofitClient
import com.example.proposedapplication.model.ApiResponse
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EditProfileActivity : Activity() {

    private lateinit var firstnameInput: TextInputEditText
    private lateinit var lastnameInput: TextInputEditText
    private lateinit var emailInput: TextInputEditText
    private lateinit var passwordInput: TextInputEditText
    private lateinit var btnUpdate: MaterialButton

    private var userId: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)

        // UI initialization
        firstnameInput = findViewById(R.id.editFirstname)
        lastnameInput = findViewById(R.id.editLastname)
        emailInput = findViewById(R.id.editEmail)
        passwordInput = findViewById(R.id.editPassword)
        btnUpdate = findViewById(R.id.save_button)

        // Get USER_ID from SharedPreferences
        userId = getSharedPreferences("UserSession", MODE_PRIVATE).getString("USER_ID", null)

        if (userId == null) {
            Toast.makeText(this, "User not logged in", Toast.LENGTH_SHORT).show()
            finish()
            return
        }

        // Fetch user info
        fetchUserProfile()

        // Update logic
        btnUpdate.setOnClickListener {
            val updatedUser = User(
                _id = userId!!,
                firstname = firstnameInput.text.toString().trim(),
                lastname = lastnameInput.text.toString().trim(),
                email = emailInput.text.toString().trim(),
                password = passwordInput.text.toString().trim()
            )
            updateUserProfile(updatedUser)
        }
    }

    private fun fetchUserProfile() {
        RetrofitClient.apiService.getUser(userId!!).enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                if (response.isSuccessful) {
                    val user = response.body()
                    user?.let {
                        firstnameInput.setText(it.firstname)
                        lastnameInput.setText(it.lastname)
                        emailInput.setText(it.email)
                        passwordInput.setText(it.password) // ⚠️ Only use for demo/testing
                    }
                } else {
                    Toast.makeText(this@EditProfileActivity, "Failed to fetch profile", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                Toast.makeText(this@EditProfileActivity, "Error: ${t.localizedMessage}", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun updateUserProfile(user: User) {
        RetrofitClient.apiService.updateUser(user._id, user).enqueue(object : Callback<ApiResponse> {
            override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                if (response.isSuccessful && response.body()?.success == true) {
                    Toast.makeText(this@EditProfileActivity, "Profile updated successfully!", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this@EditProfileActivity, "Failed to update", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                Toast.makeText(this@EditProfileActivity, "Error: ${t.localizedMessage}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
