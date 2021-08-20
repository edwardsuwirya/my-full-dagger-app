package com.enigmacamp.myfulldaggerapp.di.authentication

import com.enigmacamp.myfulldaggerapp.data.repository.AuthenticationRepository
import com.enigmacamp.myfulldaggerapp.di.annotation.AuthScope
import com.enigmacamp.myfulldaggerapp.di.data.DataComponent
import dagger.Component

@AuthScope
@Component(modules = [AuthenticationRepoModule::class], dependencies = [DataComponent::class])
interface AuthenticationComponent {
    fun provideAuthenticationRepo():AuthenticationRepository
}