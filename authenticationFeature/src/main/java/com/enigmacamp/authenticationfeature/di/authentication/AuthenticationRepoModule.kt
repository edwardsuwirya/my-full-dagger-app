package com.enigmacamp.authenticationfeature.di.authentication

import com.enigmacamp.authenticationfeature.data.api.AuthApi
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
abstract class AuthenticationRepoModule {
    @Binds
    abstract fun bindsAuthenticationRepository(authenticationRepositoryImpl: com.enigmacamp.authenticationfeature.data.repository.AuthenticationRepositoryImpl): com.enigmacamp.authenticationfeature.data.repository.AuthenticationRepository

    companion object {
        @Provides
        fun provideAuthApi(retrofit: Retrofit): AuthApi {
            return retrofit.create(AuthApi::class.java)
        }
    }
}