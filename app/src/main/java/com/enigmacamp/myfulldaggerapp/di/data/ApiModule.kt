package com.enigmacamp.myfulldaggerapp.di.app

import com.enigmacamp.myfulldaggerapp.data.api.AuthApi
import com.enigmacamp.myfulldaggerapp.data.api.interceptor.AuthTokenInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
class ApiModule {
    @Singleton
    @Provides
    fun provideOkHttpClient(authTokenInterceptor: AuthTokenInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(authTokenInterceptor)
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofitInstance(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://10.0.2.2:3008/enigma/")
            .addConverterFactory(MoshiConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @Provides
    fun provideAuthApi(retrofit: Retrofit): AuthApi {
        return retrofit.create(AuthApi::class.java)
    }
}