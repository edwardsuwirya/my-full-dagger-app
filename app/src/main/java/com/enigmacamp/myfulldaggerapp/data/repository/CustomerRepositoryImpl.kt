package com.enigmacamp.myfulldaggerapp.data.repository

import com.enigmacamp.myfulldaggerapp.data.db.AppDatabase
import com.enigmacamp.myfulldaggerapp.data.entity.Customer
import javax.inject.Inject


class CustomerRepositoryImpl @Inject constructor(private val db: AppDatabase) : CustomerRepository {
    override fun registerNewCustomer(customer: Customer) = db.customerDao().insert(customer)
    override fun customerById(id: Int) = db.customerDao().findById(id)
}