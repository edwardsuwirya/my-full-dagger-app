package com.enigmacamp.customerfeature.data.repository

import com.enigmacamp.core.data.entity.Customer


interface CustomerRepository {
    fun registerNewCustomer(customer: Customer): Long
    fun customerById(id: Int): Customer
}