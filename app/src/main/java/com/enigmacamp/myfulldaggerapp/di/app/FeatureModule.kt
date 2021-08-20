package com.enigmacamp.myfulldaggerapp.di.app

import com.enigmacamp.myfulldaggerapp.di.authentication.AuthenticationActivityModule
import dagger.Module

@Module(includes = [AuthenticationActivityModule::class])
class FeatureModule {
}