package com.example.proposedapplication

import android.content.Intent
import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class NewTutorialsActivity : AppCompatActivity() {

    private lateinit var webView1: WebView
    private lateinit var webView2: WebView
    private lateinit var backButton: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_tutorials)

        // ✅ Initialize views
        webView1 = findViewById(R.id.webView1)
        webView2 = findViewById(R.id.webView2)
        backButton = findViewById(R.id.backButton)

        // ✅ WebView 1 setup
        val webSettings1: WebSettings = webView1.settings
        webSettings1.javaScriptEnabled = true
        webView1.webViewClient = WebViewClient()
        webView1.loadUrl("https://www.youtube.com/watch?v=1sxR3Gv4I_k")

        // ✅ WebView 2 setup
        val webSettings2: WebSettings = webView2.settings
        webSettings2.javaScriptEnabled = true
        webView2.webViewClient = WebViewClient()
        webView2.loadUrl("https://www.youtube.com/watch?v=haRCpUOCG_M")

        // ✅ Back button click
        backButton.setOnClickListener {
            val intent = Intent(this, NewDashboardActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
