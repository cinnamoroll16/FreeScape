package com.example.proposedapplication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class NewCreationActivity : Activity() {

    private lateinit var etLength: EditText
    private lateinit var etWidth: EditText
    private lateinit var etSoil: EditText
    private lateinit var etFunction: EditText
    private lateinit var etStyle: EditText
    private lateinit var etPathway: EditText
    private lateinit var etBudget: EditText
    private lateinit var etMaintenance: EditText
    private lateinit var btnSubmit: Button
    private lateinit var btnCancel: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_creation)

        etLength = findViewById(R.id.et_length)
        etWidth = findViewById(R.id.et_width)
        etSoil = findViewById(R.id.et_soil)
        etFunction = findViewById(R.id.et_func)
        etStyle = findViewById(R.id.et_style)
        etPathway = findViewById(R.id.et_pathway)
        etBudget = findViewById(R.id.et_budget)
        etMaintenance = findViewById(R.id.et_maintenance)
        btnSubmit = findViewById(R.id.confirm_button)
        btnCancel = findViewById(R.id.cancel_button)

        // Prefill fields if coming back from NewCreationDetails
        intent.extras?.let {
            etLength.setText(it.getString("LENGTH_DATA", ""))
            etWidth.setText(it.getString("WIDTH_DATA", ""))
            etSoil.setText(it.getString("SOIL_DATA", ""))
            etFunction.setText(it.getString("FUNCTION_DATA", ""))
            etStyle.setText(it.getString("STYLE_DATA", ""))
            etPathway.setText(it.getString("PATHWAY_DATA", ""))
            etBudget.setText(it.getString("BUDGET_DATA", ""))
            etMaintenance.setText(it.getString("MAINTENANCE_DATA", ""))
        }

        btnSubmit.setOnClickListener {
            val inputs = listOf(
                etLength.text.toString(),
                etWidth.text.toString(),
                etSoil.text.toString(),
                etFunction.text.toString(),
                etStyle.text.toString(),
                etPathway.text.toString(),
                etBudget.text.toString(),
                etMaintenance.text.toString()
            )

            if (inputs.any { it.isBlank() }) {
                Toast.makeText(this, "Please fill all fields!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val intent = Intent(this, NewCreationDetails::class.java).apply {
                putExtra("LENGTH_DATA", etLength.text.toString())
                putExtra("WIDTH_DATA", etWidth.text.toString())
                putExtra("SOIL_DATA", etSoil.text.toString())
                putExtra("FUNCTION_DATA", etFunction.text.toString())
                putExtra("STYLE_DATA", etStyle.text.toString())
                putExtra("PATHWAY_DATA", etPathway.text.toString())
                putExtra("BUDGET_DATA", etBudget.text.toString())
                putExtra("MAINTENANCE_DATA", etMaintenance.text.toString())
            }
            startActivity(intent)
        }

        btnCancel.setOnClickListener {
            Toast.makeText(this, "Cancelled. Returning to Dashboard...", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, NewDashboardActivity::class.java))
        }
    }
}
