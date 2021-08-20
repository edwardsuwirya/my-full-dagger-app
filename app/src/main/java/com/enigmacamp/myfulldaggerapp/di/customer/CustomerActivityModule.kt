package com.enigmacamp.myfulldaggerapp.di.customer

import com.enigmacamp.myfulldaggerapp.data.repository.CustomerRepository
import com.enigmacamp.myfulldaggerapp.presentation.NextActivity
import com.enigmacamp.myfulldaggerapp.presentation.NextActivityViewModel
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector


@Module
abstract class CustomerActivityModule {
    @ContributesAndroidInjector
    abstract fun contributeNextActivity(): NextActivity

    companion object {
        @Provides
        fun provideMainActivityViewModel(
            customerRepository: CustomerRepository
        ): NextActivityViewModel {
            return NextActivityViewModel(customerRepository)
        }
    }
}