package com.alexramos.cafeteria

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class PostresAdapter(private val items: List<MenuItem>) : RecyclerView.Adapter<PostresAdapter.PostresViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostresViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(android.R.layout.simple_list_item_2, parent, false)
        return PostresViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostresViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    override fun getItemCount() = items.size

    class PostresViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val text1: TextView = view.findViewById(android.R.id.text1)
        private val text2: TextView = view.findViewById(android.R.id.text2)

        fun bind(item: MenuItem) {
            text1.text = item.name
            text2.text = "Precio: ${item.price}€"
        }
    }
}
