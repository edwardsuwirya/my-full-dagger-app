package com.enigmacamp.customerfeature.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.enigmacamp.core.data.entity.Customer
import com.enigmacamp.customerfeature.data.repository.CustomerRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CustomerFragmentViewModel(private val customerRepository: CustomerRepository) : ViewModel() {
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