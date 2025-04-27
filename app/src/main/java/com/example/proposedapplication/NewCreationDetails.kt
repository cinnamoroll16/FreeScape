package com.example.proposedapplication

import android.os.Bundle
import android.app.Activity
import android.content.Intent
import android.widget.Button
import android.widget.TextView

class NewCreationDetails : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_creation_details)

        val tvYardLength = findViewById<TextView>(R.id.tv_yardLength)
        val tvYardWidth = findViewById<TextView>(R.id.tv_yardWidth)
        val tvSoil = findViewById<TextView>(R.id.tv_soildisp)
        val tvFunction = findViewById<TextView>(R.id.tv_functiondisp)
        val tvStyle = findViewById<TextView>(R.id.tv_styledisp)
        val tvPathway = findViewById<TextView>(R.id.tv_pathdisp)
        val tvBudget = findViewById<TextView>(R.id.tv_budgetdisp)
        val tvMaintenance = findViewById<TextView>(R.id.tv_maintenancedisp)

        val length = intent.getStringExtra("LENGTH_DATA")
        val width = intent.getStringExtra("WIDTH_DATA")
        val soil = intent.getStringExtra("SOIL_DATA")
        val function = intent.getStringExtra("FUNCTION_DATA")
        val style = intent.getStringExtra("STYLE_DATA")
        val pathway = intent.getStringExtra("PATHWAY_DATA")
        val budget = intent.getStringExtra("BUDGET_DATA")
        val maintenance = intent.getStringExtra("MAINTENANCE_DATA")

        tvYardLength.text = "Yard Length: $length"
        tvYardWidth.text = "Yard Width: $width"
        tvSoil.text = "Soil Type: $soil"
        tvFunction.text = "Function: $function"
        tvStyle.text = "Style: $style"
        tvPathway.text = "Pathway Type: $pathway"
        tvBudget.text = "Budget: $budget"
        tvMaintenance.text = "Maintenance: $maintenance"
    }
}
