package com.enigmacamp.myfulldaggerapp.di.app

import com.enigmacamp.myfulldaggerapp.di.authentication.AuthenticationActivityModule
import com.enigmacamp.myfulldaggerapp.di.customer.CustomerActivityModule
import dagger.Module

@Module(includes = [AuthenticationActivityModule::class, CustomerActivityModule::class])
class FeatureModule {
}