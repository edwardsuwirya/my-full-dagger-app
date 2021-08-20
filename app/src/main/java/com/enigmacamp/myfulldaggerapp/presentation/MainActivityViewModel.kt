package com.enigmacamp.myfulldaggerapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.enigmacamp.myfulldaggerapp.data.api.request.AuthenticationRequest
import com.enigmacamp.myfulldaggerapp.data.entity.Customer
import com.enigmacamp.myfulldaggerapp.data.repository.AuthenticationRepository
import com.enigmacamp.myfulldaggerapp.data.repository.CustomerRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivityViewModel(
    private val authenticationRepository: AuthenticationRepository,
    private val customerRepository: CustomerRepository
) : ViewModel() {
    fun customerLogin(userName: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val isAuthenticated =
                authenticationRepository.login(AuthenticationRequest(userName, password))
            if (isAuthenticated) {
                customerRepository.registerNewCustomer(
                    Customer(
                        name = userName,
                        idCard = "123",
                        gender = "L"
                    )
                )
            }
        }

    }
}