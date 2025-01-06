package com.alexramos.cafeteria

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MenuAdapter(
    private val items: List<MenuItem>,
    private val onItemAdded: (MenuItem) -> Unit
) : RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_menu, parent, false)
        return MenuViewHolder(view)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item, onItemAdded)
    }

    override fun getItemCount() = items.size

    class MenuViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val nameTextView: TextView = view.findViewById(R.id.itemName)
        private val priceTextView: TextView = view.findViewById(R.id.itemPrice)
        private val addButton: Button = view.findViewById(R.id.addButton)

        fun bind(item: MenuItem, onItemAdded: (MenuItem) -> Unit) {
            nameTextView.text = item.name
            priceTextView.text = "Precio: ${item.price}€"
            addButton.setOnClickListener { onItemAdded(item) }
        }
    }
}
