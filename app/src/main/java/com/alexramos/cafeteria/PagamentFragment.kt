package com.alexramos.cafeteria

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.alexramos.cafeteria.databinding.FragmentPagamentBinding

class PagamentFragment : Fragment() {
    private lateinit var binding: FragmentPagamentBinding
    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentPagamentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedViewModel.totalPrice.observe(viewLifecycleOwner) { total ->
            binding.textViewTotal.text = "Total: $total €"
        }
    }
}