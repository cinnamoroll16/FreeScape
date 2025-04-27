package com.example.proposedapplication.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.proposedapplication.R
import com.example.proposedapplication.data.Developer
import com.example.proposedapplication.NewDeveloper1Details
import com.example.proposedapplication.NewDeveloper2Details
import com.example.proposedapplication.NewDeveloper3Details
import com.example.proposedapplication.NewDeveloper4Details

class DeveloperAdapter(context: Context, private val developers: List<Developer>) : 
    ArrayAdapter<Developer>(context, R.layout.item_developer, developers) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(context)
            .inflate(R.layout.item_developer, parent, false)

        val developer = developers[position]

        val imageView = view.findViewById<ImageView>(R.id.developer_image)
        val nameView = view.findViewById<TextView>(R.id.developer_name)

        imageView.setImageResource(developer.imageResourceId)
        nameView.text = developer.name

        view.setOnClickListener {
            Toast.makeText(context, "Redirecting to ${developer.name}'s page", Toast.LENGTH_SHORT).show()
            
            // Navigate to corresponding detail activity
            val intent = when (position) {
                0 -> Intent(context, NewDeveloper1Details::class.java)
                1 -> Intent(context, NewDeveloper2Details::class.java)
                2 -> Intent(context, NewDeveloper3Details::class.java)
                3 -> Intent(context, NewDeveloper4Details::class.java)
                else -> null
            }
            
            intent?.let { context.startActivity(it) }
        }

        return view
    }
} 