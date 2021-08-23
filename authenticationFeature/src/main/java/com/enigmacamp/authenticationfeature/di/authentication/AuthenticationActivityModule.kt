package com.enigmacamp.authenticationfeature.di.authentication

import com.enigmacamp.authenticationfeature.presentation.AuthenticationActivity
import com.enigmacamp.authenticationfeature.presentation.AuthenticationActivityViewModel
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector


@Module
abstract class AuthenticationActivityModule {
    @ContributesAndroidInjector
    abstract fun contributeAuthenticationActivity(): AuthenticationActivity

    companion object {
        @Provides
        fun provideMainActivityViewModel(
            authenticationRepository: com.enigmacamp.authenticationfeature.data.repository.AuthenticationRepository,
        ): AuthenticationActivityViewModel {
            return AuthenticationActivityViewModel(authenticationRepository)
        }
    }
}