package com.example.proposedapplication

import android.app.Activity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Toast

class NewDeveloper4Details : Activity() {
    private lateinit var skillsListView: ListView
    private lateinit var skillsList: ArrayList<String>
    private lateinit var adapter: ArrayAdapter<String>
    private lateinit var btnDone: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_developer4_details)

        // Initialize ListView
        skillsListView = findViewById(R.id.skills_listview)
        skillsList = ArrayList()

        // Add initial skills
        skillsList.addAll(listOf(
            "UI/UX Design",
            "Graphic Design",
            "User Research",
            "Prototyping"
        ))

        // Create and set adapter
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, skillsList)
        skillsListView.adapter = adapter

        // Set click listener to add skill to bottom of list
        skillsListView.setOnItemClickListener { _, _, position, _ ->
            val clickedSkill = skillsList[position]
            Toast.makeText(this, "Adding: $clickedSkill", Toast.LENGTH_SHORT).show()
            skillsList.add(clickedSkill)
            adapter.notifyDataSetChanged()
        }

        // Set long click listener to delete skill
        skillsListView.setOnItemLongClickListener { _, _, position, _ ->
            val deletedSkill = skillsList[position]
            Toast.makeText(this, "Removing: $deletedSkill", Toast.LENGTH_SHORT).show()
            skillsList.removeAt(position)
            adapter.notifyDataSetChanged()
            true
        }

        btnDone = findViewById<Button>(R.id.btn_done)
        btnDone.setOnClickListener {
            finish()
        }
    }
}