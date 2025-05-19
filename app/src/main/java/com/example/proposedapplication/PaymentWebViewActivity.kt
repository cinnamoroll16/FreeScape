package com.example.proposedapplication

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import android.widget.Toast

class PaymentWebViewActivity : Activity() {

    private lateinit var webView: WebView
    private lateinit var progressBar: ProgressBar

    companion object {
        const val EXTRA_PAYMENT_URL = "payment_url"
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment_webview)

        webView = findViewById(R.id.paymentWebView)
        progressBar = findViewById(R.id.webviewProgress)

        val url = intent.getStringExtra(EXTRA_PAYMENT_URL)
        if (url.isNullOrEmpty()) {
            Toast.makeText(this, "Payment URL is missing", Toast.LENGTH_LONG).show()
            finish()
            return
        }

        webView.settings.javaScriptEnabled = true
        webView.webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView?, url: String?) {
                progressBar.visibility = View.GONE
                // Check for keywords in URL to detect payment status (customize this)
                if (url?.contains("success", ignoreCase = true) == true) {
                    Toast.makeText(this@PaymentWebViewActivity, "Payment Successful", Toast.LENGTH_SHORT).show()
                    finish()
                } else if (url?.contains("cancel", ignoreCase = true) == true) {
                    Toast.makeText(this@PaymentWebViewActivity, "Payment Cancelled", Toast.LENGTH_SHORT).show()
                    finish()
                }
            }
        }

        webView.webChromeClient = WebChromeClient()
        webView.loadUrl(url)
    }
}
