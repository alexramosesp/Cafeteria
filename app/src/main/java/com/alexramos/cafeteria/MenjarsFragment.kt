package com.alexramos.cafeteria

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.alexramos.cafeteria.databinding.FragmentMenjarsBinding


class MenjarsFragment : Fragment() {
    private lateinit var binding: FragmentMenjarsBinding
    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentMenjarsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val menuItems = listOf(
            MenuItem("Pizza Margarita", 12),
            MenuItem("Espagueti Boloñesa", 10),
            MenuItem("Ensalada César", 8)
        )

        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = MenuAdapter(menuItems) { item ->
            sharedViewModel.addToTotal(item.price)
        }

        sharedViewModel.totalPrice.observe(viewLifecycleOwner) { total ->
            binding.textViewTotal.text = "Total: $total €"
        }
    }
}