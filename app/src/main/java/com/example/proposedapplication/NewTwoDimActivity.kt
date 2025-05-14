package com.example.proposedapplication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import com.google.android.material.tabs.TabLayout

class NewTwoDimActivity : Activity() {

    private lateinit var backButton: ImageView
    private lateinit var undoButton: ImageView
    private lateinit var redoButton: ImageView
    private lateinit var aboutButton: ImageView
    private lateinit var confirmButton: Button
    private lateinit var tabLayout: TabLayout
    private lateinit var btn2D: Button
    private lateinit var btnVIR: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_two_dim)

        backButton = findViewById(R.id.btnBack)
        undoButton = findViewById(R.id.btnUndo)
        redoButton = findViewById(R.id.btnRedo)
        aboutButton = findViewById(R.id.btnAbout)
        confirmButton = findViewById(R.id.btnConfirm)
        tabLayout = findViewById(R.id.bottomTabs)
        btn2D = findViewById(R.id.btn2D)
        btnVIR = findViewById(R.id.btnVIR)

        backButton.setOnClickListener {
            startActivity(Intent(this, NewDashboardActivity::class.java))
            finish()
        }

        aboutButton.setOnClickListener {
            startActivity(Intent(this, NewCreationDetails::class.java))
        }

        confirmButton.setOnClickListener {
            startActivity(Intent(this, NewClientFinderActivity::class.java))
            finish()
        }

        btnVIR.setOnClickListener {
            val intent = Intent(this, NewVirtualActivity::class.java)
            Toast.makeText(this, "Virtual View Activated", Toast.LENGTH_SHORT).show()
            startActivity(intent)
        }

        btn2D.setOnClickListener {
            Toast.makeText(this, "Already in 2D View", Toast.LENGTH_SHORT).show()
        }

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                Toast.makeText(this@NewTwoDimActivity, "${tab?.text} selected", Toast.LENGTH_SHORT).show()
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })

    }
}