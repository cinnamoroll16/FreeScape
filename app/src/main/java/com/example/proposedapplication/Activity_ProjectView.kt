package com.example.proposedapplication

import android.app.Activity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class Activity_ProjectView : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_project_view)

        // 1. Back Button Functionality
        val btnBack = findViewById<ImageView>(R.id.btnBack)
        btnBack.setOnClickListener {
            finish() // Closes this activity
        }

        // 2. Get Data from Intent or Bundle (you can replace this with backend later)
        val projectData = intent.extras
        if (projectData != null) {
            findViewById<TextView>(R.id.tvYardLength).text = "Yard Length: ${projectData.getString("yardLength", "-")}"
            findViewById<TextView>(R.id.tvYardWidth).text = "Yard Width: ${projectData.getString("yardWidth", "-")}"
            findViewById<TextView>(R.id.tvSoilType).text = "Soil Type: ${projectData.getString("soilType", "-")}"
            findViewById<TextView>(R.id.tvFunction).text = "Function: ${projectData.getString("function", "-")}"
            findViewById<TextView>(R.id.tvStyle).text = "Style: ${projectData.getString("style", "-")}"
            findViewById<TextView>(R.id.tvPathType).text = "Path Type: ${projectData.getString("pathType", "-")}"
            findViewById<TextView>(R.id.tvBudgetRange).text = "Budget Range: ${projectData.getString("budgetRange", "-")}"
            findViewById<TextView>(R.id.tvMaintenance).text = "Maintenance: ${projectData.getString("maintenance", "-")}"
        }
    }
}
