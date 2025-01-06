package com.alexramos.cafeteria

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class BegudesAdapter(private val items: List<MenuItem>) : RecyclerView.Adapter<BegudesAdapter.BegudesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BegudesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(android.R.layout.simple_list_item_2, parent, false)
        return BegudesViewHolder(view)
    }

    override fun onBindViewHolder(holder: BegudesViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    override fun getItemCount() = items.size

    class BegudesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val text1: TextView = view.findViewById(android.R.id.text1)
        private val text2: TextView = view.findViewById(android.R.id.text2)

        fun bind(item: MenuItem) {
            text1.text = item.name
            text2.text = "Precio: ${item.price}€"
        }
    }
}