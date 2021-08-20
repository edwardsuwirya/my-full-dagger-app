package com.enigmacamp.myfulldaggerapp.di.customer

import com.enigmacamp.myfulldaggerapp.data.repository.CustomerRepository
import com.enigmacamp.myfulldaggerapp.data.repository.CustomerRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
abstract class CustomerModule {
    @Binds
    abstract fun bindsCustomerRepository(customerRepositoryImpl: CustomerRepositoryImpl): CustomerRepository
}