package com.example.proposedapplication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import com.google.android.material.tabs.TabLayout

class NewVirtualActivity : Activity() {
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
        setContentView(R.layout.activity_new_virtual)

        backButton = findViewById(R.id.btnBack)
        undoButton = findViewById(R.id.btnUndo)
        redoButton = findViewById(R.id.btnRedo)
        aboutButton = findViewById(R.id.btnAbout) // Renamed from btnDownload
        confirmButton = findViewById(R.id.btnConfirm)
        tabLayout = findViewById(R.id.bottomTabs)
        btn2D = findViewById(R.id.btn2D)
        btnVIR = findViewById(R.id.btnVIR)

        // Navigation: Back to NewDashboardActivity
        backButton.setOnClickListener {
            val intent = Intent(this, NewDashboardActivity::class.java)
            startActivity(intent)
            finish() // Optional: remove this if you want to return via back stack
        }

        // Navigation: Go to NewCreationDetailsActivity
        aboutButton.setOnClickListener {
            val intent = Intent(this, NewCreationDetails::class.java)
            startActivity(intent)
        }

        // Other button functionality
        undoButton.setOnClickListener {
            Toast.makeText(this, "Undo clicked", Toast.LENGTH_SHORT).show()
        }

        redoButton.setOnClickListener {
            Toast.makeText(this, "Redo clicked", Toast.LENGTH_SHORT).show()
        }

        confirmButton.setOnClickListener {
            val intent = Intent(this, NewClientFinderActivity::class.java)
            startActivity(intent)
        }


        // Tab clicks
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                Toast.makeText(this@NewVirtualActivity, "${tab?.text} selected", Toast.LENGTH_SHORT).show()
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })

        btn2D.setOnClickListener {
            val intent = Intent(this, NewTwoDimActivity::class.java)
            Toast.makeText(this, "2D View Activated", Toast.LENGTH_SHORT).show()
            startActivity(intent)
        }

        btnVIR.setOnClickListener {
            Toast.makeText(this, "Alread in Virtual View", Toast.LENGTH_SHORT).show()
        }
    }
}