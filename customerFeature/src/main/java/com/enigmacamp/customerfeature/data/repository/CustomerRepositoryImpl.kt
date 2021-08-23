package com.enigmacamp.customerfeature.data.repository

import javax.inject.Inject


class CustomerRepositoryImpl @Inject constructor(private val db: com.enigmacamp.core.data.db.AppDatabase) :
    CustomerRepository {
    override fun registerNewCustomer(customer: com.enigmacamp.core.data.entity.Customer) = db.customerDao().insert(customer)
    override fun customerById(id: Int) = db.customerDao().findById(id)
}