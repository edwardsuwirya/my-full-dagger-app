package com.enigmacamp.myfulldaggerapp

import com.enigmacamp.authenticationfeature.di.authentication.DaggerAuthenticationComponent
import com.enigmacamp.core.di.data.DaggerDataComponent
import com.enigmacamp.customerfeature.di.customer.DaggerCustomerComponent
import com.enigmacamp.myfulldaggerapp.di.app.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class BaseApplication : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().authenticationComponent(provideAuthComponent())
            .customerComponent(provideCustomerComponent()).build()
    }

    private fun provideDataComponent(): com.enigmacamp.core.di.data.DataComponent {
        return DaggerDataComponent.builder().application(this).build()
    }

    private fun provideAuthComponent(): com.enigmacamp.authenticationfeature.di.authentication.AuthenticationComponent {
        return DaggerAuthenticationComponent.builder().dataComponent(provideDataComponent()).build()
    }

    private fun provideCustomerComponent(): com.enigmacamp.customerfeature.di.customer.CustomerComponent {
        return DaggerCustomerComponent.builder().dataComponent(provideDataComponent()).build()
    }
}