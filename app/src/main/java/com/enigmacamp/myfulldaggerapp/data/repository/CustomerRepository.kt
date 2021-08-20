package com.enigmacamp.myfulldaggerapp.data.repository

import com.enigmacamp.myfulldaggerapp.data.entity.Customer


interface CustomerRepository {
    fun registerNewCustomer(customer: Customer): Long
    fun customerById(id: Int): Customer
}