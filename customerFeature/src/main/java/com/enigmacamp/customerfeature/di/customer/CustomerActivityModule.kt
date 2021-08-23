package com.enigmacamp.customerfeature.di.customer

import com.enigmacamp.customerfeature.data.repository.CustomerRepository
import com.enigmacamp.customerfeature.presentation.CustomerActivity
import com.enigmacamp.customerfeature.presentation.CustomerActivityViewModel
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector


@Module
abstract class CustomerActivityModule {
    @ContributesAndroidInjector
    abstract fun contributeCustomerActivity(): CustomerActivity

    companion object {
        @Provides
        fun provideMainActivityViewModel(
            customerRepository: CustomerRepository
        ): CustomerActivityViewModel {
            return CustomerActivityViewModel(customerRepository)
        }
    }
}