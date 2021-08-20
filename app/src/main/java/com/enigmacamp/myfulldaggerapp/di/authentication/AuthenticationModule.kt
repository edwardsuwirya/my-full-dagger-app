package com.enigmacamp.myfulldaggerapp.di.authentication

import com.enigmacamp.myfulldaggerapp.data.repository.AuthenticationRepository
import com.enigmacamp.myfulldaggerapp.data.repository.AuthenticationRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
abstract class AuthenticationModule {
    @Binds
    abstract fun bindsAuthenticationRepository(authenticationRepositoryImpl: AuthenticationRepositoryImpl): AuthenticationRepository
}