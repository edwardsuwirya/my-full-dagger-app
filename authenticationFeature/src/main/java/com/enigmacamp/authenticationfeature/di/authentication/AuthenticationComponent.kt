package com.enigmacamp.authenticationfeature.di.authentication

import com.enigmacamp.authenticationfeature.data.repository.AuthenticationRepository
import com.enigmacamp.core.di.annotation.AuthScope
import com.enigmacamp.core.di.data.DataComponent
import dagger.Component

@AuthScope
@Component(modules = [AuthenticationRepoModule::class], dependencies = [DataComponent::class])
interface AuthenticationComponent {
    fun provideAuthenticationRepo(): AuthenticationRepository
}