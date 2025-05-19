package com.example.proposedapplication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button

class NewDeveloper1Details : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_developer1_details)

        val doneButton = findViewById<Button>(R.id.btn_done)
        doneButton.setOnClickListener {
            val intent = Intent(this, NewDeveloper1::class.java)
            startActivity(intent)
            finish()
        }
    }
}