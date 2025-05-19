package com.example.proposedapplication

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import com.example.proposedapplication.api.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Activity_Premium_Plan : Activity() {

    private lateinit var backArrow: ImageView
    private lateinit var subscribedButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_premium_plan)

        backArrow = findViewById(R.id.backArrow)
        subscribedButton = findViewById(R.id.subscribedButton)

        val alreadySubscribed = false // Simulate subscription status

        // Back button logic
        backArrow.setOnClickListener {
            finish()
        }

        if (alreadySubscribed) {
            subscribedButton.isEnabled = false
            subscribedButton.text = "Subscribed"
        } else {
            subscribedButton.setOnClickListener {
                // Replace with actual user ID from login session
                val userId = "1234567890"
                val request = GCashRequest(userId = userId, amount = 350.0)

                // Start payment process using Retrofit
                RetrofitClient.instance.createPayment(request)
                    .enqueue(object : Callback<GCashResponse> {
                        override fun onResponse(call: Call<GCashResponse>, response: Response<GCashResponse>) {
                            if (response.isSuccessful && response.body() != null) {
                                val checkoutUrl = response.body()!!.checkout_url
                                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(checkoutUrl))
                                startActivity(intent)
                            } else {
                                Toast.makeText(this@Activity_Premium_Plan, "Payment request failed", Toast.LENGTH_SHORT).show()
                            }
                        }

                        override fun onFailure(call: Call<GCashResponse>, t: Throwable) {
                            Toast.makeText(this@Activity_Premium_Plan, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
                        }
                    })
            }
        }
    }
}
