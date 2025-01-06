package com.alexramos.cafeteria

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BegudesViewModel : ViewModel() {
    val begudes = MutableLiveData<List<MenuItem>>()

    init {
        begudes.value = listOf(
            MenuItem("Coca-Cola", 2),
            MenuItem("Fanta", 2),
            MenuItem("Agua", 1)
        )
    }
}