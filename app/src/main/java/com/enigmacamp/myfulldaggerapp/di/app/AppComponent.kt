package com.enigmacamp.myfulldaggerapp.di.app

import com.enigmacamp.myfulldaggerapp.BaseApplication
import com.enigmacamp.core.di.annotation.AppScope
import com.enigmacamp.authenticationfeature.di.authentication.AuthenticationComponent
import com.enigmacamp.customerfeature.di.customer.CustomerComponent
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector

@AppScope
@Component(
    modules = [
        AndroidInjectionModule::class,
        AppModule::class],
    dependencies = [com.enigmacamp.customerfeature.di.customer.CustomerComponent::class, com.enigmacamp.authenticationfeature.di.authentication.AuthenticationComponent::class]
)
interface AppComponent : AndroidInjector<BaseApplication> {

}