package com.example.proposedapplication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import com.example.proposedapplication.adapter.DeveloperAdapter
import com.example.proposedapplication.data.Developer

class NewDeveloper1 : Activity() {
    private lateinit var developersList: ListView
    private lateinit var btnDevBack: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_developer1)

        // Initialize views
        developersList = findViewById(R.id.developers_list)
        btnDevBack = findViewById(R.id.btn_devback)

        // Create developer list
        val developers = listOf(
            Developer("ADRIANE LORENZ RACAZA", R.drawable.racaza),
            Developer("SANDARRA DUMANACAL", R.drawable.darra),
            Developer("ANGELICA SABELLAGA", R.drawable.angel2),
            Developer("MARY JESSA DAÑO", R.drawable.jessa)
        )

        // Set up adapter
        val adapter = DeveloperAdapter(this, developers)
        developersList.adapter = adapter

        // Set up back button
        btnDevBack.setOnClickListener {
            finish()
        }
    }
}