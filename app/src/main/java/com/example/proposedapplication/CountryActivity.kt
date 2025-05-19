package com.example.proposedapplication

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CountryActivity : AppCompatActivity() {

    private lateinit var searchInput: EditText
    private lateinit var countryListLayout: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_country)

        searchInput = findViewById(R.id.searchCountry)
        val scrollView = findViewById<androidx.core.widget.NestedScrollView>(R.id.scrollView)
        countryListLayout = scrollView.getChildAt(0) as LinearLayout
        searchInput.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                filterCountries(s.toString())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })
    }

    private fun filterCountries(query: String) {
        val lowerQuery = query.lowercase()

        for (i in 0 until countryListLayout.childCount) {
            val row = countryListLayout.getChildAt(i) as LinearLayout
            val textView = row.findViewById<TextView>(android.R.id.text1) ?: row.getChildAt(1) as TextView
            val countryName = textView.text.toString().lowercase()

            row.visibility = if (countryName.contains(lowerQuery)) {
                LinearLayout.VISIBLE
            } else {
                LinearLayout.GONE
            }
        }
    }
}
