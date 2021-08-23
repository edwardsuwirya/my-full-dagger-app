package com.enigmacamp.customerfeature.di.customer

import com.enigmacamp.customerfeature.data.repository.CustomerRepository
import com.enigmacamp.customerfeature.data.repository.CustomerRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
abstract class CustomerRepoModule {
    @Binds
    abstract fun bindsCustomerRepository(customerRepositoryImpl: CustomerRepositoryImpl): CustomerRepository
}