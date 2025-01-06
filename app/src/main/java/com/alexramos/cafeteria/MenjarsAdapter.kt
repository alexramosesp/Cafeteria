package com.alexramos.cafeteria

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class MenjarsAdapter(private val items: List<MenuItem>) : RecyclerView.Adapter<MenjarsAdapter.MenjarsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenjarsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(android.R.layout.simple_list_item_2, parent, false)
        return MenjarsViewHolder(view)
    }

    override fun onBindViewHolder(holder: MenjarsViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    override fun getItemCount() = items.size

    class MenjarsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val text1: TextView = view.findViewById(android.R.id.text1)
        private val text2: TextView = view.findViewById(android.R.id.text2)

        fun bind(item: MenuItem) {
            text1.text = item.name
            text2.text = "Precio: ${item.price}€"
        }
    }
}