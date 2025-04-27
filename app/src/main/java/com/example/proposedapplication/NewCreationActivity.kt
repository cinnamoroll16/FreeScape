package com.example.proposedapplication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class NewCreationActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_creation)

        val etLength = findViewById<TextView>(R.id.et_length)
        val etWidth = findViewById<TextView>(R.id.et_width)
        val etSoil = findViewById<TextView>(R.id.et_soil)
        val etFunction = findViewById<TextView>(R.id.et_func)
        val etStyle = findViewById<TextView>(R.id.et_style)
        val etPathway = findViewById<TextView>(R.id.et_pathway)
        val etBudget = findViewById<TextView>(R.id.et_budget)
        val etMaintenance = findViewById<TextView>(R.id.et_maintenance)
        val btnSubmit = findViewById<Button>(R.id.confirm_button)

        btnSubmit.setOnClickListener {
            val length = etLength.text.toString()
            val width = etWidth.text.toString()
            val soil = etSoil.text.toString()
            val function = etFunction.text.toString()
            val style = etStyle.text.toString()
            val pathway = etPathway.text.toString()
            val budget = etBudget.text.toString()
            val maintenance = etMaintenance.text.toString()

            if (length.isNotEmpty() && width.isNotEmpty() && soil.isNotEmpty() && function.isNotEmpty() &&
                style.isNotEmpty() && pathway.isNotEmpty() && budget.isNotEmpty() && maintenance.isNotEmpty()) {

                val intent = Intent(this, NewCreationDetails::class.java).apply {
                    putExtra("LENGTH_DATA", length)
                    putExtra("WIDTH_DATA", width)
                    putExtra("SOIL_DATA", soil)
                    putExtra("FUNCTION_DATA", function)
                    putExtra("STYLE_DATA", style)
                    putExtra("PATHWAY_DATA", pathway)
                    putExtra("BUDGET_DATA", budget)
                    putExtra("MAINTENANCE_DATA", maintenance)
                }
                startActivity(intent)
            } else {
                Toast.makeText(this, "Please fill all fields!", Toast.LENGTH_SHORT).show()
            }
        }
        val cancelButton = findViewById<Button>(R.id.cancel_button)
        cancelButton.setOnClickListener {
            Toast.makeText(this, "Cancelled. Going back to Dashboard...", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, NewDashboardActivity::class.java)
            startActivity(intent)
        }
    }
}