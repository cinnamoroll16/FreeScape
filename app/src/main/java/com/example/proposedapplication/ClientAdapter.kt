package com.example.proposedapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ClientAdapter(
    private var clients: List<Client>,
    private val onItemClick: (Client) -> Unit  // Click listener lambda
) : RecyclerView.Adapter<ClientAdapter.ClientViewHolder>() {

    inner class ClientViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val idText: TextView = itemView.findViewById(R.id.client_id)
        val assignmentText: TextView = itemView.findViewById(R.id.client_assignment)
        val contactText: TextView = itemView.findViewById(R.id.client_contact)
        val iconImage: ImageView = itemView.findViewById(R.id.client_icon)

        fun bind(client: Client) {
            idText.text = client.id
            assignmentText.text = client.assignment
            contactText.text = client.contact
            iconImage.setImageResource(R.drawable.ic_person) // static icon

            // Set the click listener on the entire item view
            itemView.setOnClickListener {
                onItemClick(client)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClientViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.new_client_finder_item, parent, false)
        return ClientViewHolder(view)
    }

    override fun onBindViewHolder(holder: ClientViewHolder, position: Int) {
        val client = clients[position]
        holder.bind(client) // use bind to set data and click listener
    }

    override fun getItemCount(): Int = clients.size

    fun updateList(newList: List<Client>) {
        clients = newList
        notifyDataSetChanged()
    }
}
