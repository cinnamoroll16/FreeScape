package com.example.proposedapplication

import android.app.Activity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Activity_ProjectHistory : Activity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ProjectAdapter
    private lateinit var projectList: List<ProjectModel>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_project_history)

        // 🔙 Back button
        findViewById<ImageView>(R.id.backArrow).setOnClickListener {
            finish()
        }

        // 🔁 RecyclerView setup
        recyclerView = findViewById(R.id.recyclerViewPrevious)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        // 🧪 Dummy project list (replace with backend data)
        projectList = listOf(
            ProjectModel("Zen Corner", "A relaxing zen garden with bamboo fence."),
            ProjectModel("Mini Orchard", "A backyard with fruit trees and walkway."),
            ProjectModel("Tropical Retreat", "A design with palm trees and hammock spot.")
        )

        adapter = ProjectAdapter(projectList)
        recyclerView.adapter = adapter
    }
}
