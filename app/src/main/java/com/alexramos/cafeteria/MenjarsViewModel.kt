package com.alexramos.cafeteria

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MenjarsViewModel : ViewModel() {
    val menjars = MutableLiveData<List<MenuItem>>()

    init {
        menjars.value = listOf(
            MenuItem("Pizza", 12),
            MenuItem("Espagueti", 10),
            MenuItem("Ensalada", 8)
        )
    }
}