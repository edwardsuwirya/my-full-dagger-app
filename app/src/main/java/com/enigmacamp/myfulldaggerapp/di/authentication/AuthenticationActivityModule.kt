package com.enigmacamp.myfulldaggerapp.di.authentication

import com.enigmacamp.myfulldaggerapp.data.repository.AuthenticationRepository
import com.enigmacamp.myfulldaggerapp.data.repository.CustomerRepository
import com.enigmacamp.myfulldaggerapp.di.annotation.CustomerScope
import com.enigmacamp.myfulldaggerapp.di.customer.CustomerRepoModule
import com.enigmacamp.myfulldaggerapp.presentation.MainActivity
import com.enigmacamp.myfulldaggerapp.presentation.MainActivityViewModel
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector


@Module
abstract class AuthenticationActivityModule {
    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity

    companion object {
        @Provides
        fun provideMainActivityViewModel(
            authenticationRepository: AuthenticationRepository,
            customerRepository: CustomerRepository
        ): MainActivityViewModel {
            return MainActivityViewModel(authenticationRepository, customerRepository)
        }
    }
}