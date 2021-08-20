package com.enigmacamp.myfulldaggerapp.di.customer

import com.enigmacamp.myfulldaggerapp.data.repository.CustomerRepository
import com.enigmacamp.myfulldaggerapp.di.annotation.CustomerScope
import com.enigmacamp.myfulldaggerapp.di.data.DataComponent
import dagger.Component

@CustomerScope
@Component(modules = [CustomerRepoModule::class], dependencies = [DataComponent::class])
interface CustomerComponent {
    fun provideCustomerRepository(): CustomerRepository
}