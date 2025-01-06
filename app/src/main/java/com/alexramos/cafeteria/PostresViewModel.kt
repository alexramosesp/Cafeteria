package com.alexramos.cafeteria

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PostresViewModel : ViewModel() {
    val postres = MutableLiveData<List<MenuItem>>()

    init {
        postres.value = listOf(
            MenuItem("Helado", 3),
            MenuItem("Brownie", 4),
            MenuItem("Tarta de Queso", 5)
        )
    }
}