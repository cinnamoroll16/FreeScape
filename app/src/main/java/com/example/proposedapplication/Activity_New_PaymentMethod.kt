package com.example.proposedapplication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.proposedapplication.api.RetrofitClient
import com.google.android.material.button.MaterialButton
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Activity_New_PaymentMethod : Activity() {

    private lateinit var backArrow: ImageView
    private lateinit var planTitle: TextView
    private lateinit var planSub: TextView
    private lateinit var termsButton: MaterialButton
    private lateinit var btnContinue: MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_payment_method)

        // Bind views
        backArrow = findViewById(R.id.backArrow)
        planTitle = findViewById(R.id.planTitle)
        planSub = findViewById(R.id.planSub)
        termsButton = findViewById(R.id.termsButton)
        btnContinue = findViewById(R.id.btnContinue)

        // Back button
        backArrow.setOnClickListener {
            finish()
        }

        // Set plan name and cost from intent extras
        planTitle.text = intent.getStringExtra("PLAN_NAME") ?: "Premium Individual"
        planSub.text = intent.getStringExtra("PLAN_COST") ?: "₱79.00 · For 2 months"

        // Open Terms of Service
        termsButton.setOnClickListener {
            startActivity(Intent(this, Activity_Terms_of_Service::class.java))
        }

        // Continue with payment
        btnContinue.setOnClickListener {
            val matchId = intent.getStringExtra("MATCH_ID") ?: ""
            if (matchId.isEmpty()) {
                Toast.makeText(this, "Match ID is missing", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // 🔧 Prepare payload as required by your backend
            val payload = mapOf("matchId" to matchId)

            RetrofitClient.apiService.createFreeScapePaymentSession(payload).enqueue(object : Callback<PaymentSessionResponse> {
                override fun onResponse(call: Call<PaymentSessionResponse>, response: Response<PaymentSessionResponse>) {
                    if (response.isSuccessful && response.body() != null) {
                        val paymentUrl = response.body()!!.paymentUrl
                        Toast.makeText(this@Activity_New_PaymentMethod, "Payment session created", Toast.LENGTH_SHORT).show()

                        // Optional: launch a WebView or browser with paymentUrl
                        val intent = Intent(this@Activity_New_PaymentMethod, PaymentWebViewActivity::class.java)
                        intent.putExtra("PAYMENT_URL", paymentUrl)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this@Activity_New_PaymentMethod, "Failed to create session", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<PaymentSessionResponse>, t: Throwable) {
                    Toast.makeText(this@Activity_New_PaymentMethod, "Network error: ${t.localizedMessage}", Toast.LENGTH_SHORT).show()
                }
            })
        }
    }
}
