package com.enigmacamp.myfulldaggerapp

import com.enigmacamp.myfulldaggerapp.di.app.DaggerAppComponent
import com.enigmacamp.myfulldaggerapp.di.authentication.AuthenticationComponent
import com.enigmacamp.myfulldaggerapp.di.authentication.DaggerAuthenticationComponent
import com.enigmacamp.myfulldaggerapp.di.customer.CustomerComponent
import com.enigmacamp.myfulldaggerapp.di.customer.DaggerCustomerComponent
import com.enigmacamp.myfulldaggerapp.di.data.DaggerDataComponent
import com.enigmacamp.myfulldaggerapp.di.data.DataComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class BaseApplication : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().authenticationComponent(provideAuthComponent())
            .customerComponent(provideCustomerComponent()).build()
    }

    private fun provideDataComponent(): DataComponent {
        return DaggerDataComponent.builder().application(this).build()
    }

    private fun provideAuthComponent(): AuthenticationComponent {
        return DaggerAuthenticationComponent.builder().dataComponent(provideDataComponent()).build()
    }

    private fun provideCustomerComponent(): CustomerComponent {
        return DaggerCustomerComponent.builder().dataComponent(provideDataComponent()).build()
    }
}