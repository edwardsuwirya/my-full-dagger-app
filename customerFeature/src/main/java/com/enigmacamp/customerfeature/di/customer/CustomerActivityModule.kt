package com.enigmacamp.customerfeature.di.customer

import com.enigmacamp.customerfeature.data.repository.CustomerRepository
import com.enigmacamp.customerfeature.presentation.CustomerFragment
import com.enigmacamp.customerfeature.presentation.CustomerFragmentViewModel
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector


@Module
abstract class CustomerActivityModule {
    @ContributesAndroidInjector
    abstract fun contributeCustomerFragment(): CustomerFragment

    companion object {
        @Provides
        fun provideMainActivityViewModel(
            customerRepository: CustomerRepository
        ): CustomerFragmentViewModel {
            return CustomerFragmentViewModel(customerRepository)
        }
    }
}