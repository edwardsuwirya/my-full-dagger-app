package com.enigmacamp.myfulldaggerapp.data.repository

import com.enigmacamp.myfulldaggerapp.data.db.AppDatabase
import com.enigmacamp.myfulldaggerapp.data.entity.Customer


class CustomerRepositoryImpl(private val db: AppDatabase) : CustomerRepository {
    override fun registerNewCustomer(customer: Customer) = db.customerDao().insert(customer)
}