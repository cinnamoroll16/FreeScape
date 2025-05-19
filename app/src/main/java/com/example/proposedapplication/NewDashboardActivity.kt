package com.example.proposedapplication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView

class NewDashboardActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_dashboard)



        findViewById<ImageView>(R.id.iv_creations).setOnClickListener {
            startActivity(Intent(this, NewCreationActivity::class.java))
        }

        findViewById<ImageView>(R.id.iv_history).setOnClickListener {
            startActivity(Intent(this, Activity_ProjectHistory::class.java))
        }

        findViewById<ImageView>(R.id.iv_tutorials).setOnClickListener {
            startActivity(Intent(this, NewTutorialsActivity::class.java))
        }

        findViewById<ImageView>(R.id.iv_client).setOnClickListener {
            startActivity(Intent(this, NewClientFinderActivity::class.java))
        }

        findViewById<ImageView>(R.id.iv_plans).setOnClickListener {
            startActivity(Intent(this, Activity_Premium_Plan::class.java))
        }

        findViewById<ImageView>(R.id.iv_settings).setOnClickListener {
            startActivity(Intent(this, SettingActivity::class.java))
        }
    }
}
