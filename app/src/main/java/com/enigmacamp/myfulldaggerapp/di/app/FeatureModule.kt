package com.enigmacamp.myfulldaggerapp.di.app

import com.enigmacamp.authenticationfeature.di.authentication.AuthenticationActivityModule
import com.enigmacamp.customerfeature.di.customer.CustomerActivityModule
import dagger.Module

@Module(includes = [
    AuthenticationActivityModule::class,
    CustomerActivityModule::class])
class FeatureModule {
}