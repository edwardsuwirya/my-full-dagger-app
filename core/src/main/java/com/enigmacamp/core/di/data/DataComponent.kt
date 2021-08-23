package com.enigmacamp.core.di.data

import android.app.Application
import com.enigmacamp.core.data.SharedPref
import com.enigmacamp.core.data.db.AppDatabase
import dagger.BindsInstance
import dagger.Component
import retrofit2.Retrofit
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ApiModule::class,
        DbModule::class,
        SharedPrefModule::class,
    ]
)
interface DataComponent {
    fun provideRetrofit(): Retrofit
    fun provideDatabase(): AppDatabase
    fun provideSharedPref(): SharedPref

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: Application): Builder
        fun build(): DataComponent
    }
}