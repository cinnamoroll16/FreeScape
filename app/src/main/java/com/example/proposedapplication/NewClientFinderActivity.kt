package com.example.proposedapplication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.proposedapplication.api.RetrofitClient
import com.example.proposedapplication.model.CreationDetails
import com.example.proposedapplication.model.MatchRequest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewClientFinderActivity : Activity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ClientAdapter
    private lateinit var searchView: SearchView
    private lateinit var backButton: ImageView

    private val clients = listOf(
        Client("ID:001", "Landscape Designer", "Contact: (+63) 9012341558"),
        Client("ID:002", "Landscape Designer", "Contact: (+63) 9012341558"),
        Client("ID:003", "Landscape Designer", "Contact: (+63) 9012341558"),
        Client("ID:004", "Landscape Designer", "Contact: (+63) 9012341558")
    )

    private lateinit var creationDetails: CreationDetails

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_client_finder)

        recyclerView = findViewById(R.id.client_list_recyclerview)
        searchView = findViewById(R.id.search_view)
        backButton = findViewById(R.id.backButton)

        // Retrieve creation details passed from previous activity
        creationDetails = CreationDetails(
            length = intent.getStringExtra("LENGTH_DATA") ?: "",
            width = intent.getStringExtra("WIDTH_DATA") ?: "",
            soil = intent.getStringExtra("SOIL_DATA") ?: "",
            function = intent.getStringExtra("FUNCTION_DATA") ?: "",
            style = intent.getStringExtra("STYLE_DATA") ?: "",
            pathway = intent.getStringExtra("PATHWAY_DATA") ?: "",
            budget = intent.getStringExtra("BUDGET_DATA") ?: "",
            maintenance = intent.getStringExtra("MAINTENANCE_DATA") ?: ""
        )

        adapter = ClientAdapter(clients) { client ->
            // On client click, save match and navigate to payment
            saveMatchAndProceed(client)
        }

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        setupSearch()

        backButton.setOnClickListener {
            val intent = Intent(this, NewDashboardActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun saveMatchAndProceed(client: Client) {
        val matchedData = MatchRequest(
            creationDetails = creationDetails,
            client = client
        )

        RetrofitClient.apiService.saveMatch(matchedData).enqueue(object : Callback<MatchResponse> {
            override fun onResponse(call: Call<MatchResponse>, response: Response<MatchResponse>) {
                if (response.isSuccessful) {
                    val matchId = response.body()?.matchId
                    Toast.makeText(this@NewClientFinderActivity, "You are connected to your client", Toast.LENGTH_SHORT).show()

                    val intent = Intent(this@NewClientFinderActivity, NewDashboardActivity::class.java).apply {
                        putExtra("MATCH_ID", matchId)
                    }
                    startActivity(intent)
                } else {
                    Toast.makeText(this@NewClientFinderActivity, "Failed to save.", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<MatchResponse>, t: Throwable) {
                Toast.makeText(this@NewClientFinderActivity, "Network error: ${t.localizedMessage}", Toast.LENGTH_SHORT).show()
            }
        })
    }


    private fun setupSearch() {
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                filterClients(query)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterClients(newText)
                return true
            }
        })
    }

    private fun filterClients(query: String?) {
        if (query.isNullOrBlank()) {
            adapter.updateList(clients)
            return
        }
        val filtered = clients.filter {
            it.id.contains(query.trim(), ignoreCase = true)
        }
        adapter.updateList(filtered)
    }
}