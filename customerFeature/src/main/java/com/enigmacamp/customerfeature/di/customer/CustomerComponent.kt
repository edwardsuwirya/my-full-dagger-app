package com.enigmacamp.customerfeature.di.customer

import com.enigmacamp.core.di.annotation.CustomerScope
import com.enigmacamp.customerfeature.data.repository.CustomerRepository
import dagger.Component

@CustomerScope
@Component(modules = [CustomerRepoModule::class], dependencies = [com.enigmacamp.core.di.data.DataComponent::class])
interface CustomerComponent {
    fun provideCustomerRepository(): CustomerRepository
}