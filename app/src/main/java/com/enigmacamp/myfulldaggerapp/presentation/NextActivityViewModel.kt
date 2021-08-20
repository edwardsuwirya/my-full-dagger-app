package com.enigmacamp.myfulldaggerapp.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.enigmacamp.myfulldaggerapp.data.entity.Customer
import com.enigmacamp.myfulldaggerapp.data.repository.CustomerRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NextActivityViewModel(private val customerRepository: CustomerRepository) : ViewModel() {
    private var _customerLiveData = MutableLiveData<Customer>()

    val customerLiveData: LiveData<Customer>
        get() = _customerLiveData

    init {
        getCustomerInfo()
    }

    fun getCustomerInfo() {
        viewModelScope.launch(Dispatchers.IO) {
            val customer = customerRepository.customerById(1)
            _customerLiveData.postValue(customer)
        }

    }
}