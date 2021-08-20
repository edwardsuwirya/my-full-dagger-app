package com.enigmacamp.myfulldaggerapp.di.data

import android.app.Application
import com.enigmacamp.myfulldaggerapp.data.SharedPref
import com.enigmacamp.myfulldaggerapp.data.api.AuthApi
import com.enigmacamp.myfulldaggerapp.data.db.AppDatabase
import com.enigmacamp.myfulldaggerapp.data.db.CustomerDao
import com.enigmacamp.myfulldaggerapp.di.app.ApiModule
import com.enigmacamp.myfulldaggerapp.di.app.AppComponent
import com.enigmacamp.myfulldaggerapp.di.app.DbModule
import com.enigmacamp.myfulldaggerapp.di.app.SharedPrefModule
import dagger.BindsInstance
import dagger.Component
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
    fun provideAuthApi(): AuthApi
    fun provideDatabase(): AppDatabase
    fun provideSharedPref(): SharedPref

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: Application): Builder
        fun build(): DataComponent
    }
}