package com.example.proposedapplication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.cardview.widget.CardView

class NewDeveloper1 : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_developer1)

        val cardDeveloper1 = findViewById<CardView>(R.id.cardDeveloper1)
        val cardDeveloper2 = findViewById<CardView>(R.id.cardDeveloper2)
        val cardDeveloper3 = findViewById<CardView>(R.id.cardDeveloper3)
        val cardDeveloper4 = findViewById<CardView>(R.id.cardDeveloper4)

        cardDeveloper1.setOnClickListener {
            val intent = Intent(this, NewDeveloper1Details::class.java)
            startActivity(intent)
        }

        cardDeveloper2.setOnClickListener {
            val intent = Intent(this, NewDeveloper2Details::class.java)
            startActivity(intent)
        }

        cardDeveloper3.setOnClickListener {
            val intent = Intent(this, NewDeveloper3Details::class.java)
            startActivity(intent)
        }

        cardDeveloper4.setOnClickListener {
            val intent = Intent(this, NewDeveloper4Details::class.java)
            startActivity(intent)
        }
    }
}