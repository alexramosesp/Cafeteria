package com.alexramos.cafeteria

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.alexramos.cafeteria.databinding.FragmentPostresBinding

class PostresFragment : Fragment() {
    private lateinit var binding: FragmentPostresBinding
    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentPostresBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val menuItems = listOf(
            MenuItem("Helado", 3),
            MenuItem("Brownie", 4),
            MenuItem("Tarta de Queso", 5)
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
