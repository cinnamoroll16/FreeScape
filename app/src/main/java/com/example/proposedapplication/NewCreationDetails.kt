package com.example.proposedapplication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import com.google.android.material.button.MaterialButton

class NewCreationDetails : Activity() {

    private lateinit var tvYardLength: TextView
    private lateinit var tvYardWidth: TextView
    private lateinit var tvSoil: TextView
    private lateinit var tvFunction: TextView
    private lateinit var tvStyle: TextView
    private lateinit var tvPathway: TextView
    private lateinit var tvBudget: TextView
    private lateinit var tvMaintenance: TextView
    private lateinit var editButton: MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_creation_details)

        tvYardLength = findViewById(R.id.tv_yard_length)
        tvYardWidth = findViewById(R.id.tv_yard_width)
        tvSoil = findViewById(R.id.tv_soil_type)
        tvFunction = findViewById(R.id.tv_function_purpose)
        tvStyle = findViewById(R.id.tv_style)
        tvPathway = findViewById(R.id.tv_path_type)
        tvBudget = findViewById(R.id.tv_budget_range)
        tvMaintenance = findViewById(R.id.tv_maintenance)
        editButton = findViewById(R.id.edit_details)

        // ✅ Set text using intent extras
        tvYardLength.text = "Yard Length\n" + (intent.getStringExtra("LENGTH_DATA") ?: "-")
        tvYardWidth.text = "Yard Width\n" + (intent.getStringExtra("WIDTH_DATA") ?: "-")
        tvSoil.text = "Soil Type\n" + (intent.getStringExtra("SOIL_DATA") ?: "-")
        tvFunction.text = "Function\n" + (intent.getStringExtra("FUNCTION_DATA") ?: "-")
        tvStyle.text = "Style\n" + (intent.getStringExtra("STYLE_DATA") ?: "-")
        tvPathway.text = "Path Type\n" + (intent.getStringExtra("PATHWAY_DATA") ?: "-")
        tvBudget.text = "Budget Range\n" + (intent.getStringExtra("BUDGET_DATA") ?: "-")
        tvMaintenance.text = "Maintenance\n" + (intent.getStringExtra("MAINTENANCE_DATA") ?: "-")

        editButton.setOnClickListener {
            val intent = Intent(this, NewCreationActivity::class.java).apply {
                putExtra("LENGTH_DATA", intent.getStringExtra("LENGTH_DATA"))
                putExtra("WIDTH_DATA", intent.getStringExtra("WIDTH_DATA"))
                putExtra("SOIL_DATA", intent.getStringExtra("SOIL_DATA"))
                putExtra("FUNCTION_DATA", intent.getStringExtra("FUNCTION_DATA"))
                putExtra("STYLE_DATA", intent.getStringExtra("STYLE_DATA"))
                putExtra("PATHWAY_DATA", intent.getStringExtra("PATHWAY_DATA"))
                putExtra("BUDGET_DATA", intent.getStringExtra("BUDGET_DATA"))
                putExtra("MAINTENANCE_DATA", intent.getStringExtra("MAINTENANCE_DATA"))
            }
            startActivity(intent)
            finish()
        }

        findViewById<MaterialButton>(R.id.workspace).setOnClickListener {
            startActivity(Intent(this, NewVirtualActivity::class.java))
        }
    }
}