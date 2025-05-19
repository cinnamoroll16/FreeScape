package com.example.proposedapplication

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.proposedapplication.R
import com.example.proposedapplication.api.RetrofitClient
import com.example.proposedapplication.model.ApiResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DeactiveActivity : Activity() {

    private lateinit var userId: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_deactivate_account)

        val btnProceed = findViewById<Button>(R.id.btn_proceed)
        val btnCancel = findViewById<Button>(R.id.btn_cancel)

        userId = intent.getStringExtra("USER_ID") ?: ""

        btnProceed.setOnClickListener {
            if (userId.isNotEmpty()) {
                deactivateUser(userId)
            } else {
                Toast.makeText(this, "Missing user ID", Toast.LENGTH_SHORT).show()
            }
        }

        btnCancel.setOnClickListener {
            finish()
        }
    }

    private fun deactivateUser(userId: String) {
        RetrofitClient.apiService.deleteUser(userId).enqueue(object : Callback<ApiResponse> {
            override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                if (response.isSuccessful && response.body()?.success == true) {
                    Toast.makeText(this@DeactiveActivity, "Account deleted", Toast.LENGTH_LONG).show()
                    finish()
                } else {
                    Toast.makeText(this@DeactiveActivity, "Failed to delete", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                Toast.makeText(this@DeactiveActivity, "Error: ${t.localizedMessage}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}

