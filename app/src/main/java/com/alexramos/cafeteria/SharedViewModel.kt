package com.alexramos.cafeteria

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {
    private val _totalPrice = MutableLiveData(0)
    val totalPrice: LiveData<Int> get() = _totalPrice

    fun addToTotal(price: Int) {
        _totalPrice.value = (_totalPrice.value ?: 0) + price
    }

    fun getTotal(): Int {
        return _totalPrice.value ?: 0
    }
}